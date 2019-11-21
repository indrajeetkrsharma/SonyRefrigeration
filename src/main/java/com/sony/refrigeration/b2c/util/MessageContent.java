package com.sony.refrigeration.b2c.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import com.sony.refrigeration.b2c.constant.MessageConstants;
import com.sony.refrigeration.b2c.exceptions.SonyRefrigerationException;

public class MessageContent
{

    /** The log. */
    private static Logger log = Logger.getLogger(MessageContent.class);

    /** The path properties. */
    public static Properties pathProperties = null;

    /**
     * Constructor.
     */
    private MessageContent()
    {

    }

    /**
     * Gets the Merged content data using the passed parameters.
     * contentType contains the static template with place holder for dynamic data.
     * <code>velocityContext</code> contains the data that should be filled in the
     * static data in place of place holders.
     *
     * @param contentTypeName the content type name
     * @param velocityContext the velocity context
     * @return Content data.
     * @throws SonyRefrigerationException the ebreeze exception
     */
    public static String getContentData(String contentTypeName, VelocityContext velocityContext)
            throws SonyRefrigerationException
    {
        log.info("getContentData(): Entered");
        // Load the velocity.properties.
        // Load the template.
        StringWriter contentWriter = new StringWriter();
        try
        {

            InputStream velocityStream =
                    MessageContent.class
                            .getResourceAsStream(MessageConstants.PROPERTY_FILE_VELOCITY);
            Properties velocityProperties = new Properties();
            velocityProperties.load(velocityStream);
            String contentTemplate = getContent(contentTypeName);
            if (StringUtils.isEmpty(contentTemplate))
            {
                log.error("Template content not retrieved.");
                throw new SonyRefrigerationException("Template content not retrieved.");
            }
            Velocity.init(velocityProperties);
            Velocity.evaluate(velocityContext, contentWriter, "LOG", contentTemplate);
        }
        catch (IOException e)
        {
            log.error("Error in getting the content data/velocity tempalte.");
            throw new SonyRefrigerationException("Error in getting the content data/velocity tempalte.");
        }
        catch (ParseErrorException pee)
        {
            log.error("Error in parsing velocity template.");
            throw new SonyRefrigerationException("Error in parsing velocity template.");
        }
        catch (MethodInvocationException mie)
        {
            log.error("Error in parsing velocity template.");
            throw new SonyRefrigerationException("Error in parsing velocity template.");
        }
        catch (ResourceNotFoundException rnfe)
        {
            log.error("Error finding velocity template.");
            throw new SonyRefrigerationException("Error finding velocity template.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("Error in velocity template initialization.");
            throw new SonyRefrigerationException("Error in velocity template initialization.");
        }
        log.info("Leaving: getContentData()");
        return contentWriter.getBuffer().toString();
    }

    /**
     * This method reads the given file and returns the file content.
     *
     * @param fileName File name.
     * @return Content of the given file.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static String getContent(String fileName) throws IOException
    {
        log.info("getContent(): Entered");
        StringBuffer htmlBuffer = new StringBuffer();
        if (null != fileName)
        {
            try
            {
                InputStream inputStream = MessageContent.class.getResourceAsStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                while (null != (line = reader.readLine()))
                {
                    htmlBuffer.append(line);
                }
            }
            catch (IOException iox)
            {
                iox.printStackTrace();
                throw iox;
            }
        }

        log.info("Leaving: getContent()");
        return htmlBuffer.toString();
    }
}

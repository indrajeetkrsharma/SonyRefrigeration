package com.sony.refrigeration.b2c.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.internal.FilterHelper;

/**
 * The Class PropertyUtils is used to load values from the property file.
 */
public class PropertyUtils
{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(PropertyUtils.class);

    /**
     * path to jboss config folder.
     */
    private static final String JBOSS_CONFIG_FOLDER = "jboss.server.config.url";

    /**
     * path to jboss config folder.
     */
    private static final String PROP_FILE_NAME = "ebreez-config.properties";

    /**
     * The value holder for properties.
     * Making it as static so that, this property file will be loaded only once in the life cycle
     */
    private static Properties properties = new Properties();

    /**
     * Loads keys and values from property file.
     *
     * @return the properties
     * @throws URISyntaxException the uRI syntax exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Properties loadProperties() throws URISyntaxException, IOException
    {
        LOGGER.debug("Inside loadProperties -  ENTRY ");
        //If the properties are already loaded, return it
        /*if (!properties.isEmpty())
        {
            return properties;
        }*/
        String path = System.getProperty(JBOSS_CONFIG_FOLDER);
        if(StringUtils.isBlank(path)){
            LOGGER.debug("Unable to get the path from the System Property:" + JBOSS_CONFIG_FOLDER);
        }
        path = path + PROP_FILE_NAME;
        
        LOGGER.debug(" Property file present in following path :" + path);
        URL url = new URL(path);
        try
        {
            File file = new File(url.toURI());
            if (file.exists())
            {
//                InputStream inputStream = url.openStream();
            	InputStream inputStream = FilterHelper.class.getClass().getResourceAsStream("/email.properties");
                properties.load(inputStream);
                LOGGER.debug("Loaded properties from file : " + path);
                if(inputStream!=null){
                    inputStream.close();
                }
            }
            else
            {
                if (LOGGER.isDebugEnabled())
                {
                    LOGGER.debug("couldn't load file..");
                }
            }

        }
        catch (Exception e)
        {
            LOGGER.error("Exception: " + e.getMessage());
        }
        LOGGER.debug("Inside loadProperties -  EXIT ");
        return properties;
    }

    /**
     * Gets the value from the property file.
     *
     * @param key the key
     * @return the value
     */
    public static String getValue(String key)
    {
        Properties properties = null;
        try
        {
            properties = loadProperties();
        }
        catch (URISyntaxException e)
        {
            LOGGER.error(e.getMessage(), e);
        }
        catch (IOException e)
        {
            LOGGER.error(e.getMessage(), e);
        }
        if (properties != null)
        {
            return properties.getProperty(key);
        }
        else
        {
            return null;
        }
    }

    /**
     * Gets the value from the property file.
     *
     * @param key the key
     * @return the value
     */
    public static String getRecentValue(String key)
    {
        /*Properties properties = new Properties();

        String path = System.getProperty(JBOSS_CONFIG_FOLDER) + PROP_FILE_NAME;
        LOGGER.debug(" Property file present in following path :" + path);
        try
        {
            URL url = new URL(path);
            if (new File(url.toURI()).exists())
            {
                properties.load(url.openStream());
                LOGGER.debug("Loaded properties from file : " + path);
            }
            else
            {
                if (LOGGER.isDebugEnabled())
                {
                    LOGGER.debug("couldn't load file..");
                }
            }
        }
        catch (URISyntaxException e)
        {
            LOGGER.error(e.getMessage(), e);
        }
        catch (IOException e)
        {
            LOGGER.error(e.getMessage(), e);
        }finally{
            if (properties != null)
            {
                return properties.getProperty(key);
            }
        }
        return null;*/
        return getLatestConfigValue(key);
    }
    
    /**
     * Gets the latest config value.
     *
     * @param key the key
     * @return the latest config value
     */
    public static String getLatestConfigValue(String key)
    {
        Properties properties = new Properties();

        String path = System.getProperty(JBOSS_CONFIG_FOLDER) + PROP_FILE_NAME;
        LOGGER.debug(" Property file present in following path :" + path);
        try
        {
            URL url = new URL(path);
            if (new File(url.toURI()).exists())
            {
                InputStream inputStream = url.openStream();
                properties.load(inputStream);
                LOGGER.debug("Loaded properties from file : " + path);
                if(inputStream!=null){
                    inputStream.close();
                }
            }
            else
            {
                if (LOGGER.isDebugEnabled())
                {
                    LOGGER.debug("couldn't load file..");
                }
            }
        }
        catch (URISyntaxException e)
        {
            LOGGER.error(e.getMessage(), e);
        }
        catch (IOException e)
        {
            LOGGER.error(e.getMessage(), e);
        }finally{
            if (properties != null)
            {
                return properties.getProperty(key);
            }
        }
        return null;
    }
    
    public Properties loadPropertiesFromClassPath()
    {
        LOGGER.debug("Inside loadProperties -  ENTRY ");
        Properties properties = new Properties();
		InputStream in = this.getClass().getResourceAsStream("email.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return properties;
    }
}

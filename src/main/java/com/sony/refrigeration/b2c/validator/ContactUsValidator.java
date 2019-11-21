package com.sony.refrigeration.b2c.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sony.refrigeration.b2c.beans.ContactUsBean;

@Component
public class ContactUsValidator implements Validator 
{

	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	
	@Override
	public boolean supports(Class<?> clazz) 
	{
		return ContactUsBean.class.equals(clazz);
	}

	@Override
	public void validate(Object arg0, Errors errors) 
	{
		ContactUsBean contactUsBean = (ContactUsBean) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNo", "NotEmpty.userForm.number");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "NotEmpty.userForm.subject");
		
		if(!emailValidator.valid(contactUsBean.getEmail())){
			errors.rejectValue("email", "Pattern.userForm.email");
		}
		/*if(contactUsBean.getName()==null || contactUsBean.getName().length()<=0)
		{
			errors.rejectValue("name", "Name Can't be empty");
		}*/
	}

}

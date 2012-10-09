package com.tavant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.util.regex.*;

import com.tavant.domain.User;
import com.tavant.services.UserService;


@Service("registrationValidator")
public class RegistrationValidator implements Validator {
	UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"required.firstName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"required.lastName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId",
				"required.emailId", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field name is required.");
		

		User user = (User) target;
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String emailId = user.getEmailId();
		String password = user.getPassword();
		String confirmPass = user.getConfirmPassword();

		boolean nothingEmpty = !(firstName.isEmpty() || lastName.isEmpty()
				|| emailId.isEmpty() || password.isEmpty());

		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(emailId);
		boolean matchFound = m.matches();
		User existingUser = userService.selectByEmailId(emailId);
		
		if (nothingEmpty) {
			
			//checking validity of email address
			

			if (!matchFound) {
				errors.rejectValue("emailId", "invalid.emailId");
			}
			//checking if user with email id already exists
			else if(existingUser != null){
				errors.rejectValue("emailId", "exists.emailId");
			}
			else if(password.length() < 6 || password.length() > 20){
				errors.rejectValue("password", "length.password");
			}
			else if (!password.equals(confirmPass)) {
				errors.rejectValue("password", "notmatch.password");
			}
			
			
			
		}

	}

}

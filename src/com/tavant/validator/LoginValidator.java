package com.tavant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tavant.domain.User;
import com.tavant.services.UserService;

@Service("loginValidator")
public class LoginValidator implements Validator {
	private UserService userService;
	private User validUser;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getValidUser() {
		return validUser;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId",
				"required.emailid", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field name is required.");

		User user = (User) target;

		// System.out.println("i'm from validator " + user);
		if (!((user.getEmailId()).trim().isEmpty() || (user.getPassword())
				.trim().isEmpty())) {
			User currentUser = userService.selectByEmailId(user.getEmailId());

			if (currentUser != null
					&& currentUser.getPassword().equals(user.getPassword())) {
				validUser = currentUser;
				// System.out.println("i'm from validator " + target);
			} else {
				// System.out.println("I'm from vaidator, something is wrong");
				errors.rejectValue("emailId", "loginInfo.notmatch",
						"Something is wrong");
			}

		}

	}

}

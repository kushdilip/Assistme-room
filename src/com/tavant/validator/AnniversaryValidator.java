package com.tavant.validator;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tavant.domain.Anniversary;

@Service("anniversaryValidator")
public class AnniversaryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Anniversary.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "people",
				"required.people");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date",
				"required.date");

		Anniversary anvrsry = (Anniversary) target;

		String people = anvrsry.getPeople();
		String date = anvrsry.getDate();

		if (!people.trim().isEmpty() && !date.trim().isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date testDate = null;
			try {
				testDate = sdf.parse(date);
			} catch (ParseException e) {
				errors.rejectValue("date", "invalid.date",
						"Please enter date in correct format");
			}

			if (!sdf.format(testDate).equals(date)) {
				errors.rejectValue("date", "invalid.date",
						"Please enter date in correct format");
			}
		}

	}
}

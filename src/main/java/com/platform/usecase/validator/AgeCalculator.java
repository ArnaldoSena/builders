package com.platform.usecase.validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class AgeCalculator {
	
	public static int calutateAge(Date birthDtToConverter) {
		var birthDate = birthDtToConverter.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		var currentDate = LocalDate.now(ZoneId.systemDefault());
		return calculateAge(birthDate, currentDate);
	}
	
	public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
	
}

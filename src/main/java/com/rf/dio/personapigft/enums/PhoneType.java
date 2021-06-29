package com.rf.dio.personapigft.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

	HOME("Home"), 
	MOBILE("Mobile"), 
	COMMERCIAL("Commercial");

	@SuppressWarnings("unused")
	private final String description;
}

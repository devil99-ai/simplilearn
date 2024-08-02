package com.simplilearn.TDD;

public class PasswordValidator {
	
	public boolean isValid(String password) {
		if(password.isEmpty()) {
			return false;
		}else {
			if(password.length()>=5 && password.length()<=10) {
				return true;
			}else {
				return false;
			}
		}
	}

}

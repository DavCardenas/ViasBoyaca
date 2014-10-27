package logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {


	public boolean validateNotHaveLetters(String cadena){
		Pattern cd = Pattern.compile("[a-zA-Z]");
		Matcher mat = cd.matcher(cadena);
		return (!(mat.find()));
	}
	public boolean validateNotHaveNumbers(String cadena){
		Pattern cd = Pattern.compile("[0-9]");
		Matcher mat = cd.matcher(cadena);
		return (!(mat.find()));
	}
}


package com.green.todopra.common.check;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String ID_REGEX = "^[a-zA-Z0-9]{6,12}$"; // 6~12 글자 영문 대소문자 숫자 0~9 만 가능
    private static final String PASSWORD_REGEX =
            "^(?=.*[!@#$%^&*()-_=+\\\\|\\[\\]{};:'\",.<>/?]).{8,20}$\n"; //영문 8~20 글자 특수문자 1개이상 포함,
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";


    public static boolean isValidEmail(String email) { //Validation
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) { //Validation
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidId(String id) { //Validation
        Pattern pattern = Pattern.compile(ID_REGEX);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }
}

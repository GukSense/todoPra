package com.green.todopra.user;

import com.green.todopra.common.check.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    @DisplayName("이메일 정규표현식 테스트 정상적인 경우")
    void validIdTest() {
        /**
         *  id: 6~12 글자 영문 대소문자 숫자 0~9 만 가능
         *  password: 영문 8~20 글자 특수문자 1개이상 포함
         * */
        //given
        String inputIdData = "abcdef"; // 소문자만사용 && 최소길이
        //when
        boolean validId = Validator.isValidId(inputIdData);
        //then
        assertTrue(validId); // expected true

        //g
        inputIdData = "ABCDEF";
        boolean validOnlyUppercase = Validator.isValidId(inputIdData);
        //w
        //t
    }

    @Test
    @DisplayName("이메일 정규표현식 테스트_6글자미만")
    void validSixLetters() {
        String inputIdData = "gang";
        boolean validLessSixLetters = Validator.isValidId(inputIdData);
        assertFalse(validLessSixLetters);
    }

    @Test
    @DisplayName("이메일 정규표현식 테스트_12글자 초과")
    void validExceedTwelveLetters() {
        String intputIdData = "BaeGangGuk1234";
        boolean validExceedTwelveLetters = Validator.isValidId(intputIdData);
        assertFalse(validExceedTwelveLetters);
    }

    @Test
    @DisplayName("이메일 정규표현식 테스트_")
}
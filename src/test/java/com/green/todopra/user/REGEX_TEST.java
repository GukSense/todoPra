package com.green.todopra.user;

import com.green.todopra.common.check.Validator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class REGEX_TEST {

    @Test
    @DisplayName("아이디 정규표현식 테스트 정상적인 경우")
    void validIdTest() {
        /**
         *  id: 6~12 글자 영문 대소문자 숫자 0~9 만 가능
         *  password: 영문 8~20 글자 특수문자 1개이상 포함
         *  "abcdef": 최소 길이, 소문자만 사용
         *  "ABCDEF": 최소 길이, 대문자만 사용
         *  "123456": 최소 길이, 숫자만 사용
         *  "aB3dE5": 혼합된 문자
         *  "abcdEF1234": 영문 대소문자와 숫자 혼합
         *  "1234567890AB": 최대 길이, 숫자와 대문자 혼합
         *
         * */

        /**
        소문자만사용
        */
        //given
        String inputIdData = "abcdef";
        //when
        boolean validId = Validator.isValidId(inputIdData);
        //then
        assertTrue(validId); // expected true
        log.info("소문자만 사용 success {}", validId );

        /**
        대문자만 사용
        */

        //g
        inputIdData = "ABCDEF";
        //w
        boolean validOnlyUppercase = Validator.isValidId(inputIdData);
        //t
        assertTrue(validOnlyUppercase);
        log.info("대문자만 사용 success {}", validOnlyUppercase );
        /**
         * 숫자만사용
         */
        //given
        inputIdData = "123456";
        //when
        boolean validOnlyNumber = Validator.isValidId(inputIdData);
        //then
        assertTrue(validOnlyNumber);
        log.info("숫자만 사용 success {}", validOnlyNumber );
        /**
         * 영어 대소문자와 혼합
         * */
        //g
        inputIdData = "gangGUK1234";
        //w
        boolean validChaosAll = Validator.isValidId(inputIdData);
        //t
        assertTrue(validChaosAll);
        log.info("영어 대소문자와 혼합 success {}", validChaosAll );
        /**
         * 최대 길이, 숫자와 대문자 혼합
         * */
        //g
        inputIdData = "1234567890AB";
        //w
        boolean validMaxLengthMix = Validator.isValidId(inputIdData);
        //t
        assertTrue(validMaxLengthMix);
        log.info("최대 길이, 숫자와 대문자 혼합 {}", validMaxLengthMix);
    }

    @Test
    @DisplayName("아이디 정규표현식 테스트_6글자미만")
    void validSixLetters() {
        String inputIdData = "gang";
        boolean validLessSixLetters = Validator.isValidId(inputIdData);
        assertFalse(validLessSixLetters);
    }

    @Test
    @DisplayName("아이디 정규표현식 테스트_12글자 초과")
    void validExceedTwelveLetters() {
        String intputIdData = "BaeGangGuk1234";
        boolean validExceedTwelveLetters = Validator.isValidId(intputIdData);
        assertFalse(validExceedTwelveLetters);
    }

    @Test
    @DisplayName("아이디 정규표현식 테스트_대문자만 사용")
    void validOnlyUpperCase() {
       ;

    }
}

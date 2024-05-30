package com.green.todopra.user;

import com.green.todopra.common.check.Validator;
import com.green.todopra.user.model.SignInPostReq;
import com.green.todopra.user.model.SignUpPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    public int signUpPost(SignUpPostReq p) {
        return 0;
    }

    public void validateUser(SignUpPostReq p) {
        //아이디검사
        boolean validId = Validator.isValidId(p.getUid());
        if (!validId) {
            throw new RuntimeException("유효하지 않은 아이디입니다.");
        } else if (!Validator.isValidPassword(p.getUpw())) {
            throw new RuntimeException("유효하지않은 비밀번호 입니다.");
        } else if (!Validator.isValidEmail(p.getEmail())) {
            throw new RuntimeException("유효하지않은 이메일 입니다.");
        }
    }
}

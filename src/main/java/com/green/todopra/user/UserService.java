package com.green.todopra.user;

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
}

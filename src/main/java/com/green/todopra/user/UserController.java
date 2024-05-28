package com.green.todopra.user;


import com.green.todopra.common.check.Validator;
import com.green.todopra.common.model.ResultDto;
import com.green.todopra.user.model.SignUpPostReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
@Tag(name = "유저", description = "USER CRUD")
public class UserController {
    private final UserService service;

    @PostMapping("sing-up")
    @Operation(summary = "유저 회원가입", description = "")
    public ResultDto<Integer> signUpPost(@RequestPart @Valid SignUpPostReq p) {
        log.info("{}", p);
        boolean validId = Validator.isValidId(p.getUid());
        boolean validEmail = Validator.isValidEmail(p.getEmail());
        boolean validPassword = Validator.isValidPassword(p.getUpw());

        log.info("{}", validEmail);

        int result = service.signUpPost(p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("회원가입 완료")
                .resultData(result)
                .build();
    }
}

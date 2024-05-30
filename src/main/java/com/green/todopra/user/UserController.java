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
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
@Tag(name = "유저", description = "USER CRUD")
public class UserController {
    private final UserService service;

    @PostMapping("sing-up")
    @Operation(summary = "유저 회원가입",
            description = "<div > [email]: 이메일 ex)abc1234@naver.com </div>" + "\n" +
                          "<div> [uid]: 아이디 ex) abc1234 </div>" + "\n" +
                          "<div> [upw]: 비밀번호 ex) abc1234 </div>"

    )
    public ResultDto<Integer> signUpPost(@RequestBody @Valid SignUpPostReq p) {
        log.info("{}", p);
        try {
            service.validateUser(p);
        } catch (RuntimeException e) {
            return ResultDto.<Integer>builder().build(); // 어떤 에러메시지를 던져줘야하나?
        }
        int result = service.signUpPost(p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("회원가입 완료")
                .resultData(result)
                .build();
    }
}

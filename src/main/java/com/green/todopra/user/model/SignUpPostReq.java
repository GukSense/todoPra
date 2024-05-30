package com.green.todopra.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class SignUpPostReq {
    @Email(message = "유효하지 않은 이메일 형식입니다.")
    @NotBlank
    @Schema(example = "이메일", description = "redraib05@naver.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String email;




    @Schema(example = "아이디", description = "redraib05", requiredMode = Schema.RequiredMode.REQUIRED)
    private String uid;
    @Schema(example = "비밀번호", description = "aaa1234", requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
    @Schema(example = "닉네임", description = "저스디스", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nm;

    @JsonIgnore
    private long userId;
    @JsonIgnore
    private String pic;



}

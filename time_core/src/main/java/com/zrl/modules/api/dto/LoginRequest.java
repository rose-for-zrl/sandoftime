package com.zrl.modules.api.dto;

import javax.validation.constraints.NotNull;

public class LoginRequest {
    @NotNull(message = "用户名不能为空")
    private String nickName;
    @NotNull(message = "密码不能为空")
    private String password;
    @NotNull(message = "验证码不能为空")
    private String code;
    @NotNull(message = "验证码不能为空")
    private String trueCode;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTrueCode() {
        return trueCode;
    }

    public void setTrueCode(String trueCode) {
        this.trueCode = trueCode;
    }
}

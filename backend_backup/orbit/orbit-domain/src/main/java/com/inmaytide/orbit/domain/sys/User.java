package com.inmaytide.orbit.domain.sys;

import com.inmaytide.orbit.consts.UserStatus;
import com.inmaytide.orbit.domain.basic.BasicEntity;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mybatis.annotations.Entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(table = "sys_user")
public class User extends BasicEntity {

    private static final long serialVersionUID = -924373759818451358L;

    private String username;
    private String name;
    private LocalDate brithday;
    private String education;
    private String password;
    private String email;
    private String qq;
    private String wechat;
    private String telephone;
    private String cellphone;
    private String avatar;
    private String remark;
    private String status;
    @Transient
    private String token;
    @Transient
    private List<Organization> organization;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isLocked() {
        return Objects.equals(getStatus(), UserStatus.LOCKED.toString());
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDate getBrithday() {
        return brithday;
    }

    public void setBrithday(LocalDate brithday) {
        this.brithday = brithday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}

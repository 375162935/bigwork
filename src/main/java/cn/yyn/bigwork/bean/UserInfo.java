package cn.yyn.bigwork.bean;

import java.util.Date;

/**
 * @author 杨以诺
 * by 2020-05-19 17:16
 */
public class UserInfo {
    private Integer userId;     //用户id
    private String username;    //用户账号
    private String password;    //用户密码
    private String trueName;    //用户真实姓名
    private String email;       //用户邮箱
    private String phone;       //用户电话
    private String message;     //用户信息简介
    private String country;     //用户祖国
    private String gender;     //用户性别：0-男 1-女
    private Date birthday;      //用户生日
    private Date createTime;   //用户创建时间
    private Integer roleId;    //用户角色id
    private Role role;          //角色类的对象

    public UserInfo() {
    }

    public UserInfo(Integer userId, String username, String password, String trueName, String email, String phone, String message, String country, String gender, Date birthday, Date createTime, Integer roleId, Role role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.trueName = trueName;
        this.email = email;
        this.phone = phone;
        this.message = message;
        this.country = country;
        this.gender = gender;
        this.birthday = birthday;
        this.createTime = createTime;
        this.roleId = roleId;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", trueName='" + trueName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", message='" + message + '\'' +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                ", roleId=" + roleId +
                ", role=" + role +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

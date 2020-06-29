package cn.yyn.bigwork.service;


import cn.yyn.bigwork.bean.UserInfo;

/**
 * @author 杨以诺
 * by 2020-05-19 17:19
 */
public interface UserService {

    UserInfo findUserByUserName(String username);

    void addUserInfo(UserInfo userInfo);

    Integer updUserInfo(UserInfo userInfo);
}

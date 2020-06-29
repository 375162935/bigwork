package cn.yyn.bigwork.service.impl;

import cn.yyn.bigwork.bean.UserInfo;
import cn.yyn.bigwork.dao.UserInfoDao;
import cn.yyn.bigwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 杨以诺
 * by 2020-05-19 17:20
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findUserByUserName(String username) {
        return userInfoDao.findUserByUserName(username);
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
         this.userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public Integer updUserInfo(UserInfo userInfo) {
        return userInfoDao.updUserInfo(userInfo);
    }
}

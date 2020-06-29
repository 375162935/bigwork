package cn.yyn.bigwork.dao;

import cn.yyn.bigwork.bean.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author 杨以诺
 * by 2020-05-19 17:17
 */
@Repository
public interface UserInfoDao {
    UserInfo findUserByUserName(String username);

    void addUserInfo(UserInfo userInfo);

    Integer updUserInfo(UserInfo userInfo);

}

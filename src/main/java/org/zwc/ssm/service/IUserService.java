package org.zwc.ssm.service;

import org.zwc.ssm.domain.User;

import java.util.List;

/**
 * Created by zhangwenchao on 2017/10/30.
 */
public interface IUserService {

    public User selectUser(long userId);

    public List<User> getUserList();


}

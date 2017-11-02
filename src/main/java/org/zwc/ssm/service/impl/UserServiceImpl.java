package org.zwc.ssm.service.impl;

/**
 * Created by zhangwenchao on 2017/10/30.
 */

import org.springframework.stereotype.Service;
import org.zwc.ssm.dao.IUserDao;
import org.zwc.ssm.domain.User;
import org.zwc.ssm.service.IUserService;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {

        return this.userDao.selectUser(userId);
    }

}

package org.zwc.ssm.dao;

import org.springframework.stereotype.Repository;
import org.zwc.ssm.domain.User;

import java.util.List;

/**
 * Created by zhangwenchao on 2017/10/30.
 */
@Repository
public interface IUserDao {

   public User selectUser(long id);

   public List<User> getUserList();
}

package org.zwc.ssm.dao;

import org.springframework.stereotype.Repository;
import org.zwc.ssm.domain.User;

/**
 * Created by zhangwenchao on 2017/10/30.
 */
@Repository
public interface IUserDao {

    User selectUser(long id);

}

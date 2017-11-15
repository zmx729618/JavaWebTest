package org.zwc.test.ssm;

/**
 * Created by zhangwenchao on 2017/10/30.
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zwc.ssm.dao.IUserDao;
import org.zwc.ssm.domain.User;

import javax.inject.Inject;
import java.util.List;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserDaoTest {

    @Inject
    private IUserDao userDao;

    @Test
    public void testSelectUser() throws Exception {
        long id = 1;
        User user = userDao.selectUser(id);
        System.out.println(user.getUsername());
        Assert.assertEquals("xiaoming",user.getUsername());

    }




    @Test
    public void testGetUserList() throws Exception {

        List<User> userList = userDao.getUserList();
        for(User u : userList){
            System.out.println(u.getUsername());
        }

    }

}

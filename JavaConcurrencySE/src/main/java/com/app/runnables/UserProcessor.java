package com.app.runnables;

import com.app.beans.User;
import com.app.dao.UserDao;

import java.util.concurrent.Callable;

public class UserProcessor implements Callable<Integer> {

    String userRecord;
    UserDao userDao;

    public UserProcessor(String userRecord, UserDao userDao) {
        this.userRecord = userRecord;
        this.userDao = userDao;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "processing record for : " + userRecord);
        String[] userInfo = userRecord.split(",");
        User user = new User();
        user.setEmailAddress(userInfo[0]);
        user.setName(userInfo[1]);
        user.setId(Integer.valueOf(userInfo[2]));
        return userDao.saveUser(user);
    }
}

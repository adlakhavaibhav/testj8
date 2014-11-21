package com.nm.service;

import com.nm.domain.User;
import com.nm.impl.service.ServiceLocatorFactory;
import com.nm.pact.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by adlakhavaibhav on 20/11/14.
 */
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private BaseDao baseDao;

    @Override
    public String testCall() {
        return "test hello";
    }


    @Override
    @Transactional
    public TestPojo testPojo(){

        User user = new User();

        user.setId(2L);
        user.setName("user2");

        baseDao.save(user);

        ServiceLocatorFactory.getService(TestService2.class).test();

        return new TestPojo("1", "test pojo");

    }
}

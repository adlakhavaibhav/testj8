package com.nm.service;

import com.nm.pact.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adlakhavaibhav on 21/11/14.
 */
@Service
public class TestService2Impl implements TestService2 {

    @Autowired
    private BaseDao baseDao;

    public void test(){
        throw new RuntimeException();
    }
}

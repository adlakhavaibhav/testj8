package com.nm.service;

import org.springframework.stereotype.Service;

/**
 * Created by adlakhavaibhav on 20/11/14.
 */
@Service
public class TestServiceImpl implements TestService {


    @Override
    public String testCall() {
        return "test hello";
    }


    @Override
    public TestPojo testPojo(){
        return new TestPojo("1", "test pojo");

    }
}

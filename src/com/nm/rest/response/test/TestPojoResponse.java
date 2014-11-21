package com.nm.rest.response.test;

import com.nm.rest.constants.DtoJsonConstants;
import com.nm.rest.response.generic.AbstractBaseResponse;
import com.nm.service.TestPojo;

import java.util.List;

/**
 * Created by adlakhavaibhav on 21/11/14.
 */
public class TestPojoResponse extends AbstractBaseResponse {

    private TestPojo testPojo;


    public TestPojo getTestPojo() {
        return testPojo;
    }

    public void setTestPojo(TestPojo testPojo) {
        this.testPojo = testPojo;
    }

    @Override
    protected List<String> getKeys() {
        List<String> keys = super.getKeys();
        keys.add("tp");

        return keys;
    }

    @Override
    protected List<Object> getValues() {
        List<Object> values = super.getValues();

        values.add(testPojo);

        return values;
    }
}

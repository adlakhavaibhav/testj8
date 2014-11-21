package com.nm.rest.response.generic;



import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: Apr 11, 2013
 * Time: 7:58:56 PM
 */
public abstract class AbstractBaseResponse extends AbstractGenericResponse {

    @Override
    protected List<String> getKeys() {
        return super.getKeys();
    }

    @Override
    protected List<Object> getValues() {
        return super.getValues();
    }
}

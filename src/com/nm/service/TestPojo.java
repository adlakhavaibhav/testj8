package com.nm.service;

/**
 * Created by adlakhavaibhav on 20/11/14.
 */
public class TestPojo {

    private String id;
    private String name;

    public TestPojo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.nm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by adlakhavaibhav on 21/11/14.
 */
@Entity
@Table(name = "mobile")
public class Mobile {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = true, length = 80)
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package com.example.demo.api.user.bo;

import java.io.Serializable;

/**
 * @author JiakunXu
 */
public class User implements Serializable {

    private Long   id;

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

package com.it.soul.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String gender;

    private String avatar;

}

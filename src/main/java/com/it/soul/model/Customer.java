package com.it.soul.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    private String phone;

    private String email;

    private String gender;

    private String avatar;

    private LocalDateTime expireDate;

    private int credit;


    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private String token;

}

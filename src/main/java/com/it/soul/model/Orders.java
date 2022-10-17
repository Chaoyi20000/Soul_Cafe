package com.it.soul.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Orders implements Serializable {
    private Long id;

    private Integer number;

    private Integer status;

    private Long customerId;

    private LocalDateTime orderTime;

    private Integer pay_method;

    private BigDecimal total;

    private String remark;

    private String phone;

    private String customerName;

    @TableField(exist = false)
    private List<OrderDetail> orderDetails;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

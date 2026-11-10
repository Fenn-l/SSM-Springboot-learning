package com.ape.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    private Long id;
    private String name;
    @TableField(value = "password",select = false)
    private String password;
    private Integer age;
    private String tel;
    @TableField(exist = false)
    private String email;
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
    @Version
    private Integer version;
}

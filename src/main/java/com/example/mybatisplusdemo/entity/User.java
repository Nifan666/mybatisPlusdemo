package com.example.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * 对应表名称
 */
@TableName("user")
@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    /**
     * 对应主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer userid;
    private String username;
    private String password;

}

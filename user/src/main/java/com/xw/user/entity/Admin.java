package com.xw.user.entity;

import com.xw.commons.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by AnKh on 2017/5/31.
 */
@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode
@NoArgsConstructor
@Table(name="admin")
public class Admin extends BaseEntity{
    private String username;

    private String password;

    private String salt;

    private String token;

}

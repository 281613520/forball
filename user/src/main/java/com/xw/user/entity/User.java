package com.xw.user.entity;

import com.xw.commons.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.joda.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ankh on 2017/5/28.
 */
@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "user")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String salt;
}

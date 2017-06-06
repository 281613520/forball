package com.xw.visitor.entity;

import com.xw.commons.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ankh on 2017/6/4.
 */
@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode
@NoArgsConstructor
@Table(name="module")
public class Module extends BaseEntity {
    private String name;

    public Module(String name) {
        this.name = name;
    }
}

package com.xw.visitor.entity;

import com.xw.commons.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ankh on 2017/6/4.
 */
@NoArgsConstructor
@Data
@ToString
@Table(name = "tag")
@Entity
@EqualsAndHashCode
public class Tag extends BaseEntity {
    @Getter@Setter private String name;
    @Getter@Setter private String moduleId;
    @Getter@Setter private int articleNum;

    private transient Module module;

    public Tag(String name, String moduleId) {
        this.name = name;
        this.moduleId = moduleId;
    }
}

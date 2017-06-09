package com.xw.visitor.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.xw.commons.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.joda.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Ankh on 2017/6/4.
 */
@Entity
@NoArgsConstructor
@Table(name = "article")
@ToString
@Data
@EqualsAndHashCode(callSuper = true)
public class Article extends BaseEntity {

    private String title;
    private String content;
    private String tagId;
    private String moduleId;
    private boolean isTop = false;
    private int readNum = 0;
    private int up = 0;
    private int down = 0;

    public Article(String title, String content, String tagId) {
        this.title = title;
        this.content = content;
        this.tagId = tagId;
    }
}

package com.xw.commons.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xw.commons.dbconverter.TimeConverter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.Id;

import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

/**
 * Created by AnKh on 2017/5/24.
 */
@ToString
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "systemUUID")
    @GenericGenerator(name="systemUUID",strategy="uuid2")
    private String id;

    @Convert(converter = TimeConverter.class)
    //@JsonSerialize
    //@JsonDeserialize
    private LocalDateTime operationTime;


    private boolean isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}

package com.xw.commons.dbconverter;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import java.sql.Timestamp;

/**
 * Created by AnKh on 2017/5/26.
 */
@Slf4j
public class TimeConverter implements AttributeConverter<LocalDateTime,Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(final LocalDateTime localDateTime) {
        return localDateTime == null ? null : new Timestamp(localDateTime.toDateTime().getMillis());
    }

    @Override
    public LocalDateTime convertToEntityAttribute(final Timestamp timestamp) {
        return timestamp == null ? null : LocalDateTime.fromDateFields(timestamp);
    }
}

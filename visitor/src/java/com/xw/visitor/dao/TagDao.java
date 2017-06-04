package com.xw.visitor.dao;


import com.xw.visitor.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ankh on 2017/6/4.
 */
public interface TagDao extends JpaRepository<Tag,String>{
    Tag findByName(final String name);

    @Query("select tag from Tag tag order by moduleId")
    List<Tag> findAll();

    @Query("select tag from Tag tag where isDelete = false and moduleId = :moduleId")
    List<Tag> findByModuleId(@Param("moduleId") String moduleId);
}

package com.xw.visitor.dao;


import com.xw.visitor.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ankh on 2017/6/4.
 */
public interface ArticleDao extends JpaRepository<Article,String> {


    /**
     * 分页
     * @param pageable
     * @param tagId
     * @param isDelete
     * @return
     */
    @Query("select article.id ,article.title,article.tagId from Article article where tagId = :tagId and isDelete = :isDelete order by title")
    Page<Object> findByTagIdAndInPage(Pageable pageable, @Param("tagId")String tagId, @Param("isDelete") boolean isDelete);

    @Query("select article.id ,article.title,article.tagId from Article article where tagId = :tagId order by title")
    Page<Object> findByTagIdAndInPageForAdmin(Pageable pageable, @Param("tagId")String tagId);

    List<Article> findByIsTop(boolean isTop);

    List<Article> findByIsDelete(boolean isDelete);
}

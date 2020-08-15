package com.jason.dao;

import com.jason.model.entity.ArticleFirstPic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleFirstPicDao {

    public void addFirstImage(ArticleFirstPic articleFirstPic);

    public void updateFirstImag(ArticleFirstPic articleFirstPic);

    public void deleteFirstImgById(@Param("id") Integer id);

    public List<ArticleFirstPic> getAllImages();

    public ArticleFirstPic getOneImageById(@Param("id") Integer id);
}

package com.jason.service;

import com.github.pagehelper.PageInfo;
import com.jason.model.entity.ArticleFirstPic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleFirstPicService {

    public void addFirstImage(ArticleFirstPic articleFirstPic);

    public void updateFirstImag(ArticleFirstPic articleFirstPic);

    public void deleteFirstImgById(Integer id);

    public PageInfo<ArticleFirstPic> getAllImages(Integer page, Integer size);

    public ArticleFirstPic getOneImageById(Integer id);

    public List<ArticleFirstPic> getImages();
}

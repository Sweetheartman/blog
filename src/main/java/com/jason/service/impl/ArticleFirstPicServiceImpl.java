package com.jason.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.dao.ArticleFirstPicDao;
import com.jason.model.entity.ArticleFirstPic;
import com.jason.service.ArticleFirstPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleFirstPicServiceImpl implements ArticleFirstPicService {

    @Autowired
    private ArticleFirstPicDao articleFirstPicDao;

    @Override
    public void addFirstImage(ArticleFirstPic articleFirstPic) {
        articleFirstPicDao.addFirstImage(articleFirstPic);

    }

    @Override
    public void updateFirstImag(ArticleFirstPic articleFirstPic) {
        articleFirstPicDao.updateFirstImag(articleFirstPic);
    }

    @Override
    public void deleteFirstImgById(Integer id) {
        articleFirstPicDao.deleteFirstImgById(id);
    }

    @Override
    public PageInfo<ArticleFirstPic> getAllImages(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<ArticleFirstPic> articleFirstPics = articleFirstPicDao.getAllImages();
        return new PageInfo<>(articleFirstPics) ;
    }

    @Override
    public ArticleFirstPic getOneImageById(Integer id) {
        return articleFirstPicDao.getOneImageById(id);
    }

    @Override
    public List<ArticleFirstPic> getImages() {
        return articleFirstPicDao.getAllImages();
    }
}

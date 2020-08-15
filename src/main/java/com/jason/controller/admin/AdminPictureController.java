package com.jason.controller.admin;

import com.github.pagehelper.PageInfo;
import com.jason.model.entity.ArticleFirstPic;
import com.jason.service.ArticleFirstPicService;
import com.jason.service.QiniuService;
import com.qiniu.common.QiniuException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/picture")
@Slf4j
public class AdminPictureController {
    @Autowired
    private ArticleFirstPicService articleFirstPicService;

    @Autowired
    private QiniuService qiniuService;

    @RequestMapping(path = {"/",""})
    public String toPicturePage(@RequestParam(value = "page",defaultValue = "1") Integer page,
                            @RequestParam(value = "size",defaultValue = "5") Integer size,
                            Model model,
                            HttpServletRequest request){

        PageInfo<ArticleFirstPic> pictures = articleFirstPicService.getAllImages(page,size);
        model.addAttribute("pictures",pictures) ;


        log.info("X-Pjax {}",request.getHeader("X-Pjax"));
        if(request.getHeader("X-Pjax") != null){
            return "admin/common-template/picture" ;
        }

        return "admin/picture" ;
    }

    @RequestMapping("/save")
    public String savePicture(@RequestParam(value = "id",required = false) Integer id,
                              @RequestParam(value = "fileName",required = true) String filename,
                              @RequestParam(value = "fileUrl",required = true) String fileurl,
                              @RequestParam(value = "fileKey",required = true) String filekey
                              ){

        if(id != null){
            ArticleFirstPic articleFirstPic = new ArticleFirstPic(id,filename,fileurl,filekey);
            articleFirstPicService.updateFirstImag(articleFirstPic);
        }else{
            ArticleFirstPic articleFirstPic = new ArticleFirstPic(null,filename,fileurl,filekey);
            articleFirstPicService.addFirstImage(articleFirstPic);
        }
        return "forward:/admin/picture/list";
    }

    @RequestMapping("/list")
    public String listTag(@RequestParam(value = "page",defaultValue = "1") Integer page,
                          @RequestParam(value = "size",defaultValue = "5") Integer size,
                          Model model){

        PageInfo<ArticleFirstPic> pictures = articleFirstPicService.getAllImages(page,size);
        model.addAttribute("pictures",pictures) ;
        return "admin/common-template/picture::list";
    }

    @RequestMapping("/delete")
    public String deletepicture(@RequestParam(value = "id",required = true) Integer id, @RequestParam(value = "filekey", required = true) String key) throws QiniuException {
        articleFirstPicService.deleteFirstImgById(id);
        qiniuService.delete(key);
        return "forward:/admin/picture/list";
    }
}

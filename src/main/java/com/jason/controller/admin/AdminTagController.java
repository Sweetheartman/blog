package com.jason.controller.admin;

import com.github.pagehelper.PageInfo;
import com.jason.model.entity.Tag;
import com.jason.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/tag")
@Slf4j
public class AdminTagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(path = {"/",""})
    public String toTagPage(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                 @RequestParam(value = "size",defaultValue = "5") Integer size,
                                 Model model,
                                 HttpServletRequest request){

        PageInfo<Tag> tags = tagService.getTags(page,size);
        model.addAttribute("tags",tags) ;


        log.info("X-Pjax {}",request.getHeader("X-Pjax"));
        if(request.getHeader("X-Pjax") != null){
            return "admin/common-template/tag" ;
        }

        return "admin/tag" ;
    }

    @RequestMapping("/save")
    public String saveTag(@RequestParam(value = "id",required = false) Integer id,
                               @RequestParam(value = "name",required = true) String name){

        if(id != null){
            Tag tag = new Tag(id,name,null);
            tagService.updateTag(tag);
        }else{
            Tag tag = new Tag(null,name,null);
            tagService.addTag(tag);
        }
        return "forward:/admin/tag/list";
    }

    @RequestMapping("/list")
    public String listTag(@RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "size",defaultValue = "5") Integer size,
                               Model model){

        PageInfo<Tag> tags = tagService.getTags(page,size);
        model.addAttribute("tags",tags) ;
        return "admin/common-template/tag::list";
    }

    @RequestMapping("/delete")
    public String deleteTag(@RequestParam(value = "id",required = true) Integer id){
        tagService.deleteTagById(id);
        return "forward:/admin/tag/list";
    }
}

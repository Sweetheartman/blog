package com.jason.controller.admin;

import com.github.pagehelper.PageInfo;
import com.jason.model.entity.Friends;
import com.jason.service.FriendsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/friends")
@Slf4j
public class AdminFriendsController {

    @Autowired
    private FriendsService friendsService;

    @RequestMapping(path = {"/",""})
    public String toTagPage(@RequestParam(value = "page",defaultValue = "1") Integer page,
                            @RequestParam(value = "size",defaultValue = "5") Integer size,
                            Model model,
                            HttpServletRequest request){

        PageInfo<Friends> friends = friendsService.getAllFriends(page,size);
        model.addAttribute("friends",friends) ;


        log.info("X-Pjax {}",request.getHeader("X-Pjax"));
        if(request.getHeader("X-Pjax") != null){
            return "admin/common-template/friends" ;
        }

        return "admin/friends" ;
    }

    @RequestMapping("/save")
    public String saveFriends(@RequestParam(value = "id",required = false) Integer id,
                              @RequestParam(value = "name",required = true) String name,
                              @RequestParam(value = "gender",required = false) String gender,
                              @RequestParam(value = "blogurl",required = true) String blogurl,
                              @RequestParam(value = "imgurl",required = false) String imgurl,
                              @RequestParam(value = "phone",required = false) String phone,
                              @RequestParam(value = "mail",required = false) String mail,
                              @RequestParam(value = "description",required = true) String description
                              ){

        if(id != null){
            Friends friends = new Friends(id,name,gender,blogurl,imgurl,phone,mail,description);
            friendsService.updateFriends(friends);
        }else{
            Friends friends = new Friends(null,name,gender,blogurl,imgurl,phone,mail,description);
            friendsService.addFriends(friends);
        }
        return "forward:/admin/friends/list";
    }

    @RequestMapping("/list")
    public String listFriends(@RequestParam(value = "page",defaultValue = "1") Integer page,
                          @RequestParam(value = "size",defaultValue = "5") Integer size,
                          Model model){

        PageInfo<Friends> friends = friendsService.getAllFriends(page,size);
        model.addAttribute("friends",friends) ;
        return "admin/common-template/friends::list";
    }

    @RequestMapping("/delete")
    public String deleteFriends(@RequestParam(value = "id",required = true) Integer id){
        friendsService.deleteFriends(id);
        return "forward:/admin/friends/list";
    }
}

package com.shetu.multipledboperation_jackrutorial.controller;

import com.shetu.multipledboperation_jackrutorial.model.User;
import com.shetu.multipledboperation_jackrutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
    private UserService userService;
@GetMapping("/")
    public String getAllUsers(Model model){
    List<User> list = userService.getAllUser();
    model.addAttribute("userList",list);
    return "user-list";
}

}

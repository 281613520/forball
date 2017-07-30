package com.xw.user.controller;

import com.xw.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ankh on 2017/6/9.
 */
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/admin/login")
    public Object login(){
        return  null;
    }
}

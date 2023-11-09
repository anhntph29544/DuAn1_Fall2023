package com.example.duan1.controller;


import com.example.duan1.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    ChucVuService chucVuService;

}

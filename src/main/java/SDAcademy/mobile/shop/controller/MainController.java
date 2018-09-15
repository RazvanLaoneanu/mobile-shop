package SDAcademy.mobile.shop.controller;

import SDAcademy.mobile.shop.entity.User;
import SDAcademy.mobile.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showIndex(){
        return "index";

    }

}

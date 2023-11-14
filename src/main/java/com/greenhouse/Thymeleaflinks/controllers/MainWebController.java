package com.greenhouse.Thymeleaflinks.controllers;

import com.greenhouse.Thymeleaflinks.data.HangSessionRepository;
import com.greenhouse.Thymeleaflinks.data.UserRepository;
import com.greenhouse.Thymeleaflinks.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainWebController {
    @Autowired
    private AuthenticationController authenticationController;
    @Autowired
    private HangSessionRepository hangSessionRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String welcome() {
        return "index";
    }

//    @GetMapping("/home")
//    public String displayHomePage(Model model, HttpServletRequest request) {
//        User loggedInUser = authenticationController.getUserFromSession(request.getSession());
//        if(loggedInUser!= null){
//            System.out.println("User: " + loggedInUser);
//            System.out.println("Hang Sessions: " + hangSessionRepository.findByUser(loggedInUser));
//            model.addAttribute("user", loggedInUser);
//            model.addAttribute("hangSessions", hangSessionRepository.findByUser(loggedInUser));
//            return "success";
//        } else{
//            return "redirect:/login";
//        }
//    }
}

package com.greenhouse.Thymeleaflinks.controllers;

import com.greenhouse.Thymeleaflinks.data.HangSessionRepository;
import com.greenhouse.Thymeleaflinks.data.UserRepository;
import com.greenhouse.Thymeleaflinks.models.HangSession;
import com.greenhouse.Thymeleaflinks.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/hangsession")
public class HangSessionController {
    @Autowired
    private HangSessionRepository hangSessionRepository;
    @Autowired
    private AuthenticationController authenticationController;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public String displayAddHangSessionForm(Model model) {
        model.addAttribute("hangSession", new HangSession());
        return "hangsession/add";
    }
    @PostMapping("/add")
    public String processAddHangSessionForm(@ModelAttribute HangSession newHangSession, HttpServletRequest request){
        User loggedInUser = authenticationController.getUserFromSession(request.getSession());
        System.out.println("post");

        if(loggedInUser != null){
            newHangSession.setUser(loggedInUser);
            hangSessionRepository.save(newHangSession);
            return "success.html";
        } else{
            return "redirect:/login";
        }
    }




}

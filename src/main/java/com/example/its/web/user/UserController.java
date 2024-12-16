package com.example.its.web.user;

import com.example.its.domain.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String showList(Model model){
        model.addAttribute("userList", userService.findAll());
        return "users/list";
    }

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute UserForm form){
        return "users/creationForm";
    }

    @PostMapping("/create")
    public String create(@Validated UserForm form, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }

        userService.create(form.toEntity());
        return "redirect:/users";
    }
}

package com.exam.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.exam.dto.UserDTO;
import com.exam.exam.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getProducts(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("content", "fragments/list_product");
        return "main";
    }

    @GetMapping("user/create")
    public String showCreateForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        model.addAttribute("content", "fragments/form");
        return "main";
    }

    @PostMapping("user/create")
    public String createUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("content", "fragments/form");
            // If there are validation errors, return to the create form with error messages
            return "main";
        }

        userService.createUser(userDTO);
        return "redirect:/user";
    }

    @GetMapping("user/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        System.out.println("User ID: " + id); // Log the ID
        UserDTO userDTO = userService.getUserDTOById(id);
        model.addAttribute("content", "fragments/form-update");
        model.addAttribute("userDTO", userDTO);
        return "main";
    }

    @PostMapping("user/edit/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid @ModelAttribute("userDTO") UserDTO userDTO,
            BindingResult result, Model model) {
        System.out.println("User ID: " + id); // Log the ID
        if (result.hasErrors()) {
            model.addAttribute("content", "fragments/form-update");
            return "main";
        }
        userService.updateUser(id, userDTO);
        return "redirect:/user";
    }

    @GetMapping("user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}

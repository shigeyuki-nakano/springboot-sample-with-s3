package com.example.springboot.sample.with.s3.controller;

import com.example.springboot.sample.with.s3.dto.FoodMemoRegisterRequestDto;
import com.example.springboot.sample.with.s3.service.FoodMemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final FoodMemoService foodMemoService;

    @GetMapping
    public String index(
            @ModelAttribute("request") FoodMemoRegisterRequestDto request) {
        return "register/index";
    }

    @PostMapping
    public String register(
            @ModelAttribute("request") @Validated FoodMemoRegisterRequestDto request,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return index(request);
        }
        model.addAttribute("request", request);

        foodMemoService.register(request);

        return "redirect:/";
    }
}

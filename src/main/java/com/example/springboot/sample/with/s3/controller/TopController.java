package com.example.springboot.sample.with.s3.controller;

import com.example.springboot.sample.with.s3.service.FoodMemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TopController {

    private final FoodMemoService foodMemoService;

    @GetMapping
    public String index(Model model) {
        final var foodMemoList = foodMemoService.findAll();

        model.addAttribute("foodMemoList", foodMemoList);

        return "index";
    }
}

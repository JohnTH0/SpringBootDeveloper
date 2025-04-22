package com.th.sbdeveloper.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ExamController {

    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model) { // View 단으로 데이터를 전달하는 모델객체
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("테스트");
        examplePerson.setAge(11);
        examplePerson.setHobbies(List.of("일","노예"));

        model.addAttribute("person", examplePerson);
        model.addAttribute("today", LocalDateTime.now());

        return "example";
    }

    @Setter
    @Getter
    class Person {
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}

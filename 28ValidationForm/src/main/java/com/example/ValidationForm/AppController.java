package com.example.ValidationForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AppController {

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("emp",new Emp());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String add(@Valid Emp emp, BindingResult res){

        if(res.hasErrors()){
            return "index";
        }

        return "success";

    }
}

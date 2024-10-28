package org.trump.vote.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class HomeController {
    @GetMapping(value = "/home", produces = "text/html")
    @ApiOperation(value = "主页", notes = "主页")
    public String index() {
        return "home";
    }
}

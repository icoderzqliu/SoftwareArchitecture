package org.example.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreeMarkerTest {

    @RequestMapping("/freeMarker")
    public String freeMarker1(Model model){

        model.addAttribute("name","lzq1");
        return "freeMarker";

    }

    @RequestMapping("/normal")
    public String freeMarker(Model model){

        model.addAttribute("name","lzq2");
        return "normal";

    }
}

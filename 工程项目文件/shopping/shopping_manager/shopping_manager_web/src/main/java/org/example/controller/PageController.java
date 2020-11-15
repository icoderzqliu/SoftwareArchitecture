package org.example.controller;

import org.example.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.EasyUITree;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    IProductCategoryService productCategoryService;

    @RequestMapping("/{page}")
    public String requestPage(@PathVariable String page)
    {
        return page;
    }

    @RequestMapping("/")
    public String requestIndex(){
        return "index";
    }

    @RequestMapping("/product_add")
    public String requestProductAdd(HttpServletRequest request){
        List<EasyUITree> categories = productCategoryService.findProductCategoryListByParentId((short) 0);
        request.getSession().setAttribute("categories",categories);

        return "product_add";
    }
}

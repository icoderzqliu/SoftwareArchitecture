package org.example.rest.controller;

import org.example.rest.service.IProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Res_Categories;

@Controller
@RequestMapping("/rest")
public class ProductCategoriesController {

    @Autowired
    IProductCategoriesService productCategoriesService;

    @RequestMapping("/productCategories/list")
    @ResponseBody
    public Res_Categories getCategories(){
        Res_Categories categories = productCategoriesService.getCategories();
        return  categories;
    }
}

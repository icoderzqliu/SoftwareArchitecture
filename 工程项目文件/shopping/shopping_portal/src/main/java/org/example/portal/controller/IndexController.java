package org.example.portal.controller;

import org.example.portal.service.ICategoriesService;
import org.example.portal.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Res_Categories;
import pojo.Res_Product;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ICategoriesService categoriesService;

    @Autowired
    IProductService productService;

    @RequestMapping("/index.html")
    public String index(ModelMap modelMap){

        Res_Categories categories = categoriesService.getCategories();
        List<Res_Product> products = productService.getProducts();

        modelMap.addAttribute("categories",categories);
        modelMap.addAttribute("products",products);

        return "Product";

    }
}

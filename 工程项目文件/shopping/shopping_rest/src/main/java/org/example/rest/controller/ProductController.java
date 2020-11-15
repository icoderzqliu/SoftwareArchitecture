package org.example.rest.controller;

import org.example.rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Res_Product;
import pojo.ResponseJsonResult;

@Controller
@RequestMapping("/rest")
public class ProductController {

    @Autowired
    IProductService productService;

    @RequestMapping("/product/list")
    @ResponseBody
    public ResponseJsonResult getProduct(){
        ResponseJsonResult responseJsonResult = productService.getProduct();
        return  responseJsonResult;
    }
}

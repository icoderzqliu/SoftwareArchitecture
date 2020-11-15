package org.example.controller;

import org.example.pojo.Product;
import org.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyGrid;
import pojo.ResponseJsonResult;

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @RequestMapping("/product/list")
    @ResponseBody
    public EasyGrid listProduct(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "rows",defaultValue = "10")int rows) {

        EasyGrid easyGrid = productService.listProduct(page, rows);


        return easyGrid;

    }

    @RequestMapping("product_save")
    @ResponseBody
    public ResponseJsonResult saveProduct(Product product){

        ResponseJsonResult responseJsonResult = productService.saveProduct(product);

        return responseJsonResult;
    }
}

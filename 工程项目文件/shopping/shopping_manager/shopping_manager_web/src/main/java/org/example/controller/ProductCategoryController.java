package org.example.controller;

import org.example.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.List;

@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {

    @Autowired
    IProductCategoryService productCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> getProductCategoryByParentId(@RequestParam(value = "id",defaultValue = "0") Short parentId)
    {
        List<EasyUITree> easyUITrees = productCategoryService.findProductCategoryListByParentId(parentId);
        return  easyUITrees;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseJsonResult addCategory(Short parentId,String name){
        ResponseJsonResult responseJsonResult = productCategoryService.addCategory(parentId, name);
        return  responseJsonResult;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseJsonResult deleteCategory(Short parentId,Short id){
        ResponseJsonResult responseJsonResult = productCategoryService.deleteCategory(parentId, id);
        return  responseJsonResult;
    }

}

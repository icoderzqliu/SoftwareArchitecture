package org.example.service.impl;

import org.example.mapper.ProductCategoryMapper;
import org.example.pojo.ProductCategory;
import org.example.pojo.ProductCategoryExample;
import org.example.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    public List<EasyUITree> findProductCategoryListByParentId(Short parentid) {

        ProductCategoryExample productCategoryExample = new ProductCategoryExample();

        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentid);
        List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(productCategoryExample);

        List<EasyUITree> easyUITrees = new ArrayList<>(productCategoryList.size());

        for (ProductCategory productCategory:productCategoryList) {

            EasyUITree easyUITree  = new EasyUITree();

            easyUITree.setId(productCategory.getId());
            easyUITree.setText(productCategory.getName());
            easyUITree.setState(productCategory.getParentId()==0?"closed":"open");
            easyUITree.setAttributes(productCategory.getParentId()+"");
            easyUITrees.add(easyUITree);

        }

        return easyUITrees;
    }

    @Override
    public ResponseJsonResult addCategory(Short parentid, String name) {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setParentId(parentid);
        productCategory.setName(name);

        productCategoryMapper.insert(productCategory);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setMsg(productCategory.getId()+"");


        return responseJsonResult;
    }

    @Override
    public ResponseJsonResult deleteCategory(Short parentid, Short id) {

        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();

        if(parentid==0){

            criteria.andIdEqualTo(id);
            ProductCategoryExample.Criteria criteria1 = productCategoryExample.createCriteria();
            criteria1.andParentIdEqualTo(id);

            productCategoryExample.or(criteria1);

        }else {
            criteria.andIdEqualTo(id);
        }

        productCategoryMapper.deleteByExample(productCategoryExample);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();

        responseJsonResult.setStatus(200);
        responseJsonResult.setMsg("成功");
        return responseJsonResult;
    }
}

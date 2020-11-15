package org.example.rest.service.impl;

import org.example.mapper.ProductCategoryMapper;
import org.example.pojo.ProductCategory;
import org.example.pojo.ProductCategoryExample;
import org.example.rest.service.IProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Res_Categories;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoriesServiceImpl implements IProductCategoriesService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    public Res_Categories getCategories() {

        Res_Categories res_categories = new Res_Categories();

        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();

        criteria.andParentIdEqualTo((short) 0);

        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(productCategoryExample);

        List<Res_Categories.CategoriesBean> categories = new ArrayList<>();

        for (int i = 0; i <productCategories.size() ; i++) {

            Res_Categories.CategoriesBean categoriesBean = new Res_Categories.CategoriesBean();
            ProductCategory productCategory = productCategories.get(i);
            categoriesBean.setName(productCategory.getName());
            categoriesBean.setCatId(productCategory.getId()+"");

            List<Res_Categories.CategoriesBean.SubcategoriesBean> subcategoriesBeanList=getSubCategories(productCategory.getId());
            categoriesBean.setSubcategories(subcategoriesBeanList);

            categories.add(categoriesBean);
        }

        res_categories.setCategories(categories);

        return res_categories;
    }

    private List<Res_Categories.CategoriesBean.SubcategoriesBean> getSubCategories(Short id) {

        List<Res_Categories.CategoriesBean.SubcategoriesBean> list = new ArrayList<>();

        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(productCategoryExample);

        for (int i = 0; i < productCategories.size(); i++) {

            Res_Categories.CategoriesBean.SubcategoriesBean subcategoriesBean = new Res_Categories.CategoriesBean.SubcategoriesBean();
            ProductCategory productCategory = productCategories.get(i);
            subcategoriesBean.setCatId(productCategory.getId()+"");
            subcategoriesBean.setName(productCategory.getName());

            list.add(subcategoriesBean);
        }
        return list;

    }
}

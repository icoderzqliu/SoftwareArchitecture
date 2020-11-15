package org.example.rest.service.impl;

import com.github.pagehelper.PageHelper;
import org.example.mapper.ProductMapper;
import org.example.pojo.Product;
import org.example.pojo.ProductExample;
import org.example.rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Res_Product;
import pojo.ResponseJsonResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public ResponseJsonResult getProduct() {

        PageHelper.startPage(1,50);
        ProductExample productExample = new ProductExample();
        List<Product> products = productMapper.selectByExample(productExample);

        List<Res_Product> res_products= new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {

            Res_Product res_product = new Res_Product();
            Product product = products.get(i);
            res_product.setPrice(product.getPrice());
            res_product.setId(product.getId());
            res_product.setName(product.getName());
            res_product.setImgUrl(product.getImage());

            res_products.add(res_product);
        }

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setList(res_products);
        return responseJsonResult;
    }
}

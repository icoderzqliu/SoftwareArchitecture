package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.ProductMapper;
import org.example.pojo.Product;
import org.example.pojo.ProductExample;
import org.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyGrid;
import pojo.ResponseJsonResult;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public ResponseJsonResult saveProduct(Product product) {

        product.setStatus((byte) 1);
        productMapper.insert(product);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setStatus(200);
        return responseJsonResult;
    }

    @Override
    public EasyGrid listProduct(int pages, int rows) {

        ProductExample productExample = new ProductExample();

        PageHelper.startPage(pages,rows);
        List<Product> productList = productMapper.selectByExample(productExample);

        PageInfo<Product> pageInfo=new PageInfo<>(productList);

        EasyGrid easyGrid = new EasyGrid();

        easyGrid.setTotal((int) pageInfo.getTotal());

        easyGrid.setRows(productList);


        return easyGrid;
    }
}

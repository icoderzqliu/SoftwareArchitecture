package org.example.service;

import org.example.pojo.Product;
import pojo.EasyGrid;
import pojo.ResponseJsonResult;

public interface IProductService {
    ResponseJsonResult saveProduct(Product product);

    EasyGrid listProduct(int pages,int rows);
}

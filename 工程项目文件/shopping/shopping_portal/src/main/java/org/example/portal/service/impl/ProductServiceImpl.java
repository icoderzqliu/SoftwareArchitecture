package org.example.portal.service.impl;

import com.google.gson.Gson;
import org.example.portal.service.IProductService;
import org.example.portal.util.GsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pojo.Res_Product;
import pojo.ResponseJsonResult;
import utils.HttpClientUtil;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Value("${REST_URL}")
    private  String REST_URL;

    @Value("${REST_PRODUCT_LIST}")
    private String REST_PRODUCT_LIST;

    @Override
    public List<Res_Product> getProducts() {

        try {
            String result = HttpClientUtil.httpGet(REST_URL + REST_PRODUCT_LIST);

            ResponseJsonResult responseJsonResult = GsonUtils.FromGson(ResponseJsonResult.class, result);

            List<Res_Product> list = (List<Res_Product>) responseJsonResult.getList();
            return  list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

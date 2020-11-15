package org.example.portal.service.impl;

import org.example.portal.service.ICategoriesService;
import org.example.portal.util.GsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pojo.Res_Categories;
import utils.HttpClientUtil;

import java.io.IOException;

@Service
public class CategoriesServiceImpl implements ICategoriesService {
    
    @Value("${REST_URL}")
    private  String REST_URL;
    
    @Value("${REST_CAT_LIST}")
    private String REST_CAT_LIST;
    
    @Override
    public Res_Categories getCategories() {

        try {
            String result = HttpClientUtil.httpGet(REST_URL + REST_CAT_LIST);
            Res_Categories res_categories = GsonUtils.FromGson(Res_Categories.class, result);
            return  res_categories;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
        
    }
}

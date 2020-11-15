package org.example.service;

import pojo.EasyUITree;
import pojo.ResponseJsonResult;


import java.util.List;

public interface IProductCategoryService {
    List<EasyUITree> findProductCategoryListByParentId(Short parentid);

    ResponseJsonResult addCategory(Short parentid, String name);

    ResponseJsonResult deleteCategory(Short parentid, Short id);
}

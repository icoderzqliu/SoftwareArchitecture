package org.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.ProductCategory;
import org.example.pojo.ProductCategoryExample;

public interface ProductCategoryMapper {
    int countByExample(ProductCategoryExample example);

    int deleteByExample(ProductCategoryExample example);

    int deleteByPrimaryKey(Short id);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    List<ProductCategory> selectByExample(ProductCategoryExample example);

    ProductCategory selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    int updateByExample(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}
package com.itcast.mapper;


import com.itcast.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /**
     * 查询所有
     */
    List<Brand> selectAll();

    /**
     * 查看详情： 根据id
     */
    Brand selectById(int id);

    /**
     * 条件查询
     * * 参数接收
     *  1.散装参数  需要使用@Param("SQL种的参数占位符名称")
     *  2.实体类封装参数  保证SQL种的参数名和实体类属性名对应上，即可设置成功
     *  3.map集合 保证SQL种的参数名和map集合的键的名称对应上
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
//    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

//    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);


    /**
     * 单条件动态查询
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改 返回受影响的行数
     * @param brand
     * @return
     */
    int update(Brand brand);

    /**
     * 删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);
}

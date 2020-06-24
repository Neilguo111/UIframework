package com.qingxiao.mapper;

import com.qingxiao.ApiBeans;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

    @Mapper
    public interface ApiBeansMapper {

        void insertApi(ApiBeans apiBeans);

        ApiBeans selectById(int id);

        ApiBeans selectByName(String name);

        // 返回指定容量的数据
        List<ApiBeans> getBeans(int size);

        List<ApiBeans> getAllBeans();

        List<Integer> getIds();
}

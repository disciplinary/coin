package com.base;

import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * MapStruct 基类
 *
 * @author DreamChan
 */
public interface BaseMapStruct<V, E, P, Q> {

    /**
     *  Entity 转 Vo
     */
    V toVo(E source);


    /**
     *  EditParam 转 Entity
     */
    E toEntity(P source);

    /**
     *  QueryParam 转 Entity
     */
    E pageQueryParamToEntity(Q source);

    /**
     *  Entity 集合 转 Vo 集合
     */
    List<V> toVoList(List<E> source);

    /**
     *  Entity 集合 转 Vo 集合
     */
    Page<V> toVoList(IPage source);
}

package com.zy.demo.service;

import com.zy.demo.obj.Entity;

/**
 * 实体业务
 *
 * @author zy
 */
public interface EntityService {

    /**
     * 查询实体
     *
     * @return 实体对象
     */
    Entity queryEntity();

    /**
     * 新增实体
     */
    void addEntity(Entity entity);
}

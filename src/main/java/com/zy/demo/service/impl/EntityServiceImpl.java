package com.zy.demo.service.impl;

import com.zy.demo.obj.Entity;
import com.zy.demo.service.EntityService;

/**
 * 实体业务实现类
 *
 * @author zy
 */
public class EntityServiceImpl implements EntityService {
    @Override
    public Entity queryEntity() {
        System.out.println("查询实体--queryEntity");
        return new Entity();
    }

    @Override
    public void addEntity(Entity entity) {
        System.out.println("新增实体--addEntity--" + entity);
    }
}

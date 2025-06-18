package com.model.dao;

import java.util.List;

public interface InterfaceDAO<Entity, Key> {
    abstract public void create(Entity e);

    abstract public void update(Entity e);

    abstract public void deleteById(Key k);

    abstract public List<Entity> selectBySql(String sql, Object... args);

    abstract public List<Entity> selectAll();

    abstract public Entity selectById(Key k);
}

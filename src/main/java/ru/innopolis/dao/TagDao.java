package ru.innopolis.dao;

import ru.innopolis.entity.Tag;

import java.util.List;

public class TagDao extends BaseDAO<Tag> {

    public List<Tag> getAll() {
        return super.getAll(Tag.class);
    }

    public Tag get(String id) {
        return super.get(Tag.class, id);
    }

}
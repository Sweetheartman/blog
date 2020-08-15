package com.jason.model.entity;


public class Tag {
    private Integer id ;
    private String name ;
    private Integer count ;

    public Tag(){}
    public Tag(Integer id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

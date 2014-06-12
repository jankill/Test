package com.dongyf.spring.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongyf on 2014/6/9.
 */
public class Node {
    private Long id;
    private String name;
    private Node parent;
    private List<Node> children = new ArrayList<Node>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }
}

package com.dongyf.spring.entity;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by dongyf on 2014/6/10.
 */
public class JsonNode {
    private Long id;
    private String name;
    private boolean hasChildren;
    private Collection<JsonNodeRef> childrenRef = new HashSet<JsonNodeRef>();

    public JsonNode(Node node) {
        this.id = node.getId();
        this.name = node.getName();
        this.hasChildren = !node.getChildren().isEmpty();
        for(Node child: node.getChildren()) {
            this.childrenRef.add(new JsonNodeRef(child));
        }
    }

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

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public Collection<JsonNodeRef> getChildrenRef() {
        return childrenRef;
    }

    public void setChildrenRef(Collection<JsonNodeRef> childrenRef) {
        this.childrenRef = childrenRef;
    }

    @Override
    public String toString() {
        return "JsonNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hasChildren=" + hasChildren +
                ", childrenRef=" + childrenRef +
                '}';
    }
}

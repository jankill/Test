package com.dongyf.spring.entity;

/**
 * Created by dongyf on 2014/6/10.
 */
public class JsonNodeRef {
    private String $ref;

    public JsonNodeRef(Node node) {
        this.$ref = node.getId().toString();
    }

    public String get$ref() {
        return $ref;
    }

    public void set$ref(String $ref) {
        this.$ref = $ref;
    }

    @Override
    public String toString() {
        return "JsonNodeRef{" +
                "$ref='" + $ref + '\'' +
                '}';
    }
}

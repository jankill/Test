package com.dongyf.spring.dao;

import com.dongyf.spring.entity.Node;

import java.util.List;

/**
 * Created by dongyf on 2014/6/8.
 */
public interface TreeDao {
    public List<Node> getRoot();
    public List<Node> findChildren(String id);
    public Node findNode(String id);

}

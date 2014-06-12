package com.dongyf.spring.biz;

import com.dongyf.spring.entity.JsonNode;
import com.dongyf.spring.entity.Node;

import java.util.List;

/**
 * Created by dongyf on 2014/6/8.
 */
public interface TreeService {
    public JsonNode findNode(String id);
    public List<Node> findChildren(String parentId);
    public List<JsonNode> getRoot();

    aasdasdas
}

package com.dongyf.spring.biz;

import com.dongyf.spring.dao.TreeDao;
import com.dongyf.spring.entity.JsonNode;
import com.dongyf.spring.entity.Node;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by dongyf on 2014/6/8.
 */
@Service
public class TreeServiceImpl implements TreeService {

    private TreeDao treeDao;

    @Resource
    public void setTreeDao(TreeDao treeDao) {
        this.treeDao = treeDao;
    }


/*    public Set<Root> nodesToJsonNodes(List<Node> nodes) {
        Set<Root> children = new HashSet<Root>();
        for (Node node : nodes) {
            node.setChildren(findChildren(String.valueOf(node.getId())));
            children.add(new Root(node));
        }
        return children;
    }*/

    /*public JsonNode(Node node) {
        this.id = node.getId();
        this.name = node.getName();
        this.hasChildren = !node.getChildren().isEmpty();
        for(Node child: node.getChildren()) {
            this.childrenRef.add(new JsonNodeRef(child));
        }
    }*/

    @Override
    public List<JsonNode> getRoot() {
        List<Node> nodes = treeDao.getRoot();
        List<JsonNode> children = new ArrayList<JsonNode>();
        for (Node node : nodes) {
            node.setChildren(treeDao.findChildren(node.getId().toString()));
            children.add(new JsonNode(node));
        }
        return children;

    }

    @Override
    public JsonNode findNode(String id) {
        Node node = treeDao.findNode(id);
        node.setChildren(treeDao.findChildren(node.getId().toString()));
        JsonNode jsonNode = new JsonNode(node);
        return jsonNode;
    }

    @Override
    public List<Node> findChildren(String id) {
        List<Node> nodes = treeDao.findChildren(id);
        return nodes;

    }

    /*@Override
    public JsonNode findNode(String id) {
        Set<Root> children = new HashSet<Root>();
        List<Root> roots = treeDao.findNode(id);
        children.addAll(roots);
        Root rt = treeDao.getRoot(id);
        Node node = new Node();
        node.setName(rt.getName());
        node.setId(rt.getId());
        node.setChildren(children);

        return node;
    }*/
}

package com.dongyf.spring.controller;

import com.dongyf.spring.biz.TreeService;
import com.dongyf.spring.entity.JsonNode;
import flexjson.JSONSerializer;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dongyf on 2014/6/11.
 */
@RequestMapping(value = "data")
@Scope("prototype")
@Controller
public class TreeController {

    @Resource
    public void setTreeService(TreeService treeService) {
        this.treeService = treeService;
    }

    private TreeService treeService;
    @RequestMapping(value = "/root", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public HttpEntity<String> getRoot() {
        List<JsonNode> jsonNodeSet = treeService.getRoot();

        JSONSerializer jsonSerializer = new JSONSerializer();
        String rootToJson = jsonSerializer.include("childrenRef").serialize(jsonNodeSet);
        return new HttpEntity<String>(rootToJson);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public HttpEntity<String> get(@PathVariable("id") Long id) {
        JsonNode jsonNode = treeService.findNode(id.toString());
        JSONSerializer jsonSerializer = new JSONSerializer();
        String rootToJson = jsonSerializer.include("childrenRef").serialize(jsonNode);
        return new HttpEntity<String>(rootToJson);
    }
}

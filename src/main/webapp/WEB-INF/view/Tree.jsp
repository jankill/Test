<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Welcome WebMail!</title>
    <link rel="stylesheet"
          href="<c:url value="/resources/dojo/dojo/resources/dojo.css"/>"
          type="text/css">
    <link rel="stylesheet"
          href="<c:url value="/resources/dojo/dijit/themes/dijit.css"/>"
          type="text/css">
    <link rel="stylesheet"
          href="<c:url value="/resources/dojo/dijit/themes/claro/claro.css"/>"
          type="text/css">

    <style>
        html, body {
            height: 100%;
            margin: 0;
            overflow: hidden;
            padding: 0;
        }

    </style>
    <script type="text/javascript"
            src="<c:url value="/resources/dojo/dojo/dojo.js" />"
            data-dojo-config="'isDebug': true,'locale': 'zh-cn','async':true"></script>

    <script type="text/javascript">
        require([
            "dojox/data/JsonRestStore",
            "dijit/Tree", "dijit/tree/ForestStoreModel", "dojo/domReady!"
        ], function (JsonRestStore, Tree, ForestStoreModel) {

            var store = new JsonRestStore({
                target: "data/",
                idAttribute: "id"
            });
            var treeModel = new ForestStoreModel({
                store: store,
                query: "root",
                childrenAttrs: ["childrenRef"],
                labelAttr: "name",
                deferItemLoadingUntilExpand: true,
                mayHaveChildren: function (item) {
                    return store.getValue(item, "hasChildren") == true;
                }
            });

            var tree = new Tree({
                        model: treeModel,
                        showRoot: false,
                        onClick: function (item, node) {
                            location.href = "/WebMail/tree/nodes/" + item.id;
                        }
                    },
                    "tree");
        });
    </script>
</head>
<body>
<div id="tree"></div>
</body>
</html>

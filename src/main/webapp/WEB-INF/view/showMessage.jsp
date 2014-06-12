<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <title>GridxDemo!</title>
    <link rel="stylesheet"
          href="<c:url value="/resources/dojo/dojo/resources/dojo.css"/>"
          type="text/css">
    <link rel="stylesheet"
          href="<c:url value="/resources/dojo/dijit/themes/dijit.css"/>"
          type="text/css">
    <link rel="stylesheet"
          href="<c:url value="/resources/dojo/dijit/themes/claro/claro.css"/>"
          type="text/css">
    <link rel="stylesheet"
          href="<c:url value="/resources/dojo/dgrid/css/dgrid.css"/>"
          type="text/css">
    <link rel="stylesheet"
          href="<c:url value="/resources/dojo/dgrid/css/skins/claro.css"/>"
          type="text/css">
    <style>
        html, body {
            height: 100%;
            margin: 0;
            overflow: hidden;
            padding: 0;
        }

        #appLayout {
            height: 100%;
        }

        #leftCol {
            width: 14em;
        }

        #viewsChart {
            width: 550px;
            height: 550px;
        }
    </style>
    <script type="text/javascript"
            src="<c:url value="/resources/dojo/dojo/dojo.js" />"
            data-dojo-config="'isDebug': true,'locale': 'zh-cn','async':true"></script>

    <script type="text/javascript">
        require([ "dojo/store/JsonRest",
            "dojo/_base/declare",
            "dgrid/Grid",
            "dojo/request",
            "dojo/store/JsonRest",
            "dojo/data/ObjectStore",
            "dojo/store/Memory",
            "dgrid/extensions/Pagination",
            "dgrid/Selection",
            "dgrid/Keyboard",
            "dgrid/editor",
            "dojo/domReady!"], function (JsonRest, declare, Grid, request, JsonRest, ObjectStore, Memory, Pagination, Selection, Keyboard, editor) {
            var store = new JsonRest({idProperty: 'id',
                target: "getAllInv"
            });
            store.query("", {start: 0, count: 15}).then(function (results) {
                /* var dataStore = new ObjectStore({ob})*/
                // Create an instance of OnDemandGrid referencing the store
                var grid = new (declare([Grid, Pagination]))({
                    store: store,
                    columns: [
                        {field: "id", label: "First Name"},
                        editor({
                            label: "Last Name",
                            field: "userName",
                            editor: "text",
                            editOn: "dblclick"
                        }),

                        { field: "email", label: "Games Played"}
                    ],
                    loadingMessage: "正在加载...",
                    noDataMessage: "没有找到相关的数据!",
                    pagingLinks: false,
                    pagingTextBox: true,
                    firstLastArrows: true,

                    rowsPerPage: 15,
                    pageSizeOptions: [10, 150, 25]

                }, "gridxNode");

            });

            /*
             request("getAllInv", {
             handleAs: "json"
             }).then(function (response) {
             // Once the response is received, build an in-memory store
             // with the data
             var store = new Memory({ data: response });
             // Create an instance of OnDemandGrid referencing the store


             });
             */
        });
    </script>
</head>
<body>
<div id="gridxNode"></div>
</body>
</html>

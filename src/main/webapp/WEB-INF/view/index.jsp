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

        #appLayout {
            height: 100%;
        }


    </style>
    <script type="text/javascript"
            src="<c:url value="/resources/dojo/dojo/dojo.js" />"
            data-dojo-config="'isDebug': true,'locale': 'zh-cn','async':true"></script>

    <script type="text/javascript">
        require([
            "dijit/layout/BorderContainer",
            "dijit/layout/TabContainer",
            "dojox/layout/ContentPane",
            "dijit/form/Button",
            "dijit/registry",
            "dijit/Menu",
            "dijit/MenuItem",
            "dijit/MenuBar",
            "dijit/MenuBarItem",
            "dijit/PopupMenuBarItem",
            "dojo/domReady!"
        ], function (BorderContainer, TabContainer, ContentPane, Button, registry, Menu, MenuItem, MenuBar, MenuBarItem, PopupMenuBarItem) {


            var indexTab = new ContentPane({
                id: "indexTab",
                title: "首页",
                href: "showMessage",
                executeScripts: true,
                style: "height:100%"
            });
            var appLayout = new BorderContainer({
                id: "app",
                design: "headline",
                style: "height:100%"
            }, "appLayout");


            //left ContentPane
            var contentTabs = new TabContainer({
                id: "centerContentPane",
                region: "center",
                "class": "centerPanel"
            });
            appLayout.addChild(contentTabs);
            var leftContentPane = new ContentPane({
                id: "leftContentPane",
                region: "left",
                "class": "edgePanel",
                href: "tree",
                splitter: "true",
                style: "width:160px"
            });
            appLayout.addChild(leftContentPane);

            var bottomContentPane = new ContentPane({
                id: "bottomContentPane",
                region: "bottom",
                "class": "edgePanel"

            });
            appLayout.addChild(bottomContentPane);
            var editPane = new ContentPane({
                id: "editPane",
                title: "EditPane1",
                href: "showMessage",
                executeScripts: true,
                closable: true,
                style: "height:100%"
            });
            contentTabs.addChild(editPane);


            appLayout.startup();

        });
    </script>

</head>
<body class="claro">
<div id="mainMenu"></div>
<div id="appLayout" class="demoLayout"></div>
</body>
</html>

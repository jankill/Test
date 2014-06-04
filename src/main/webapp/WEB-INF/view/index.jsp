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

        #layoutBorderContainer {
            height: 100%;
        }

        #leftCol {
            width: 14em;
        }

        /*.claro .demoLayout .edgePanel {
            background-color: #d0e9fc;
        }*/

        #viewsChart {
            width: 550px;
            height: 550px;
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

            // create the Menu container
            var mainMenu = new MenuBar({}, "mainMenu");

            // create Menu container and child MenuItems
            // for our sub-menu (no srcNodeRef; we will
            //add it under a PopupMenuItem)
            var taskMenu = new Menu({
                id: "taskMenu"
            });

            // define the task sub-menu items
            taskMenu.addChild(new MenuItem({
                id: "complete",
                label: "Mark as Complete"
            }));

            taskMenu.addChild(new MenuItem({
                id: "cancel",
                label: "Cancel"
            }));

            taskMenu.addChild(new MenuItem({
                id: "begin",
                label: "Begin"
            }));
            var layoutTabContainer = new TabContainer({
                id: "layoutTabContainer",
                style: "height:100%"
            }, "layoutBorderContainer");
            var indexTab = new ContentPane({
                id: "indexTab",
                title: "首页",
                //href: "showMessage",
                executeScripts: true,
                style: "height:100%"
            });
            layoutTabContainer.addChild(indexTab);


            // create and add main menu items
            mainMenu.addChild(new MenuBarItem({
                id: "edit",
                label: "Edit",
                onClick: function () {

                    var layoutBorderContainer = new BorderContainer({
                        id: "layoutBorderContainer",
                        design: "headline"

                    });

                    //center ContentPane
                    var layoutCenter = new ContentPane({
                        id: "layoutCenter",
                        region: "center",
                        "class": "centerPanel",
                        href: "showMessage",
                        executeScripts: true
                    });
                    layoutBorderContainer.addChild(layoutCenter);
                    
                    //left ContentPane
                    var layoutLeft = new ContentPane({
                        id: "layoutLeft",
                        region: "left",
                        "class": "edgePanel",
                        splitter: "true",
                        style: "width:160px"
                    });
                    layoutBorderContainer.addChild(layoutLeft);
                    var editPane = new ContentPane({
                        id: "editPane",
                        title: "EditPane1",
                        executeScripts: true,
                        closable:true,
                        style: "height:50%"
                    });
                    layoutTabContainer.addChild(editPane);
                    editPane.addChild(layoutBorderContainer);
                    layoutTabContainer.selectChild(editPane);
                }
            }));

            mainMenu.addChild(new MenuBarItem({
                id: "view",
                label: "View"
            }));

            // make task menu item open the sub-menu we defined above
            mainMenu.addChild(new PopupMenuBarItem({
                id: "task",
                label: "Task",
                popup: taskMenu
            }));

            mainMenu.startup();
            taskMenu.startup();
            layoutTabContainer.startup();

        });
    </script>

</head>
<body class="claro">
<div id="mainMenu"></div>
<div id="layoutBorderContainer" class="demoLayout"></div>
</body>
</html>

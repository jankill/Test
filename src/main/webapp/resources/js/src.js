/**
 * Created by dongyf on 2014/5/23.
 */
var btnct = null;
var button = new Button({
    label: "new Tabs!",
    onClick: function () {

        var widget = registry.byId("userContent");

        alert(widget);
        if (typeof widget == "undefined") {
            btnct = new ContentPane({
                id: "userContent",
                closable: true,
                executeScripts: true,
                title: "new Tabs",
                content: "新建一个Tab",
                href: "showMessage",
                selected: true
            });
            contentTabs.addChild(btnct);
            contentTabs.selectChild(btnct);
        } else {
            contentTabs.selectChild(btnct);
        }

    }
}, "Btn");
var btnct1 = null;

var button1 = new Button({
    label: "new Tabs!",

    onClick: function () {
        var widget = registry.byId("userContent1");

        alert(widget);
        if (typeof widget == "undefined") {
            btnct1 = new ContentPane({
                id: "userContent1",
                closable: true,
                executeScripts: true,
                title: "new Tabs",
                content: "新建一个Tab",

                selected: true
            });
            contentTabs.addChild(btnct1);
            contentTabs.selectChild(btnct1);
        } else {
            contentTabs.selectChild(btnct1);
        }

    }
}, "Btn1");
leftContentPane.addChild(button);
leftContentPane.addChild(button1);
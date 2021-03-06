define(['dstore/Model', 'xstyle/util/createStyleSheet', 'xstyle/core/elemental'], function (Model, createStyleSheet, elemental) {
    var model = new Model({
        data: '{\n  "first": "Web",\n  "last": "Developer",\n  "favorites": [\n    "Data Bindings", "CSS Extensions"\n  ]\n}',
        ui: "#target {\n => h2 (data/first+' '+data/last),\n    ul (data/favorites) {\n      color: #060;\n    };\n  background-color: #ccc;\n  width: 200px;\n  padding: 10px;\n}",
        parsed: {}});
    model.observe('data', update);
    model.observe('ui', update);
    var parse, lastStyleSheet;

    function update() {
        console.log('model.data, model.ui', model.data, model.ui);
        var newSheet = createStyleSheet(model.ui);
        try {
            model.set('parsed', JSON.parse(model.data));
            model.property('data').set('error', '');
        } catch (e) {
            model.property('data').set('error', e);
        }
        setTimeout(function () {
            if (lastStyleSheet) {
                // remove the last stylesheet
                document.head.removeChild(lastStyleSheet);
                elemental.clearRenderers();
                var target = document.getElementById("target");
                if (target) {
                    target.innerHTML = "";
                }
            }

            lastStyleSheet = newSheet;
            var error;
            var ui = model.property('ui');
            parse.onerror = function (e, message) {
                ui.set('error', error = e + ' line' + message.slice(18));
            };
            try {
                parse(model.ui, lastStyleSheet.sheet);
                if (!error) {
                    ui.set('error', '');
                }
            } catch (e) {
                ui.set('error', e);
            }
        }, 100);
    }

    model.define = function (name, rule) {
        do {
            parse = rule.parse;
            rule = rule.parent;
        } while (!parse);
        return model;
    }
    return model;
});
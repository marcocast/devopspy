define([ 'backbone', 'marionette' ], function(Backbone, Marionette) {

	console.log("new App");

	var App = new Backbone.Marionette.Application();

	App.addRegions({
		headerRegion : "#header",
		mainRegion : "#main"
	});

	App.addInitializer(function() {

		Backbone.history.start();
	});

	return App;
});
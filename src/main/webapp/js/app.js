define([ 'backbone', 'marionette' ], function(Backbone, Marionette) {

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
define([ 'backbone', 'marionette' ], function(Backbone, Marionette) {

	var App = new Backbone.Marionette.Application();

	App.addRegions({
		headerRegion : "#header",
		sideNavRegion : "#side-nav",
		mainRegion : "#main-home"
	});

	App.addInitializer(function() {

		Backbone.history.start();
	});

	return App;
});
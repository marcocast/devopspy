define([ 'marionette', 'hbs!templates/about-view' ], function(Marionette,
		aboutViewTemplate) {

	console.log("new AboutView");

	return Backbone.Marionette.ItemView.extend({

		template : aboutViewTemplate

	});
});
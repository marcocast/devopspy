define([ 'marionette', 'hbs!templates/home-view' ], function(Marionette,
		homeViewTemplate) {

	console.log("new HomeView");

	return Backbone.Marionette.ItemView.extend({

		template : homeViewTemplate

	});
});
define([ 'marionette', 'hbs!templates/home-view' ], function(Marionette,
		homeViewTemplate) {

	return Backbone.Marionette.ItemView.extend({

		template : homeViewTemplate

	});
});
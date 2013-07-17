define([ 'marionette', 'hbs!templates/about-view' ], function(Marionette,
		aboutViewTemplate) {

	return Backbone.Marionette.ItemView.extend({

		template : aboutViewTemplate

	});
});
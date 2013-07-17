define([ 'marionette', 'hbs!templates/header-view' ], function(Marionette,
		headerViewTemplate) {

	return Backbone.Marionette.ItemView.extend({

		template : headerViewTemplate

	});
});
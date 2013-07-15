define([ 'marionette', 'hbs!templates/header-view' ], function(Marionette,
		headerViewTemplate) {

	console.log("new HeaderView");

	return Backbone.Marionette.ItemView.extend({

		template : headerViewTemplate

	});
});
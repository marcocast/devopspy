define([ 'marionette', 'hbs!templates/home-view' ], function(Marionette,
		homeViewTemplate) {
	
	'use strict';

	return Backbone.Marionette.ItemView.extend({

		template : homeViewTemplate

	});
});
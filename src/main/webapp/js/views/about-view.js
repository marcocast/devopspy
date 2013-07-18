define([ 'marionette', 'hbs!templates/about-view' ], function(Marionette,
		aboutViewTemplate) {
	
	'use strict';

	return Backbone.Marionette.ItemView.extend({

		template : aboutViewTemplate

	});
});
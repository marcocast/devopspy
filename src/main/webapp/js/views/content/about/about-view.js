define([ 'marionette', 'hbs!templates/content/about/about-view' ], function(Marionette,
		aboutViewTemplate) {
	
	'use strict';

	return Backbone.Marionette.ItemView.extend({

		template : aboutViewTemplate

	});
});
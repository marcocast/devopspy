define([ 'marionette', 'hbs!templates/content/dashboard/dashboard-view' ], function(Marionette,
		homeViewTemplate) {
	
	'use strict';

	return Backbone.Marionette.ItemView.extend({

		template : homeViewTemplate,
	});
});
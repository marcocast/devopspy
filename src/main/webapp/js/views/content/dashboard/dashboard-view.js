define([ 'marionette', 'hbs!templates/content/content-view' ], function(Marionette,
		dashboardViewTemplate) {
	
	'use strict';

	return Backbone.Marionette.ItemView.extend({

		template : dashboardViewTemplate
	});
});
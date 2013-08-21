define([ 'marionette', 'hbs!templates/content/content-view' ], function(Marionette,
		settingsViewTemplate) {
	
	'use strict';

	return Backbone.Marionette.ItemView.extend({

		template : settingsViewTemplate,
	});
});
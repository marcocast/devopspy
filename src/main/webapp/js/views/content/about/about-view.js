define([ 'marionette', 'hbs!templates/content/content-view' ], function(Marionette,
		aboutViewTemplate) {
	
	'use strict';

	return Backbone.Marionette.Layout.extend({

		template : aboutViewTemplate,
		
	});
});
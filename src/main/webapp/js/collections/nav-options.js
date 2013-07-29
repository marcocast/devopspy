define([ 'backbone', 'models/nav-option' ], function(Backbone, NavOption) {
	
	'use strict';
	
	return Backbone.Collection.extend({

		model : NavOption

	});
});
define([ 'backbone', 'models/header-option' ], function(Backbone, HeaderOption) {
	
	'use strict';
	
	return Backbone.Collection.extend({

		model : HeaderOption

	});
});
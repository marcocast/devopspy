define([ 'backbone', 'models/profile' ], function(Backbone, Profile) {
	
	'use strict';
	
	return Backbone.Collection.extend({

		url : 'api/devopspyprofile',

		model : Profile,

		parse : function(response) {
			return response.content;
		}
	});
});
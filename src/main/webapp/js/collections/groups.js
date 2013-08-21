define([ 'backbone', 'models/group' ], function(Backbone, Group) {
	
	'use strict';
	
	return Backbone.Collection.extend({

		url : 'api/devopspyprofilegroup',

		model : Group,

		parse : function(response) {
			return response.content;
		}
	});
});
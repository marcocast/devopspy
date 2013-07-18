define([ 'backbone' ], function(Backbone) {
	
	'use strict';

	return Backbone.Model.extend({

		defaults : {
			title : "",
			target : "",
			active : false
		}
	});
});
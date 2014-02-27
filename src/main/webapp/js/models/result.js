define([ 'backbone' ], function() {
	
	'use strict';

	return Backbone.Model.extend({

		defaults : {
			id : null,
			result : null,
			profileName : null,
			executionDate : null,
			totOccourences : null
		}
	});
});
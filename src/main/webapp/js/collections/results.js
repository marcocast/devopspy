define([ 'backbone', 'models/result', 'models/search-data' ], function(Backbone, Result, SearchData) {
	
	'use strict';
	
	return Backbone.Collection.extend({

		url : 'grep',

		model : Result,

		parse : function(response) {
			return response.content;
		},
		
		loadResultsFromServer : function(searchData) {
			console.log('alerts:loadAlertsFromServerWithCriteria');
			this.create({
				data : searchData.toJSON()
			});
		}
	});
});
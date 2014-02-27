define([ 'backbone' ], function() {
	
	'use strict';

	return Backbone.Model.extend({

		defaults : {
			id : null,
			isRegex : true,
			expression : '',
			dosProfiles : []
		},

		urlRoot : 'api/searchdata',

		methodUrl : function (method){
			if (method == 'create'){
				return this.urlRoot;
			} else {
				return this.urlRoot + '/' + encodeURIComponent(this.id);
			}
		},

		sync : function(method, model, options) {
			options = options || {};
			options.url = this.methodUrl(method.toLowerCase());

			Backbone.sync(method, model, options);
		},
	});
});
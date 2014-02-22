define([ 'backbone' ], function() {
	
	'use strict';

	return Backbone.Model.extend({

		defaults : {
			name : 'New Profile',
			filePath : null,
			host : null,
			user : null,
			password : null,
			userAuthPrivateKeyLocation : null
		},

		urlRoot : 'api/profile',

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
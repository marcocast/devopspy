define([ 'models/profile', 'collections/profiles', 'backbone' ], function(Profile, Profiles) {
	
	'use strict';

	return Backbone.Model.extend({

		defaults : {
			name : "New Group",
		},
		
		urlRoot : 'api/devopspyprofilegroup',

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
		}
	});
});
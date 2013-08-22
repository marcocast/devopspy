define([ 'models/group', 'collections/groups', 'backbone' ], function(Group, Groups) {
	
	'use strict';

	return Backbone.Model.extend({

		defaults : {
			name : 'New Profile',
			filePath : null,
			host : null,
			user : null,
			password : null,
			userAuthPrivateKeyLocation : null,
			dosProfileGroups : null
		},

		urlRoot : 'api/devopspyprofile',

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
		
		hasGroup : function(groupId) {
			return _.filter(this.get('dosProfileGroups'), function(profileGroup) { return profileGroup.id == groupId; }).length > 0;
		}
	});
});
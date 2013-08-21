define([ 'marionette', 'models/profile', 'hbs!templates/content/dashboard/profiles/profile-view', 'bootstrap' ], function(Marionette,
		Profile, profileViewTemplate) {

	'use strict';

	return Backbone.Marionette.ItemView.extend({

		tagName : 'tr',

		template : profileViewTemplate,
		
		modelEvents: {
		    'change' : 'render'
		},

		events : {
			'click button.delete-profile' : 'deleteProfile',
			'click button.edit-profile' : 'editProfile'
		},
		
		onRender : function() {
			this.$el.find('span').tooltip({delay: { show: 500, hide: 100 }});
			this.$el.find('button').tooltip({delay: { show: 500, hide: 100 }});
		},

		deleteProfile : function() {
			this.model.destroy({
				success: function(model, response) {
					alert("profile destroyed!" + model.id);
				}, 
				
				error: function(model, response) {
					alert("profile " + model.id + " not destroyed, error " + response.status);
				},
				
				wait: true
			});
		},
		
		editProfile : function() {
			this.trigger("profile:edit");
		}
	});
});
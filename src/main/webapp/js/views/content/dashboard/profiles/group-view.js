define([ 'marionette', 'models/group', 'models/profile', 'collections/profiles', 'views/content/dashboard/profiles/group-profile-badge-view', 'hbs!templates/content/dashboard/profiles/group-view', 'bootstrap' ], function(Marionette,
		Group, Profile, Profiles, GroupProfileBadgeView, groupViewTemplate) {

	'use strict';

	return Backbone.Marionette.CompositeView.extend({

		tagName : 'tr',
		
		itemViewContainer : 'td.group-profiles',
		
		itemView : GroupProfileBadgeView,

		template : groupViewTemplate,
		
		modelEvents: {
		    'change' : 'render'
		},

		events : {
			'click button.delete-group' : 'deleteGroup',
			'click button.edit-group' : 'editGroup'
		},
		
		onRender : function() {
			this.$el.find('span').tooltip({delay: { show: 500, hide: 100 }});
			this.$el.find('button').tooltip({delay: { show: 500, hide: 100 }});
		},

		serializeData: function(){
			var data = Backbone.Marionette.ItemView.prototype.serializeData.apply(this, arguments);
			data.profilesCount = this.collection.length;
			return data;
		},

		deleteGroup : function() {
			this.model.destroy({
				success: function(model, response) {
					alert("group destroyed!" + model.id);
				}, 
				
				error: function(model, response) {
					alert("group " + model.id + " not destroyed, error " + response.status);
				},
				
				wait: true
			});
		},
		
		editGroup : function() {
			this.trigger("group:edit");
		}
	});
});
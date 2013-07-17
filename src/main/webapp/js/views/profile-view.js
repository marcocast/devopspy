define([ 'marionette', 'models/profile', 'hbs!templates/profile-view' ], function(Marionette,
		Profile, profileViewTemplate) {

	return Backbone.Marionette.ItemView.extend({

		tagName : 'li',

		template : profileViewTemplate,

		events : {
			'click a.delete-profile' : 'deleteProfile'
		},

		onBeforeRender : function() {
			this.$el.attr('value', this.model.id);
		},

		deleteProfile : function() {
			this.model.destroy({success: function(model, response) {
				  alert("profile destroyed!" + model.id);
			}});
		}
	});
});
define([ 'marionette', 'hbs!templates/profile-view' ], function(Marionette,
		profileViewTemplate) {

	console.log("new ProfileView");

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
				  alert("destroyed!");
			}});
		}
	});
});
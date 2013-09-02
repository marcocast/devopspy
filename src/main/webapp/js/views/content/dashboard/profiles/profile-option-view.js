define([ 'marionette', 'models/profile', 'hbs!templates/content/dashboard/profiles/profile-option-view', 'bootstrap' ], function(Marionette,
		Profile, profileOptionViewTemplate) {

	'use strict';

	return Backbone.Marionette.ItemView.extend({

		tagName : 'label',
		
		template : profileOptionViewTemplate,
		
		ui : {
			'checkbox' : 'input.profile-option'
		},
		
		onRender : function(){
			this.$el.addClass('checkbox');
			if (this.model.hasGroup(this.options.currentGroupId)){
				this.ui.checkbox.prop('checked', true);
			}
		},
		
		modelEvents: {
		    'change' : 'render'
		}
	});
});
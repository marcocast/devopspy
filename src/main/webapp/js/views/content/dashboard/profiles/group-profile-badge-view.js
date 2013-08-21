define([ 'marionette', 'models/profile', 'hbs!templates/content/dashboard/profiles/group-profile-badge-view', 'bootstrap' ], function(Marionette,
		Profile, groupProfileBadgeTemplate) {

	'use strict';

	return Backbone.Marionette.ItemView.extend({

		tagName : 'span',

		template : groupProfileBadgeTemplate,
		
		modelEvents: {
		    'change' : 'render'
		},

		onRender : function() {
			this.$el.addClass('label');
			this.$el.attr('data-toggle','tooltip');
			this.$el.attr('title', this.model.get('name'));
			this.$el.tooltip({delay: { show: 500, hide: 100 }});
		}
	});
});
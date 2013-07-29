define([ 'marionette', 'models/nav-option', 'hbs!templates/side-nav/side-nav-option-view' ], function(Marionette,
		NavOption, sideNavOptionViewTemplate) {

	'use strict';

	return Backbone.Marionette.ItemView.extend({
		
		tagName : 'li',

		template : sideNavOptionViewTemplate,
		
		initialize : function(){
			_.bindAll(this, "render");
		},	
		
		onRender : function(){
			if (this.model.get('active')){
				this.$el.addClass('active');
			}
		}
	});
});
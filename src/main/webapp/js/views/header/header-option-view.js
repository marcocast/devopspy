define([ 'marionette', 'models/nav-option', 'hbs!templates/header/header-option-view' ], function(Marionette,
		NavOption, headerOptionViewTemplate) {

	'use strict';

	return Backbone.Marionette.ItemView.extend({
		
		tagName : 'li',

		template : headerOptionViewTemplate,
		
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
define([ 'marionette', 'views/side-nav/side-nav-option-view' ], function(Marionette, SideNavOptionView) {
	
	'use strict';

	return Backbone.Marionette.CollectionView.extend({
		
		tagName : 'ul',

		itemView : SideNavOptionView,
		
		collectionEvents : {
			change : 'render'
		},
		
		modelEvents : {
			change : 'render'
		},
			
		onRender : function(){
			this.$el.addClass("nav nav-list bs-docs-sidenav nav-collapse collapse");
		}
	});
});
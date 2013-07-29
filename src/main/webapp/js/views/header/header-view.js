define([ 'marionette', 'views/header/header-option-view', 'hbs!templates/header/header-view' ], function(Marionette, HeaderOption, headerViewTemplate) {
	
	'use strict';

	return Backbone.Marionette.CompositeView.extend({

		tagName : 'div',
		
		itemViewContainer : 'ul.dos-main-nav',

		template : headerViewTemplate,
		
		itemView : HeaderOption,
		
		collectionEvents : {
			change : 'render'
		},
		
		modelEvents : {
			change : 'render'
		}
	});
});
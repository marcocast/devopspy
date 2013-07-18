define([ 'marionette', 'views/header-option-view', 'hbs!templates/header-view' ], function(Marionette, HeaderOption, headerViewTemplate) {
	
	'use strict';

	return Backbone.Marionette.CompositeView.extend({

		tagName : 'div',
		
		itemViewContainer : 'ul',

		template : headerViewTemplate,
		
		itemView : HeaderOption,
	});
});
define([ 'marionette', 'models/header-option', 'hbs!templates/header-option-view' ], function(Marionette,
		HeaderOption, headerOptionViewTemplate) {

	'use strict';

	return Backbone.Marionette.ItemView.extend({

		tagName : 'li',

		template : headerOptionViewTemplate,
		
	});
});
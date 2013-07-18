define([ 'app', 'marionette', '../collections/header-options', '../views/header-view', '../views/home-view',	'../views/about-view', '../views/main-view', '../defaults/default-header-options' ],
	function(App, Marionette, HeaderOptions, HeaderView, HomeView, AboutView, MainView, defaultHeaderOptions) {

		'use strict';

		return Marionette.Controller.extend({
	
			initialize : function(options) {
				var headerOptions = new HeaderOptions();
				headerOptions.reset(defaultHeaderOptions);
				var headerView = new HeaderView({ collection : headerOptions });
				App.headerRegion.show(headerView);
			},
	
			home : function() {
				App.mainRegion.show(new MainView());
			},
	
			about : function() {
				App.mainRegion.show(new AboutView());
	
			},
	
			profiles : function() {
				App.mainRegion.show(new MainView());
			}
		});
	});

define([ 'app', 'marionette', '../views/header-view', '../views/home-view',
		'../views/about-view', '../views/main-view' ],
		function(App, Marionette, HeaderView, HomeView, AboutView, MainView) {

			return Marionette.Controller.extend({

				initialize : function(options) {
					App.headerRegion.show(new HeaderView());
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

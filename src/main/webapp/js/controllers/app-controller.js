define([ 'app', 'marionette', '../views/header-view', '../views/home-view',
		'../views/about-view', '../views/main-view' ],
		function(App, Marionette, HeaderView, HomeView, AboutView, MainView) {

			console.log("new AppController");

			return Marionette.Controller.extend({

				initialize : function(options) {
					console.log("AppController.initialize");

					App.headerRegion.show(new HeaderView());
				},

				home : function() {
					console.log("AppController.home");

					App.mainRegion.show(new MainView());
				},

				about : function() {
					console.log("AppController.about");

					App.mainRegion.show(new AboutView());

				},

				profiles : function() {
					console.log("AppController.profiles");

					App.mainRegion.show(new MainView());
				}
			});
		});

require([ "app", "routers/app-router", "controllers/app-controller", "jquery", "backbone", "marionette", "bootstrap" ], 
	function(App, AppRouter, AppController) {
	
		'use strict';
	
		App.appRouter = new AppRouter({
			controller : new AppController()
		});
	
		App.start();
	});
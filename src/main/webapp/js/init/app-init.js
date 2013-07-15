require([ "app", "routers/app-router", "controllers/app-controller", "jquery",
		"backbone", "marionette", "bootstrap" ], function(App, AppRouter,
		AppController) {

	console.log("new AppRouter");

	App.appRouter = new AppRouter({
		controller : new AppController()
	});

	console.log("App start");

	App.start();
});
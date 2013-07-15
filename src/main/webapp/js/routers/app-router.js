define([ 'backbone', 'marionette', 'controllers/app-controller' ],
	function(Backbone, Marionette, AppControler) {

	console.log("new AppRouter");

	return Backbone.Marionette.AppRouter.extend({

		appRoutes : {
			'' : 'home',
			'home' : 'home',
			'about' : 'about',
			'profiles' : 'profiles'
		}
	});
});
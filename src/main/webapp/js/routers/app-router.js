define([ 'backbone', 'marionette', 'controllers/app-controller' ],
	function(Backbone, Marionette, AppControler) {
	
	'use strict';

	return Backbone.Marionette.AppRouter.extend({

		appRoutes : {
			'' : 'home',
			'home' : 'home',
			'about' : 'about',
			'profiles' : 'profiles'
		}
	});
});
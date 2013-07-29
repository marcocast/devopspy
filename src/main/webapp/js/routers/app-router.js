define([ 'backbone', 'marionette', 'controllers/app-controller' ],
	function(Backbone, Marionette, AppControler) {
	
	'use strict';

	return Backbone.Marionette.AppRouter.extend({

		appRoutes : {
			'' : 'dashboardSearch',
			'dashboard' : 'dashboardSearch',
			'dashboard/search' : 'dashboardSearch',
			'dashboard/graphs' : 'dashboardGraphs',
			'dashboard/statistics' : 'dashboardStatistics',
			'dashboard/components' : 'dashboardComponents',
			'dashboard/scheduler' : 'dashboardScheduler',
			'dashboard/profiles' : 'dashboardProfiles',
			'settings' : 'settingsAccount',
			'settings/account' : 'settingsAccount',
			'settings/users' : 'settingsUsers',
			'about' : 'aboutDevopspy',
			'about/devopspy' : 'aboutDevopspy',
			'about/licence' : 'aboutLicence',
		}
	});
});
define([ 'views/content/dashboard/dashboard-view', 'hbs!templates/content/dashboard/search/dashboard-search-view' ], function(DashboardView, dashboardSearchViewTemplate) {
	
	'use strict';

	return DashboardView.extend({
		
		template : dashboardSearchViewTemplate

	});
});
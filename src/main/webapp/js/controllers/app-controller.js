define([ 'app',
        'marionette',
        'defaults/default-header-options',
        'defaults/default-dashboard-options',
        'defaults/default-settings-options',
        'defaults/default-about-options',
        'collections/nav-options',
		'views/header/header-view',
		'views/side-nav/side-nav-view',
		'views/content/dashboard/dashboard-view',
		'views/content/dashboard/search/dashboard-search-view',
		'views/content/dashboard/graphs/dashboard-graphs-view',
		'views/content/dashboard/statistics/dashboard-statistics-view',
		'views/content/dashboard/components/dashboard-components-view',
		'views/content/dashboard/scheduler/dashboard-scheduler-view',
		'views/content/dashboard/profiles/dashboard-profiles-view',
		'views/content/settings/account/settings-account-view',
		'views/content/settings/users/settings-users-view',
		'views/content/about/devopspy/about-devopspy-view',
		'views/content/about/licence/about-licence-view',
		'views/content/main-view'
	], function(App, 
		Marionette,
		defaultHeaderOptions,
		defaultDashboardOptions,
		defaultSettingsOptions,
		defaultAboutOptions,
		NavOptions,
		HeaderView,
		SideNavView,
		HomeView,
		DashboardSearchView,
		DashboardGraphsView,
		DashboardStatisticsView,
		DashboardComponentsView,
		DashboardSchedulerView,
		DashboardProfilesView,
		SettingsAccountView,
		SettingsUsersView,
		AboutDevopspyView,
		AboutLicenceView,
		MainView) {

	'use strict';

	return Marionette.Controller.extend({

		initialize : function(options) {
			
			App.headerRegion.show(new HeaderView({
				collection : new NavOptions(defaultHeaderOptions)
			}));
			
			App.sideNavRegion.show(new SideNavView({
				collection : new NavOptions(defaultDashboardOptions)
			}));
		},

		dashboardSearch : function() {
			var navRoute = "#dashboard/search";
			
			this.setSideNavOptions(defaultDashboardOptions, navRoute);
			this.setHeaderNavOptions("#dashboard");

			App.mainRegion.show(new DashboardSearchView({
				model : App.sideNavRegion.currentView.collection.get(navRoute)
			}));
		},

		dashboardGraphs : function() {
			var navRoute = "#dashboard/graphs";
			
			this.setSideNavOptions(defaultDashboardOptions, navRoute);
			this.setHeaderNavOptions("#dashboard");

			App.mainRegion.show(new DashboardGraphsView({
				model : App.sideNavRegion.currentView.collection.get(navRoute)
			}));
		},

		dashboardStatistics : function() {
			var navRoute = "#dashboard/statistics";
			
			this.setSideNavOptions(defaultDashboardOptions, navRoute);
			this.setHeaderNavOptions("#dashboard");

			App.mainRegion.show(new DashboardStatisticsView({
				model : App.sideNavRegion.currentView.collection.get(navRoute)
			}));
		},

		dashboardComponents : function() {
			var navRoute = "#dashboard/components";
			
			this.setSideNavOptions(defaultDashboardOptions, navRoute);
			this.setHeaderNavOptions("#dashboard");

			App.mainRegion.show(new DashboardComponentsView({
				model : App.sideNavRegion.currentView.collection.get(navRoute)
			}));
		},

		dashboardScheduler : function() {
			var navRoute = "#dashboard/scheduler";
			
			this.setSideNavOptions(defaultDashboardOptions, navRoute);
			this.setHeaderNavOptions("#dashboard");

			App.mainRegion.show(new DashboardSchedulerView({
				model : App.sideNavRegion.currentView.collection.get(navRoute)
			}));
		},

		dashboardProfiles : function() {
			var navRoute = "#dashboard/profiles";
			
			this.setSideNavOptions(defaultDashboardOptions, navRoute);
			this.setHeaderNavOptions("#dashboard");

			App.mainRegion.show(new DashboardProfilesView({
				model : App.sideNavRegion.currentView.collection.get(navRoute)
			}));
		},

		settingsAccount : function() {
			var navRoute = "#settings/account";
			
			this.setSideNavOptions(defaultSettingsOptions, navRoute);
			this.setHeaderNavOptions("#settings");

			App.mainRegion.show(new SettingsAccountView({
				model : App.sideNavRegion.currentView.collection.get(navRoute)
			}));

		},

		settingsUsers : function() {
			var navRoute = "#settings/users";
			
			this.setSideNavOptions(defaultSettingsOptions, navRoute);
			this.setHeaderNavOptions("#settings");

			App.mainRegion.show(new SettingsUsersView({
				model : App.sideNavRegion.currentView.collection.get(navRoute)
			}));
		},

		aboutDevopspy : function() {
			
			var navRoute = "#about/devopspy";
			
			this.setSideNavOptions(defaultAboutOptions, navRoute);
			this.setHeaderNavOptions("#about");

			App.mainRegion.show(new AboutDevopspyView({
				model : App.sideNavRegion.currentView.collection.get(navRoute)
			}));
		},

		aboutLicence: function() {
			
			var navRoute = "#about/licence";
			
			this.setSideNavOptions(defaultAboutOptions, navRoute);
			this.setHeaderNavOptions("#about");

			App.mainRegion.show(new AboutLicenceView({
				model : App.sideNavRegion.currentView.collection.get(navRoute)
			}));
		},
		
		setSideNavOptions : function(navOptions, navRoute){
			
			App.sideNavRegion.currentView.collection.reset(navOptions);
			App.sideNavRegion.currentView.collection.each(function(option) {
				option.set({active:false});
			});
			App.sideNavRegion.currentView.collection.get(navRoute).set({active:true});
		},
		
		setHeaderNavOptions : function(navRoute){
			
			App.headerRegion.currentView.collection.each(function(option) {
				option.set({active:false});
			});
			App.headerRegion.currentView.collection.get(navRoute).set({active:true});
		}
	});
});

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
		'views/content/about/about-view',
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
		AboutView,
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
			this.setHeaderNavOptions("#dashboard");
			this.setSideNavOptions(defaultDashboardOptions, "#dashboard/search");
			App.mainRegion.show(new MainView());
		},

		dashboardGraphs : function() {
			this.setHeaderNavOptions("#dashboard");
			this.setSideNavOptions(defaultDashboardOptions, "#dashboard/graphs");
			App.mainRegion.show(new MainView());

		},

		dashboardStatistics : function() {
			this.setHeaderNavOptions("#dashboard");
			this.setSideNavOptions(defaultDashboardOptions, "#dashboard/statistics");
			App.mainRegion.show(new MainView());

		},

		dashboardComponents : function() {
			this.setHeaderNavOptions("#dashboard");
			this.setSideNavOptions(defaultDashboardOptions, "#dashboard/components");
			App.mainRegion.show(new MainView());

		},

		dashboardScheduler : function() {
			this.setHeaderNavOptions("#dashboard");
			this.setSideNavOptions(defaultDashboardOptions, "#dashboard/scheduler");
			App.mainRegion.show(new MainView());

		},

		dashboardProfiles : function() {
			this.setHeaderNavOptions("#dashboard");
			this.setSideNavOptions(defaultDashboardOptions, "#dashboard/profiles");
			App.mainRegion.show(new MainView());

		},

		settingsAccount : function() {
			this.setHeaderNavOptions("#settings");
			this.setSideNavOptions(defaultSettingsOptions, "#settings/account");
			App.mainRegion.show(new MainView());

		},

		settingsUsers : function() {
			this.setHeaderNavOptions("#settings");
			this.setSideNavOptions(defaultSettingsOptions, "#settings/users");
			App.mainRegion.show(new MainView());

		},

		aboutDevopspy : function() {
			this.setHeaderNavOptions("#about");
			this.setSideNavOptions(defaultAboutOptions, "#about/devopspy");
			App.mainRegion.show(new MainView());

		},

		aboutLicence : function() {
			this.setHeaderNavOptions("#about");
			this.setSideNavOptions(defaultAboutOptions, "#about/licence");
			App.mainRegion.show(new MainView());
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

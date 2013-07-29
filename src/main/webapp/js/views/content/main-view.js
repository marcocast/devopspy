define([ 'marionette', 'collections/profiles',
		'views/content/dashboard/profiles/profiles-view', 'views/content/dashboard/dashboard-view',
		'hbs!templates/main-view' ], function(Marionette, Profiles,
		ProfilesView, HomeView, mainViewTemplate) {

	'use strict';

	return Backbone.Marionette.Layout.extend({

		template : mainViewTemplate,

		regions : {
			sidebarRegion : "#sidebar",
			mainRegion : "#main"
		},

		initialize : function() {

			this.profiles = new Profiles();
			this.profiles.fetch();

			this.profilesView = new ProfilesView({
				collection : this.profiles
			});
			this.homeView = new HomeView();
		},

		onRender : function() {
			this.sidebarRegion.show(this.profilesView);
			this.mainRegion.show(this.homeView);
		}
	});
});
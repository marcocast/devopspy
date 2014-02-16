define([ 'marionette',
         'collections/profiles',
         'views/content/dashboard/profiles/profiles-view', 
         'hbs!templates/content/dashboard/profiles/dashboard-profiles-view' 
         ],
function(Marionette, 
		Profiles,
		ProfilesView,
		dashboardProfilesViewTemplate) {
	
	'use strict';

	return Backbone.Marionette.Layout.extend({
		
		template : dashboardProfilesViewTemplate,
		
		initialize : function(){
			this.profiles = new Profiles();
			this.profiles.fetch({'async':false});

			this.profilesView = new ProfilesView({
				collection : this.profiles
			});
		},
		
		regions : {
			profilesRegion : '#view-profiles',
		},
		
		onRender : function(){
			this.profilesRegion.show(this.profilesView);
		}
	});
});
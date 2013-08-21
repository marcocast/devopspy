define([ 'marionette',
         'collections/profiles',
         'collections/groups',
         'views/content/dashboard/profiles/profiles-view', 
         'views/content/dashboard/profiles/groups-view', 
         'hbs!templates/content/dashboard/profiles/dashboard-profiles-view' 
         ],
function(Marionette, 
		Profiles,
		Groups,
		ProfilesView,
		GroupsView,
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
			
			this.groups = new Groups();
			this.groups.fetch();

			this.groupsView = new GroupsView({
				collection : this.groups,
				profiles : this.profiles
			});
		},
		
		regions : {
			profilesRegion : '#view-profiles',
			groupsRegion : '#view-groups'
		},
		
		onRender : function(){
			this.profilesRegion.show(this.profilesView);
			this.groupsRegion.show(this.groupsView);
		}
	});
});
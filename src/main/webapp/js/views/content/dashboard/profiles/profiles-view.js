define([ 
	'marionette',
	'models/profile',
	'collections/profiles',
	'collections/groups',
	'views/content/dashboard/profiles/profiles-collection-view', 
	'views/content/dashboard/profiles/profile-modal-view', 
	'hbs!templates/content/dashboard/profiles/profiles-view' 
	],
function(
	Marionette, 
	Profile,
	Profiles,
	Groups,
	ProfilesCollectionView,
	ProfileModalView,
	profilesViewTemplate
) {
	
	'use strict';

	return Backbone.Marionette.Layout.extend({
		
		template : profilesViewTemplate,
		
		initialize : function(){
			
			var that = this;
			
			this.profilesCollectionView = new ProfilesCollectionView({
				collection : this.collection
			});
			
			this.profilesCollectionView.on("itemview:profile:edit", function(childView){
				that.editProfile(childView.model);
			});
		},
		
		ui : {
			newProfileButton : '#create-profile',
			showHideProfilesButton : '#show-hide-profiles',
			profilesCollectionRegion : '#profiles-collection'

		},
		
		events : {
			"click #create-profile": 'createProfile',
			"click #show-hide-profiles" : 'showHideProfiles'
		},
		
		regions : {
			profilesCollectionRegion : '#profiles-collection',
			profilesModalRegion : '#profiles-modal-region'
		},
		
		onRender : function(){
			this.profilesCollectionRegion.show(this.profilesCollectionView);
		},
		
		createProfile : function(){
			this.editProfile(new Profile());
		},
		
		editProfile : function(model){
			var profileModalView = new ProfileModalView({model : model, profiles : this.collection});
			this.profilesModalRegion.show(profileModalView);
		},
		
		showHideProfiles : function(){
			if (this.ui.profilesCollectionRegion.is(":visible")) {
				this.ui.showHideProfilesButton.text("Show profiles");
				this.ui.profilesCollectionRegion.hide(200);
			} else {
				this.ui.showHideProfilesButton.text("Hide profiles");
				this.ui.profilesCollectionRegion.show(200);
			}
		}
	});
});
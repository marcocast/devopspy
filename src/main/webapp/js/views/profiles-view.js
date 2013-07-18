define([ 'marionette', 'models/profile', 'collections/profiles', 'views/profile-view', 'hbs!templates/profiles-view' ],
	function(Marionette,Profile, Profiles, ProfileView, profilesCollectionViewTemplate) {

		'use strict';
	
		return Backbone.Marionette.CompositeView.extend({
	
			template : profilesCollectionViewTemplate,
	
			itemView : ProfileView,
	
			itemViewContainer : 'ol',
	
			id : 'profiles-collection',
	
			events : {
				'click a.btn' : 'createProfile'
			},
	
			ui : {
				newProfileName : 'input#new-profile-name',
				newProfileUser : 'input#new-profile-user',
				newProfilePassword : 'input#new-profile-password',
				newProfileHost : 'input#new-profile-host',
				newProfileFilePath : 'input#new-profile-file-path',
			},
	
			createProfile : function(){
	
				var newProfile = new Profile({
					name : this.ui.newProfileName.val(),
					filePath : this.ui.newProfileFilePath.val(),
					user : this.ui.newProfileUser.val(),
					password : this.ui.newProfilePassword.val(),
					host : this.ui.newProfileHost.val()
				});
	
				newProfile.save();
				this.collection.fetch();
			}
		});
	});
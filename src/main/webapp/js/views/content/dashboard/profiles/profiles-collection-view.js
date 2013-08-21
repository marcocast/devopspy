define([ 'marionette', 'models/profile', 'collections/profiles', 'views/content/dashboard/profiles/profile-view', 'hbs!templates/content/dashboard/profiles/profiles-collection-view' ],
	function(Marionette,Profile, Profiles, ProfileView, profilesCollectionViewTemplate) {

		'use strict';
	
		return Backbone.Marionette.CompositeView.extend({
	
			template : profilesCollectionViewTemplate,
	
			itemView : ProfileView,
	
			itemViewContainer : 'tbody',
	
			id : 'profiles-collection',
		});
	});
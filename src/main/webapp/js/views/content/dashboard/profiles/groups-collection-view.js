define([ 'marionette', 'models/group', 'collections/groups', 'models/profile', 'collections/profiles', 'views/content/dashboard/profiles/group-view', 'hbs!templates/content/dashboard/profiles/groups-collection-view' ],
	function(Marionette, Group, Groups, Profile, Profiles, GroupView, groupsCollectionViewTemplate) {

		'use strict';
	
		return Backbone.Marionette.CompositeView.extend({
	
			template : groupsCollectionViewTemplate,
	
			itemView : GroupView,
	
			itemViewContainer : 'tbody',
			
			collectionEvents : {
				change : 'render'
			},
			
			initialize : function(options){
				this.profiles = options.profiles;
			},
			
			buildItemView: function(group, ItemView){
				var filteredProfiles = this.profiles.filter(function(profile) {
					  return profile.hasGroup(this.id);
				}, group);
				
				var groupProfiles = new Profiles(filteredProfiles);
				
				var view = new ItemView({
					model: group,
					collection: groupProfiles
				});
				
				return view;
			},
			
			id : 'groups-collection',
			
			ui : {
				groupsCell : '.profile-groups'
			}
		});
	});
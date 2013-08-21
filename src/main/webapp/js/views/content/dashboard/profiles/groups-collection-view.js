define([ 'marionette', 'models/group', 'collections/groups', 'models/profile', 'collections/profiles', 'views/content/dashboard/profiles/group-view', 'hbs!templates/content/dashboard/profiles/groups-collection-view' ],
	function(Marionette, Group, Groups, Profile, Profiles, GroupView, groupsCollectionViewTemplate) {

		'use strict';
	
		return Backbone.Marionette.CompositeView.extend({
	
			template : groupsCollectionViewTemplate,
	
			itemView : GroupView,
	
			itemViewContainer : 'tbody',
			
			initialize : function(options){
				this.profiles = options.profiles;
			},
			
			buildItemView: function(item, ItemView){
				
				var filteredProfiles = this.profiles.filter(function(profile) {
					  return _.where(profile.get("dosProfileGroups"),{id:1}).length == 1;
				});
				
				var groupProfiles = new Profiles(filteredProfiles);
				
				var view = new ItemView({
					model: item,
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
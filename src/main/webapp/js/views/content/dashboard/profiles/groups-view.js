define([ 'marionette',
         'models/group',
         'collections/profiles',
         'collections/groups',
         'views/content/dashboard/profiles/groups-collection-view', 
         'views/content/dashboard/profiles/group-modal-view', 
         'hbs!templates/content/dashboard/profiles/groups-view' 
         ],
function(Marionette, 
		Group,
		Profiles,
		Groups,
		GroupsCollectionView,
		GroupModalView,
		groupsViewTemplate) {
	
	'use strict';

	return Backbone.Marionette.Layout.extend({
		
		template : groupsViewTemplate,
		
		initialize : function(options){
			
			var that = this;
			
			this.profiles = options.profiles;
			
			this.groupsCollectionView = new GroupsCollectionView({
				collection : this.collection,
				profiles : options.profiles
			});
			
			this.groupsCollectionView.on("itemview:group:edit", function(childView){
				that.editGroup(childView.model);
			});
		},
		
		ui : {
			newGroupButton : '#create-group',
			showHideGroupsButton : '#show-hide-groups',
			groupsCollectionRegion : '#groups-collection'

		},
		
		events : {
			"click #create-group": 'createGroup',
			"click #show-hide-groups" : 'showHideGroups'
		},
		
		regions : {
			groupsCollectionRegion : '#groups-collection',
			groupsModalRegion : '#groups-modal-region'
		},
		
		onRender : function(){
			this.groupsCollectionRegion.show(this.groupsCollectionView);
		},
		
		createGroup : function(){
			this.editGroup(new Group());
		},
		
		editGroup : function(model){
			var groupModalView = new GroupModalView({model : model, collection : this.profiles});
			this.groupsModalRegion.show(groupModalView);
		},
		
		showHideGroups : function(){
			if (this.ui.groupsCollectionRegion.is(":visible")) {
				this.ui.showHideGroupsButton.text("Show groups");
				this.ui.groupsCollectionRegion.hide(200);
			} else {
				this.ui.showHideGroupsButton.text("Hide groups");
				this.ui.groupsCollectionRegion.show(200);
			}
		},
	});
});
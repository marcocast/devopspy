define([ 'marionette', 'models/group', 'collections/groups',
		'views/content/dashboard/profiles/profile-option-view',
		'hbs!templates/content/dashboard/profiles/group-modal-view',
		'bootstrap', 'to-checklist' ], function(Marionette, Profile, Groups,
		ProfileOptionView, groupModalViewTemplate) {

	'use strict';

	return Backbone.Marionette.CompositeView.extend({

		template : groupModalViewTemplate,

		ui : {
			modal : '#group-modal',
			deleteButton : '#group-modal-delete',
			closeButton : '#group-modal-close',
			saveButton : '#group-modal-save',
			inputName : '#inputName',
			profilesFilterField : '#profiles-filter',
			profileOptions : '#group-modal-profiles-options'
		},

		events : {
			'click #group-modal-delete' : 'deleteProfile',
			'click #group-modal-save' : 'saveGroup',
			'click #group-modal-close' : 'closeModal',
			'keyup #profiles-filter' : 'filterProfiles'
		},

		itemViewContainer : '#group-modal-profiles-options',

		itemView : ProfileOptionView,

		onRender : function() {
			this.ui.modal.modal();
		},

		closeModal : function() {
			this.ui.modal.modal('hide');
		},

		deleteProfile : function() {
			var that = this;
			this.model.destroy({
				success : function(model, response) {
					alert("group destroyed!" + model.id);
					that.ui.modal.modal('hide');
				},
				error : function(model, response) {
					that.options.profiles.fetch();
					alert("group " + model.id + " not destroyed, error "
							+ response.status);
				},
				wait : true
			});
		},

		saveGroup : function() {
			this.updateModelFromForm();
			this.updateProfilesFromForm(this.getProfileOptionsFromForm());
			this.saveModel();
		},

		updateModelFromForm : function() {
			var name = this.ui.inputName.val();
			this.model.set('name', name == '' ? null : name);
		},
		
		updateProfilesFromForm : function(profileOptionsSelected){
			var group = this.model.toJSON();
			var that = this;
			this.collection.each(function(profile) {
				var profileGroups = profile.get('dosProfileGroups');
				if (_.contains(profileGroups, group)) {
					if (!(profileOptionsSelected[profile.id])) {
						profileGroups = _.without(profileGroups, group); 
						profile.set('dosProfileGroups', profileGroups);
						that.saveProfile(profile);
					}
				} else {
					if (profileOptionsSelected[profile.id]) {
						profileGroups.push(group); 
						profile.set('dosProfileGroups', profileGroups);
						that.saveProfile(profile);
					}
				}
			});
		},
		
		getProfileOptionsFromForm : function(){
			var profileOptionsSelected = {};
			this.ui.profileOptions.find("input.profile-option").each(function() {
				var profileId =  $(this).val();
				var isChecked =  $(this).is(':checked');
				profileOptionsSelected[profileId] = isChecked;
			});
			return profileOptionsSelected;
		},

		saveModel : function() {
			var that = this;
			this.model.save(null, {
				success : function(model, response, options) {
					alert("group saved!" + model.id);
					that.collection.fetch();
					that.ui.modal.modal('hide');
				},
				error : function(model, response, options) {
					alert("group " + model.id + " not saved, error "
							+ response.status);
				},
				wait : true
			});
		},
		
		saveProfile : function(profile){
			var that = this; 
			profile.save(null, {
				success: function(model, response, options) {
					  alert("profile saved!" + model.id);
				}, 
				error: function(model, response, options) {
					  alert("profile " + model.id + " not saved, error " + response.status);
				},
				wait: true
			});
		},

		filterProfiles : function() {
			var filterText = this.ui.profilesFilterField.val();
			if (filterText == '') {
				this.ui.profileOptions.find("label").show();
			} else {
				this.ui.profileOptions.find("label:contains('" + filterText + "')").show();
				this.ui.profileOptions.find("label:not(:contains('" + filterText + "'))")
						.hide();
			}
		}
	});
});
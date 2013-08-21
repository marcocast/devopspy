define([ 'marionette', 'models/profile', 'collections/profiles', 'hbs!templates/content/dashboard/profiles/profile-modal-view', 'bootstrap' ], function(Marionette,
		Profile, Profiles, profileModalViewTemplate) {

	'use strict';

	return Backbone.Marionette.ItemView.extend({

		template : profileModalViewTemplate,
		
		ui : {
			modal : '#profile-modal',
			deleteButton : '#profile-modal-delete',
			closeButton : '#profile-modal-close',
			saveButton : '#profile-modal-save',
			inputName : '#inputName',
			inputFilePath : '#inputFilePath',
			inputHost : '#inputHost',
			inputUser : '#inputUser',
			inputPassword : '#inputPassword',
			inputKeyLocation : '#inputKeyLocation'
		},
		
		events : {
			'click #profile-modal-delete' : 'deleteProfile',
			'click #profile-modal-save' : 'saveProfile',
			'click #profile-modal-close' : 'closeModal'
		},
		
		onRender : function() {
			this.ui.modal.modal();
		},
		
		closeModal : function(){
			this.ui.modal.modal('hide');
		},
		
		deleteProfile : function() {
			var that = this; 
			this.model.destroy({
				success: function(model, response) {
					alert("profile destroyed!" + model.id);
					that.ui.modal.modal('hide');
				}, 
				
				error: function(model, response) {
					that.options.profiles.fetch();
					alert("profile " + model.id + " not destroyed, error " + response.status);
				},
				
				wait: true
			});
		},
		
		saveProfile : function() {
			this.updateModelFromForm();
			this.saveModel();
		},
		
		updateModelFromForm : function(){
			var name = this.ui.inputName.val();
			var filePath = this.ui.inputFilePath.val();
			var host = this.ui.inputHost.val();
			var user = this.ui.inputUser.val();
			var password = this.ui.inputPassword.val();
			var userAuthPrivateKeyLocation = this.ui.inputKeyLocation.val();
			
			this.model.set('name', name == '' ? null : name);
			this.model.set('filePath', filePath == '' ? null : filePath);
			this.model.set('host', host == '' ? null : host);
			this.model.set('user', name == '' ? null : user);
			this.model.set('password', name == '' ? null : password);
			this.model.set('userAuthPrivateKeyLocation', name == '' ? null : userAuthPrivateKeyLocation);
		},
		
		saveModel : function(){
			var that = this; 
			this.model.save(null, {
				success: function(model, response, options) {
					  alert("profile saved!" + model.id);
					  that.options.profiles.fetch();
					  that.ui.modal.modal('hide');
				}, 
				
				error: function(model, response, options) {
					  alert("profile " + model.id + " not saved, error " + response.status);
				},
				
				wait: true
			});
		}
	});
});
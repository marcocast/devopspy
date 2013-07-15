define([ 'marionette', 'views/profile-view',
		'hbs!templates/profiles-view' ], function(Marionette,
		ProfileView, profilesCollectionViewTemplate) {

	console.log("new ProfilesCollectionView");

	return Backbone.Marionette.CompositeView.extend({

		template : profilesCollectionViewTemplate,

		itemView : ProfileView,

		itemViewContainer : 'ol',

		id : 'profiles-collection',
	});
});
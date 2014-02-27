define([ 
	'models/search-data',
	'views/content/dashboard/dashboard-view', 
	'collections/profiles',
	'collections/results',
	'hbs!templates/content/dashboard/search/dashboard-search-view' 
], function(
	SearchData,
	DashboardView, 
	Profiles,
	Results,
	dashboardSearchViewTemplate) {
	
	'use strict';

	return DashboardView.extend({
		
		template : dashboardSearchViewTemplate,
		
		events : {
			"click #dos-serach-data-submit" : "submitSearch"
		},
		
		ui : {
			searchDataExpressionField : '#dos-search-data-expression'
		},
				
		submitSearch : function(){
		
			var searchData = new SearchData();
			
			searchData.set('dosProfiles', [2]);
			searchData.set('expression', this.ui.searchDataExpressionField.val());
			
			var searchResults = new Results();
			
			searchResults.loadResultsFromServer(searchData);
			console.log('');
		},
				
		initialize : function(){
			this.profiles = new Profiles();
			this.profiles.fetch({'async':false});

		},
		
		regions : {
			profilesRegion : '#view-profiles',
		},
		
		onRender : function(){
		}
	});
});
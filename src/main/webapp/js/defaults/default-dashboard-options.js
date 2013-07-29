define([ 'models/nav-option' ], function(NavOption) {

	'use strict';

	return [ new NavOption({
		title : "Search",
		target : "#dashboard/search",
		icon : "icon-search"
	}), new NavOption({
		title : "Graphs",
		target : "#dashboard/graphs",
		icon : "icon-signal"
	}), new NavOption({
		title : "Statistics",
		target : "#dashboard/statistics",
		icon : "icon-globe"
	}), new NavOption({
		title : "Component Interactions",
		target : "#dashboard/components",
		icon : "icon-cog"
	}), new NavOption({
		title : "Scheduler",
		target : "#dashboard/scheduler",
		icon : "icon-calendar"
	}), new NavOption({
		title : "Profiles",
		target : "#dashboard/profiles",
		icon : "icon-file"
	})  ];
});

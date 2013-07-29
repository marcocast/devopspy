define([ 'models/nav-option' ], function(NavOption) {

	'use strict';

	return [ new NavOption({
		title : "Account",
		target : "#settings/account",
		icon : "icon-search"
	}), new NavOption({
		title : "Users",
		target : "#settings/users",
		icon : "icon-signal"
	})  ];
});

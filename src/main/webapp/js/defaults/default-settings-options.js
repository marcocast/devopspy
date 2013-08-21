define([ 'models/nav-option' ], function(NavOption) {

	'use strict';

	return [ new NavOption({
		title : "Account",
		target : "#settings/account",
		icon : "icon-briefcase"
	}), new NavOption({
		title : "Users",
		target : "#settings/users",
		icon : "icon-user"
	})  ];
});

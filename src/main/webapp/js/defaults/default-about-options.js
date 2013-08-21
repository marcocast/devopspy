define([ 'models/nav-option' ], function(NavOption) {

	'use strict';

	return [ new NavOption({
		title : "About DevOpSpy",
		target : "#about/devopspy",
		icon : "icon-question-sign"
	}), new NavOption({
		title : "Licence",
		target : "#about/licence",
		icon : " icon-book"
	}) ];
});

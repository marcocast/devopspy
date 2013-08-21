define(['models/nav-option' ],
	function(NavOption) {

		'use strict';
		
		return [ new NavOption({
			title : "Dashboard",
			target : "#dashboard",
			icon : "icon-home"
		}), new NavOption({
			title : "Settings",
			target : "#settings",
			icon : "icon-wrench"
		}), new NavOption({
			title : "About",
			target : "#about",
			icon : " icon-question-sign"
		})  ];
	});

define(['models/nav-option' ],
	function(NavOption) {

		'use strict';
		
		return [ new NavOption({
			title : "Dashboard",
			target : "#dashboard",
			icon : "icon-search"
		}), new NavOption({
			title : "Settings",
			target : "#settings",
			icon : "icon-signal"
		}), new NavOption({
			title : "About",
			target : "#about",
			icon : "icon-globe"
		})  ];
	});

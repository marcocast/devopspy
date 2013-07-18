define(['models/header-option' ],
	function(HeaderOption) {

		'use strict';
		
		return [
			new HeaderOption({ title: "Home", target: "#home" }),
			new HeaderOption({ title: "About", target: "#about" })
		];
	});

define([ 'backbone' ], function(Backbone) {
	return Backbone.Model.extend({

		defaults : {
			id : "",
			name : "",
			filePath : "",
			host : "",
			user : "",
			password : ""
		}
	});
});
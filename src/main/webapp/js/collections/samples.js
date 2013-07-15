define([ 'backbone', 'model/sample' ], function(Backbone, Sample) {

	var Samples = Backbone.Collection.extend({

		model : Sample,
		url : 'api/sample'

	});
	return Samples;
});

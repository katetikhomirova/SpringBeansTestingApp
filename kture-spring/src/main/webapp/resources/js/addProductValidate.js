$(document).ready(
		function() {

			$('#addProduct').validate(
					{
						rules : {
							title : {
								minlength : 2,
								required : true
							},
							price : {
								number : true,
								required : true
							},
							description : {
								minlength : 2,
								required : true
							},
						},
						highlight : function(element) {
							$(element).closest('.form-group').removeClass(
									'has-success').addClass('has-error');
						},
						success : function(element) {
							element.text('OK!').addClass('valid').closest(
									'.form-group').removeClass('has-error')
									.addClass('has-success');
						}
					});

		});
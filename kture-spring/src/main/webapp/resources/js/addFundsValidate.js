$(document).ready(
		function() {

			$('#updateFunds').validate(
					{
						rules : {
							funds : {
								number : true
								
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
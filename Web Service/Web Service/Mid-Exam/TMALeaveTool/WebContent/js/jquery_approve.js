$(document).ready(function() {
						$(".approve")
								.click(
										function() {
											console.log("approve");
											var id = $(this).parent().siblings(
													".id").text();
											var $that=$(this);
											console.log("id:"+id);
											$
													.ajax({
														type : "PUT",
														url : "http://localhost:8080/TMALeaveToolServices/rest/application/approve",
														data : id,
														dataType : "text",
														contentType : 'text/plain',
														success : function(data) {
															$that.parent().siblings(".status").text("Accepted");
															getCountLeave();
														},
														error : function(error) {
															alert("Total more than 12 day");
														}
													});
										});
						$(".reject")
								.click(
										function() {
											var id = $(this).parent().siblings(
													".id").text();
											var $that=$(this);
											$
													.ajax({
														type : "PUT",
														url : "http://localhost:8080/TMALeaveToolServices/rest/application/reject",
														data : id,
														dataType : "text",
														contentType : 'text/plain',
														success : function(data) {
															$that.parent().siblings(".status").text("Rejected");
															getCountLeave();
														},
														error : function(error) {
															
														}
													});
										});
						function getCountLeave(){
							var user= $("#username").text();
							$.ajax({
								type:"GET",
								url:"http://localhost:8080/TMALeaveToolServices/rest/employee/leave/"+user,
								contentType:"text/plain",
								success:function(data){
									$("#countleave").text(data+"/12");
								},error:function(error){
									console.log("error");
								}
							});
							
						}
						
						

					});
	
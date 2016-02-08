$(document).ready(function() {
	CompanyController.init();
})

var company = {
	"id" : null,
	"name" : null,
	"address" : null,
	"city" : null,
	"country" : null,
	"employees" : [],
	"owners" : []
}
var owner = {
	"name" : null
}
$("#new").click(
		function() {
			var tid = $('#companiesTable tr:last').attr('id') == undefined ? 0
					: $('#companiesTable tr:last').attr('id');
			company.id = tid + 1;
			company.name = $("#name").val();
			company.address = $("#address").val();
			company.city = $("#city").val();
			company.country = $("#country").val();
			company.email = $("#email").val();
			company.phone = $("#phone").val();
			CompanyController.createCompany(company);
		});

$("#edit").click(function() {
	company.id = $("#editId").val();
	company.name = $("#editName").val();
	company.address = $("#editAddress").val();
	company.city = $("#editCity").val();
	company.country = $("#editCountry").val();
	CompanyController.editedCompany(company);
});

$("#add").click(function() {
	$("#companies").hide();
	$("#newCompany").show();
});

$("#addOwner").click(function() {
	console.log("owners ");
	$("#dialog").dialog("open");
});

$("#saveOwner").click(function() {
	var id = $("#editId").val();
	owner.name = $("#ownerName").val();
	CompanyController.addOwner(id, owner);
});

var CompanyController = {
	init : function() {	
		$("#companies").show();
		$("#newCompany").hide();
		$("#editCompany").hide();
		this.getAllCompanies();
		$("#dialog").dialog({
			autoOpen: false
			});
		
	},

	getAllCompanies : function() {
		$
				.ajax({
					url : "http://localhost:8080/companies",
					type : "GET"

				})
				.then(
						function(data) {
							$
									.each(
											data,
											function(i, company) {
												$("#companiesTable")
														.append(
																"<tr id='"
																		+ company.id
																		+ "'><td><a href='javascript:CompanyController.editCompany("
																		+ company.id
																		+ ");'>"
																		+ company.id
																		+ "</a></td>"
																		+ "<td>"
																		+ company.name
																		+ "</td>"
																		+ "<td>"
																		+ company.address
																		+ "</td>"
																		+ "<td>"
																		+ company.city
																		+ "</td>"
																		+ "<td>"
																		+ company.country
																		+ "</td></tr>");
											});
						});
	},

	createCompany : function(company) {
		$.ajax({
			url : "http://localhost:8080/companies/add",
			type : "POST",
			dataType : 'json',
			data : JSON.stringify(company),
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				console.log(data);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		}).then(function() {
			$("#companies").show();
			$("#newCompany").hide();
			setTimeout(function() {
                location.reload();
            }, 10);
		});
	},

	editCompany : function(id) {
		$.ajax({
			url : "http://localhost:8080/companies/" + id,
			type : "GET"
		}).then(function(data) {
			$("#companies").hide();
			$("#newCompany").hide();
			$("#editCompany").show();
			$("#editId").val(data.id);
			$("#editName").val(data.name);
			$("#editAddress").val(data.address);
			$("#editCity").val(data.city);
			$("#editCountry").val(data.country);
			$.each(data.owners,function(i, owners){
				console.log("owners " + owners);
				$("#ownerList").append("<ol>"+owners.name+"</ol");
			});
		});
	},

	editedCompany : function(company) {
		$.ajax({
			url : "http://localhost:8080/companies/" + company.id,
			type : "POST",
			dataType : 'json',
			data : JSON.stringify(company),
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				console.log("success :" + data);
			},
			failure : function(errMsg) {
				console.log("error: " + errMsg);			}
		}).then(function() {
			CompanyController.init();
			setTimeout(function() {
                location.reload();
            }, 10);
		});
	},
	
	addOwner : function(id,owner){
		var url = "http://localhost:8080/companies/"+id+"/addOwner";
		console.log(url);
		$.ajax({
			url : url,
			type : "POST",
			dataType : 'json',
			data : JSON.stringify(owner),
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				console.log(data);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		}).then(function() {
			$("#companies").show();
			$("#newCompany").hide();
			setTimeout(function() {
                location.reload();
            }, 10);
		});
	}

}

//----------Items---------------------------
//Save/Update 
$(document).on("click","#GetItems",function()
		{
			var result = isValidFormItems();
			if(result=="true")
			{	$("#formItems").submit();}
			else
			{	$("#divStsMsgItem").html(result);	}		
		});

//Edit
$(document).on("click","#btnEdit",function()
		{
			$("#hideMode").val(update);
			$("#hidID").val($(this).attr("param"));
			$("#txtItemName").val($(this).closest("tr").find('td:eq(1)').text());
			$("#txtItemDesc").val($(this).closest("tr").find('td:eq(2)').text);
		});
//Remove			
$(document).on("click","#btnRemove",function()
{
		$("#hideMode").val("remove");
		$("#hidID").val($(this).attr("param"));
		var res =confirm("Are You Sure?");
			if(res==true){
				$("#formItems").submit();
			}
});
			
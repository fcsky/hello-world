$(document).ready(
		function() {
			var flag=1;
			var searchColumns;
			var searchRule;
			var searchText;
			
			page(flag,searchColumns,searchRule,searchText);
			
			 var height=$("table").outerWidth();

	 
			//点击搜索按钮
			$('#searchButton', parent.document).click(function(){
				searchColumns=$("#searchColumns option:selected", parent.document).val();
				searchRule=$("#searchRule option:selected", parent.document).val();
				searchText=$("#searchInput", parent.document).val();
				flag=6;
				page(flag,searchColumns,searchRule,searchText);
				
			});
			
		

					
			// 下一页
			$("#next").click(function() {
				flag = 2;
				page(flag, searchColumns, searchRule, searchText);
			});
			// 上一页
			$("#last").click(function() {
				flag = 3;
				page(flag, searchColumns, searchRule, searchText);
			});
			// 首页
			$("#first").click(function() {
				flag = 4;
				page(flag, searchColumns, searchRule, searchText);
			});
			// 尾页
			$("#end").click(function() {
				flag = 5;
				page(flag, searchColumns, searchRule, searchText);
			});
		
		
			//删除
			$("#delete").click(function() {
				var del = [];
				$choose = $("input:checkbox:checked");
				if ($choose.val() != null) {
					$choose.each(function() {
						del.push($(this).val());
					});

					if (confirm("是否确认删除")) {
						del_user(del.join(","));
					}
				} else {
					alert("请选择需要删除的用户");
				}

			});
		
		//修改
		$(document).on('click',"table button",function(){

			var a=$(this).text();
			$(this).text(a=="确认"?"修改":"确认")
			if(a=="修改"){
				
					$(this).parent().siblings("td:not('.id')").each(function(index,item){
						$(this).html("<input type='text' value='"+$(this).text()+"'>");
					});
			}
			else if(a=="确认"){
				var str=[];
					str.push("id:"+$(this).parent().siblings(".id").text());
					$(this).parent().siblings("td:not('.id')").each(function(index,item){
						var eqindex=$(this).index();
						var key=$(this).parent().prevAll("#t_head").find("th").eq(eqindex).attr("id");
						str.push("'"+key+"':'"+$(this).find("input").val()+"'");
						$(this).text($(this).find("input").val());
					});
					var json=str.join(",");
					update_user("{"+json+"}");
			}
		});
		
		//全选
			$("#chooseAll").click(function() {
				$chooseAll = $(this).text();
				if ($chooseAll == "全选") {
					$("input:checkbox").prop("checked", true);
				} else {
					$("input:checkbox").prop("checked", false);
				}
				$(this).text($chooseAll == "全选" ? "全不选" : "全选");

			});
});


//查询所有用户ajax
function ajax_finduser(){

	$.ajax({
		type : "POST",
		url : "../findAllUser",
		dataType : "json",
		data : {
			
		},
		success : function(data) {
			$("table tr:not('#t_head')").remove();
			var val;
			if(data==""){
				val = "<tr> <td  colspan='8'>未查询到内容</td></tr>";
				$("table").append(val);
				$("#page").css("display","none");
			}
			else{
				$("#page").css("display","block");
				$.each(data, function(i, value) {
					val = "<tr>" +
							"<td class='id'>"+ value.id+ "</td>" +
							"<td class='email'>"+ value.email+ "</td>" +
							"<td class='uname'>"+ value.uname+ "</td>" +
							"<td class='sign'>"+ (value.sign == undefined ? "" : value.sign)+ "</td>" +
							"<td class='birthday'>"+ value.birthday+ "</td>" +
							"<td class='sex'>"+ value.sex+ "</td>" +
							"<td class='address'>"+ (value.address == undefined ? "": value.address) + "</td>" +
							"<td><button id='update'>修改</button><input type='checkbox' value="+value.id+"></td>"
						  "</tr>";
					$("table").append(val);
				});
			}

		 },
		 error : function(jqXHR) {
//		 		alert("失败" + jqXHR.status);
		 }
	});
}
//显示页数ajax
function page(flag, searchColumns, searchRule, searchText) {
	$.ajax({
		type : "GET",
		url : "../count",
		dataType : "json",
		data : {
			flag : flag,
			searchColumns : searchColumns,
			searchRule : searchRule,
			searchText : searchText,
		},
		success : function(data) {
			ajax_finduser();
			$("#page_lable").text(data.current + "/" + data.allPage);

		},
		error : function(jqXHR) {

		}
	});
}
//删除ajax
function del_user(del) {
	$.ajax({
		type : "GET",
		url : "../delUser",
		dataType : "json",
		data : {
			updateId : del,
		},
		success : function(data) {
			if (data.msg) {
				alert("删除成功");
				$("input:checkbox:checked").parent().parent().remove();
			} else
				alert("删除失败");
		}

	});
}
//修改
function update_user(updateUser) {
	$.ajax({
		type : "POST",
		url : "../updateUser",
		dataType : "json",
		data : {
			updateUser : updateUser,
		},
		success : function(data) {
			if (data.msg) {
				alert("修改成功");

			} else
				alert("修改失败");
		}

	});
}
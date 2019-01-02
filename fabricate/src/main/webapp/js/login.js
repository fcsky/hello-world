//设置登录与注册按钮状态
var flag=1;

$(document).ready(function(){
	$(".put_in").focus(function(){
		this.style.cssText="\
		border:3px solid #475570;\
		padding:8px 8px 8px 38px;\
		background-position:5px";
	
		$(this).attr('placeholder','');

	});
	$("input").blur(function(){
		$(this).css({
			"border":"1px solid #5B6A81",
			"padding":"10px 10px 10px 40px",
			"background-position":"7px"
		});
		if($("#email_text").val()==""){
			$("#email_text").attr('placeholder','请输入邮箱');
		}
		if($("#password_text").val()==""){
			$("#password_text").attr('placeholder','请输入密码');
		}
	});

	//注册
	$("#reg_bn").click(function(){
		if(flag==0){
			if(email_test()&password_test()){
				addUser();
				
			}
		}
		else{
			$("#login_bn").animate({width:'52px'},490);
			$(this).animate({width:'247px'},510);
			
			$("#set_up").slideUp("slow");
			
			
			setTimeout(function(){

				// $("#user_text").slideUp(400);
				$("#user_div").slideDown(400);
			},400);
			
			flag=0;
		}

	});

	//点击登录按钮,验证邮箱和密码	
	$("#login_bn").click(function(){
		if(flag==1){
			if(email_test()&password_test()){
				
					ajax_user();
			}
		}
		else if(flag==3){
			ajax_admin();
		}
		else{

			$("#user_div").slideUp("slow");
			$("#reg_bn").animate({width:'52px'},490);
			$(this).animate({width:'247px'},510);
			
			setTimeout(function(){
				$("#set_up").slideDown(400);
			},400);
			
			flag=1;
		}
	});
	
	//管理员回车键登录
	$("body").keydown(function(){
		if(flag==1||flag==3){
			if (event.keyCode == "13"){
				ajax_admin();
			}
		}

	});
	//点击管理员登录
	$("#admin_login").click(function(){
		$("#reg").animate({width:'hide'},510);
		$("#login_bn").animate({width:'300px'},510);
		$("#set_up").slideUp("slow");
		$("#email_text").attr("placeholder","请输入用户名");
		flag=3;
	});

});



//普通用户登录ajax
function ajax_user(){
		$.ajax({
		type:"POST",
		url:"login",
		dataType:"json",
		data:{
			email:$("#email_text").val(),
			password:$("#password_text").val(),
		},
		success:function(data){
			if(data.key){
				$(window).attr("location","page/manage.html");
			}
			else{
				$("#error_tips").text("邮箱或密码错误");
			}
		},
		error:function(jqXHR){
			$("#error_tips").text("服务器错误，请稍后重试");
		}
		
	});
}
//管理员登录ajax
function ajax_admin(){
		$.ajax({
		type:"POST",
		url:"adminLogin",
		dataType:"json",
		data:{
			uname:$("#email_text").val(),
			password:$("#password_text").val(),
		},
		success:function(data){
			if(data.key){
				$(window).attr("location","page/manage.html");
			}
			else{
				$("#error_tips").text("邮箱或密码错误");
			}
		},
		error:function(jqXHR){
			$("#error_tips").text("服务器错误，请稍后重试");
		}
		
	});
}
//添加用户
function addUser(){
	$.ajax({
		type:"POST",
		url:"addUser",
		dataType:"json",
		data:{
			email:$("#email_text").val(),
			password:$("#password_text").val(),
			uname:$("#user_text").val(),
		},
		success:function(data){
			if(data.msg==1){
					$("#error_tips").text("注册成功,请登录");
			}
			else if(data.msg==3){
				$("#email_error").text("该邮箱已存在,请登录或重新输入");
			}
		},
		error:function(jqXHR){
			
		}
	});
}



//邮箱验证
function email_test(){
	var email=$("#email_text").val();
	

	var email_error=$("#email_error");
	
	var regular=/[\w_]{6,11}[@][a-zA-Z]+[.][a-zA-Z]{2,4}/;
	if (email!="") {
		if(!regular.test(email)){
			email_error.text("邮箱格式错误");
			return false;
		}
		else{
			email_error.text("");
			return true;
		}
		
	}
	else{
		email_error.text("请输入邮箱");
		return false;
	}


}
//密码验证
function password_test(){
	var password=$("#password_text").val();
	var password_error=$("#password_error");
	if(password!=""){
		if(password.length>=6&&password.length<=16){
			return true;
		}
		else{
			password_error.text("密码长度为6~16位");
			return false;
		}
				
		
		
	}
	else{
		password_error.text("请输入密码");
		return false;
	}

}
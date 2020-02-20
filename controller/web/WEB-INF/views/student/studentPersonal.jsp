<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>个人信息</title>
	<link rel="stylesheet" type="text/css" href="/static/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/static/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/static/easyui/css/demo.css">
	
	<script type="text/javascript" src="/static/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/static/easyui/js/validateExtends.js"></script>
	<script type="text/javascript">
	$(function() {	
		
		//修改密码窗口
	    $("#passwordDialog").dialog({
	    	title: "修改密码",
	    	width: 500,
	    	height: 300,
	    	iconCls: "icon-add",
	    	modal: true,
	    	collapsible: false,
	    	minimizable: false,
	    	maximizable: false,
	    	draggable: true,
	    	closed: true,
	    	buttons: [
	  	    		{
	  					text:'提交',
	  					iconCls:'icon-user_add',
	  					handler:function(){
	  						var validate = $("#editPassword").form("validate");
	  						if(!validate){
	  							$.messager.alert("消息提醒","请检查你输入的数据!","warning");
	  							return;
	  						} else{
	  							$.ajax({
	  								type: "post",
	  								url: "/student/editPasswod",//"StudentServlet?method=EditPasswod&t="+new Date().getTime(),
	  								data: $("#editPassword").serialize(),
	  								success: function(msg){
	  									if(msg == "success"){
	  										$.messager.alert("消息提醒","修改成功，将重新登录","info")
	  										setTimeout(function(){
	  											top.location.href = "/sys_student/login";
	  										}, 1000);
	  									}
	  								}
	  							});
	  						}
	  					}
	  				},
	  				{
	  					text:'重置',
	  					iconCls:'icon-reload',
	  					handler:function(){
	  						//清空表单
	  						$("#old_password").textbox('setValue', "");
	  						$("#new_password").textbox('setValue', "");
	  						$("#re_password").textbox('setValue', "");
	  					}
	  				}
	  			],
	    })
		
		//设置编辑学生窗口
	    $("#editDialog").dialog({
	    	title: "修改密码",
	    	width: 500,
	    	height: 400,
	    	fit: true,
	    	modal: false,
	    	noheader: true,
	    	collapsible: false,
	    	minimizable: false,
	    	maximizable: false,
	    	draggable: true,
	    	closed: false,
	    	toolbar: [
	    		{
					text:'提交',
					plain: true,
					iconCls:'icon-user_add',
					handler:function(){
						var validate = $("#editForm").form("validate");
						if(!validate){
							$.messager.alert("消息提醒","请检查你输入的数据!","warning");
							return;
						} else{
							var formData=new FormData();
							if($("#pimage")[0].files[0]!=null){
								formData.append("multipartFile",$("#pimage")[0].files[0]);
							}
							formData.append("name",$("#edit_name").val());
							formData.append("sex",$("#edit_sex").val());
							formData.append("phone",$("#edit_phone").val());
							formData.append("qq",$("#edit_qq").val());
							formData.append("number",$("#edit_number").val());
							$.ajax({
								type: "post",
								url: "/student/editStudent",//"StudentServlet?method=EditStudent&t="+new Date().getTime(),
								data: formData,
								processData : false, // 使数据不做处理
								contentType : false, // 不要设置Content-Type请求头
								success: function(msg){
									if(msg == "success"){
										$.messager.alert("消息提醒","更新成功!","info");
									} else{
										$.messager.alert("消息提醒","更新失败!","warning");
										return;
									}
								}
							});
						}
					}
				},'-',
				{
					text:'重置',
					plain: true,
					iconCls:'icon-reload',
					handler:function(){
						//清空表单
						$("#edit_name").textbox('setValue', "");
						$("#edit_sex").textbox('setValue', "男");
						$("#edit_phone").textbox('setValue', "");
						$("#edit_qq").textbox('setValue', "");
					}
				},'-',
				{
					text:'修改密码',
					plain: true,
					iconCls:'icon-password',
					handler:function(){
						$("#passwordDialog").dialog("open");
					}
				}
			],
			
	    });
		$("#pimage").change(function(){
			// Get a reference to the fileList
		    var files = !!this.files ? this.files : [];
		    // If no files were selected, or no FileReader support, return(如果没有选择任何文件，或者没有文件读取器支持，则返回)
		    if (!files.length || !window.FileReader) return;
		    // Only proceed if the selected file is an image(仅当所选文件是图像时才继续)
		    if (/^image/.test( files[0].type)){
		        // Create a new instance of the FileReader
		        var reader = new FileReader();
		        // Read the local file as a DataURL(以dataurl形式读取本地文件)
		        reader.readAsDataURL(files[0]);
		        // 加载时，将图像数据设置为图片标签的内容的背景
		        reader.onloadend = function(){
		        	$("#user_photo").attr("src", this.result);
		        }
		    }
		})
		
	})
	</script>
</head>
<body>
	<!-- 修改学生窗口 -->
	<div id="editDialog" style="padding: 20px">
		<div style="width: 300px; height: 400px;float: right; margin: 20px 120px 0 0;">
		
	    	<img id="user_photo" alt="照片" style="margin-bottom: 30px;display: block;max-width: 250px; max-height: 300px;" title="照片" src="${userDetail.imgpath}" />

	    </div>
	    
    	<form id="editForm">
	    	<table cellpadding="8" >
	    		<tr>
	    			<td>学号:</td>
	    			<td>
	    				<input id="edit_number" value="${userDetail.number }" data-options="readonly: true" class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="number" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>姓名:</td>
	    			<td><input id="edit_name" value="${userDetail.name }" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="name" data-options="required:true, missingMessage:'请填写姓名'" /></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td><select id="edit_sex" class="easyui-combobox" data-options="editable: false, panelHeight: 50, width: 60, height: 30" name="sex"><option ${userDetail.sex == '男'? 'selected':''} value="男">男</option><option ${userDetail.sex == '女'? 'selected':''} value="女">女</option></select></td>
	    		</tr>
	    		<tr>
	    			<td>电话:</td>
	    			<td><input id="edit_phone"  value="${userDetail.phone }" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="phone" validType="mobile" /></td>
	    		</tr>
	    		<tr>
	    			<td>QQ:</td>
	    			<td><input id="edit_qq"  value="${userDetail.qq }" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="qq" validType="number"  /></td>
	    		</tr>
				<tr>
					<td>修改头像：</td>
					<td><input type="file" name="pimage" id="pimage" class="form-control"></td>
				</tr>
	    		<%-- <tr>
	    			<td>年级:</td>
	    			<td><input id="edit_grade"  value="${userDetail.clazz.name }" style="width: 200px; height: 30px;" class="easyui-textbox" data-options="readonly: true"/></td>
	    		</tr>
	    		<tr>
	    			<td>班级:</td>
	    			<td><input id="edit_clazz"  value="${userDetail.grade.name }" style="width: 200px; height: 30px;" class="easyui-textbox" data-options="readonly: true"/></td>
	    		</tr> --%>
	    	</table>
	    </form>
	</div>
	
	<!-- 修改密码窗口 -->
	<div id="passwordDialog" style="padding: 20px">
    	<form id="editPassword">
	    	<table cellpadding="8" >
	    		 <tr>
	    			<td>原密码:</td>
	    			<td>
	    				<input id="old_password" style ="width: 200px; height: 30px;" class="easyui-textbox" type="password" validType="oldPassword[${user.password}]"  data-options="required:true, missingMessage:'请输入原密码'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>新密码:</td>
	    			<td>
	    				<input  type="hidden" name="account" value="${userDetail.number }" />
	    				<input id="new_password" style="width: 200px; height: 30px;" class="easyui-textbox" type="password" validType="password" name="password" data-options="required:true, missingMessage:'请输入新密码'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>新密码:</td>
	    			<td><input id="re_password" style="width: 200px; height: 30px;" class="easyui-textbox" type="password" validType="equals['#new_password']"  data-options="required:true, missingMessage:'再次输入密码'" /></td>
	    		</tr>
	    	</table>
	    </form>
	</div>
	
	<!-- 提交表单处理iframe框架 -->
	<iframe id="photo_target" name="photo_target"></iframe>    
	
</body>
</html>
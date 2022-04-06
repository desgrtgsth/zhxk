﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="id" />
		<input type="hidden" name="dtype" /><!--要么是student，要么是管理员-->
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>用户名：</label>
				<input name="name" type="text" size="30" value="" class="required"/>
			</p>
			<p>
				<label>密码：</label>
				<input name="password" id="password" type="password" size="30" value="" class="required"/>
			</p>
			<p>
				<label>确认密码：</label>
				<input name="re_password" type="password" size="30" value="" class="required" equalTo="#password"//>
			</p>
			<p>
				<label>真实姓名：</label>
				<input name="realname" type="text" size="30" value="" class="required"/>
			</p>
			<p>
				<label>年龄：</label>
				<input type="text"  value="" name="age" class="digits">
			</p>
			
			<p>
				<label>性别：</label>
				<select name="type" class="required combox">
					<option value="">请选择</option>
					<option value="F">女</option>
					<option value="M">男</option>
				</select>
			</p>
			<p>
				<label>email：</label>
				<input type="text"  value="" name="email" class="email">
			</p>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>

﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="id" />
		<input type="hidden" name="dtype" /><!--要么是student，要么是管理员-->
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>课程名：</label>
				<input name="name" type="text" size="30" value="" class="required"/>
			</p>
			
			<p>
				<label>学分：</label>
				<input name="age" class="digits" type="text" size="30" alt="请输入数字"/>
			</p>
			<p>
				<label>授课老师名：</label>
				<input id="teacher_id" name="teacher.id" value="" type="hidden"/>
				<input class="required" name="teacher.name" type="text" postField="keyword" suggestFields="name" 
					lookupGroup="teacher"/>
				<a class="btnLook" href="teacher_lookup.html" lookupGroup="teacher" rel="teacher_select">查找带回</a>
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

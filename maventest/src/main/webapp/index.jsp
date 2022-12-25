<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Basic DataGrid - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.10.8/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.10.8/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.10.8/demo/demo.css" />
    <script type="text/javascript" src="jquery-easyui-1.10.8/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.10.8/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
  </head>
  <body>
    <h2>Customer Payment Information</h2>
    <div style="margin: 20px 0"></div>
    <table id="dg"></table>
    <div id="tb" style="padding: 2px 5px">
      <label>Customer ID : </label>
      <input type="text" id="customer_id" />
      <a href="javascript:get_data()" class="easyui-linkbutton" iconCls="icon-search" plain="true"> 조회 </a>
    </div>
  </body>
</html>

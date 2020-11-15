<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/11/6
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table class="easyui-datagrid"
       data-options="url:'/product/list',fitColumns:true,singleSelect:true,pageSize:5,pageList:[5,15,10,20]" toolbar="#bar"
        pagination="true" rownumbers="true">
    <thead>
    <tr>
        <th data-options="field:'id',width:100">id</th>
        <th data-options="field:'name',width:100">商品名称</th>
        <th data-options="field:'image',width:100,formatter:showImage">商品主图</th>
        <th data-options="field:'marketPrice',width:100">市场价格</th>
        <th data-options="field:'price',width:100">价格</th>
        <th data-options="field:'productNumber',width:100">商品编码</th>
    </tr>
    </thead>
</table>

<div id="bar">
    <a id="btnSearch" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">search</a>
    <a id="btnEdit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">edit</a>
</div>

<script>
    function showImage(value,row,index) {
        if(row.image){
            console.log("http://192.168.153.130:8888/"+row.image+"");
            return "<img style='height: 100px; width: auto' src='http://192.168.153.130:8888/"+row.image+"'/>";
        }
    }
</script>

</body>
</html>

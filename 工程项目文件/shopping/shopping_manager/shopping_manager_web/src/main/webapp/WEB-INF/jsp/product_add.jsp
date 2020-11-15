<%@ page import="java.util.List" %>
<%@ page import="pojo.EasyUITree" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/11/8
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<title>商品添加</title>
<script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/product_add.js"></script>

<%
    List<EasyUITree> list = (List<EasyUITree>) session.getAttribute("categories");
%>
<%--<script>--%>
<%--    $("#productAddForm").find("select[name='cid']").combobox({--%>
<%--    onChange:function () {--%>
<%--        alert("bbb");--%>

<%--        var value = $("#cc").val();--%>
<%--        alert(value);--%>

<%--    }--%>
<%--})--%>
<%--</script>--%>
<div style="padding: 10px 10px 10px 10px;">
    <form id="productAddForm" method="post">

        <input type="hidden" name="categoryId">
        <input type="hidden" name="image">
        <input type="hidden" name="description">


        <table cellpadding="10px">

            <tr>
                <td>商品名称</td>
                <td>
                    <input class="easyui-textbox" name="name" data-options="required:true" style="width:800px">
                </td>
            </tr>

            <tr>
                <td>商品分类</td>
                <td>
                    <select id="cc" class="easyui-combobox" name="cid" style="width:200px;">
                        <option value="0">请选择</option>
                        <%
                            for(int i=0;i<list.size();i++)
                            {
                                EasyUITree item = list.get(i);
                                %>
                                <option value="<%=item.getId()%>"><%=item.getText()%></option>
                            <%
                            }
                        %>
                    </select>

                    <p id="cbox" style="display: none"></p>
                </td>
            </tr>

            <tr>
                <td>市场价格</td>
                <td>
                    <input class="easyui-numberbox" name="marketPricePreview" data-options="min:1,max:999999999,required:true,precision:2" style="width:800px">
                    <input type="hidden" name="marketPrice">
                </td>
            </tr>

            <tr>
                <td>商品价格</td>
                <td>
                    <input class="easyui-numberbox" name="pricePreview" data-options="min:1,max:999999999,required:true,precision:2" style="width:800px">
                    <input type="hidden" name="price">
                </td>
            </tr>

            <tr>
                <td>商品编号</td>
                <td>
                    <input class="easyui-numberbox" name="productNumber" data-options="required:true" style="width:800px">
                </td>
            </tr>

            <tr>
                <td>商品主图</td>
                <td>
                    <input id="fileName" name="uploadFile"/>
                    <a href="#" class="easyui-linkbutton uploadPic" >上传图片</a>
                </td>
            </tr>

            <tr>
                <td>主图预览</td>
                <td>
                    <img src="" id="img" width="376" height="190"/>
                </td>
            </tr>

            <tr>
                <td>商品描述</td>
                <td>
                    <script id="editor" type="text/plain" style="width:800px;height:500px;"></script>
                </td>
            </tr>

        </table>

    </form>
    <div align="center">
        <a id="btnSubmit" href="#" class="easyui-linkbutton"  onclick="submitForm()">提交</a>
        <a id="btnCancel" href="#" class="easyui-linkbutton" >重置</a>

    </div>

</div>

<script>

    $(function () {

        // //实例化编辑器
        // //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
        // var ue = UE.getEditor('editor');

        SP.init();

    })


    function loadSubCategory(value) {

        var $box = $("#productAddForm").find('#cbox');


        if(value==0)
        {
            $box.html('').hide();
            return;
        }

        $.getJSON("/product_category/list",{id:value},function (data) {

            var s = '';
            s=' <select id="cc2" class="easyui-combobox" name="cid2" style="width:200px;">';
            s+='<option value="0">请选择二级分类</option>';

            $.each(data,function (idx,item) {

                s+= '<option value="'+item.id+'">'+item.text+'</option>'

            })

            s+='</select>';
            $box.html(s).show();

            $("#productAddForm").find("select[name='cid2']").combobox({
                onChange:function () {
                    // alert("aaa");

                    var value = $("#cc2").val();
                    if(value==0)
                    {
                        $("#productAddForm").find("input[name='categoryId']").val($("#productAddForm").find("input[name='cid1']").val());

                    }
                    else {
                        $("#productAddForm").find("input[name='categoryId']").val(value);
                    }
                }
            })

        });

    }

    $("#productAddForm").find("select[name='cid']").combobox({
        onChange:function () {
            // alert("aaa");

            var value = $("#cc").val();
            $("#productAddForm").find("input[name='categoryId']").val(value);
            loadSubCategory(value);

        }
    })

    $("#fileName").filebox({
        prompt:"选择图片",
        width:"200",
        buttonText:"浏览",
    });

    $(".uploadPic").click(function () {
        $.ajaxFileUpload({
            url:'/uploadFile',
            fileElementId:'filebox_file_id_1',
            type:'post',
            success:function (data) {
                console.log($(data).find("body").text());
                $("#img").attr("src","http://192.168.153.130:8888/"+$(data).find("body").text());
                $("#productAddForm").find("input[name='image']").val($(data).find("body").text());

            }
        });
    });

    function submitForm() {
        $("#productAddForm").find("input[name='description']").val(UE.getEditor('editor').getContent());
        $("#productAddForm").find("input[name='price']").val(eval($("#productAddForm").find("input[name='pricePreview']").val()*100));
        $("#productAddForm").find("input[name='marketPrice']").val(eval($("#productAddForm").find("input[name='marketPricePreview']").val()*100));

        $.post("/product_save",$("#productAddForm").serialize(),function (data) {
            if(data.status == 200)
            {
                $.messager.alert('提示','成功添加商品');
            }

        });
    }
</script>
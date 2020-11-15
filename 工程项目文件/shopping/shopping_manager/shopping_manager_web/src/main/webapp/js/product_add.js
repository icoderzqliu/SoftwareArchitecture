var SP = SHOPPING = {

    init:function (data) {

        //实例化编辑器
        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
        var ue = UE.getEditor('editor');

        // this.initProductCategory();
        // this.initFileUpload();

    },

    // initProductCategory:function() {
    //
    //
    //     $("#productAddForm").find("select[name='cid']").combobox({
    //         onChange:function () {
    //             alert("aaa");
    //
    //             var value = $("#cc").val();
    //             alert(value);
    //
    //         }
    //     })
    //     alert("jjj");
    // }
}
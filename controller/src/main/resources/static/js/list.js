
$(function () {
    //注册一个全局的ajax错误处理函数
    $(document).ajaxError(function(){
        alert("一个错误发生!");
    });
//查询所有分类信息
    function getAll(){
        $.getJSON("/admin/category/list",function (data) {
            $.each(data,function(index,category){
                var $tr = $("<tr><td></td><td></td><td>" +
                    "<a href='#' class='delete btn btn-danger  '>删除</a>" +
                    "<a href='#' class='edit btn btn-info '>编辑</a></td></tr>");
                $tr.find("td:first").text(category.cid);
                $tr.find("td:eq(1)").text(category.cname);
                //用data这个函数保存额外的数据到元素中
                $tr.find("td a:eq(0)").data("cid",category.cid);
                $tr.find("td a:eq(1)").data("cid",category.cid);
                $tr.appendTo("tbody");
            });
        });
    }
    //第一次加载页面的时候立即查询所有的信息。
    getAll();

    //***************删除****************************
    //给动态生成的元素添加事件，先选定已经存在的某个父元素，接着用on函数，此函数
    //的第二个参数选择要动态添加事件的选择器
    $("tbody").on("click",".delete",function (e) {
        e.preventDefault();
        //记录下当前引发单击事件的元素，以便删除成功后利用它找到所在行，并删除行。
        var $that = $(this);
        if (confirm("确定要删除吗?")) {
            $.post("/admin/category/delete",{cid:$(this).data("cid")},function () {
                //1.第一种刷新方式
                // 删除成功 直接用脚本删除当前行。相当于刷新页面了。
                // 因为这是成功后调用的函数，数据库对应的记录已经删除
                console.log($that);
                $that.closest("tr").remove();
            });
        }


    });//删除链接的点击事件处理


    //********************修改操作******************************
    //修改操作,打开模式框
    // 这里打开模式窗口，并赋值给模式窗口
    //cid的赋值方式用data的形式，cname用普通的选择器操作的方式
    $("tbody").on("click",".edit",function () {
        $("#save").data("op", "update");
        //把cid的值从data中取出来，并赋值给模式窗口中的隐藏域中
        $("#cid").val($(this).data("cid"));
        $("#cname").val($(this).closest("tr").find("td:eq(1)").text());

        $("#cid").prop("disabled", "disabled");
        $("#myModal").modal('show');
    });


    //修改操作
    $("#save").click(function(){
        var op = $("#save").data("op");
        if(op!="update"){
            return;
        }
        $("#myModal").modal('hide');
        var obj = {cid:$("#cid").val(),cname:$("#cname").val()};
        console.log(obj);
        $.post("/admin/category/update",obj,function () {
            //2.第2种刷新方式
            // 修改成功 直接重新加载页面即可，相当于刷新。不要在servlet中进行跳转动作。
            location.href="/admin/category/index";
        });
    });//修改保存按钮单击事件

//********************新增操作*****************************
    //新增操作,打开模式框

    $("#content").on("click",".add",function () {
        $("#save").data("op", "insert");
        $("#cid").val("");
        $("#cid").prop("disabled", "");
        $("#cname").val("");

        $("#myModal").modal('show');
    });


    //新增操作
    $("#save").click(function(){
        var op = $("#save").data("op");
        if(op!="insert"){
            return;
        }
        $("#myModal").modal('hide');
        var obj = {cid:$("#cid").val(),cname:$("#cname").val()};
        console.log(obj);
        $.post("/admin/category/insert",obj,function () {
            // 3.第三种刷新方式，直接清空表格数据，并重新加载数据
            $("tbody").empty();
            getAll();
        });
    });
})

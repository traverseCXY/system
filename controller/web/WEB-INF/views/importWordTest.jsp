<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/jquery-form/form@4.2.2/dist/jquery.form.min.js" integrity="sha384-FzT3vTVGXqf7wRfy8k4BiyzvbNfeYjK+frTVqZeNDFl8woCbF0CYG6g2fMEFFo/i" crossorigin="anonymous"></script>
</head>
<body>

<div style="margin-left:74px;margin-top:30px;font-size:18px;">
    <form action="/file/importWord" method="post" id="importQuestionForm" enctype="multipart/form-data" target="upload_iframe">
        <span style="color: #fff;">导入文件:</span>
        <input class="easyui-linkbutton" style="width:245px;color: #fff;" id="file" type="file" value="浏览"  name="file"/>
        <input class="easyui-linkbutton" type="button" value="导入" id="impUser" onclick="importExcel();" style="width:90px;height:30px;text-align:center;background:#4082A1;cursor: pointer;">
    </form>
</div>

<script>
    // //文件名显示
    $('#file').on('change', function() {
        var originName = $(this).val();
        var fileName = originName.substring(originName.lastIndexOf('\\')+1);
        fileName = '<span class="am-badge">' + fileName + '</span>';
    });
    //excl导入
    function importExcel() {
        alert("sss");
        var myFile = $("#file").val();
        if (myFile.length <= 0) {
            $.messager.alert('批量导入试题','请选择导入内容!');
            return false;
        }
        //form表单提交获取返回结果做判断
        $("#importQuestionForm").ajaxSubmit(function(data){
            if (data >= 0) {
              alert("插入成功，您成功的插入了"+data+"条题目");
            }else {
                alert('提示', "word无法导入数据！请检查word文档或者练习管理员");
            }
        });
    }
</script>

</body>
</html>

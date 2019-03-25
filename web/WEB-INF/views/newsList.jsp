<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="wu-toolbar">
        <div class="wu-toolbar-button">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
        </div>
        <div class="wu-toolbar-search">
            <label>新闻标题:</label><input id="search-title" class="wu-text" style="width:100px;height:20px" >
            <label>新闻作者:</label><input id="search-author" class="wu-text" style="width:100px;height: 20px;">
            <label>所属分类:</label>
            <select id="search-category" class="easyui-combobox" panelHeight="auto" style="width:120px">
                <option value="-1">全部</option>
                <c:forEach items="${ NewsRangeList }" var="newsRange">
                    <option value="${newsRange.id }">${newsRange.name }</option>
                </c:forEach>
            </select>
            <a href="#" id="search-btn" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
        </div>
    </div>
    <!-- End of toolbar -->
    <table id="data-datagrid" class="easyui-datagrid" toolbar="#wu-toolbar"></table>
</div>

<!-- End of easyui-dialog -->
<script type="text/javascript">

    /**
     * 删除记录
     */
    function remove(){
        $.messager.confirm('信息提示','确定要删除该记录？', function(result){
            if(result){
                var item = $('#data-datagrid').datagrid('getSelections');
                if(item == null || item.length == 0){
                    $.messager.alert('信息提示','请选择要删除的数据！','info');
                    return;
                }
                $.ajax({
                    url:'delete',
                    dataType:'json',
                    type:'post',
                    data:{id:item[0].id},
                    success:function(data){
                        if(data.type == 'success'){
                            $.messager.alert('信息提示','删除成功！','info');
                            $('#data-datagrid').datagrid('reload');
                        }else{
                            $.messager.alert('信息提示',data.msg,'warning');
                        }
                    }
                });
            }
        });
    }

    /**
     * Name 打开添加窗口
     */
    function openAdd(){
        //$('#add-form').form('clear');
        window.location.href = '/news/addPage';
    }

    /**
     * 打开修改窗口
     */
    function openEdit(){
        //$('#edit-form').form('clear');
        var item = $('#data-datagrid').datagrid('getSelected');
        if(item == null || item.length == 0){
            $.messager.alert('信息提示','请选择要修改的数据！','info');
            return;
        }
        window.location.href = '/news/editPage?id=' + item.id;
    }


    //搜索按钮监听
    $("#search-btn").click(function(){
        var option = {title:$("#search-title").val(),categoryId:$("#search-category").combobox('getValue'),author:$("#search-author").val()};
        $('#data-datagrid').datagrid('reload',option);
    });

    /**
     * 载入数据
     */
    $('#data-datagrid').datagrid({
        url:'list',
        rownumbers:true,
        singleSelect:true,
        pageSize:20,
        pagination:true,
        multiSort:true,
        fitColumns:true,
        idField:'id',
        treeField:'name',
        fit:true,
        columns:[[
            { field:'chk',checkbox:true},
            { field:'title',title:'标题',width:300,formatter:function(value,row,index){
                    return '<a href="../../news/detail?id='+row.id+'" target="_blank">' + value + '</a>';
                }},
            { field:'categoryId',title:'分类',width:80,formatter:function(value,row,index){
                    return row.newsCategory.name;
                }},
            { field:'author',title:'作者',width:80},
            { field:'tags',title:'标签',width:100},
            { field:'viewNumber',title:'浏览量',sortable:true,width:30},
            { field:'commentNumber',title:'评论数',sortable:true,width:30},
        ]],
    });
</script>




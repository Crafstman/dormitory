<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<title>账单流水</title>
<style type="text/css">
h2 {
	text-align: center;
	margin: 0 auto;
	color: #666;
}

table {
	table-layout: fixed;
	empty-cells: show;
	border-collapse: collapse;
	margin: 0 auto;
	border: 1px solid #cad9ea;
	color: #666;
}

td {
	text-align: left;
	height: 20px;
}
</style>
</head>

<body>
	<h2>账单详情如下</h2>
	<table border="1px" id = "test">
		<thead>
			<tr>
				<th>序号</th>
				<th>金额</th>
				<th>收支类型</th>
				<th>备注</th>
				<th>时间</th>
				<th>记录人员</th>
				<th>余额</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>

		<c:forEach items="${requestScope.message}" var="item"
			varStatus="status">
			<tbody>
				<tr>
					<td>${status.index + 1}</td>
					<td>￥${item.money}</td>
					<td>${item.type}</td>
					<td>${item.detail}</td>
					<td><fmt:formatDate value="${item.time}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${item.operator}</td>
					<td abbr="left">￥${item.balance}</td>
					<!-- <td><a href="javascript:;" onclick="delone(this)">隐藏</a></td> -->
				</tr>
			</tbody>
 
		</c:forEach>
	</table>

	<script>
        $(document).ready(function() {
            var sort_direction=1; //排序标志，1为升序，-1为降序
            $('th').each(function(i) {
                $(this).click(function() {
                    if(sort_direction==1) {
                        sort_direction=-1;
                    }
                    else {
                        sort_direction=1;
                    }
                    //获得行数组
                    var trarr=$('table').find('tbody > tr').get();
                    //数组排序
                    trarr.sort(function(a, b) {
                        var col1=$(a).children('td').eq(i).text().toUpperCase();
                        var col2=$(b).children('td').eq(i).text().toUpperCase();
                        return(col1 < col2) ? -sort_direction: (col1 > col2) ? sort_direction: 0;
                        //返回-1表示a>b降序,返回1表示a<b升序,否则为0相等
                    }
                    );
                    //清空表格
                    $("#test tbody").html("");
                    
                    $.each(trarr, function(i, row) {
                        //将排好序的数组重新填回表格
                        //$("#test tbody").html("");
                        $('tbody').append(row);
                       // console.log(row);
                    }
                    );
                }
                );
            }
            );
        }
    );
        
       
		function delone(otr) {
			var a = otr.parentNode.parentNode;
			a.parentNode.removeChild(a);

		}
		
	</script>
</body>
</html>
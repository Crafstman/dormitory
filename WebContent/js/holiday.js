/**
 * 手动输入节假日
 * 自动输出值日人员
 */
function holiday(){
	var starDate = '2018/05/15 00:00:00';//定义开始计算的时间
	var worker = new Array("陈泽文","贾英泽","赵永春","鲁茸独枝","唐绍鹏","蒲恩伟");	//确定值日成员
	//执行模块
	var nowDate = new Date();	//获取当前时间
	var date3 = nowDate.getTime() - new Date(starDate).getTime(); //时间差的毫秒数  
	var dateStr = nowDate.toLocaleDateString().toString();	//格式化日期
	
	//测试模块
	//var nowDate = '2018/12/31 00:00:00';	//测试时间
	//var date3 = new Date(nowDate).getTime() - new Date(starDate).getTime(); //测试时间差的毫秒数  	
	//var dateStr = new Date(nowDate).toLocaleDateString().toString();	//测试格式化日期
	
	//节假日日期数组
	var holiday=new Array("2018/6/16","2018/6/17","2018/6/18","2018/9/22","2018/9/23","2018/9/24"
			,"2018/10/1","2018/10/2","2018/10/3","2018/10/4","2018/10/5","2018/10/6","2018/10/7"
			,"2018/12/30","2018/12/31");
		
	/*遍历节假日数组
	       是：节假日跳过
	   不是：打印出值日人员
	*/
	for (var i = 0; i < holiday.length; i++) {
		if(dateStr !== holiday[i]){
			//从开始日期计算执行的天数并跳过节假日，不跳过周末
			var days=Math.floor(date3/(24*3600*1000))-i;//为节假日天数
			var j = days%6;	//计算周期，6为宿舍总人数
			console.log(dateStr+worker[j]+days);
			//添加值
			var oDiv=document.getElementById("work");
		    
			var txt ="今日："+worker[j];	//今日值日
		    
		    //明日值日逻辑,若是最后一人则显示下一轮第一个
		    var nextWorker;
		    if(j == 6)
		    	nextWorker = worker[0];
		    else
		    	nextWorker = worker[j+1];
		    var next ="明日：" + nextWorker;
		    oDiv.innerHTML = txt+"<br/>"+next;
			
		}else{
			console.log("今天放假！");
			oDiv.innerHTML = "今天放假！";
			break;
		}
	}
}


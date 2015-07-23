<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@include file="/WEB-INF/views/common/jquery.jsp"%>
<script type="text/javascript" language="JavaScript" src="${ctx}/resources/esl/esl-1.6.10.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
 <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<title>echart</title>
</head>
<body>
<body style="margin-bottom: 10px;">
	<div id="main" style="height:500px;"></div>
<script type="text/javascript"> 
require.config({
    paths: {
        "echarts": ctx+"/resources/echarts-2.0.4/echarts",
        "echarts/chart/map": ctx+"/resources/echarts-2.0.4/echarts-map"
    }
});
require(
		[
         "echarts", 
         "echarts/chart/map"
         ],
function(ec) {
    var myChart = ec.init(document.getElementById("main"));
    var option ={
    	    title : {
    	        text: 'iphone销量',
    	        subtext: '纯属虚构',
    	        x:'center'
    	    },
    	    tooltip : {
    	        trigger: 'item'
    	    },
    	    legend: {
    	        orient: 'vertical',
    	        x:'left',
    	        data:['iphone3','iphone4','iphone5']
    	    },
    	    dataRange: {
    	        min: 0,
    	        max: 2500,
    	        x: 'left',
    	        y: 'bottom',
    	        text:['高','低'],           // 文本，默认为数值文本
    	        calculable : true
    	    },
    	    toolbox: {
    	        show: true,
    	        orient : 'vertical',
    	        x: 'right',
    	        y: 'center',
    	        feature : {
    	            mark : {show: true},
    	            dataView : {show: true, readOnly: false},
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    roamController: {
    	        show: true,
    	        x: 'right',
    	        mapTypeControl: {
    	            'china': true
    	        }
    	    },
    	    series : [
    	        {
    	            name: 'iphone3',
    	            type: 'map',
    	            mapType: 'china',
    	            roam: false,
    	            itemStyle:{
    	                normal:{label:{show:true}},
    	                emphasis:{label:{show:true}}
    	            },
    	            data:[
    	                {name: '北京',value: Math.round(Math.random()*1000)},
    	                {name: '天津',value: Math.round(Math.random()*1000)},
    	                {name: '上海',value: Math.round(Math.random()*1000)},
    	                {name: '重庆',value: Math.round(Math.random()*1000)},
    	                {name: '河北',value: Math.round(Math.random()*1000)},
    	                {name: '河南',value: Math.round(Math.random()*1000)},
    	                {name: '云南',value: Math.round(Math.random()*1000)},
    	                {name: '辽宁',value: Math.round(Math.random()*1000)},
    	                {name: '黑龙江',value: Math.round(Math.random()*1000)},
    	                {name: '湖南',value: Math.round(Math.random()*1000)},
    	                {name: '安徽',value: Math.round(Math.random()*1000)},
    	                {name: '山东',value: Math.round(Math.random()*1000)},
    	                {name: '新疆',value: Math.round(Math.random()*1000)},
    	                {name: '江苏',value: Math.round(Math.random()*1000)},
    	                {name: '浙江',value: Math.round(Math.random()*1000)},
    	                {name: '江西',value: Math.round(Math.random()*1000)},
    	                {name: '湖北',value: Math.round(Math.random()*1000)},
    	                {name: '广西',value: Math.round(Math.random()*1000)},
    	                {name: '甘肃',value: Math.round(Math.random()*1000)},
    	                {name: '山西',value: Math.round(Math.random()*1000)},
    	                {name: '内蒙古',value: Math.round(Math.random()*1000)},
    	                {name: '陕西',value: Math.round(Math.random()*1000)},
    	                {name: '吉林',value: Math.round(Math.random()*1000)},
    	                {name: '福建',value: Math.round(Math.random()*1000)},
    	                {name: '贵州',value: Math.round(Math.random()*1000)},
    	                {name: '广东',value: Math.round(Math.random()*1000)},
    	                {name: '青海',value: Math.round(Math.random()*1000)},
    	                {name: '西藏',value: Math.round(Math.random()*1000)},
    	                {name: '四川',value: Math.round(Math.random()*1000)},
    	                {name: '宁夏',value: Math.round(Math.random()*1000)},
    	                {name: '海南',value: Math.round(Math.random()*1000)},
    	                {name: '台湾',value: Math.round(Math.random()*1000)},
    	                {name: '香港',value: Math.round(Math.random()*1000)},
    	                {name: '澳门',value: Math.round(Math.random()*1000)}
    	            ]
    	        },
    	        {
    	            name: 'iphone4',
    	            type: 'map',
    	            mapType: 'china',
    	            itemStyle:{
    	                normal:{label:{show:true}},
    	                emphasis:{label:{show:true}}
    	            },
    	            data:[
    	                {name: '北京',value: Math.round(Math.random()*1000)},
    	                {name: '天津',value: Math.round(Math.random()*1000)},
    	                {name: '上海',value: Math.round(Math.random()*1000)},
    	                {name: '重庆',value: Math.round(Math.random()*1000)},
    	                {name: '河北',value: Math.round(Math.random()*1000)},
    	                {name: '安徽',value: Math.round(Math.random()*1000)},
    	                {name: '新疆',value: Math.round(Math.random()*1000)},
    	                {name: '浙江',value: Math.round(Math.random()*1000)},
    	                {name: '江西',value: Math.round(Math.random()*1000)},
    	                {name: '山西',value: Math.round(Math.random()*1000)},
    	                {name: '内蒙古',value: Math.round(Math.random()*1000)},
    	                {name: '吉林',value: Math.round(Math.random()*1000)},
    	                {name: '福建',value: Math.round(Math.random()*1000)},
    	                {name: '广东',value: Math.round(Math.random()*1000)},
    	                {name: '西藏',value: Math.round(Math.random()*1000)},
    	                {name: '四川',value: Math.round(Math.random()*1000)},
    	                {name: '宁夏',value: Math.round(Math.random()*1000)},
    	                {name: '香港',value: Math.round(Math.random()*1000)},
    	                {name: '澳门',value: Math.round(Math.random()*1000)}
    	            ]
    	        },
    	        {
    	            name: 'iphone5',
    	            type: 'map',
    	            mapType: 'china',
    	            itemStyle:{
    	                normal:{label:{show:true}},
    	                emphasis:{label:{show:true}}
    	            },
    	            data:[
    	                {name: '北京',value: Math.round(Math.random()*1000)},
    	                {name: '天津',value: Math.round(Math.random()*1000)},
    	                {name: '上海',value: Math.round(Math.random()*1000)},
    	                {name: '广东',value: Math.round(Math.random()*1000)},
    	                {name: '台湾',value: Math.round(Math.random()*1000)},
    	                {name: '香港',value: Math.round(Math.random()*1000)},
    	                {name: '澳门',value: Math.round(Math.random()*1000)}
    	            ]
    	        }
    	    ]
    	};
    	                    
    myChart.setOption(option);
});
</script>
</body>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
	
<div id="ChartPanel">
	<div class="genderAnalysis"><canvas id="piechart" width="200" height="200" ></canvas></div>
	<div class="createDateAnalysis"><canvas id="linechart" ></canvas></div>
</div>


<script type="text/javascript">

	
	//饼状图参数
	var pieChartData = {
		labels : "${pieChartData.labels}".split(","),
		datasets : [ {
			backgroundColor : [ 'rgba(54, 162, 235, 1)','rgba(255,99,132,1)' ],
			data : "${pieChartData.datas}".split(",")
		} ]
	};
	
	//线性图参数
	var lineChartData = {
			labels :"${lineChartData.labels}".split(","),
			datasets : [{
				label: "创建用户数量",
				borderColor : "rgba(54, 162, 235, 1)",
				data : "${lineChartData.datas}".split(","),
				fill : false //线下面填充
			}]
	};
	
	$(function() {
		var piectx = $("#piechart").get(0).getContext("2d");
		var linectx = $("#linechart").get(0).getContext("2d");
		//生成饼状图
		var piechart = new Chart(piectx, {
			type : 'pie',
			data : pieChartData,
			options : {
				title : {
					display: true,
					text: '用户性别分布统计',
					fontColor: '#000'
				}
			}
		});
		
		//生成线性图
		var linechart=new Chart(linectx,{
			type: 'line',
			data: lineChartData,
			 options: {
	                responsive: true,
	                title : {//设置标题
						display: true,
						text: '用户创建日期统计',
						fontColor: '#000'
					},
	                tooltips: {
	                    mode: 'index',
	                    intersect: false,
	                },
	                hover: {
	                    mode: 'nearest',
	                    intersect: true
	                },
	                scales: {//设置横轴坐标
	                    xAxes: [{
	                        display: true,
	                        scaleLabel: {
	                            display: true,
	                            labelString: '创建日期'
	                        }
	                    }],
	                    yAxes: [{//设置纵轴坐标
	                        display: true,
	                        scaleLabel: {
	                            display: true,
	                            labelString: '创建用户数量'
	                        }
	                    }]
	                }
	            }
		});
	});
</script>
package com.qingshixun.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * chart.js 插件数据实体
 * @author back
 *
 */
@Component
@Scope("prototype")
public class ChartData {
	
	private String labels;//列表名数组
	
	private String datas;//数据项数组

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getDatas() {
		return datas;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}
	
	public ChartData() {
		this.labels = "";
		this.datas = "";
	}

	@Override
	public String toString() {
		return "ChartData [labels=" + labels + ", datas=" + datas + "]";
	}
	
}

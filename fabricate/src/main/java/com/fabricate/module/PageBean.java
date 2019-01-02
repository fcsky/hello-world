package com.fabricate.module;

import org.springframework.stereotype.Component;

@Component("pageBean")
public class PageBean {
	private int columns = 10;// 每页显示行数
	private int index=0;// 查询的起始位置
	private int pageSize;// 总页数
	private int allColumns;// 总行数
	private int current=1;// 当前页

	//这个方法只有在搜索或者第一次加载时才会调用，所以每次都要把数据初始化
	public void setPage(int allColumns) {
		
		this.current=1;
		this.index=0;
		this.allColumns=allColumns;
		int flag = allColumns % this.columns;
		int temp = allColumns/this.columns;
		if (flag == 0) {
			this.pageSize = temp;
		} else {
			this.pageSize = temp + 1;
		}
	}

	// 下一页
	public void setNextPage() {
		System.out.println(toString());
		if((index+columns)<allColumns) {
			index += columns;
		}
			
		
		if(current<pageSize)
			current+=1;
		else
			current=pageSize;
		
		System.out.println(toString());
	}

	// 上一页
	public void setLastPage() {
		if(index>=columns)
			index -= columns;
		else
			index=0;
		
		
		if(current>1)
			current-=1;
		else 
			current=1;
		
	}

	// 首页
	public void setFirstPage() {
		this.index = 0;
		current=1;
	}

	// 尾页
	public void setEndPage() {
		//获取最后一页的起始位置
		index=allColumns/columns*columns;
		current=pageSize;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getAllColumns() {
		return allColumns;
	}

	public void setAllColumns(int allColumns) {
		this.allColumns = allColumns;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	@Override
	public String toString() {
		return "PageBean [columns=" + columns + ", index=" + index + ", pageSize=" + pageSize + ", allColumns="
				+ allColumns + ", current=" + current + "]";
	}

}

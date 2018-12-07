package com.dubbo.server.dao.mapper;

import java.util.List;
import java.util.Map;

import com.dubbo.entity.TblBrowserRoute;

import tk.mybatis.mapper.common.Mapper;

/*extends Mapper<TblBrowserRoute> 这里使用了通用Mapper
 * 一旦继承了Mapper，继承的Mapper就拥有了Mapper所有的通用方法
 * Select：selectByPrimaryKey();selectAll();等等
 * Insert,Update,Delete,Example等（ selectByExample(Object example);。。。）*/
public interface TblBrowserRouteMapper extends Mapper<TblBrowserRoute>{
	public List<Map<String,String>> selectAdapters();
}

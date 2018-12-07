package com.dubbo.server.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.GatewayService;
import com.dubbo.entity.TblBrowserRoute;
import com.dubbo.entity.TblTradeChannel;
import com.dubbo.server.dao.mapper.TblBrowserRouteMapper;
import com.dubbo.server.dao.mapper.TblTradeChannelMapper;

import tk.mybatis.mapper.entity.Example;

@Service(interfaceClass = GatewayService.class,timeout=50000) 
@Component
public class GatewayServiceImpl implements GatewayService,Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(GatewayServiceImpl.class);
	
	@Autowired(required=true)
	private TblBrowserRouteMapper browserMapper;
	
	@Autowired(required=true)
	private TblTradeChannelMapper tradechannelMapper;
	
	@Override
	public Map<String, String> selectAll() {
		LOGGER.info("provider======selectAll() begin........");
		List<TblBrowserRoute> browserRoute = browserMapper.selectAll();
		LOGGER.info("provider======browserMapper.selectAll() Done!!!!");
		
		int i=0;
		Map<String,String> map = new HashMap();
		
		for(TblBrowserRoute b: browserRoute){
			LOGGER.info(browserRoute.get(i++).toString());
			LOGGER.info("tbl_browser_route:["+b.toString()+"]");
			Example example = new Example(TblTradeChannel.class);
			Example.Criteria criteria = example.createCriteria();
			criteria.andEqualTo("tcId", b.getTcId());
			LOGGER.info("tcId=["+b.getTcId()+"]");
			
			/*Example方法
			方法：List<T> selectByExample(Object example);
			说明：根据Example条件进行查询*/
			List<TblTradeChannel> tbltradechannels = tradechannelMapper.selectByExample(example);
			if(tbltradechannels != null && tbltradechannels.size()>0){
				LOGGER.info(tbltradechannels.toString());
				map.put(b.getAdapterV(), tbltradechannels.get(0).getPayUrl());
				LOGGER.info("put to map:key=["+b.getAdapterV()+"],value=["+tbltradechannels.get(0).getPayUrl()+"].");
			}
		}
		LOGGER.info(map.toString());
		return map;
	}

	@Override
	public String identityAdaptor(Map<String, String> param, String key) {
		LOGGER.info("identify adapter begin~~~");
		LOGGER.info("map<param>:["+param+"]");
		LOGGER.info("find key:["+key+"]");
		String htmlUrl = param.get(key);
		LOGGER.info("return htmlUrl:["+htmlUrl+"]");
		return htmlUrl;
	}

}

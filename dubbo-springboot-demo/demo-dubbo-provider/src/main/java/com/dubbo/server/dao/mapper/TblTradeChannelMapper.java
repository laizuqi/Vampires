package com.dubbo.server.dao.mapper;

import com.dubbo.entity.TblTradeChannel;

import tk.mybatis.mapper.common.Mapper;

public interface TblTradeChannelMapper extends Mapper<TblTradeChannel> {
	public TblTradeChannel selectchannelByTCID(int tcId);
}

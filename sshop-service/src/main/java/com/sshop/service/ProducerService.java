package com.sshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshop.core.model.Producer;
import com.sshop.dao.ProducerDao;

@Service
public class ProducerService {
	
	@Autowired
	private ProducerDao producerDao;
	@Autowired
	private ImageService imageService;
	
	/**
	 * 获取商品生产者信息
	 * @param producerId
	 * @return
	 */
	public Producer findGoodsProducer(Integer producerId) {
		if (producerId == null) {
			return null;
		}
		Producer producer = producerDao.findGoodsProducer(producerId);
		if (producer == null) {
			return null;
		}
		// 获取头像
		String headImage = imageService.findHeadImage(producerId);
		producer.setHeader(headImage);
		return producer;
	}
	
}

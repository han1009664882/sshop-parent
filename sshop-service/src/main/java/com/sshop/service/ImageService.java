package com.sshop.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sshop.core.constant.Constant;
import com.sshop.core.constant.ImagesType;
import com.sshop.core.model.Images;
import com.sshop.core.util.AssertUtil;
import com.sshop.dao.ImagesDao;

@Service
public class ImageService {
	
	@Autowired
	private ImagesDao imagesDao;
	
	@Value("${image.prefix}")
	private String imagePrefix;
	
	/**
	 * 获取商品详情的一张图片
	 * @param code
	 * @return
	 */
	public String findGoodsDetailImage(String code) {
		AssertUtil.notNull(code, "参数异常");
		String path = imagesDao.findGoodsDetailImage(code);
		if (StringUtils.isNotBlank(path)) {
			path = imagePrefix + path;
		}
		return path;
	}
	
	/**
	 * 获取头像
	 * @param userId
	 * @return
	 */
	public String findHeadImage(Integer userId) {
		if (userId == null || userId < 1) {
			return null;
		}
		String path = imagesDao.findHeadImage(userId);
		if (StringUtils.isNotBlank(path)) {
			path = imagePrefix + path;
		}
		return path;
	}

	/**
	 * 获取商品图片信息
	 * @param goodCode
	 * @return
	 */
	public List<Images> findGoodsImages(String goodCode) {
		if (StringUtils.isBlank(goodCode)) {
			return null;
		}
		List<Images> images = imagesDao.findGoodsImages(goodCode);
		return images;
	}
	
	/**
	 * 获取默认的商品部件图片
	 * @param goodsCode
	 * @return
	 */
	public List<Images> findDefaultPartImages(String goodsCode) {
		List<Images> images = imagesDao.findDefaultPartImages(goodsCode);
		return images;
	}
	
	/**
	 * 保存用户默认图片
	 * @param userId
	 */
	public void addUserHeader(Integer userId) {
		Images images = new Images();
		images.setUserId(userId);
		images.setDescription("用户头像");
		images.setPath(Constant.USER_DEFAULT_HEAD_IMAGE);
		images.setStatus(0);
		images.setType(ImagesType._HEADER_.getValue());
		imagesDao.insert(images);
	}
	
	/**
	 * 通过ids查询多个图片
	 * @param ids
	 * @return
	 */
	public List<Images> findByIds(String ids) {
		List<Images> images = imagesDao.findByIds(ids);
		for (Images image : images) {
			String path = imagePrefix + image.getPath();
			image.setPath(path);
		}
		return images;
	}
	
}

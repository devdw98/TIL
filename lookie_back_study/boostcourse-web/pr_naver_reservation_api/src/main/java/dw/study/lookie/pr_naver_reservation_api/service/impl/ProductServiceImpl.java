package dw.study.lookie.pr_naver_reservation_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.pr_naver_reservation_api.dao.ProductDao;
import dw.study.lookie.pr_naver_reservation_api.dto.Product;
import dw.study.lookie.pr_naver_reservation_api.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao pDao;

	@Override
	public int getCount() {
		return pDao.selectAllCount();
	}

	@Override
	@Transactional
	public List<Product> getProductInfos(Integer categoryId, Integer start) {
		return pDao.selectProductInfo(categoryId, start, LIMIT);
	}

}

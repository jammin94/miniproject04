package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;
import com.model2.mvc.service.purchase.PurchaseService;

@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService{
	@Autowired
	@Qualifier("purchaseDaoImpl")
	private PurchaseDao purchaseDao;
	
	public PurchaseServiceImpl() {
		System.out.println(this.getClass());
	}

	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}

/////////////////////////////////////////////////////////////////////
	
	public void addPurchase(Purchase purchase) throws Exception{
		purchaseDao.addPurchase(purchase);
	}
	
	public Purchase getPurchase(int tranNo) throws Exception{
		return purchaseDao.getPurchase(tranNo);
	}
	

	public Map<String , Object> getPurchaseList(Map map) throws Exception{
		List<Purchase> list= purchaseDao.getPurchaseList(map);
		int totalCount = purchaseDao.getTotalCount((Search)map);
		
		Map<String, Object> mapp = new HashMap<String, Object>();
		mapp.put("list", list );
		mapp.put("totalCount", new Integer(totalCount));
		
		return mapp;
	}
	
	
	public Map<String , Object> getSalesList(Map map) throws Exception{
		List<Purchase> list= purchaseDao.getSalesList(map);
		int totalCount = purchaseDao.getTotalCount((Search)map);
		
		Map<String, Object> mapp = new HashMap<String, Object>();
		mapp.put("list", list );
		mapp.put("totalCount", new Integer(totalCount));
		
		return mapp;
	}
	
	
	public void updatePurchase(Purchase purchase) throws Exception{
		purchaseDao.updatePurchase(purchase);
	}
	
	
	public void updateTrancode(Purchase purchase) throws Exception{
		purchaseDao.updateTranCode(purchase);;
	}

}

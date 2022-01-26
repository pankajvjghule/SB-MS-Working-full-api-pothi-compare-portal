package com.apipothi.flipkart.to.service.impl;
/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * Web Site  : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apipothi.flipkart.dao.FlipkartDAO;
import com.apipothi.flipkart.model.FlipkartProduct;
import com.apipothi.flipkart.request.FlipkartRequest;
import com.apipothi.flipkart.to.FlipkartTO;
import com.apipothi.flipkart.to.service.FlipkartService;

@Component
public class FlipkartServiceImpl implements FlipkartService {

	private final static Logger logger = LoggerFactory.getLogger(FlipkartServiceImpl.class);

	@Autowired
	FlipkartDAO dao;

	@Override
	public String addProductFromManufacturer(List<FlipkartTO> manufacturerProductDetails) {
		logger.info("START- addProductFromManufacturer{}" + manufacturerProductDetails);
		String statusmsg = "";
		try {
			for (FlipkartTO flipkartTO : manufacturerProductDetails) {
				FlipkartProduct flipkartProduct = new FlipkartProduct();
				flipkartProduct.setId(flipkartTO.getId());
				flipkartProduct.setProductid(flipkartTO.getWproductid());
				flipkartProduct.setProductname(flipkartTO.getWproductname());
				// Selling Price Logic
				long costPrice = flipkartTO.getWproductprice();
				long sellingPrice = flipkartSellingPrice(costPrice);
				// flipkartProduct.setProductprice(flipkartTO.getWproductprice());
				flipkartProduct.setProductprice(sellingPrice);
				dao.save(flipkartProduct);
			}
			statusmsg = "Data Inserted successfully";
		} catch (Exception e) {
			statusmsg = "Exception occured during data insertion";
			logger.error("-Exception{}", e);
		}
		return statusmsg;
	}

	private long flipkartSellingPrice(long costPrice) {

		long profit = 0L;
		long sellingPrice = 0L;

		if (costPrice <= 100) {
			profit = ((costPrice * 60) / 100);
			sellingPrice = costPrice + profit;
			System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "60%" + " PROFIT " + profit + " SELLING PRICE" + sellingPrice);
			return sellingPrice;

		} else if (costPrice > 100 && costPrice <= 500) {
			profit = ((costPrice * 50) / 100);
			sellingPrice = costPrice + profit;
			System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "50%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
			return sellingPrice;

		} else if (costPrice > 500 && costPrice <= 1000) {
			profit = ((costPrice * 40) / 100);
			sellingPrice = costPrice + profit;
			System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "40%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
			return sellingPrice;

		} else if (costPrice > 1000 && costPrice <= 2000) {
			profit = ((costPrice * 30) / 100);
			sellingPrice = costPrice + profit;
			System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "30%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
			return sellingPrice;

		} else if (costPrice > 2000 && costPrice <= 4000) {
			profit = ((costPrice * 20) / 100);
			sellingPrice = costPrice + profit;
			System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "20%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
			return sellingPrice;

		} else if (costPrice > 4000 && costPrice <= 7000) {
			profit = ((costPrice * 10) / 100);
			sellingPrice = costPrice + profit;
			System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "10%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
			return sellingPrice;

		} else{
			profit = ((costPrice * 5) / 100);
			sellingPrice = costPrice + profit;
			System.out.println("COST PRICE" + "-" + costPrice + " PROFIT-" + "05%" + " PROFIT - " + profit + " SELLING PRICE - " + sellingPrice);
			return sellingPrice;

		}
	}

	@Override
	public List<FlipkartTO> getByIDProductInFlipkart(int id) {
		logger.info("START- getByIDProductInFlipkart{}" + id);
		String statusmsg = "";
		List<FlipkartTO> flipkartProductList = new ArrayList<FlipkartTO>();
		FlipkartTO to = new FlipkartTO();
		try {
			Optional<FlipkartProduct> flipkartProduct = dao.findById(id);
			logger.info("***productbyid ***" + flipkartProduct);
			to.setId(flipkartProduct.get().getId());
			to.setWproductid(flipkartProduct.get().getProductid());
			to.setWproductname(flipkartProduct.get().getProductname());
			to.setWproductprice(flipkartProduct.get().getProductprice());
			flipkartProductList.add(to);
			logger.info("***END--getByIDProductInFlipkart()--RESPONSE{} " + flipkartProductList);
		} catch (Exception e) {
			statusmsg = "Exception occured during data insertion";
			logger.error("-Exception{}", statusmsg);
		}
		return flipkartProductList;
	}

	@Override
	public List<FlipkartTO> getAllProductInFlipkart() {
		logger.info("START- getAllProductInFlipkart{}");
		String statusmsg = "";
		List<FlipkartTO> listOflipkartProduct = new ArrayList<FlipkartTO>();
		try {
			List<FlipkartProduct> flipkartProductList = dao.findAll();
			for (FlipkartProduct flipkartProduct : flipkartProductList) {
				FlipkartTO to = new FlipkartTO();
				to.setId(flipkartProduct.getId());

				to.setWproductid(flipkartProduct.getProductid());
				to.setWproductname(flipkartProduct.getProductname());
				to.setWproductprice(flipkartProduct.getProductprice());
				listOflipkartProduct.add(to);
			}

		} catch (Exception e) {
			statusmsg = "Exception occured during getAllProductInFlipkart";
			logger.error("-Exception{}", statusmsg);
		}
		return listOflipkartProduct;
	}

	@Override
	public String addProductInFlipkart(List<FlipkartRequest> request) {
		logger.info("***START--createmyproduct()-- Request{}" + request);
		List<FlipkartRequest> flipkartProduct = request;
		List<FlipkartProduct> productList = new ArrayList<FlipkartProduct>();
		String statusMsg = "";
		FlipkartProduct product = new FlipkartProduct();
		for (FlipkartRequest flipkartRequest : flipkartProduct) {
			product.setId(flipkartRequest.getId());

			product.setProductid(flipkartRequest.getWproductid());
			product.setProductname(flipkartRequest.getWproductname());
			product.setProductprice(flipkartRequest.getWproductprice());
			productList.add(product);
		}
		try {
			dao.insert(productList);
			statusMsg = "Data Inserted Successfully";
		} catch (Exception e) {
			statusMsg = "Exception occured while Inserting the Data";
			logger.error("-Exception{}", statusMsg);
		}
		return statusMsg;
	}

	@Override
	public String updateProductInFlipkart(FlipkartRequest request) {
		logger.info("***START--updateProductInFlipkart()-- product{}" + request);
		String statusMsg = "";
		FlipkartProduct product = new FlipkartProduct();
		product.setId(request.getId());
		product.setProductid(request.getWproductid());
		product.setProductname(request.getWproductname());
		product.setProductprice(request.getWproductprice());

		try {
			dao.save(product);
			statusMsg = "Data Updated sucessfully";
		} catch (Exception e) {
			statusMsg = "Exception occured while Updating the Data";
		}
		logger.info("***END--updatemyproduct()-- product{}" + statusMsg);
		return statusMsg;
	}

	@Override
	public boolean deleteProductInFlipkart(int id) {
		logger.info("***START--deleteProductInFlipkart()-- id{}" + id);
		boolean success = false;
		dao.deleteById(id);
		success = true;
		logger.info("***END--deleteProductInFlipkart()--");
		return success;
	}

}

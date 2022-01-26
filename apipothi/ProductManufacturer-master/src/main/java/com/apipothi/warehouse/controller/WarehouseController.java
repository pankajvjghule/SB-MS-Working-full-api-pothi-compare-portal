package com.apipothi.warehouse.controller;
/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * Web Site  : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apipothi.warehouse.constant.WarehouseConstant;
import com.apipothi.warehouse.request.WarehouseRequest;
import com.apipothi.warehouse.response.WarehouseResponse;
import com.apipothi.warehouse.service.impl.WarehouseServiceImpl;
import com.apipothi.warehouse.to.WarehouseProductTO;

@RestController
public class WarehouseController {
	private final static Logger logger = LoggerFactory.getLogger(WarehouseController.class);
	@Autowired
	WarehouseServiceImpl warehouseservice;

	@Value("${server.port}")
	int port;
	
	@Value("${spring.application.name}")
	String appname;

	@PostMapping("/createproduct")
	public WarehouseResponse createproduct(@RequestBody List<WarehouseRequest> productlist) {
		logger.info("***START---createproduct() productlist{}" + productlist);
		WarehouseResponse response = new WarehouseResponse();
		try {
			String sucess = warehouseservice.createmyproduct(productlist);
			response.setMessage(sucess);
			response.setStatuscode(WarehouseConstant.SUCESS_CODE);
			response.setPort(port);
			response.setAppname(appname);

		} catch (Exception e) {
			response.setMessage(WarehouseConstant.INSERTFAIL_MSG);
			response.setStatuscode(WarehouseConstant.NOCONTENT_CODE);
			response.setPort(port);
			response.setAppname(appname);
		}
		logger.info("***END---createproduct()");
		return response;
	}

	@GetMapping("/getallproduct")
	public WarehouseResponse getallproduct() {
		WarehouseResponse response = new WarehouseResponse();
		logger.info("***START---getallproduct()");
		try {
			List<WarehouseProductTO> allproductdetals = warehouseservice.getmyproduct();
			response.setProductDetails(allproductdetals);
			response.setStatuscode(WarehouseConstant.SUCESS_CODE);
			response.setMessage(WarehouseConstant.SUCESS_MSG);
			response.setPort(port);
			response.setAppname(appname);
		} catch (Exception e) {
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.NOCONTENT_CODE);
			response.setMessage(WarehouseConstant.NOCONTENT_MSG);
			response.setPort(port);
			response.setAppname(appname);
		}
		logger.info("***END---getallproduct()-RESPONSE {} " + response);
		return response;
	}

	@GetMapping("/getproductbyid/{id}")
	public WarehouseResponse getproductbyid(@PathVariable int id) {
		logger.info("***START---getproductbyid() id{} " + id);
		WarehouseResponse response = new WarehouseResponse();
		try {
			List<WarehouseProductTO> producrList = warehouseservice.getbyidmyproduct(id);
			response.setProductDetails(producrList);
			response.setStatuscode(WarehouseConstant.SUCESS_CODE);
			response.setMessage(WarehouseConstant.SUCESS_MSG);
			response.setPort(port);
			response.setAppname(appname);
		} catch (Exception e) {
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.NOCONTENT_CODE);
			response.setMessage(WarehouseConstant.NOCONTENT_MSG);
			response.setPort(port);
			response.setAppname(appname);
		}
		logger.info("***getproductbyid() RESPONSE{} ***" + response);
		return response;
	}

	@PutMapping("/updateproduct/{id}")
	public WarehouseResponse updateproduct(@PathVariable int id, WarehouseRequest product) {
		logger.info("***START---updateproduct() id{} " + id + "Product{}" + product);
		WarehouseResponse response = new WarehouseResponse();
		try {
			product.setId(id);
			String statusMsg = warehouseservice.updatemyproduct(product);
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.SUCESS_CODE);
			response.setMessage(statusMsg);
			response.setPort(port);
			response.setAppname(appname);
		} catch (Exception e) {
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.NOCONTENT_CODE);
			response.setMessage(WarehouseConstant.NOCONTENT_MSG);
			response.setPort(port);
			response.setAppname(appname);
		}
		logger.info("***END---updateproduct()*** RESPONSE" + response);
		return response;
	}

	@DeleteMapping("/deleteproduct/{id}")
	public WarehouseResponse deleteproduct(@PathVariable int id) {
		logger.info("***START---updateproduct() id{} " + id);
		WarehouseResponse response = new WarehouseResponse();
		try {
			warehouseservice.deletemyproduct(id);
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.SUCESS_CODE);
			response.setMessage(WarehouseConstant.SUCESS_MSG);
			response.setPort(port);
			response.setAppname(appname);
		} catch (Exception e) {
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.NOCONTENT_CODE);
			response.setMessage(WarehouseConstant.NOCONTENT_MSG);
			response.setPort(port);
			response.setAppname(appname);
		}
		logger.info("***END---deleteproduct()*** RESPONSE{} " + response);
		return response;
	}
}

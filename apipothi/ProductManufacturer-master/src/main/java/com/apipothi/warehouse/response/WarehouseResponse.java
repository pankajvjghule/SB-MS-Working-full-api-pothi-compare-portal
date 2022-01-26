package com.apipothi.warehouse.response;
/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * Web Site  : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
import java.util.List;

import com.apipothi.warehouse.model.WarehouseProduct;
import com.apipothi.warehouse.to.WarehouseProductTO;

public class WarehouseResponse {

	private int statuscode;
	private String message;
	private int port;
	private String appname;

	private List<WarehouseProductTO> productDetails;

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<WarehouseProductTO> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<WarehouseProductTO> productDetails) {
		this.productDetails = productDetails;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	@Override
	public String toString() {
		return "WarehouseResponse [statuscode=" + statuscode + ", message=" + message + ", port=" + port + ", appname="
				+ appname + ", productDetails=" + productDetails + "]";
	}

}

package com.apipothi.warehouse.service;
/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * Web Site  : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
import java.util.List;
import java.util.Optional;

import com.apipothi.warehouse.model.WarehouseProduct;
import com.apipothi.warehouse.request.WarehouseRequest;
import com.apipothi.warehouse.to.WarehouseProductTO;

public interface WarehouseService {

	public String createmyproduct(List<WarehouseRequest> product  );

	public List<WarehouseProductTO> getmyproduct();

	public List<WarehouseProductTO> getbyidmyproduct(int id);

	public String updatemyproduct(WarehouseRequest product);

	public boolean deletemyproduct(int id);

}

package com.apipothi.warehouse.dao;
/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * Web Site  : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.apipothi.warehouse.model.WarehouseProduct;

@Repository
public interface WarehouseDAO extends MongoRepository<WarehouseProduct, Integer> {

}

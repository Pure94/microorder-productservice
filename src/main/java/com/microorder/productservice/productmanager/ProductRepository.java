package com.microorder.productservice.productmanager;

import org.springframework.data.mongodb.repository.MongoRepository;

interface ProductRepository extends MongoRepository<ProductEntity, String>
{

}

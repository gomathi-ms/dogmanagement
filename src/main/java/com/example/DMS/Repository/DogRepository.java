package com.example.DMS.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.DMS.Model.Dog;

public interface DogRepository  extends CrudRepository<Dog,Integer>{
List<Dog> findByname(String name);
}

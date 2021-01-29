package com.example.iam.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.iam.model.Resource;

public interface ResoureRepository extends CrudRepository<Resource, Long>
{
	List<Resource> findByResourceId(String resourceId);
	List<Resource> findAll();
}
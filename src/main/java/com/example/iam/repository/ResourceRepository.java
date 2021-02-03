package com.example.iam.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.iam.model.Resource;

public interface ResourceRepository extends CrudRepository<Resource, Long>
{
	List<Resource> findByResourceId(int resourceId);
	List<Resource> findByEntityId(String entityId);
	List<Resource> findAll();
}
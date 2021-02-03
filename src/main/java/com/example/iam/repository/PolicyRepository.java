package com.example.iam.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.iam.model.Policy;

public interface PolicyRepository extends CrudRepository<Policy, Long>
{
	List<Policy> findByResourceId(int resourceId);
	List<Policy> findAll();
}
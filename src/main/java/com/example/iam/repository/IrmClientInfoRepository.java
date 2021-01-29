package com.example.iam.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.iam.model.IrmClientInfo;


public interface IrmClientInfoRepository extends CrudRepository<IrmClientInfo, Long>
{
	List<IrmClientInfo> findAll();
}
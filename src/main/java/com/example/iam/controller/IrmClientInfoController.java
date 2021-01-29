package com.example.iam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.iam.repository.IrmClientInfoRepository;
import com.example.iam.model.IrmClientInfo;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
 
@RestController
@RequestMapping("/irm/register")
public class IrmClientInfoController
{
	@Autowired
	IrmClientInfoRepository irmClientInfoRepository;
	
	@PostMapping(
			path = "/register",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> create(@RequestBody IrmClientInfo irmClientInfo)
	{
		IrmClientInfo irmClientInfo1 = irmClientInfoRepository.save(irmClientInfo);

		Map<String, String> retValue = new HashMap<String, String>();		
		retValue.put("id", irmClientInfo1.getId());
		
		return retValue;
	}
	
	@GetMapping(path = "/findall")
	public List<IrmClientInfo> findAll()
	{
		List<IrmClientInfo> irmClientInfoList = irmClientInfoRepository.findAll();		
		return irmClientInfoList;
	}
}
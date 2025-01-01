package com.infy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rewards/points")
public class RewardsController {
	
	@Autowired
	private RewardPointService  rewardpointserviceImpl;
	
	@GetMapping(value = "/{customerId}")
	public Map<String, Integer> getresult(@PathVariable int customerId)	{
		
		 Map<String, Integer> result = rewardpointserviceImpl.monthlypointswithtotal(customerId);
		 return result;
	}
	
	

}

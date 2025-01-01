package com.infy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class rewardpointserviceImpl implements RewardPointService{
	
	
	static ArrayList<DTOTransaction> transaction = new ArrayList<DTOTransaction>();
	static {
		transaction.add(new DTOTransaction(1, 120, "2024-10-01"));
		transaction.add(new DTOTransaction(1, 90, "2024-10-10"));
        transaction.add(new DTOTransaction(2, 150, "2024-10-15"));
        transaction.add(new DTOTransaction(2, 60, "2024-10-20"));
        transaction.add(new DTOTransaction(3, 80, "2024-11-01"));
        transaction.add(new DTOTransaction(1, 110, "2024-11-05"));
        transaction.add(new DTOTransaction(2, 200, "2024-11-10"));
        transaction.add(new DTOTransaction(3, 50, "2024-12-01"));
        transaction.add(new DTOTransaction(1, 130, "2024-12-05"));
	
	}
	
	
	 public static int calculateRewardPoints(DTOTransaction dtotransaction) {
	        double amount = dtotransaction.getAmount();
	        int points = 0;

	        if (amount > 100) {
	            
	            points += (int) ((amount - 100) * 2);  
	        }
	        if (amount > 50) {
	            
	            points += (int) ((Math.min(amount, 100) - 50) * 1);  
	        }

	        return points;
	    }
	
		public Map<String, Integer> monthlypointswithtotal(int customerId)	{
		
		int OctPts = 0;
	    int NovPts = 0;
	    int DecPts = 0;
	    
	    for (DTOTransaction t : transaction) {
	    	
         if (t.getCustomerId() == customerId) {
             int points = rewardpointserviceImpl.calculateRewardPoints(t);
             String month = t.getDate().substring(5, 7);

             switch (month) {
                 case "10":
                	 OctPts += points;
                     break;
                 case "11":
                	 NovPts += points;
                     break;
                 case "12":
                	 DecPts += points;
                     break;
             }
         }
     }
		
		Map<String, Integer> result = new HashMap<>();
		result.put("October", OctPts);
        result.put("November", NovPts);
        result.put("December", DecPts);
        
        result.put("Total", OctPts + NovPts + DecPts);
		
        return result;
	}

}

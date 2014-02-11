package leetcode;

public class GasStation {

	/*
	 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

	 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

	 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

	 Note:
	 The solution is guaranteed to be unique. 
	*/
	
	public static void main(String[] args) {
		
		int[] gas = { 2,4};
		int[] cost = { 3,4};
		System.out.println(canCompleteCircuit(gas,cost));
		
	}

	
	
	 public static int canCompleteCircuit(int[] gas, int[] cost) {
	
		 int tank = 0;
		 int i = 0; //current working station.
		 int start = 0;
		 int steps = 0;
		while(start<=gas.length  ){
			tank = tank + gas[i%gas.length] - cost[i%gas.length];
			if(tank<0){
				start = (i+1);
				tank = 0;
				steps = 0;
			}else{
				steps = steps+ 1;
			}
				
			if(steps == gas.length){
				return start;
			}
		
		i = i + 1;
		} 
		 
		 
		 return -1;
	}
	
	
	
	//brute force solution. TLE.
	 public static int canCompleteCircuitBurteForce(int[] gas, int[] cost) {
		
		 int tank = 0;
		 
		 
		 for(int i= 0  ;i<gas.length; i++){
			 
		 
			 for(int m= i  ;m<gas.length+i; m++){
				
				 tank = tank + gas[m%gas.length] - cost[m%gas.length];
				 
				 if(tank < 0 ){
					 break;
				 }
			
			 } 
			 
			 if(tank >=0){
				 return i;
			 }else{
				 tank = 0;
				 continue;
			 }
		 }
		 
		 
		 return -1;
	        
	    }
}

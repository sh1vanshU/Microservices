/**
 * 
 */
package com.coffeemachine.Model;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author shivanshu.gua
 *
 */

public class Drink {
	/*
	 * key is the name of ingredient
	 * value is the quantity of ingredient.
	 */
	private Map<String,Integer> solution=new HashMap<>();	
	
	private long drinkId;
	private String drinkName;

	
	
	public Drink(long id,String name,Map<String,Integer> sol)
	{
		this.drinkId=id;
		this.drinkName=name;
		
		for(String str:sol.keySet())
		{
			if(this.solution.containsKey(str))
			{
				this.solution.put(str, sol.get(str)+1);
			}else
			{
				this.solution.put(str,1);
			}
		}
		
	}

	public Map<String, Integer> getSolution() {
		return solution;
	}

	public void setSolution(Map<String, Integer> solution) {
		this.solution = solution;
	}

	public long getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(long drinkId) {
		this.drinkId = drinkId;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	
	
}

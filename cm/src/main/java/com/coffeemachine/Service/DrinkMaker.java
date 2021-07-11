/**
 * 
 */
package com.coffeemachine.Service;

import com.coffeemachine.Model.Drink;
import com.coffeemachine.Repository.Maker;

/**
 * @author shivanshu.gua
 *
 */
public class DrinkMaker implements Maker{

	public void makeDrink(Drink drink) {
		// Guessing we have sufficient quantity of stock.
		
		System.out.println("Creating Drink for you... Wait for a minute. Happy drink "+ drink.getDrinkName());
		
		for(String ingredientName:drink.getSolution().keySet())
		{
			// operation of reducing ingredient from the stock as per the drink standard.
		}
		
		
	}

	@Override
	public void drinkMaker(Drink drink) {
		// TODO Auto-generated method stub
		
	}
	

	
}

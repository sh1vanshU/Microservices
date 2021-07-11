package com.coffeemachine.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeemachine.Model.Drink;
import com.coffeemachine.Repository.Maker;

@RestController
@RequestMapping("drinks")
public class DrinkController {

		private Maker make;
		
		public DrinkController(Maker make) {
			this.make=make;
		}
		
		@PostMapping
		public String makingDrink(@RequestBody Drink drink)
		{
			this.make.drinkMaker(drink);
			return "Your drink is ready";
		}
		
		
}

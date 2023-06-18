package DecoratorPattern.PizzaCost.ToppingDecorator;

import DecoratorPattern.PizzaCost.BasePizza.BasePizza;

public class Mushroom extends ToppingDecorator {

	BasePizza basePizza;
	int extraCostForMushroom = 20;
	
	public Mushroom(BasePizza basePizza) {
		this.basePizza = basePizza;
	}
	
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return this.basePizza.cost() + extraCostForMushroom;
	}

}

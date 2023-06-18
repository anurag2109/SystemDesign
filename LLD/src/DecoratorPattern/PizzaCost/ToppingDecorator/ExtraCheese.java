package DecoratorPattern.PizzaCost.ToppingDecorator;

import DecoratorPattern.PizzaCost.BasePizza.BasePizza;

public class ExtraCheese extends ToppingDecorator {
	
	BasePizza basePizza;
	int extraCostForCheese = 10;
	
	public ExtraCheese(BasePizza basePizza) {
		this.basePizza = basePizza;
	}
	
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return this.basePizza.cost() + extraCostForCheese;
	}

}

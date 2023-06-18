package DecoratorPattern.PizzaCost.BasePizza;

public class FarmHouse extends BasePizza {
	
	int farmHousePizzaCost = 200;
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return farmHousePizzaCost;
	}

}

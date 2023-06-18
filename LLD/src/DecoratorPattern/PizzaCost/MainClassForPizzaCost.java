package DecoratorPattern.PizzaCost;

import DecoratorPattern.PizzaCost.BasePizza.BasePizza;
import DecoratorPattern.PizzaCost.BasePizza.Margherita;
import DecoratorPattern.PizzaCost.ToppingDecorator.ExtraCheese;
import DecoratorPattern.PizzaCost.ToppingDecorator.Mushroom;

public class MainClassForPizzaCost {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasePizza basePizza = new Mushroom(new Mushroom(new ExtraCheese(new Margherita())));
		System.out.println(basePizza.cost());
	}
}

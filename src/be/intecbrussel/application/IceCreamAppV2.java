package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum.MagnumType;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.NoMoreIceCreamException;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;

public class IceCreamAppV2 {

public static void main(String[] args) throws NoMoreIceCreamException {
		
	PriceList list1 = new PriceList(1.5,2,3);
	Stock stock = new Stock(1, 30, 30, 30);
	IceCreamCar iceCreamCar = new IceCreamCar(list1,stock);
	Eatable[] Eatable = new Eatable[4];
	
	Cone.Flavor[] flavors1 = new Cone.Flavor[]{Cone.Flavor.STRAWBERRIE, Cone.Flavor.PISTACHE};
	
	Eatable[0] = iceCreamCar.orderCone(flavors1);
	Eatable[1] = iceCreamCar.orderIceRocket();	
	Eatable[2] = iceCreamCar.orderIceRocket();	
	Eatable[3] = iceCreamCar.orderMagnum(MagnumType.ALPINENUTS);  
	
	for (Eatable icecream : Eatable) {
		icecream.eat(); 
	}
	
	System.out.println("profit: " +iceCreamCar.getProfit());  
	
}
}
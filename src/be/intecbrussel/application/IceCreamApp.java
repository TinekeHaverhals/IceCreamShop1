package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum.MagnumType;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {
	public static void main(String[] args) {
		
		PriceList list1 = new PriceList(1.5,2,3);
		IceCreamSalon IceCreamSalon = new IceCreamSalon(list1);
		Eatable[] eatable = new Eatable[4];
		
		Cone.Flavor[] flavors1 = new Cone.Flavor[]{Cone.Flavor.STRAWBERRIE, Cone.Flavor.PISTACHE};
		Cone.Flavor[] flavors2 = new Cone.Flavor[]{Cone.Flavor.CHOCOLATE, Cone.Flavor.VANILLA};
				
		eatable[0] = IceCreamSalon.orderCone(flavors1);
		eatable[1] = IceCreamSalon.orderCone(flavors2);
		eatable[2] = IceCreamSalon.orderIceRocket();
		eatable[3] = IceCreamSalon.orderMagnum(MagnumType.ALPINENUTS);
		
		for (Eatable eatableIce : eatable) {
			eatableIce.eat(); 
		}

		System.out.println("profit: " +IceCreamSalon.getProfit()); 
	}
}
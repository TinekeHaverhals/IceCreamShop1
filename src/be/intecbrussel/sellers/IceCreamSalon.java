package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Cone.Flavor;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.eatables.Magnum.MagnumType;

public class IceCreamSalon implements IceCreamSeller{
	
	private  PriceList priceList;
	private double totalProfit;

	public IceCreamSalon(PriceList priceList) {
		this.priceList = priceList;
	}
	
	@Override
	public double getProfit() {
		return this.totalProfit;
	}

	@Override
	public Cone orderCone(Flavor[] balls) {
		for(int i = 0; i < balls.length;i++) {
			totalProfit += priceList.getBallPrice();
		}
		return new Cone(balls);
	}
	
	@Override
	public IceRocket orderIceRocket() {
		totalProfit += priceList.getRocketPrice();
		return new IceRocket();
	}
	
	@Override
	public Magnum orderMagnum(MagnumType type) {
		totalProfit += priceList.getMagnumPrice(type);
		return new Magnum(type);
	}

	@Override
	public String toString() {
		return ( "totalProfit : " + totalProfit );
		
	}
}
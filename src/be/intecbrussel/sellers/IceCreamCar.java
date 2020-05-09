package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Cone.Flavor;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.eatables.Magnum.MagnumType;

public class IceCreamCar implements IceCreamSeller {
	
	private PriceList priceList;
	private Stock stock;
	private double profit;

	public IceCreamCar(PriceList priceList) {
        this.priceList = priceList;
    }

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }
    
	@Override
	public Cone orderCone(Flavor[] balls) throws NoMoreIceCreamException {
			return this.prepareCone(balls);
	}

	private Cone prepareCone(Flavor[] balls) throws NoMoreIceCreamException {
			if(stock.getCones() > 0) {
				if(stock.getBalls() > balls.length) {
					profit += priceList.getBallPrice() * balls.length;
					stock.setCones(stock.getCones() - 1 );
					stock.setBalls(stock.getBalls() - balls.length);
			return new Cone(balls);
			}else {
				throw new NoMoreIceCreamException("this is sold out ");
			}	
		}else {
			throw new NoMoreIceCreamException("the cones are sold out");
		}
	}
	
	@Override
	public IceRocket orderIceRocket() throws NoMoreIceCreamException {
		return this.prepareRocket();
	}

	private IceRocket prepareRocket() throws NoMoreIceCreamException {
		if (stock.getIceRockets() > 0) {
			profit += priceList.getRocketPrice();
			stock.setIceRockets(stock.getIceRockets() -1 );
			return new IceRocket();
		} else {
			throw new NoMoreIceCreamException("the iceRocket is sold out");
		}
	}

	@Override
	public Magnum orderMagnum(MagnumType type) throws NoMoreIceCreamException {
		return this.prepareMagnum(type);
	}

	private Magnum prepareMagnum(MagnumType type) throws NoMoreIceCreamException {
		if (stock.getMagni() > 0) {
			 profit += priceList.getMagnumPrice(type);
			 stock.setMagni(stock.getMagni() -1 );
			return new Magnum(type);
			
		} else {
			throw new NoMoreIceCreamException("the magnum is sold out");
		}
	}

	@Override
	public double getProfit() {
		return this.profit;
	}
}
package be.intecbrussel.eatables;

import java.util.Arrays;

public class Cone implements Eatable {
	
	private Flavor[] balls;
	
	public Cone () {
		
	}
	
	public Cone (Flavor [] balls) {
		this.balls = balls;
	}

	@Override
	public void eat() {
		System.out.println("I'm eating a cone with"+ Arrays.toString(balls));		
	}
	
	public enum Flavor {
		STRAWBERRIE, BANANA, CHOCOLATE, VANILLA, LEMON, STRACIATELLA, MOKKA, PISTACHE;
	}
}
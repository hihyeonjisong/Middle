package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T07Practice {
	
	public static void displayCartItemIn(Cart2<?> cart) {
		System.out.println("= 장바구니 항목리스트(모든 항목) =");
		for (Object obj : cart.getList()) {
			System.out.println(obj);
		}
		System.out.println("-------------------");
	}
	
	public static void displayCartItemIn2(Cart2<? extends Drink2> cart) {
		System.out.println("= 장바구니 항목리스트(음료류 항목) =");
		for (Object obj : cart.getList()) {
			System.out.println(obj);
		}
		System.out.println("-------------------");
	}
	
	public static void displayCartItemIn3(Cart2<? super Meat2> cart) {
		System.out.println("= 장바구니 항목리스트(고기류 및 상위 항목) =");
		for (Object obj : cart.getList()) {
			System.out.println(obj);
		}
		System.out.println("-------------------");
	}
	
	
	
	public static void main(String[] args) {
		
		Cart2<Food2> foodCart = new Cart2();
		foodCart.addItem(new Meat2("돼지고기", 5000));
		foodCart.addItem(new Meat2("소고기", 100000));
		foodCart.addItem(new Juice2("오렌지주스", 1000));
		foodCart.addItem(new Coffee2("아메리카노", 2000));
		
		Cart2<Meat2> meatCart = new Cart2();
		meatCart.addItem(new Meat2("돼지고기", 5000));
		meatCart.addItem(new Meat2("소고기", 100000));
		//meatCart.addItem(new Juice2("오렌지주스", 1000));
		//meatCart.addItem(new Coffee2("아메리카노", 2000));
		
		Cart2<Drink2> drinkCart = new Cart2();
		//drinkCart.addItem(new Meat2("돼지고기", 5000));
		//drinkCart.addItem(new Meat2("소고기", 100000));
		drinkCart.addItem(new Juice2("오렌지주스", 1000));
		drinkCart.addItem(new Coffee2("아메리카노", 2000));
		
		displayCartItemIn(foodCart);
		displayCartItemIn(meatCart);
		displayCartItemIn(drinkCart);
		
		//displayCartItemIn2(foodCart);
		//displayCartItemIn2(meatCart);
		displayCartItemIn2(drinkCart);
		
		displayCartItemIn3(foodCart);
		displayCartItemIn3(meatCart);
		//displayCartItemIn3(drinkCart);
		
		
	}
}

class Food2 {
	private String name;
	private int price;

	public Food2(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return name + "(" + price + "원)";
	}
}

class Meat2 extends Food2 {

	public Meat2(String name, int price) {
		super(name, price);
	}	
}

class Drink2 extends Food2 {

	public Drink2(String name, int price) {
		super(name, price);
	}
}

class Juice2 extends Drink2 {

	public Juice2(String name, int price) {
		super(name, price);
	}
}

class Coffee2 extends Drink2 {

	public Coffee2(String name, int price) {
		super(name, price);
	}
}

class Cart2<T> {
	private List<T> list;
	
	public Cart2() {
		list = new ArrayList<T>();
	}

	public List<T> getList() {
		return list;
	}

	public void addItem(T item) {
		list.add(item);
	}
}
package com.fatsecret.platform.services;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fatsecret.platform.model.Food;

public class FoodServiceTest {
	private static FatsecretService service;
	
	@BeforeClass
	public static void setUp() {
        String key = "";
        String secret = "";

        service = new FatsecretService(key, secret);
	}
	
	@Test
	public void testGetFood() {
		Food food = service.getFood(285243L);
		assertEquals("Penne", food.getName());
		assertEquals(4, food.getServings().size());
		assertEquals("Generic", food.getType());
	}
	@Test
	public void testFindFoodIdForBarcode() {
		Long foodId = service.findFoodIdForBarcode("077885882007");
		assertEquals(752679L,foodId.longValue());
	}

	@Test
	public void testGetFoodTypeGeneric() {
		Food food = service.getFood(285243L);
		assertEquals("Generic", food.getType());
	}

	@Test
	public void testGetFoodTypeBrand() {
		Food food = service.getFood(1844450L);
		assertEquals("Brand", food.getType());
	}
}
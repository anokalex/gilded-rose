package fr.esiea;

import org.junit.Test;
import org.junit.Assert;

public class TestItem{

	@Test
	public void testGetQuality(){
		Item item = new Item("apple", 2, 10);
		Assert.assertEquals(10, item.getQuality());
	}
	
    @Test
	public void testGetSellIn(){
		Item item = new Item("apple", 2, 10);
		Assert.assertEquals(2, item.getSellIn());
	}

    @Test
	public void testGetName(){
		Item item = new Item("apple", 2, 10);
		Assert.assertEquals("apple", item.getName());
	}

     @Test
	public void testSetQuality(){
		Item item = new Item("apple", 2, 10);
        item.setQuality(0);
		Assert.assertEquals(0, item.getQuality());
	}

	@Test
	public void testSetSellIn(){
		Item item = new Item("apple", 2, 10);
		item.setSellIn(0);
		Assert.assertEquals(0, item.getSellIn());
	}
}

package fr.esiea;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class GildedRoseTest{

	@Test
	public void non_specific_object_quality_and_price_decrease_by_one(){
		Item item = new Item("apple", 2, 10);
		Item[] items = new Item[] (item);
		
		GildedRose tavern = new GildedRose(items);
		
		tavern.updateQuality();
		
		SoftAssertions softly = new SoftAssertions();
		softly.asertThat(item.quality)
		.as("Apple quality")
		.isEqualTo(9);
		
		softly.assertThat(item.sellin)
		.as("Apple price)
		.isEqualTo(1);
		
		softly.assertAll();
	}
}

package com.gildedrose;

public class Brie extends QualityItem {
	
	public Brie(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void updateSellinAndQuality() {
		if (isQualityUnder50()) { // quality is less than 50 (can never be more than 50)
		     increaseItemQualityBy(1); // increment quality
		 }
		 
		 decreaseSellinBy(1); // decrement sellIn
		 
		 if (hasSellinDatePassed()) {
			 if (isQualityUnder50()) { // quality is never more than 50
		         increaseItemQualityBy(1); // increment quality
		     }
		 }
	}

}

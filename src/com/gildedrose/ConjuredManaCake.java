package com.gildedrose;

public class ConjuredManaCake extends QualityItem {
	
	public ConjuredManaCake(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void updateSellinAndQuality() {	
		if (isQualityPositive()) {
			decreaseItemQualityBy(2); // "Conjured" items degrade in Quality twice as fast as normal items
		}
		
		decreaseSellinBy(1); // decrement sellIn
		
		if (hasSellinDatePassed()) {
			if (isQualityPositive()) { // quality is still non-negative
				decreaseItemQualityBy(4); // decrement this item's quality ("Conjured" items degrade in Quality twice as fast as normal items)
			}
		}
	}

}

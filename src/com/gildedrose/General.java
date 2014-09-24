package com.gildedrose;

public class General extends QualityItem {
	
	public General(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void updateSellinAndQuality() {
		if (isQualityPositive()) {
			decreaseItemQualityBy(1);
		}
		
		decreaseSellinBy(1); // decrement sellIn
		
		if (hasSellinDatePassed()) {
			if (isQualityPositive()) { // quality is still non-negative
				decreaseItemQualityBy(2); // decrement this item's quality - Once the sell by date has passed, Quality degrades twice as fast
			}
		}
	}

}

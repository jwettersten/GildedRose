package com.gildedrose;

public class General extends QualityItem {
	
	public General(Item item) {
		super(item.name, item.sellIn, item.quality);
	}

	public void updateSellinAndQuality() {
		if (isQualityPositive()) {
			decreaseItemQuality();
		}
		
		decreaseSellin(); // decrement sellIn
		
		if (hasSellinDatePassed()) {
			if (isQualityPositive()) { // quality is still non-negative
				decreaseItemQuality(); // decrement this item's quality
			}
		}
	}

}

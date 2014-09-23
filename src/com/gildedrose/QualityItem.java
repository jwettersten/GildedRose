package com.gildedrose;

public abstract class QualityItem extends Item {

	public QualityItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public abstract void updateSellinAndQuality();
	
	public int decreaseQualityTwice() {
		this.quality = this.quality - this.quality;
		
		if (this.quality < 0) {
			this.quality = 0;
		} 
		
		return this.quality;
	}

	public boolean hasSellinDatePassed() {
		return this.sellIn < 0;
	}

	public int decreaseSellin() {
		return this.sellIn = this.sellIn - 1;
	}

	public boolean isSellinWithin5() {
		return this.sellIn < 6;
	}

	public boolean isSellinWithin10() {
		return this.sellIn < 11;
	}

	public int increaseItemQuality() {
		return this.quality = this.quality + 1;
	}

	public int decreaseItemQuality() {
		return this.quality = this.quality - 1;
	}

	public boolean isQualityUnder50() {
		return this.quality < 50;
	}
	
	public boolean isQualityPositive() {
		return this.quality > 0;
	}
	
}

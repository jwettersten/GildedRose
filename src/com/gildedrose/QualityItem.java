package com.gildedrose;

public abstract class QualityItem extends Item {

	public QualityItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public abstract void updateSellinAndQuality();
	
	protected int decreaseItemQualityBy(int amount) {
		this.quality = this.quality - amount;
		
		if (this.quality < 0) {
			this.quality = 0;
		} 
		
		return this.quality;
	}

	protected boolean hasSellinDatePassed() {
		return this.sellIn < 0;
	}

	protected int decreaseSellinBy(int amount) {
		return this.sellIn = this.sellIn - amount;
	}

	protected boolean isSellinWithin(int amount) {
		return this.sellIn <= amount;
	}

	protected int increaseItemQualityBy(int amount) {
		return this.quality = this.quality + amount;
	}

	protected boolean isQualityUnder50() {
		return this.quality < 50;
	}
	
	protected boolean isQualityPositive() {
		return this.quality > 0;
	}
	
}

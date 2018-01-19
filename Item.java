package fr.esiea;

public class Item {

    private String name;
    private int sellIn;
    private int quality;

    public String getName(){
        return this.name;
    }

    public int getSellIn(){
        return this.sellIn;
    }

    public int getQuality(){
        return this.quality;
    }

    public void incSellIn(){
        this.sellIn++;
    }

    public void incQuality(){
        this.quality++;
    }

    public void decSellIn(){
        this.sellIn--;
    }

    public void decQuality(){
        this.quality--;
    }

    public void setQuality(int quality){
        this.quality = quality;
    }

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

}
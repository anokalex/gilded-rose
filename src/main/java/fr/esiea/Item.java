package fr.esiea;

public class Item {

    private String name;
    private int sellIn;
    private int quality;
    private Integer id;

    public String getName(){
        return this.name;
    }

    public int getSellIn(){
        return this.sellIn;
    }

    public void setSellIn(int sellIn){
        this.sellIn = sellIn;
    }

    public int getQuality(){
        return this.quality;
    }

    public void setQuality(int quality){
        this.quality = quality;
    }

    public void setId(Integer id) {
        this.id = id;
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
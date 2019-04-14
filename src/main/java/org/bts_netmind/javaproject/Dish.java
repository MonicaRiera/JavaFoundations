package org.bts_netmind.javaproject;

public abstract class Dish 
{
	public Dish() { }

    public Dish(String dishName, Type type, boolean glutenFree, boolean vegetarian, boolean halalMeat, boolean seafoodFree, Object extras) {
        this.dishName = dishName;
        this.type = type;
        this.glutenFree = glutenFree;
        this.vegetarian = vegetarian;
        this.halalMeat = halalMeat;
        this.seafoodFree = seafoodFree;
        this.extras = extras;
    }

    public enum Type {
	    ST, MC, DS
    }
	
	protected String dishName;
	protected Type type;
	protected boolean glutenFree;
	protected boolean vegetarian;
	protected boolean halalMeat;
	protected boolean seafoodFree;
	protected Object extras;

	public String getDishName() { return dishName; }
	public void setDishName(String dName) { this.dishName = dName; }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isHalalMeat() {
        return halalMeat;
    }

    public void setHalalMeat(boolean halalMeat) {
        this.halalMeat = halalMeat;
    }

    public boolean isSeafoodFree() {
        return seafoodFree;
    }

    public void setSeafoodFree(boolean seafoodFree) {
        this.seafoodFree = seafoodFree;
    }

    public Object getExtras() {
        return extras;
    }

    public void setExtras(Object extras) {
        this.extras = extras;
    }
}

package org.bts_netmind.javaproject;

public abstract class Dish {

    protected String dishName;
    protected enum Type {st, mc, ds}
    protected Type type;
    protected boolean glutenFree;
    protected boolean vegetarian;
    protected boolean halalMeat;
    protected boolean seafoodFree;
    protected String extras;

	public Dish() { }

    public Dish(String dishName, String type, boolean glutenFree, boolean vegetarian, boolean halalMeat, boolean seafoodFree, String extras) {
        this.dishName = dishName;
        this.glutenFree = glutenFree;
        this.vegetarian = vegetarian;
        this.halalMeat = halalMeat;
        this.seafoodFree = seafoodFree;
        this.extras = extras;
        this.type = Type.valueOf(type);
    }

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

    public void setExtras(String extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
	    String result = this.dishName + ", a ";
	    if (isGlutenFree()) {
	        result += "gluten free dish, ";
        }
        if (isVegetarian()) {
	        result += "vegetarian dish, ";
        }
        if (isHalalMeat()) {
            result += "halal meat dish, ";
        }
        if (isSeafoodFree()) {
            result += "seafood free dish, ";
        }

        if (this.type == Type.st){
            result += "starter with " + extras + " needed";
        } else if (this.type == Type.mc) {
            String[] arr = extras.split("-");
            result += "main course made of " + arr[0] + " and preferred drink " + arr[1];
        } else if (this.type == Type.ds) {
            result += "dessert of " + extras + " calories";
        }

        return result;
    }
}

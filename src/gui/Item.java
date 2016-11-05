package gui;

public class Item {
	private String name = "";
	private int amount = 0;
	
	public Item(String name, int amount){
		this.name = convertName(name).toUpperCase();
		this.amount = amount;
	}
	
	public String convertName(String name){
		String result = name.substring(0, 1).toUpperCase(); // adds the first letter to item name.
		for(int i = 1; i < name.length(); i++){ 			// adds the remaining letters to item name.
			if((int)(name.charAt(i)) < 91)					// if the letter is an upper case using its ASCII code,
				result += " ";								// add a space if it is an upper case letter.
				result += name.charAt(i);					// adds the letter.
		}
		return result;
	}
	
	public void add(int amount){
		this.amount += amount;
	}
	
	public void remove(int amount){
		this.amount -= amount;
	}
	
	public boolean equals(Item item2){
		boolean equals = false;
		if(name.equals(item2.getName()))
			equals = true;
		return equals;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAmount(){
		return amount;
	}
	
	@Override
	public String toString(){
		String result = name + " x " + amount;
		return result;
	}
}

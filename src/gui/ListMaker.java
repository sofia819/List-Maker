package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListMaker {
	ArrayList<Item> list = new ArrayList<>();
	
	public ListMaker(){
	}
	
	public ListMaker(Item item){
		addItem(item);
	}
	
	public int addItem(Item item){
		int resultIndex = contains(item);
		int addIndex = -1;
		if(resultIndex < 0){
			list.add(item);
			addIndex = list.size() - 1;
		}
		else{
			list.get(resultIndex).add(item.getAmount());
			addIndex = resultIndex;
		}
		return addIndex;
	}
	
	public int contains(Item item){
		int index = -1;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getName().equals(item.getName()))
				index = i;
		}
		return index;
	}
	
	public Item get(int i){
		return list.get(i);
	}
	
	public int getSize(){
		return list.size();
	}
	
	public void writeFile() throws IOException{
		String file = "output.txt";
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		String result = toString();
		out.write(result);
		out.close();
	}
	
	@Override
	public String toString(){
		String result = "Total number of items : " + getSize() + "\n";
		for(int i = 0; i < getSize(); i++){
			result += i + 1 + ") " + list.get(i);
			result += "\n";
		}
		return result;
	}
}

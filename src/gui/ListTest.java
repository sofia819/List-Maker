package gui;

import java.io.*;
import java.util.*;

public class ListTest {
	private static Scanner in = new Scanner(System.in);
	private static ListMaker list = new ListMaker();
	
	public static void main(String[] args) throws IOException{
		
		readInput();
		list.writeFile();
		System.out.println(list);
	}
	
	public static void readInput(){
		while(true){
			System.out.println("Please enter the item name (oneWord) and amount (-1 to stop): ");
			String name = in.next();
			if(name.equals("-1"))
				break;
			int amount = in.nextInt();
			System.out.println(list.get(list.addItem(new Item(name, amount) ) ) );
		}
	}
	
	public static void readFile(String fileName) throws FileNotFoundException{
		Scanner fin = new Scanner (new File(fileName));
		while(fin.hasNextLine()){
			String[] arr = fin.nextLine().split(" ");
			String name = "";
				if(arr.length > 1){
					for(int i = 0; i < arr.length - 1; i++){
						name += arr[i];
					}
				int amount = Integer.parseInt(arr[arr.length - 1]);
				list.get(list.addItem(new Item(name, amount) ) );
			}
		}
	}
}

package dsAlgo;

import java.util.HashMap;
import java.util.Map;

public class Hashing_Functions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashingFunctions str = new HashingFunctions(6);
		System.out.println(str.modASCII("tumbin"));

		Hash_Map hm = new Hash_Map();
		hm.create("Animesh", 0);
		hm.create("Lohar", 1);
		hm.create("Animesh", 2);
		hm.create("Alu", 2);

		System.out.println(hm.map.entrySet());

		hm.printAll();

		hm.printMap();
		hm.size();
		hm.getMap("Lohar");
		hm.map.remove("Animesh", 2);
		hm.remove("Lohar");

		hm.printMap();

	}

}

class HashingFunctions {

	int cellNum = 0;

	// Constructor
	public HashingFunctions(int cellNum) {
		this.cellNum = cellNum;
	}

	public int modASCII(String word) {
		int total = 0;
		for (int i = 0; i < word.length(); i++) {
			total += word.charAt(i);
		}
		System.out.println(total);
		return (total % cellNum);
	}

	public void directChaining(String word) {

	}

}

class Hash_Map {

//	@SuppressWarnings("unchecked")
//	Syntax HashMap : Map<key_type , value_type> object_name = new HashMap<>() ;
	HashMap<String, Integer> hmap = new HashMap<>();
	Map<String, Integer> map = new HashMap<>();

	public void create(String key_str, int value) {
		this.map.put(key_str, value);
	}

	// get value of a key
	public void getMap(String str) {
		if (this.map.containsKey(str)) {
			System.out.println(this.map.get(str));
		}
	}

	// size of a hashmap
	public void size() {
		System.out.println(this.map.size());
	}

	// print the hashmap
	public void printMap() {
		System.out.println(this.map);
	}

	// remove the hashmap
	public void remove(String str) {
		if (this.map.containsKey(str)) {
			System.out.println(this.map.remove(str));
		}
	}

	public void printAll() {
		for (String str : this.map.keySet()) {
			System.out.println("KEY : " + str + " , VALUE : " + this.map.get(str));
		}
	}

}

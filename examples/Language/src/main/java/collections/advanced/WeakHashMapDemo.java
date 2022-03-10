package collections.advanced;

import java.util.*;

public class WeakHashMapDemo {
	public static void main(String[] args) {
		
		//Manually create string objects because we 
		// want to force some to be garbage collected
		String key1 = new String("tarantino1");
		String key2 = new String("tarantino2");
		String key3 = new String("tarantino3");
		String key4 = new String("lee1");
		String key5 = new String("lee2");
		String key6 = new String("lee3");
		String key7 = new String("lucas1");
		String key8 = new String("lucas2");
		String key9 = new String("lucas3");
		
		
		Map<String,Movie> map = new WeakHashMap<String,Movie>();
		map.put(key1,new Movie("Quentin Tarantino","Resevoir Dogs"));
		map.put(key2,new Movie("Quentin Tarantino","Pulp Fiction"));
		map.put(key3,new Movie("Quentin Tarantino","Kill Bill"));
		map.put(key4,new Movie("Ang Lee","Mission Impossible"));
		map.put(key5,new Movie("Ang Lee","The Hulk"));
		map.put(key6,new Movie("Ang Lee","Sense And Sensability"));
		map.put(key7,new Movie("George Lucas","Star Wars"));
		map.put(key8,new Movie("George Lucas","Empire Strikes Back"));
		map.put(key9,new Movie("George Lucas","Return Of The Jedi"));
		
		printContents(map);
	
		key1 = key4 = key7 = null;
		//Will probably GC strings and therefore remove entries from table
		System.gc();
		printContents(map);
		
		key2 = key5 = key8 = null;
		//Will probably GC strings and therefore remove entries from table
		System.gc();
		printContents(map);
		
		key3 = key6 = key9 = null;
		//Will probably GC strings and therefore remove entries from table
		System.gc();
		printContents(map);
		
	}
	private static void printContents(Map<String,Movie> map) {
		Set<Map.Entry<String, Movie>> keys = map.entrySet();
		if(keys.isEmpty()) {
			System.out.println("\nMap is empty!");
		} else {
			System.out.println("\nMap Contents are:");
			Iterator<Map.Entry<String, Movie>> iter = keys.iterator();
			while(iter.hasNext()) {
				Map.Entry<String, Movie> entry = iter.next();
				System.out.println("\t[" + entry.getKey() + "] " + entry.getValue());
			}
		}
	}
	private static class Movie {
		public Movie(String director,String title) {
			this.title = title;
			this.director = director;
		}
		public String toString() {
			return title + " directed by " + director;
		}
		private String title;
		private String director;
	}
}

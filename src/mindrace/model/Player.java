package mindRace;

import java.util.Locale.Category;
import java.util.Set;
/**
 * 
 * @author francisco
 *
 */

public class Player{
	private String name;
	private Set<Category> tokens;
	private Tile tile;
	public Player(String name){
		this.name = name;
		this.tokens = new HashSet<Category>();
		this.tile = new Tile();
	}
	public String getName(){
		return name;
	}
	public addToken(Category category){
		if(tokens.contains(category)){
			throw new IllegalArgumentException("Has that token");
		}
		tokens.add(category);
	}
	public void move(int quantity){
		if(quantity<0){
			throw new IllegalArgumentException("quantity must be non negative");
		}
		for (int i=quantity; i>0;i--){
			tile=tile.next;
		}
	}
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(obj.toString());
	}
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

}
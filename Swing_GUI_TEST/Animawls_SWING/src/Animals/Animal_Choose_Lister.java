package Animals;
import java.util.HashMap;

public class Animal_Choose_Lister {
	
	private HashMap <String,Animal> TmpList;
	
	public HashMap <String,Animal> Choose_Lister_Passer() {
		//must be updated when new animawls are to be added
		
		TmpList = new HashMap<String,Animal>();
		TmpList.put("Bear", new Bear("Bear"));
		TmpList.put("Bird", new Bird("Bird"));
		TmpList.put("Bat", new Bat("Bat"));
		TmpList.put("Bull", new Bull("Bird"));
		TmpList.put("Dog", new Dog("Bird"));
		TmpList.put("Elephant", new Elephant("Bird"));
		TmpList.put("Fighting Frog", new FightingFrog("Bird"));
		TmpList.put("Snake", new Snake("Snake"));
		return TmpList;
	}
	
}

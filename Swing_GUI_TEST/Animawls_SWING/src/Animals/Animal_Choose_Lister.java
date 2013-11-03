package Animals;
import java.util.HashMap;

public class Animal_Choose_Lister {
	
	private HashMap <String,Animal> TmpList;
	
	public HashMap <String,Animal> Choose_Lister_Passer() {
		//must be updated when new animawls are to be added
		
		TmpList = new HashMap<String,Animal>();
		TmpList.put("Bear", new Bear("Bear"));
		TmpList.put("Bird", new Bird("Bird"));
		return TmpList;
	}
	
}

package pakke;

import java.util.ArrayList;
import java.util.List;

public class VareListe {

	private List<Vare> varer = new ArrayList<>();

	public synchronized void addItem(Vare v) {
		if(!v.toString().isEmpty())
		varer.add(v);

	}

	public List<Vare> getItems() {
		return varer;
	}
	
	public int getId(Vare v) {
		return varer.indexOf(v);
	}

	public synchronized void slettVare(int index) {
		varer.remove(index);
	}

}

package bunco;

import java.util.ArrayList;
import java.util.Iterator;

public class HistoriqueDeTourBunco {
	private ArrayList<AFaceBunco> faces = new ArrayList<AFaceBunco>();
	
	public void add(AFaceBunco face){
		this.faces.add(face);
	}
	
	public Iterator<AFaceBunco> getFaces(){
		return this.faces.iterator();
	}
	
	public int getNombreDeFaces(){
		return this.faces.size();
	}
}

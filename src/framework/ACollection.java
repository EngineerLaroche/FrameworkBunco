package framework;

import java.util.Iterator;

public abstract class ACollection<T extends Comparable<T>> {
	protected T[] valeurs;
	protected int longueur;
	
	private int position = 0;
	
	public void ajouter(T valeur){
		if (this.position < this.longueur){
			this.valeurs[position] = valeur;
			this.position++;
		}
	}
	
	public T get(int index) {
		return valeurs[index];
	}
	
	public int getLongueur(){
		return this.longueur;
	}
	
	public Iterator<T> creerIterateur(){
		return new Iterator<T>(){
			private int itIndice = 0;
			
			@Override 
			public boolean hasNext(){
				return longueur > itIndice;
			}
			@Override
			public T next(){
				return valeurs[itIndice++];
			}
		};
	}
	
	public void sort(){
		
	}
	
	public ACollection<T> copy(){
		return null;
	}
}

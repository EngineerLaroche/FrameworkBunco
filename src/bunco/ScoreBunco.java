package bunco;

import framework.IScore;

public class ScoreBunco implements IScore {
	private int valeur;
	private String type;
	private String action;
	
	public ScoreBunco(String action, String type, int valeur){
		this.valeur = valeur;
		this.type = type;
	}
	
	public String getAction(){
		return this.action;
	}
	
	public String getType(){
		return this.type;
	}

	@Override
	public int getValeur() {
		return this.valeur;
	}

	@Override
	public int compareTo(IScore o) {
		return this.getValeur() - o.getValeur();
	}
	
	
}

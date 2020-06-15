package bunco;

import framework.CollectionTours;
import framework.IFabriqueTours;

public class FabriqueToursBunco implements IFabriqueTours {
	private final int NOMBRE_DE_TOURS = 6;
	
	@Override
	public CollectionTours creer() {
		CollectionTours tours = new CollectionTours(this.NOMBRE_DE_TOURS);
		for (int i = 1; i <= NOMBRE_DE_TOURS; i++){
			TourBunco tour = new TourBunco(i);
			tours.ajouter(tour);
		}
		return tours;
	}
}

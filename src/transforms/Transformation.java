package transforms;

import javafx.collections.ObservableList;
import javafx.scene.transform.Transform;

/**
 * Interface qui permet d'ajouter des méthodes aux class javaFX hérités de Transform
 * @author Mickael
 */
public interface Transformation {
	
	
	default String showMatrix() {
		Transform t = (Transform)this;
		return ("|" + (int)(100*t.getMxx())/100.0 + " ; " + (int)(100*t.getMxy())/100.0 + " ; " + (int)(100*t.getMxz())/100.0 + "|\n"
				+ "|" + (int)(100*t.getMyx())/100.0 + " ; " + (int)(100*t.getMyy())/100.0 + " ; " + (int)(100*t.getMyz())/100.0 + "|\n"
				+ "|" + (int)(100*t.getMzx())/100.0 + " ; " + (int)(100*t.getMzy())/100.0 + " ; " + (int)(100*t.getMzz())/100.0 + "|\n"
				);
	}

	default String rowTransform() {
		//toDo
		return null;

	}

	default String rowMaison (Maison m, int l){
		ObservableList<Double> list = m.getPoints();
		switch(l) {
		case 1: return list.get(0)+" ; "+list.get(2)+" ; "+list.get(4)+" ; "+list.get(6)+" ; "+list.get(8)+" ; "+list.get(10)+" ; "+list.get(12)+" ; "+list.get(14)+" ; "+list.get(16);
		default: return list.get(1)+" ; "+list.get(3)+" ; "+list.get(5)+" ; "+list.get(7)+" ; "+list.get(9)+" ; "+list.get(11)+" ; "+list.get(13)+" ; "+list.get(15)+" ; "+list.get(17);
		}
	}
}

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
		return ("|" + (int)(10*t.getMxx())/10.0 + " ; " + (int)(10*t.getMxy())/10.0 + " ; " + (int)(10*t.getMxz())/10.0 + " ; " + (int)(10*t.getTx())/10.0 + "|\n"
				+ "|" + (int)(10*t.getMyx())/10.0 + " ; " + (int)(10*t.getMyy())/10.0 + " ; " + (int)(10*t.getMyz())/10.0 + " ; " + (int)(10*t.getTy())/10.0 + "|\n"
				+ "|" + (int)(10*t.getMzx())/10.0 + " ; " + (int)(10*t.getMzy())/10.0 + " ; " + (int)(10*t.getMzz())/10.0 + " ; " + (int)(10*t.getTz())/10.0 + "|\n"
				+ "|" + 0.0 + " ; "+ 0.0 + " ; " + 0.0 + " ; " + 1.0 + "|");
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

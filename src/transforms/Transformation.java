package transforms;

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
}

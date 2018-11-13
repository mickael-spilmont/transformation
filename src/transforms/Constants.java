package transforms;

import javafx.geometry.Point2D;

public class Constants {
    static final double ZERO_X = 200.0; // Abcisse de l'origine
    static final double MIN_X = 0.0;    // Bord gauche
    static final double MAX_X = 400.0;  // Bord Droit
    static final double INC_X = 30.0;   // Pas du quadrillage

    static final double ZERO_Y = 200.0; // Ordonnée de l'origine
    static final double MIN_Y = 0.0;    // Bord haut
    static final double MAX_Y = 400.0;  // Bord bas
    static final double INC_Y = 30.0;   // Pas du quadrillage

    static final Point2D ORIGINE = new Point2D(ZERO_X, ZERO_Y);

    static double math2infoX(double xmath) {
        return ZERO_X - INC_X * xmath;
    }
    static double math2infoY(double ymath) {
        return ZERO_Y - INC_Y * ymath;
    }
}

package transforms;

import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import static transforms.Constants.*;

public class Controller {

    @FXML
    public Canvas canvas;

    @FXML
    public Pane pane;

    //--------------- Translation 1

    private ArrayList<Transform> transforms = new ArrayList<>();
    private ArrayList<Maison> maisons = new ArrayList<>();

    private void reset() {
        transforms.clear();
        Grille grille = new Grille();
//        Ajourer des transformation pour afficher la grille en mode maths
        pane.getChildren().add(grille);
    }

    private Color color(double value) {
        if (value == 1.0) return Color.BLUE;
        return new Color(value, value, value, 1.0);
    }

    private Color color(int idx) {
        if (idx == 0) return Color.BLUE;
        if (idx == transforms.size()) return Color.BLACK;
        double value = 1.0 - (double) idx / transforms.size();
        return color(value);
    }

    private void update() {
        reset();
//        if (cbt1.selectedProperty().getValue()) transforms.add(t1);
//        if (cbr.selectedProperty().getValue()) transforms.add(rot);
//        if (cbt2.selectedProperty().getValue()) transforms.add(t2);
        
//        Transformations
        transforms.add(new Translate(10, 10));
        transforms.add(new Rotate(10.0));
//        test affichage matrice
        System.out.println(toStringMatrice(new Translate(10 ,10)));
//        Fin transformations
        
        show();
    }

    private void drawClear() {
        for (Maison m : maisons) {
            pane.getChildren().remove(m);
        }
        maisons.clear();
    }

    private void drawAdd(Maison m) {
        maisons.add(m);
//      Ajouter les transformation pour afficher la maison en mode maths 
//      m.getTransforms().add(e);
        pane.getChildren().add(m);
    }

    private void show() {
//    	On efface la scene
        drawClear();

//        On créer la maison originale
        Maison m0 = new Maison();
        m0.setStroke(color(1.00));
//        On ajoute la maison à la scène
        drawAdd(m0);

//        Pour chaque transformation de l'arraylist transforms, on créer une nouvelle maison
//        sur laquelle on applique les transformations successives
        for (int idx = 0 ; idx <= transforms.size() ; idx++) {
            Maison m = new Maison();
            m.setStroke(color(idx));
            for (int ti = idx-1 ; ti >= 0 ; ti--) {
//            	On demande le calcule matriciel
                m.getTransforms().add(transforms.get(ti));
            }
//            On ajoute la nouvelle maison à la scène
            drawAdd(m);
        }
    }

    public void initialize() {
        reset();
        update();
    }

    private Transition animateT1(Maison m) {
//        if ((cbt1.selectedProperty().getValue() && ((t1.getX() != 0.0) || (t1.getY() != 0.0)))) {
//            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(2.0), m);
//            tt1.setCycleCount(1);
//            tt1.setByX(t1.getX());
//            tt1.setByY(t1.getY());
//            tt1.setOnFinished(e -> {
//                Maison m1 = new Maison();
//                m1.setStroke(new Color(0.35, 0.35, 0.35, 1.0));
//                m1.getTransforms().addAll(t1);
//                drawAdd(m1);
//            });
//            return tt1;
//        }
        return null;
    }

    private Transition animateR(Maison m, Point2D ref1, Point2D ref2) {
//        if ((cbr.selectedProperty().getValue()) && (r.getValue() != 0.0)) {
//            ParallelTransition rt = new ParallelTransition();
//
//            RotateTransition rt1 = new RotateTransition(Duration.seconds(2.0), m);
//            rt1.setCycleCount(1);
//            rt1.setByAngle(rot.getAngle());
//            rt.getChildren().add(rt1);
//
//            double radius = ref2.distance(math2infoX(0.0), math2infoY(0.0));
//            if (radius > 0.0) {
//                Path path = new Path();
//                MoveTo moveTo = new MoveTo();
//                moveTo.setX(ref1.getX());
//                moveTo.setY(ref1.getY());
//                ArcTo arcTo = new ArcTo();
//                arcTo.setRadiusX(radius);
//                arcTo.setRadiusY(radius);
//                arcTo.setX(ref2.getX());
//                arcTo.setY(ref2.getY());
//                arcTo.setLargeArcFlag(false);
//                if (r.getValue() > 0) {
//                    arcTo.setSweepFlag(false);
//                } else {
//                    arcTo.setSweepFlag(true);
//                }
//                path.getElements().addAll(moveTo, arcTo);
//
//                PathTransition rt2 = new PathTransition(Duration.seconds(2.0), path, m);
//                rt2.setCycleCount(1);
//                rt2.setOrientation(PathTransition.OrientationType.NONE);
//                rt.getChildren().add(rt2);
//            }
//
//            rt.setOnFinished(e -> {
//                Maison m2 = new Maison();
//                m2.setStroke(new Color(0.60, 0.60, 0.60, 1.0));
//                m2.getTransforms().addAll(rot, t1);
//                drawAdd(m2);
//            });
//            return rt;
//        }
        return null;
    }

    private Transition animateT2(Maison m) {
//        if ((cbt2.selectedProperty().getValue() && ((t2.getX() != 0.0) || (t2.getY() != 0.0)))) {
//            TranslateTransition tt2 = new TranslateTransition(Duration.seconds(2.0), m);
//            tt2.setCycleCount(1);
//            tt2.setByX(t2.getX());
//            tt2.setByY(t2.getY());
//            tt2.setOnFinished(e -> {
//                Maison m3 = new Maison();
//                m3.setStroke(new Color(0.60, 0.60, 0.60, 1.0));
//                m3.getTransforms().addAll(t2, rot, t1);
//                pane.getChildren().add(m3);
//                maisons.add(m3);
//            });
//            return tt2;
//        }
        return null;
    }

    public void animate() {
//        drawClear();
//
//        Maison mobile = new Maison();
//        drawAdd(mobile);
//
//        Maison initiale = new Maison();
//        initiale.setStroke(color(0));
//        drawAdd(initiale);
//
//        Point2D ref0 = new Point2D(math2infoX(0.0) + Maison.CENTER_X, math2infoY(0.0) + Maison.CENTER_Y);
////        Point2D ref1 = t1.transform(ref0);
////        Point2D ref2 = rot.transform(ref1);
////        Point2D ref3 = rot.transform(ref2);
////
////        SequentialTransition transitions = new SequentialTransition();
////        Transition tt1 = animateT1(mobile);
////        if (tt1 != null) transitions.getChildren().add(tt1);
////        Transition rt = animateR(mobile, ref1, ref2);
////        if (rt != null) transitions.getChildren().add(rt);
////        Transition tt2 = animateT2(mobile);
////        if (tt2!= null) transitions.getChildren().add(tt2);
//
//        transitions.setOnFinished(e -> {
//            pane.getChildren().remove(mobile);
//            show();
//        });
//        transitions.play();
    }
    
    public String toStringMatrice(Transform t) {
		return ("|" + t.getMxx() + " ; " + t.getMxy() + " ; " + t.getMxz() + " ; " + t.getTx() + "|\n"
				+ "|" + t.getMyx() + " ; " + t.getMyy() + " ; " + t.getMyz() + " ; " + t.getTy() + "|\n"
				+ "|" + t.getMzx() + " ; " + t.getMzy() + " ; " + t.getMzz() + " ; " + t.getTz() + "|\n"
				+ "|" + 0.0 + " ; "+ 0.0 + " ; " + 0.0 + " ; " + 1.0 + "|");		
	}
}

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
    private Transform convertMath = new Translate(300, 300).createConcatenation(new Scale(30.0, 30.0));

    private void reset() {
        transforms.clear();
        Grille grille = new Grille(convertMath.getMxx());
//        Ajourer des transformation pour afficher la grille en mode maths
        grille.getTransforms().add(convertMath);
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
//        Transformations
        transforms.add(new Translate(90, 90));
        transforms.add(new Rotate(90.0).createConcatenation(new Translate(90, 90)));
//        test affichage matrice
        //System.out.println(toStringMatrice(new Translate(80 ,90)));
        System.out.println();
       // System.out.println(toStringMatrice(new Rotate(70.0)));
       // System.out.println(rowMaison(maisons[0]));
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
        m.getTransforms().add(convertMath);
        pane.getChildren().add(m);
    }

    private void show() {
//    	On efface la scene
        drawClear();

//        On créer la maison originale
        Maison m0 = new Maison(convertMath.getMxx());
        m0.setStroke(color(1.00));
//        On ajoute la maison à la scène
        drawAdd(m0);

//        Pour chaque transformation de l'arraylist transforms, on créer une nouvelle maison
//        sur laquelle on applique les transformations successives
        for (int idx = 0 ; idx <= transforms.size() ; idx++) {
            Maison m = new Maison(convertMath.getMxx());
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

    public void animate() {
//		toDo
    }
}

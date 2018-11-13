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
    @FXML
    CheckBox cbt1;

    @FXML
    public Slider t1x;

    @FXML
    public Slider t1y;

    @FXML
    public TextField tf1x;

    @FXML
    public TextField tf1y;

    private Translate t1 = new Translate(0.0, 0.0);

    //--------------- Rotation
    @FXML
    CheckBox cbr;

    @FXML
    public Slider r;

    @FXML
    public TextField rf;

    private Rotate rot = new Rotate(0.0, math2infoX(0.0), math2infoY(0.0));

    //--------------- Translation 2
    @FXML
    CheckBox cbt2;

    @FXML
    public Slider t2x;

    @FXML
    public Slider t2y;

    @FXML
    public TextField tf2x;

    @FXML
    public TextField tf2y;

    private Translate t2 = new Translate(0.0, 0.0);

    private ChangeListener<Number> listener1 = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            tf1x.setText(Double.toString(t1x.getValue()));
            tf1y.setText(Double.toString(t1y.getValue()));
            updateT1();
        }
    };

    private ChangeListener<Number> listener2 = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            tf2x.setText(Double.toString(t2x.getValue()));
            tf2y.setText(Double.toString(t2y.getValue()));
            updateT2();
        }
    };

    private ChangeListener<Number> listenerR = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            rf.setText(Double.toString(r.getValue()));
            updateR();
        }
    };

    private ChangeListener<Boolean> listenerCb = (observable, oldValue, newValue) -> update();

    private EventHandler<MouseEvent> razT1x = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    t1x.setValue(0.0);
                }
            }
        }
    };
    private EventHandler<MouseEvent> razT1y = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    t1y.setValue(0.0);
                }
            }
        }
    };

    private EventHandler<MouseEvent> razT2x = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    t2x.setValue(0.0);
                }
            }
        }
    };
    private EventHandler<MouseEvent> razT2y = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    t2y.setValue(0.0);
                }
            }
        }
    };

    private EventHandler<MouseEvent> razR = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    r.setValue(0.0);
                }
            }
        }
    };

    private void updateT1() {
        t1.setX(t1x.getValue());
        t1.setY(-t1y.getValue());
    }

    private void updateT2() {
        t2.setX(t2x.getValue());
        t2.setY(-t2y.getValue());
    }

    private void updateR() {
        rot.setAngle(-r.getValue());
    }

    @FXML
    public void setT1X() {
        t1x.setValue(Double.parseDouble(tf1x.getText()));
        cbt1.setSelected(true);
    }

    @FXML
    public void setT1Y() {
        t1y.setValue(Double.parseDouble(tf1y.getText()));
        cbt1.setSelected(true);
    }

    @FXML
    public void setA() {
        r.setValue(Double.parseDouble(rf.getText()));
        cbr.setSelected(true);
    }

    @FXML
    public void setT2X() {
        t2x.setValue(Double.parseDouble(tf2x.getText()));
        cbt2.setSelected(true);
    }

    @FXML
    public void setT2Y() {
        t2y.setValue(Double.parseDouble(tf2y.getText()));
        cbt2.setSelected(true);
    }

    private ArrayList<Transform> transforms = new ArrayList<>();
    private ArrayList<Maison> maisons = new ArrayList<>();

    private void reset() {
        transforms.clear();
        Grille grille = new Grille();
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
        if (cbt1.selectedProperty().getValue()) transforms.add(t1);
        if (cbr.selectedProperty().getValue()) transforms.add(rot);
        if (cbt2.selectedProperty().getValue()) transforms.add(t2);
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
        pane.getChildren().add(m);
    }

    private void show() {
        drawClear();

        Maison m0 = new Maison();
        m0.setStroke(color(1.00));
        drawAdd(m0);

        for (int idx = 0 ; idx <= transforms.size() ; idx++) {
            Maison m = new Maison();
            m.setStroke(color(idx));
            for (int ti = idx-1 ; ti >= 0 ; ti--) {
                m.getTransforms().add(transforms.get(ti));
            }
            maisons.add(m);
            pane.getChildren().add(m);
        }
    }

    public void initialize() {
        cbt1.selectedProperty().setValue(false);
        cbt2.selectedProperty().setValue(false);
        cbr.selectedProperty().setValue(false);

        reset();
        update();

        t1x.valueProperty().addListener(listener1);
        t1y.valueProperty().addListener(listener1);
        t2x.valueProperty().addListener(listener2);
        t2y.valueProperty().addListener(listener2);
        r.valueProperty().addListener(listenerR);

        cbt1.selectedProperty().addListener(listenerCb);
        cbt2.selectedProperty().addListener(listenerCb);
        cbr.selectedProperty().addListener(listenerCb);

        t1x.setOnMouseClicked(razT1x);
        t1y.setOnMouseClicked(razT1y);
        t2x.setOnMouseClicked(razT2x);
        t2y.setOnMouseClicked(razT2y);
        r.setOnMouseClicked(razR);
    }

    private Transition animateT1(Maison m) {
        if ((cbt1.selectedProperty().getValue() && ((t1.getX() != 0.0) || (t1.getY() != 0.0)))) {
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(2.0), m);
            tt1.setCycleCount(1);
            tt1.setByX(t1.getX());
            tt1.setByY(t1.getY());
            tt1.setOnFinished(e -> {
                Maison m1 = new Maison();
                m1.setStroke(new Color(0.35, 0.35, 0.35, 1.0));
                m1.getTransforms().addAll(t1);
                drawAdd(m1);
            });
            return tt1;
        }
        return null;
    }

    private Transition animateR(Maison m, Point2D ref1, Point2D ref2) {
        if ((cbr.selectedProperty().getValue()) && (r.getValue() != 0.0)) {
            ParallelTransition rt = new ParallelTransition();

            RotateTransition rt1 = new RotateTransition(Duration.seconds(2.0), m);
            rt1.setCycleCount(1);
            rt1.setByAngle(rot.getAngle());
            rt.getChildren().add(rt1);

            double radius = ref2.distance(math2infoX(0.0), math2infoY(0.0));
            if (radius > 0.0) {
                Path path = new Path();
                MoveTo moveTo = new MoveTo();
                moveTo.setX(ref1.getX());
                moveTo.setY(ref1.getY());
                ArcTo arcTo = new ArcTo();
                arcTo.setRadiusX(radius);
                arcTo.setRadiusY(radius);
                arcTo.setX(ref2.getX());
                arcTo.setY(ref2.getY());
                arcTo.setLargeArcFlag(false);
                if (r.getValue() > 0) {
                    arcTo.setSweepFlag(false);
                } else {
                    arcTo.setSweepFlag(true);
                }
                path.getElements().addAll(moveTo, arcTo);

                PathTransition rt2 = new PathTransition(Duration.seconds(2.0), path, m);
                rt2.setCycleCount(1);
                rt2.setOrientation(PathTransition.OrientationType.NONE);
                rt.getChildren().add(rt2);
            }

            rt.setOnFinished(e -> {
                Maison m2 = new Maison();
                m2.setStroke(new Color(0.60, 0.60, 0.60, 1.0));
                m2.getTransforms().addAll(rot, t1);
                drawAdd(m2);
            });
            return rt;
        }
        return null;
    }

    private Transition animateT2(Maison m) {
        if ((cbt2.selectedProperty().getValue() && ((t2.getX() != 0.0) || (t2.getY() != 0.0)))) {
            TranslateTransition tt2 = new TranslateTransition(Duration.seconds(2.0), m);
            tt2.setCycleCount(1);
            tt2.setByX(t2.getX());
            tt2.setByY(t2.getY());
            tt2.setOnFinished(e -> {
                Maison m3 = new Maison();
                m3.setStroke(new Color(0.60, 0.60, 0.60, 1.0));
                m3.getTransforms().addAll(t2, rot, t1);
                pane.getChildren().add(m3);
                maisons.add(m3);
            });
            return tt2;
        }
        return null;
    }

    public void animate() {
        drawClear();

        Maison mobile = new Maison();
        drawAdd(mobile);

        Maison initiale = new Maison();
        initiale.setStroke(color(0));
        drawAdd(initiale);

        Point2D ref0 = new Point2D(math2infoX(0.0) + Maison.CENTER_X, math2infoY(0.0) + Maison.CENTER_Y);
        Point2D ref1 = t1.transform(ref0);
        Point2D ref2 = rot.transform(ref1);
        Point2D ref3 = rot.transform(ref2);

        SequentialTransition transitions = new SequentialTransition();
        Transition tt1 = animateT1(mobile);
        if (tt1 != null) transitions.getChildren().add(tt1);
        Transition rt = animateR(mobile, ref1, ref2);
        if (rt != null) transitions.getChildren().add(rt);
        Transition tt2 = animateT2(mobile);
        if (tt2!= null) transitions.getChildren().add(tt2);

        transitions.setOnFinished(e -> {
            pane.getChildren().remove(mobile);
            show();
        });
        transitions.play();
    }
}

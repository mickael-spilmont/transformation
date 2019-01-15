package transforms;



import static transforms.Constants.IDENTITY;

import java.io.IOException;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private Pane pane;
    
    @FXML
    public ScrollPane trans;
    
    private Translation t1=new Translation(0.0, 2.0);
    private Homothetie s1 = new Homothetie(2, 2);
    private Rotation r1 = new Rotation(90.0, 0.0, 0.0);
    
    private DrawContext drawContext;
    private  Composition composition = new Composition();
    

    public void initialize() throws Exception {
        drawContext = new DrawContext(pane);
        pane.getChildren().add(new Grille());
        composition.add(s1);
        composition.add(t1);
        composition.add(r1);
        update();
    }

    private void update() throws IOException {
    	
        try {
			show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void show() throws Exception {
        drawContext.drawClear();
        
        Maison m1 = new Maison();
        for (int index = 0 ; index <= composition.size() ; index++) {
            if (index == 0) {
                composition.drawStep(0, drawContext);
                composition.afficheMatrices(null,IDENTITY, m1);
            } else {
                composition.drawStep(index, drawContext);

                try {
                	//System.out.println("ok");
                	composition.afficheMatrices(composition.getAtomique(index-1), composition.getSuivies(index-1), m1);
                } catch (TransformationException e) {
                }
            }
        }
    }
    
    public void animate() throws NullPointerException, IndexOutOfBoundsException{
    	Maison maisonAnimée = new Maison();
    	Maison maisonAnimée2 = new Maison();
        drawContext.drawClear();
        composition.drawStep(0, drawContext);

        Timeline timeline = new Timeline();

        maisonAnimée.setStroke(Constants.SCHEMA_MOUVEMENT);
        drawContext.drawAdd(maisonAnimée);
        composition.animate(timeline, maisonAnimée, drawContext);

        
        maisonAnimée2.setStroke(Constants.SCHEMA_ORIGINE);
        drawContext.drawAdd(maisonAnimée2);
        timeline.play();
    }
    
    private Color stringToColor(String c) {
    	
    	switch(c.toUpperCase()) {
    	case "ROUGE" : return Color.RED;
    	case "BLEU" : return Color.BLUE;
    	case "GRIS" : return Color.GRAY;
    	case "VERT" : return Color.GREEN;
    	case "NOIR" : return Color.BLACK;
    	default : return Color.BLACK;
    	
    	}
    	
    }
    
    
}

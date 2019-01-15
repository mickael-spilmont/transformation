package transforms;



import static transforms.Constants.IDENTITY;

import java.io.IOException;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;


public class Controller {

	@FXML
	private Pane pane;

	@FXML
	public ScrollPane trans;

	private DrawContext drawContext;
	private  Composition composition = new Composition();


	public void initialize() throws Exception {
		drawContext = new DrawContext(pane);
		pane.getChildren().add(new Grille());
		
		composition.add(new Translation(0.0, 2.0));
		composition.add(new Homothetie(2, 2));
		composition.add(new Rotation(90.0, 0.0, 0.0));
		
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

		Dessin m1 = new Dessin();
		for (int index = 0 ; index <= composition.size() ; index++) {
			if (index == 0) {
				composition.drawStep(0, drawContext);
				composition.afficheMatrices(null,IDENTITY, m1);
			} else {
				composition.drawStep(index, drawContext);

				try {
					composition.afficheMatrices(composition.getAtomique(index-1), composition.getSuivies(index-1), m1);
				} catch (TransformationException e) {
				}
			}
		}
	}

	public void animate() throws NullPointerException, IndexOutOfBoundsException{
		Dessin maisonAnime = new Dessin();
		Dessin maisonAnime2 = new Dessin();
		Timeline timeline = new Timeline();

		drawContext.drawClear();
		composition.drawStep(0, drawContext);

		maisonAnime.setStroke(Constants.SCHEMA_MOUVEMENT);
		drawContext.drawAdd(maisonAnime);
		composition.animate(timeline, maisonAnime, drawContext);

		maisonAnime2.setStroke(Constants.SCHEMA_ORIGINE);
		drawContext.drawAdd(maisonAnime2);

		timeline.play();
	}
}
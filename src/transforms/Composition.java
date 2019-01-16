package transforms;



import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.transform.Transform;
import javafx.util.Duration;


public class Composition {

	private ArrayList<Transformation> transforms = new ArrayList<Transformation>();
	private ArrayList<Transform> compose = new ArrayList<Transform>();

	public void add(Transformation transformation) {

		this.transforms.add(transformation);
		Transform prec;
		if(this.size() <= 1) {
			prec = Constants.IDENTITY;
		}else {
			prec = this.compose.get(this.compose.size() -1);
		}

		Transform cumul = transformation.getTransform().createConcatenation(prec);
		this.compose.add(cumul);
	}

	public int size() {
		return this.transforms.size();
	}

	private void verifIndex(int index) throws TransformationException {
		if (index < 0) {
			throw new TransformationException();
		}
		if (index >= this.transforms.size()) {
			throw new TransformationException();
		}
	}

	public Transform getAtomique(int index) throws TransformationException {
		this.verifIndex(index);
		return this.transforms.get(index).getTransform();
	}

	public Transform getSuivies(int index) throws TransformationException {
		this.verifIndex(index);
		return this.compose.get(index);
	}

	private String afficheRange(Transform transformation, Range row) {
		if (transformation == null) {
			return "                 ";
		}
		switch (CompositionSturct.CompositionRange[row.ordinal()]) {
		case 1: {
			return String.format("%5.2f %5.2f %+5.1f", transformation.getMxx(), transformation.getMxy(), transformation.getTx());
		}
		case 2: {
			return String.format("%5.2f %5.2f %+5.1f", transformation.getMxy(), transformation.getMyy(), transformation.getTy());
		}
		case 3: {
			return String.format("%5.2f %5.2f %+5.1f", 0.0, 0.0, 1.0);
		}
		}
		return null;
	}

	private void afficheMatriceSchema(ObservableList<Double> liste, Range range, Transform t) throws NullPointerException, IndexOutOfBoundsException {

		for (int i = 0; i < liste.size(); i += 2) {
			Point2D point = t.transform(new Point2D(((Double)liste.get(i)).doubleValue(), ((Double)liste.get(i + 1)).doubleValue()));

			switch (CompositionSturct.CompositionRange[range.ordinal()]) {
			case 1: {
				System.out.print(String.format("%5.2f ", point.getX()));
				break;
			}
			case 2: {
				System.out.print(String.format("%5.2f ", point.getY()));
				break;
			}
			case 3: {
				System.out.print(String.format("%5.2f ", 1.0));
				break;
			}
			}
		}
	}

	void afficheMatrices(Transform transform1, Transform transform2, Dessin m) throws IOException, NullPointerException, IndexOutOfBoundsException  {
		ObservableList<Double> liste = m.getPoints();
		if (transform1 == null) {

			System.out.println("                  | ===== ===== ===== |");
		} else {

			System.out.println("===== ===== ===== | ===== ===== ===== |");
		}
		for (Range row : Range.values()) {
			System.out.print(this.afficheRange(transform1, row) + " | " + this.afficheRange(transform2, row));
			System.out.print(" | ");
			this.afficheMatriceSchema(liste, row, transform2);
			System.out.println();   
		}          
	}

	private Color color(int index) {
		if (index == 0) return Constants.SCHEMA;
		if (index == this.transforms.size()) return Constants.SCHEMA_FIN;
		return Constants.SCHEMA_ETAPE;
	}

	public void drawStep(int index, DrawContext drawContext) throws NullPointerException, ArrayIndexOutOfBoundsException {
		Dessin m = new Dessin();
		m.setStroke(this.color(index));
		if (index > 0) {
			m.getTransforms().add((Transform)this.compose.get(index - 1));
		}
		drawContext.drawAdd((Node)m);
	}

	private KeyFrame DessinKeyFrame(Duration last, int index, DrawContext drawContext) {
		return new KeyFrame(last, e -> this.drawStep(index, drawContext), new KeyValue[0]);
	}

	public void animate(Timeline timeline, Node mobile, DrawContext drawContext) {
		Duration last = Duration.seconds((double)0.0);
		for (int i = 0; i < this.size(); ++i) {
			Transformation transformation = this.transforms.get(i);
			if (transformation.estIdentite()) continue;
			mobile.getTransforms().add(1, (Transform)transformation.getTransform());
			timeline.getKeyFrames().addAll(transformation.getKeyFrame(last));
			last = last.add(Duration.seconds((double)2.0));
			timeline.getKeyFrames().add((KeyFrame)this.DessinKeyFrame(last, i + 1, drawContext));
		}
	}
}

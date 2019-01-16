package transforms;




import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

public class Constants {
	static final double ZERO_X = 0.0;
    static final double MIN_X = -10.0;
    static final double MAX_X = 10.0;
    static final double INC_X = 1.0;
    static final double ZERO_Y = 0.0;
    static final double MIN_Y = -10.0;
    static final double MAX_Y = 10.0;
    static final double INC_Y = 1.0;
    static final double SCALE = 35.0;
    private static final double OFFSET_X = 350.0;
    private static final double OFFSET_Y = 350.0;
    static final Transform SCREEN_SCALE = new Scale(35.0, -35.0);
    static final Transform SCREEN_OFFSET = new Translate(350.0, 350.0);
    static final Transform SCREEN_TRANSFORM = SCREEN_OFFSET.createConcatenation(SCREEN_SCALE);
    static final Point2D SCREEN_ORIGIN = SCREEN_TRANSFORM.transform(new Point2D(0.0, 0.0));
    public static Transform IDENTITY = new Translate();
    
    public static Color SCHEMA = Color.BLUE;
    public static Color SCHEMA_FIN = Color.GREEN;
    public static Color SCHEMA_ETAPE = Color.GREY;
    public static Color SCHEMA_MOUVEMENT = Color.RED;
    public static Color SCHEMA_ORIGINE = Color.BLACK;
    
    //liste de points du shema
    public static Double[] MATRIX_SCHEMA = {0.0, 0.0, 0.0, 1.0, 0.5, 1.5, 1.0, 1.0, 1.0, 0.0, 0.5, 0.0, 0.5, 0.75, 0.75, 0.75, 0.75, 0.0, 0.0, 0.0};
    
    
    
}

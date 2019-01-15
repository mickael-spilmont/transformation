package transforms;


public class Composition1 {

	static final int[] transCompositionRow;

    static {
        transCompositionRow = new int[Row.values().length];
        try {
            Composition1.transCompositionRow[Row.X.ordinal()] = 1;
        }
        catch (Exception e) {
            
        }
        try {
            Composition1.transCompositionRow[Row.Y.ordinal()] = 2;
        }
        catch (Exception e) {
           
        }
        try {
            Composition1.transCompositionRow[Row.T.ordinal()] = 3;
        }
        catch (Exception e) {
            
        }
    }
}

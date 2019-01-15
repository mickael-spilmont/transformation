package transforms;


public class CompositionSchema {

	static final int[] transCompositionRow;

    static {
        transCompositionRow = new int[Range.values().length];
        try {
            CompositionSchema.transCompositionRow[Range.X.ordinal()] = 1;
        }
        catch (Exception e) {
            
        }
        try {
            CompositionSchema.transCompositionRow[Range.Y.ordinal()] = 2;
        }
        catch (Exception e) {
           
        }
        try {
            CompositionSchema.transCompositionRow[Range.T.ordinal()] = 3;
        }
        catch (Exception e) {
            
        }
    }
}

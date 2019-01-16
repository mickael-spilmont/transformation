package transforms;


public class CompositionSturct {

	static final int[] CompositionRange;

    static {
        CompositionRange = new int[Range.values().length];
        try {
            CompositionSturct.CompositionRange[Range.X.ordinal()] = 1;
        }
        catch (Exception e) {
            
        }
        try {
            CompositionSturct.CompositionRange[Range.Y.ordinal()] = 2;
        }
        catch (Exception e) {
           
        }
        try {
            CompositionSturct.CompositionRange[Range.T.ordinal()] = 3;
        }
        catch (Exception e) {
            
        }
    }
}

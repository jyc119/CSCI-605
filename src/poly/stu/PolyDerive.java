package poly.poly.stu;

/**
 * This class can compute the derivative of a polynomial.
 *
 * @author RIT CS
 * @author YOUR NAME HERE
 */
public class PolyDerive {

    /**
     * Unused constructor, made private to avoid javadoc generation.
     */
    private PolyDerive() {
    }

    /**
     * Computes the derivative for a polynomial.  For example:
     * <pre>
     * poly=[1]: [0]
     * poly=[3, -1]: [-1]
     * poly=[0, 3]: [3]
     * poly=[2, -1, -2, 1]: [-1, -4, 3]
     * poly=[-5, 0, 0, 3, 3, 1]: [0, 0, 9, 12, 5]
     * </pre>
     *
     * @param poly A native array representing the polynomial, in reverse order.
     * @rit.pre poly is not an empty array.  Minimally it will contain
     *      a constant term.
     * @return A polynomial as a native array in reverse order.
     */
    public static int[] computeDerivative(int[] poly) {

        int deriveLength = (poly.length == 1) ? 1 : poly.length-1;
        int[] deriv= new int[deriveLength];
        for (int i = 1; i < poly.length; i++){
            if(poly[i] == 0){
                continue;
            }
            int newIndex = i-1;
            int coefficient = i * poly[i];
            deriv[newIndex] = coefficient;

        }

        return deriv;
    }
}

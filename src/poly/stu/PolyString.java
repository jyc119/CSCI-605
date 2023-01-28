package poly.poly.stu;

/**
 * This class can return a string representation of a polynomial of order n,
 * in the form:
 * <pre>
 * x^n + x^n-1 + ... x^1 + constant
 * </pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class PolyString {

    /**
     * The displayed variable name
     */
    public final static String VARIABLE_NAME = "x";

    /**
     * Unused constructor, made private to avoid javadoc generation.
     */
    private PolyString() {
    }

    /**
     * Helper method getCoefficient gets the coefficient of each component of the polynomial
     * @return A string representation of the coefficients in the polynomial
     *
     *
     * Get the string representation of the polynomial.  For example:
     * <pre>
     * poly=[1]: "1"
     * poly=[3, -1]: "-x + 3"
     * poly=[0, 3]: "3x + 0"
     * poly=[2, -1, -2, 1]: "x^3 + -2x^2 + -x + 2"
     * poly=[-5, 0, 0, 3, 3, 1]: "x^5 + 3x^4 + 3x^3 + -5"
     * </pre>
     *
     * @param poly A native array representing the polynomial, in reverse order.
     * @return A string representation of the polynomial.
     * @rit.pre poly is not an empty array.  Minimally it will contain
     * a constant term.
     */
    public static String getCoefficient(int element) {

        if (element == 1) {
            return "";
        } else if (element == -1) {
            return "-";
        } else {
            return String.valueOf(element);
        }
    }
    public static String getString(int[] poly) {

        StringBuilder polystring = new StringBuilder();

        for (int i = poly.length - 1; i >= 1; i--) {
            if(poly[i] == 0) {
                continue;
            }
            String str_coefficient = getCoefficient(poly[i]);
            String variable = (i == 1) ? "" : "^"+i;
            polystring.append(str_coefficient + "x" + variable + " + ");
        }
        // Insert last element since it has no x
        polystring.append(poly[0]);
        return polystring.toString();
    }
}

/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }
		double xu = x1 + (x2 - x1) / 3.0;
        double yu = y1 + (y2 - y1) / 3.0;
		double xv = x1 + 2.0 * (x2 - x1) / 3.0;
        double yv = y1 + 2.0 * (y2 - y1) / 3.0;
		double h = Math.sqrt(3.0) / 6.0;
        double xw = (x1 + x2) / 2.0 + h * (y1 - y2);
        double yw = (y1 + y2) / 2.0 + h * (x2 - x1);
		curve(n - 1, x1, y1, xu, yu);
        curve(n - 1, xu, yu, xw, yw);
        curve(n - 1, xw, yw, xv, yv);
        curve(n - 1, xv, yv, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		double length = 0.6;
        double height = length * Math.sqrt(3) / 2.0;
        double v1x = 0.25; 
        double v1y = 0.85; 
        double v2x = v1x + length; 
        double v2y = v1y;
        double v3x = v1x + length / 2.0; 
        double v3y = v1y - height;
        curve(n, v1x, v1y, v2x, v2y);
        curve(n, v2x, v2y, v3x, v3y);
        curve(n, v3x, v3y, v1x, v1y);
	}
}

package steganography;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class PSNRandMSE {
	
	public static final int DOUBLE_MANTISSA_BITS = 52;
	public static double psnr;
	
	public static final int FLOAT_MANTISSA_BITS = 23;

	public static final byte POSITIVE = 0;
	public static final byte NEGATIVE = 1;

	public static final int BLACK = 0;
	public static final int WHITE = 1;

	public static final int INSIGNIFICANT = 0;
	public static final int SIGNIFICANT = 1;

	public static long unsigned(long l) {
		long x = l; x <<= 32; x >>>= 32;
		return x;
	}

	public static String printMSE(BufferedImage im1, BufferedImage im2) {
		assert(
			im1.getType() == im2.getType()
				&& im1.getHeight() == im2.getHeight()
				&& im1.getWidth() == im2.getWidth());

		double  mse = 0;
		int width = im1.getWidth();
		int height = im1.getHeight();
		Raster r1 = im1.getRaster();
		Raster r2 = im2.getRaster();
		for (int j = 0; j < height; j++)
			for (int i = 0; i < width; i++)
				mse
					+= Math.pow(r1.getSample(i, j, 0) - r2.getSample(i, j, 0), 2);
		mse /= (double) (width * height);
		System.err.println("MSE = " + mse);
		int maxVal = 255;
		double x = Math.pow(maxVal, 2) / mse;
		 psnr = 10.0 * logbase10(x);
		return Double.toString(mse);
		
	}
	public static String printPSNR() {
		
		System.err.println("PSNR = " + psnr);
		return Double.toString(psnr);
	}
	
	public static double logbase10(double x) {
		return Math.log(x) / Math.log(10);
	}
}


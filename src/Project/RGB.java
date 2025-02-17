package a4;

import java.util.Objects;
import java.util.Random;

/**
 * Basic implementation of a class that represents color values using a 24-bit
 * integer red-green-blue (RGB) representation.
 */
public class RGB implements Comparable<RGB> {
	/* 
	 * ADD YOUR NON-STATIC FIELDS HERE. THEY SHOULD ALL HAVE private ACCESS.
	 */
	
	/**
	 * color channel values for red, green, blue
	 */
	private int r;
	private int g;
	private int b;
	
	
	/* 
	 * ADD YOUR PUBLIC STATIC FIELDS HERE.
	 */
	
	/**
	 * The maximum color channel value.
	 */
	public static final int MIN_VALUE = 0; 
	
	/**
	 * The minimum color channel value.
	 */
	public static final int MAX_VALUE = 255; 
	
	
	/**
	 * IMPLEMENTED FOR YOU.
	 * 
	 * Throws {@code ChannelValueOutOfRangeException} if {@code v} is out of range.
	 * 
	 * @param v a channel value to test
	 * 
	 * @throws ChannelValueOutOfRangeException if {@code v} is out of range.
	 */
	private void testValue(int v) {
		if (v < MIN_VALUE) {
			throw new ChannelValueOutOfRangeException(v + " < " + MIN_VALUE);
		}
		if (v > MAX_VALUE) {
			throw new ChannelValueOutOfRangeException(v + " > " + MAX_VALUE);
		}
	}
	
	
	/**
	 * Initializes this color so that all channel values are zero.
	 */
	public RGB() {
		this.r = 0;
		this.g = 0;
		this.b = 0;
	}
	
	/**
	 * Initializes this color to the specified red, green, and blue channel values.
	 * 
	 * @param r red channel value
	 * @param g green channel value
	 * @param b blue channel value
	 */
	public RGB(int r, int g, int b) {
		testValue(r);
		testValue(g);
		testValue(b);
		
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	/**
	 * Initializes this color by copying the color channel values from another color.
	 * 
	 * @param the color to copy
	 */
	public RGB(RGB other) {
		this.r = other.r;
		this.g = other.g;
		this.b = other.b;
	}
	
	
	
	/**
	 * Returns the red channel value for this color.
	 * 
	 * @return the red channel value for this color
	 */
	public int red() {
		return this.r;
	}
	
	
	/**
	 * Returns the green channel value for this color.
	 * 
	 * @return the green channel value for this color
	 */
	public int green() {
		return this.g;
	}
	
	
	/**
	 * Returns the blue channel value for this color.
	 * 
	 * @return the blue channel value for this color
	 */
	public int blue() {
		return this.b;
	}
	
	
	/**
	 * Sets the red channel value for this color returning the previous value.
	 * 
	 * @param the new red channel value for this color
	 * 
	 * @return the old red channel value for this color
	 */
	public int red(int r) {
		int temp = this.r;
		this.r = r;
		return temp;
	}
	
	
	/**
	 * Sets the green channel value for this color returning the previous value.
	 * 
	 * @param the new green channel value for this color
	 * 
	 * @return the old green channel value for this color
	 */
	public int green(int g) {
		int temp = this.g;
		this.g = g;
		return temp;
	}
	
	
	/**
	 * Sets the blue channel value for this color returning the previous value.
	 * 
	 * @param the new blue channel value for this color
	 * 
	 * @return the old blue channel value for this color
	 */
	public int blue(int b) {
		int temp = this.b;
		this.b = b;
		return temp;
	}
	
	
	/**
	 * Returns the approximate luminance of this color.
	 * 
	 * @return the approximate luminance of this color
	 */
	public double luminance() {
		double r = 0.0 + this.r;
		double g = 0.0 + this.g;
		double b = 0.0 + this.b;
		
		double l = 0.2126 * Math.pow((r / 255), 2.2) 
				+ 0.7152 * Math.pow((g / 255), 2.2)
				+ 0.0722 * Math.pow((b / 255), 2.2);
		
		return l;
	}
	
	
	/**
	 * Compares this color to another color by their luminance values.
	 * 
	 * @param other another color
	 * 
	 * @return the value 0 if both colors have equal luminance values; a negative value if this color has a lesser luminance value than the other color; a positive value if this color has a greater luminance than the other color
	 */
	public int compareTo(RGB other) {
		double thisLuminance = this.luminance();
		double otherLuminance = other.luminance();
		
		return Double.compare(thisLuminance, otherLuminance);
		
		//return Double.compare(thisLuminance, otherLuminance);
		// return thisLuminance - otherLuminance; // this cannot overflow since 0 < luminance < 1, but not working cuz need to return int
	}
	
	
	/**
	 * Returns a hash code for this color.
	 * 
	 * @return a hash code for this color
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.r, this.g, this.b);
	}
	
	
	/**
	 * Compares this color to another color for equality.
	 * <p> This color is equal to obj if and only if obj is an RGBColor reference
	 *  and both colors have equal red, green, and blue channel values.
	 * 
	 * @param an object to compare to this color
	 * 
	 * @return true if this color is equal to obj, false otherwise.
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		RGB other = (RGB) obj;
		
		if (this.r != other.r) {
			return false;
		}
		if (this.g != other.g) {
			return false;
		}
		if (this.b != other.b) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Returns a string representation of this color. 
	 * <p> The returned string has the format:
 			[r, g, b]
			where r, g, and b are the red, green, and blue channel values of this color.
	 * 
	 * @return a string representation of this color
	 */
	@Override
	public String toString() {
		String r = "" + this.r;
		String g = "" + this.g;
		String b = "" + this.b;
		
		return "[" + r + ", " + g + ", " + b + "]";
	}
	
	
	public static void main(String [] args) {
		
		RGB color1 = new RGB();
		System.out.println(color1.toString());
		
		RGB color2 = new RGB(3, 4, 6);
		System.out.println(color2.toString());
		
		RGB color3 = new RGB(color2);
		System.out.println(color3.toString());
		
		System.out.println(color1.compareTo(color3));
		System.out.println(color2.compareTo(color1));
		
		Random rand = new Random();
		System.out.println(color1.equals(rand)); // to check when the object types are different
		System.out.println(color2.equals(color3));
		
		System.out.println("The hashCode for color2 is " + color1.hashCode());
		System.out.println("The hashCode for color2 is " + color2.hashCode());
		System.out.println("The hashCode for color2 is " + color3.hashCode());
		
		RGB white = new RGB(255, 255, 255);
		System.out.println("The luminance for white is " + white.luminance());
		System.out.println("The luminance for black is " + color1.luminance());
		System.out.println(white.compareTo(color1));
		System.out.println(color1.compareTo(color1));
		System.out.println(color1.compareTo(white));
		
		
	}
}

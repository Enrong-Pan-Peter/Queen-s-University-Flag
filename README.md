# Queen's University Flag

## Overview
This project is a Java-based implementation that draws the Queen's University Tricolor Flag using RGB values and a custom `RGBImage` class. The flag consists of three vertical stripes in blue, gold, and red, each occupying one-third of the image's width.

## Files

### `RGB.java` in `src`
This class represents an RGB color using 24-bit color channels (red, green, and blue). It provides methods to:
- Store and retrieve RGB values.
- Validate that RGB values are within the range `[0, 255]`.
- Compute the luminance of a color.
- Compare colors based on luminance.
- Convert an RGB object into a string format (e.g., `[147, 112, 219]`).

### `RGBImage.java` in `src`
This class represents a digital image using a grid of `RGB` color values. Key features:
- Initializes an image of given dimensions with black pixels.
- Retrieves and modifies pixel values at specific locations.
- Converts the image into a Java `Image` object for rendering.
- Implements a `main` method that generates and displays the Queen's Tricolor Flag:
  - Blue (`RGB(0, 36, 82)`) on the left third.
  - Gold (`RGB(250, 189, 15)`) in the middle third.
  - Red (`RGB(185, 14, 49)`) on the right third.

### Exception Classes in `src`
These custom exceptions ensure robustness in handling out-of-range errors:
- **`ChannelValueOutOfRangeException.java`**: Thrown when an RGB value is outside `[0, 255]`.
- **`RowIndexOutOfRangeException.java`**: Thrown when a row index is out of bounds.
- **`ColumnIndexOutOfRangeException.java`**: Thrown when a column index is out of bounds.

## Usage

### Compilation
To compile the project, run:
```sh
javac RGB.java RGBImage.java ChannelValueOutOfRangeException.java RowIndexOutOfRangeException.java ColumnIndexOutOfRangeException.java
```

### Execution
To generate and display the Queen's Tricolor Flag, run:
```sh
java RGBImage
```

### Expected Output
A 600x300 pixel image featuring the Queen’s Tricolor Flag with three vertical color bands:
- **Blue** on the left.
- **Gold** in the center.
- **Red** on the right.

## Future Improvements
- Extend the `RGBImage` class to support additional flag designs.
- Implement user-defined flag dimensions.
- Optimize rendering efficiency.

## License
This project is licensed under the MIT License.

## Author
Pan, Enrong
# SER305FinalProject

## The application is an image blurring tool that implements Java Swing for the slider bar and label components.
## The program takes an original PNG image that is read in and uses the BufferedImage tool from the Java AWT API
## to change the properties of the image when the slider bar is moved, which calls the updateBlur function where the
## BufferedImage applyBlur function is called. The applyBlur function uses varaibles to manipulate the intesity of the
## blur and applies it to the image so that the updateBlur function can return a new blurred image.
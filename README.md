# SER305FinalProject

The application is an image blurring tool that implements Java Swing for the slider bar and label components.
The program takes an original PNG image that is read in and uses the BufferedImage tool from the Java AWT API
to change the properties of the image when the slider bar is moved, which calls the updateBlur function where the 
applyBlur function is called and the result is set as the displayed image. The applyBlur function uses a kernel to 
modify the color of each pixel based off of the surrounding pixels within the blur's radius.
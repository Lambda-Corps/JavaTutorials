/**
 * Square class definition used to teach about variables, methods,
 * classes, and objects.
 */
class Square {
    // To make something a Class Variable, you use the static keyword
    // Convention for Java programmers is to put class variable names 
    // in all caps to set them apart
    // Class variables are initializd immediately
    static final String CLASS_STRING = "My Square Class";

    // To define an instance variable, omit the static keyword. 
    // the life cycle of the variable will be for as long as the 
    // instance of the object is active.
    // The convention used by Java programmers for instance variables
    // is to precede the name with 'm_', where m signifies it's a 
    // member variable of the object.  The instance variables are 
    // initialized when the object is constructed
    
    // instance variable to store the length of one side of a square
    int m_sideLength;  

    // Here is the constructor of the Square class.  Each time an 
    // instance of a Square is requested by the program, the Java
    // language will call this method and return an instance of a 
    // square.
    Square(){
        m_sideLength = 2;
    }

    /**
     * Method to calculate and return the area of the square to 
     * a caller.
     */
    int getArea(){
        // In the method definition above, the identifier 'int' 
        // is the Return Type of the method.  The name of the 
        // method is getArea.  Notice the convention of the 
        // capitalized letters, first word lower case with the
        // second word being capitalized.

        // Area of a square is calculated by multiplying the 
        // length of the square by the width of the square. In 
        // the case of a square it's the same, so we're just 
        // going to multiply the side length by itself and return
        // the result to the caller of the method
        return m_sideLength * m_sideLength;
    }

    /**
     * Method to calculate and return the perimeter of the square to
     * a caller.
     */
    int getPerimeter(){
        // In a sqaure, the perimeter is just the sum of all four sides
        // of a square.  Rather than doing the addition four times, we 
        // can just multiply by four.
        return 4 * m_sideLength;
    }
} 

/**
 * Lesson 1 ShapeMain program runner
 */
class ShapeMain {

    // The main method to run for the program
    public static void main (String[] args){
        // Declare a local instance of a square, and contstruct it.
        // The 'new' key word is what instantiates, or constructs, an 
        // instance of an object.
        // Remember, variable declarations have two things, a type and
        // a name.
        // Type   Name       new keyword calls the constructor
        Square    mySquare = new Square(); 

        // Show the details of our newly constructed square
        System.out.println("My Square's Properties");
        // Access each of the Square's properties through the methods 
        // we defined earlier and print them to the screen
        System.out.println("Area      : " + mySquare.getArea() );
        System.out.println("Perimeter : " + mySquare.getPerimeter() );

    } // End main
} // end ShapeMain class
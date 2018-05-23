# Lesson 1 -- Basic Syntax

A Java program can be very simply described:  ___It is a collection of classes that communicate with each other to perform a set of tasks___.  Classes are the core of programs that is written in the Java programming language, so that's what we need to understand first.

The way these classes work will be by mainting a state of saved information in variables, and pass information between each other using methods.  Variables and methods will be discussed further down in the lesson.

## Classes
A class should be thought of as a definition of a given behavior. Think of it as the blueprint of the program.  Just like in architecture, a blueprint is not a building.  A blueprint defines what a building will be once it is constructed, but it's not and never will be a building.  The building must be constructed by materials before it's a building.

In Java, a class that is constructed is referred to as an ___Object___.  So, understanding our definition of what a class is, I hope you thought to yourself, _"How can a program be a collection of classes, if classes are only blueprints?"_.  If you did think that, you are correct.  The more correct definition of a Java program is: ___It is a collection of objects that communicate with each other to perform a set of tasks___. 

Notice the difference, the single word difference?  We changed out classes, and inserted objects.  Why?  Because classes are only blueprints, they are only definitions of states and behaviors that make up a program, it's the objects themselves that actually _implement_ the functionality.

To be useful to anyone, objects need to be able to communicate with other objects. There are many reasons for this, but the main reason is to keep the code simple for developers. The Java compiler doesn't care if put all the functionality in one class, or 100 classes.  The compiled program will be the same, however it is much easier for programmers to put functionality into small, clearly named classes in the source files.  

Lets put this into action.

# ShapeMain.java
We are going to use a new source file to implement Lesson 1.  Open your text editor and create a new file called ___ShapeMain.java___. We are calling it _ShapeMain_ because it is the class that is going to run our main method and the example we are going to start with has to do with basic shapes.  

Inside our _ShapeMain.java_ file we are going to implement the main method of this Lesson's program.

```java
/**
 * Lesson 1 ShapeMain program runner
 */
class ShapeMain {

    // The main method to run for the program
    public static void main (String[] args){


    } // End main
} // end ShapeMain class
```

Our _ShapeMain_ class file can be compiled and run just like the HelloWorld example from [Lesson 0](../Lesson_0/README.md).
> javac ShapeMain.java

> java -cp . ShapeMain

If successful, you should see no errors, and consequently no output either.  We are going to introduce the concepts as to how we can both save state within and pass information from object to object.

##  Variables 
Variables are used to store information in a program.  There are two main components to a variable:
* __Name__ -- This is the identifier that will be used in the program to reference the variable. 
    * The convention for variables is to start with a lower case letter, and capitalize any other subsequent words.  For example, if I had a variable representing the length of a message, by convention I would name the variable ___messageLength___ where the first word is not capitalized, and the subsequent words are.
* __Type__ -- This is the type of information that is being stored.  There are many different types of variables that are built in to Java, ___ints___ or ___doubles___ used to represent numbers, ___Strings___ representing readable text, among many others.
    * Aside from the Java built-in types, a programmer can define a class of their liking, and have one of those types as the variable.  This is what the Lesson 1 example will teach.

Type | Life Time | Description 
------------ | ------------- | ------------
___Class Variables___ |  Forever  | These variables are accessible to programs even if there isn't an object of a given type
___Instance Variables___ |  As long as object is alive | These variables are the ones that maintain the state of a given object instance
___Local Variables___ | Very short, alive between characters { and } | hese variables are used as temporary holders of information

If you don't understand this fully as of right now, that's okay.  Variables of each type will be explained further as the lesson moves forward.

## Methods 
If variables are considered the data, or state, of the given object then we can define the ___methods___ as the _behavior_ of the object.  Methods can receive information that will alter the resulting behavior within in something called arguments.  The arguments to a method are nothing more than _Local Variables_ as previously explained.  Methods can transmit information to other parts of the program in a special type of _Local Variable_ called a ___Return Value___.

### The Constructor
There is one particular method that needs to be understood:  ___The Constructor___.  The constructor is a special method called by the Java Runtime that creates an instance of an object.  Normally the constructor is defined by the programmer, but if not Java will create what is called the _Default Constructor_ for a given object.  A class can't exist without a constructor, because the constructor is the method that builds the objects.  

Remember how classes are only blueprints of functionality, the constructor is the special method that turns the blueprints into the concreate objects we need to have the program run.

Methods will be discussed in further detail in [Lesson 2](../Lesson_2/README.md).  As a convention, Java programmers use the same capitalization style as variables.  First word is lowercase, with the first letter of the second word being capitalized.

## Objects
Remember, classes are only blueprints of functionality. There isn't any concrete program data being used until we construct an object.  Here we're going to add to our _ShapeMain.java_ source file to illustrate how classes can become objects.  We are going to start with a basic class definition of a shape that should be familiar to most people, a square.

Some of the properties of a square:  All sides equal length, it has an area that is easily calculable (length * width = area), it has a perimeter that is easily calculable (4 * length = perimeter), etc.

We are going to define a class (blueprint) that explains each of these properties, then construct a few different shapes with different variables and methods to show how it works.

Back to the _ShapeMain.java_ file.  
1. Add a class definition of a class named Square to the top of the source file.
1. Define the class and instance variables that hold the state
1. Define the methods used by other objects to access the Square's properties
1. Edit the _ShapeMain_ class definition to instantiate a Square object, and print the details to the screen.
1. Compile and run the source file just as discussed in Lesson 0
    > javac ShapeMain.java
    
    > java -cp . ShapeMain
    * You should see output like the following:
    ```
        My Square's Properties
        Area      : 4
        Perimeter : 8 
    ```
```java
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
```
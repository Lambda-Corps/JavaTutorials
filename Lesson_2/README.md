# Lesson 2 - Advanced Syntax

In [Lesson 1](../Lesson_1/README.md) we covered basic syntax. We defined ___Classes___, ___Objects___, ___Methods___, and ___Variables___.  

As a review:
* Classes - The blueprint of the objects that comprise the program
* Objects - Instantiated classes.  These are the constructed classes that implement the functionality of the program
* Methods - Structured behavior defined for the program
* Variables - Captured state of the given object

If you are uncomfortable with some of the definitions, re-read Lesson 1 as this lesson will build completely upon those concepts.

For this lesson the sequence will be:
1. Create a class file called _ShapeMain.java_
1. Add a class definition of a class named _Square_ to the top of the source file.
1. Define the class and instance variables that hold the state
1. Define the methods used by other objects to access the Square's properties
1. Edit the _ShapeMain_ class definition to instantiate a Square object, and print the details to the screen.

___NOTE___: This starting point is similar to the ending point of Lesson 1, you can reference your solution for Lesson 1 if you need help completing the preparatory steps.


```java
/**
 * Square class definition used to teach about variables, methods,
 * classes, and objects.
 */
class Square {
    // Class variable string used to identify the type of object
    static final String CLASS_STRING = "My Square Class";

    // instance variable to store the length of one side of a square
    int m_sideLength;  

    // Here is the constructor of the Square class.  The default constructor creates a square with length 2
    Square(){
        m_sideLength = 2;
    }

    /**
     * Method to calculate and return the area of the square to 
     * a caller.
     */
    int getArea(){
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
        // In a sqaure, the perimeter is just the sum of all four
        //  Rather than doing the addition four times, we 
        // can just multiply by four.
        return 4 * m_sideLength;
    }
} 

/**
 * Lesson 2 ShapeMain program runner
 */
class ShapeMain {

    // The main method to run for the program
    public static void main (String[] args){
        // Instance of Square that will be used in the lesson
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

## Objects
Remember that ___Classes___ are the blueprint of the program. They don't actaully have a state, or execute anything.  Only constructed ___Objects___ implement the functionality and maintain the state of a given program.

Above we included a source file from Lesson 1. If you look above at the method ___getArea()___ you'll see that we calculate the area by multiplying the length times the width. While that is perfectly accurate, there is another way to calculate the area of a square, and we're going to implement that functionality now in our starting source file.

We will start with the old _getArea()_ method:

```java
    int getArea(){
        // ... (comments cut for brevity)
        return m_sideLength * m_sideLength;
    }
```

Now, we will use the other method of calculating the area. To calculate the area of the square, we need to know the diagonal length of the square. The diagonal is the line that runs from one corner, to the opposite corner. The diagonal is calculated by multiplying the length
of the side by the square root of 2, a.k.a. _Pythagoras' constant_.
* diagonal = side * sqrt(2)

With the diagonal calculation complete, we can use a formula to calculate the area:
* Area = (diagonal * diagonal) / 2  (diagonal squared divide by 2)

It is possible that in our program there may be another object that wants to calculate the Area of our square many different times, so in order to do that efficiently we are going to store some information about our square in instance variables.  

What is something we can do to ensure we calculate the Area efficiently using this diagonal method? The diagonal of a square is a constant, as long as the size of the square doesn't change, the size of the diagonal will remain the same forever.  One improvement we can make to the progrma is to calculate the diagonal of the square as it's being constructed.  Remember that we the programmers are in control of how the objects in our program are built and initialized, so we have a lot of freedom to do whatever we think necessary.  ___NOTE: When building constructor methods, have them be as lean and efficient as possible.  Try to do only the bare minimum inside.___  On to the changes.

1. Take the old constructor and modify it to also calculate and store the diagonal value of the square
    * We will introduce you to some of the built in Java classes that provide some functionality for you.
    * In this case it's the [Math class](https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html)
1. Change the _getArea()_ method to use the diagonal calculation instead of length * width.

Here's our old constructor:
```java
// Here is the constructor of the Square class.  The default constructor creates a square with length 2
    Square(){
        m_sideLength = 2;
    }
```
In the [Math class](https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html) you'll see in the documentation there are some well known things if you're familiar with some basic math principles. Notice in the __Field Summary__ section, there are some variables that are accessible for you to use in your calculations (namely Pi and E).  ___NOTE: We will learn more about class variables later in this lesson.___  For now just know these are __class__ variables, not __instance__ variables like the ___m_sideLength___ variable we are using in our own class/objects.

You'll also notice the other section __Method Summary__ where there are some mathematical functions that you should be familiar with.  Some of the common ones are absolute value (_abs_), square root (_sqrt_), exponentiation like x^y (_pow_), amongst others.  

This is nice that we don't have to re-invent the wheel in creating these functions.  As a programmer, we typically want to write as little code as possible in order to make our program work. The less code we write, the fewer bugs we create!

Let's take care of our code changes now, back to the constructor.  Let's make the changes to store our diagonal value.

```java
// Here is the constructor of the Square class.  The default constructor creates a square with length 2
    Square(){
        m_sideLength = 2;
        m_diagonal = m_sideLength * Math.sqrt(2);
    }
```

That is enough to take care of step one above. Simple when we can use other people's code right?

On to the next step, fixing our _getArea()_ method to use the new calculation. We are going to use a new concept here called ___Local___ variables to get the job done.  A local variable is one that exists only between the __{__ and the __}__ characters. Once that code stops executing, the variable no longer is in scope (alive), and therefore can't be used. 
```java
    int getArea(){
        // local variable
        int sqArea;

        // Initialize our sqArea variable to the actual area of the square using our formula from above
        // Area = diagonal squared divide by two
        // Math.pow takes the first argument, and raises it to the power of the second argument and returns the result. We use 2 to square the value of the diagonal, and divide that result by 2.
        sqArea = (int)Math.pow(m_diagonal, 2) / 2;

        // this could have been written like this:
        // sqArea = (m_diagonal * m_diagonal) / 2;

        // Return the calculated value to the caller of the method.
        return sqArea;
    }
```

Let's see how we did.  At this point you should save your file, compile it and run using the same steps we have used in the other lessons.

    > javac ShapeMain.java
    
    > java -cp . ShapeMain
    * You should see output like the following:
    ```
        My Square's Properties
        Area      : 4
        Perimeter : 8 
    ```

You should be asking yourself, _"Why did we just make the change?  We are literally doing the same thing as before.  What was the point?"_ The main point is to show you that no matter the design choice, the most important lesson is to write code that works. Getting it perfect the first time doesn't matter, getting it working is 90% of the solution. The way that you choose to make it work is generally the right decision, don't get lost searching for perfection. Perfection can often be the enemy of progress.

So far, there isn't much useful that our program completes right? That is because our square doesn't really do anything useful.  While we aren't going to get to that point yet, let's at least get to a point where we can get our program to have a less of a static feel, and can be more customizable as it runs.


## Methods
Getters, Setters, Constructors

## Variables
Class vs. Instance variables, track state of object over time.

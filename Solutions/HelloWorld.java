/**
 * The HelloWorldApp class implements an application that
 * simply prints "Hello World!" to standard output.
 */

 /**
  * Not these lines are preceded by special symbols, the characters
  * indicate these are comments.  Comments are text in a file that helps
  * other programmers understand what is happening, but don't 
  * actually affect the execution.
  *
  * These multi-line comments start with a /*, and end with a * /
  * Any characters in between those two sets of characters will be
  * part of the comment
  */

  // Comments can also be on a single line, preceded by two '/' characters

  /**
   * Comments should be used to tell a message to other people looking
   * at your code, or for yourself weeks and months later when you have 
   * forgotten why you wrote what you wrote.
   */
  
// Here is where the program actually starts, each Java program must 
// run inside a Class file. One defines a class file by using special
// keywords and characters: class and {
// The class is comprised of all statements in between the first { and 
// the last }
//
// To define a class, just use the keyword class and give it a name, any
// name you choose will be fine as long as a class of the same name
// doesn't already exist. The convention for naming a class is to 
// capitalize the first character, and any subsequent words in the 
// class name.  Notice that while together with no spaces, the words
// Hello and World are both capitalized. This isn't a requirement to work,
// it is just a convention that is followed by Java developers.
class HelloWorld {

    /**
     * Each Java program must implement a special method, declared in a
     * special way. This method must be declared as public static void
     * and will have a parameter list with the name 'args'. Methods and 
     * variables will be covered in Lesson 1, so don't worry so much about
     * that right now. Just know, that for a Java program to run, at some
     * point there has to be a class that is the 'main' method which will 
     * be the starting point of the method.
     */
    public static void main(String[] args) {
        /**
         * The method starts with the first '{' character, and ends with
         * a matching, closing '}' character.
         * 
         * In between those two characters, each statement will be executed
         * in order from top to bottom.
         */

        // Use the Java language's capability to display the string.
        System.out.println("Hello World!"); 
    } // This is the end of the main method

} // This is the end of the HelloWorld class

# Lesson 0 -- Hello World

First things first; why start with zero instead of one?  Easy, computers start counting at zero. When we start things in natural language, the first item is spoken of is number 1, in computers this isn't true. For example, given the array of values: [4, 5, 6] the first value is '4'. Value '4' is index '0', value '5' is index '1', and value '6' is index '2'. As you start programming there will be _many_ mistakes you make that are based on this principle alone. So remember this:  __In computer science, and more importantly in computing, counting starts at ZERO, not one__.

Second things second; why is the lesson named _Hello World_? When learning a programming language, the first things is to figure out how to write the string __"Hello World"__ to the screen. In order to do that, you generally have to understand the basic constructs of the language, which is what we're going to do here.

We are learning the Java programming language in these tutorials, so the first step is to install the language components needed to run a java program. Java installations have two different fundamental types, a JRE (Java Runtime Environment) or a JDK (Java Development Kit). The JRE is the minimum number of components needed to __RUN__ a java program, the JRE will not provide the ability to __DEVELOP__ java programs. In order to __DEVELOP__ a java program (which is what we want to do) you need to install a JDK. For FIRST robotics programming, they require that JDK __version 8__ be installed. When we go to the Internet to download that, we will look for the most recent version of Java available that starts with version 1.8.X (where X is the latest minor release).

1. [Install the JDK](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) -- Follow Oracle's instructions for your system
    * Note if you're not sure whether to install the 64-bit or the 32-bit version, choose 64-bit first, most systems will run the 64-bit version.
1. __Create a Source File__
    * This requires a text editor. All major operating systems come with one, Windows comes with Notepad, TextEdit on OSX, Nano or Vim on Linux, etc. Those all work just fine for the 'Hello World' but you'll probably want something more robust for actual devlopment. Check out the [miscellaneous section](Miscellaneous/README.md) for more information on text editors and development environments.
1. __Compile the Source File Into a .class file__
    * Before a program can be run, the source code written must be translated into something a computer can execute. This step is called compilation. Often times with robust editors such as Eclipse, Netbeans, or Jetbrains the Java compilation step happens automatically. However, in this tutorial we leave it as a separate step to highlight what is happening.
1. __Run the Program__

## Create a Source File

1. Open your text editor, for this example we will stick with Notepad on Windows, but any one will work.  Click __Start__ -> __Programs__ -> __Accessories__ and open Notepad.

1. Open your terminal program, for Windows this is _cmd.exe_. Click __Start__ -> Run -> cmd.exe
    * From the command line type __javac__ and hit enter. If you get an error related the command not being found then you need to go back through the first step above where you install the Java JDK. Make sure you follow each step all the way through, to include any steps related to ensuring that the Java tools are properly in your PATH variable.
    * Take note that upon starting your terminal, you are sitting at a prompt with an absolute path to a directory on your file system. This path is often referred to as your ___HOME___ directory.

    Before going too far, a couple of things that you need to know:
    * Java source files are case sensitive. This means that 'test' and 'Test' are not the same thing, they will be treated as two separate things. This becomes very important to understand when we start naming things in our program.
    * The file name should match the name of the class being defined in the file. This will become more clear as you go further, but it is important. _The file name should match the class being defined_.

1. Create a class called HelloWorld by entering the following code 
    ```java
    /**
    * The HelloWorldApp class implements an application that
    * simply prints "Hello World!" to standard output.
    */
    class HelloWorld {
        public static void main(String[] args) {
            // Display the string.
            System.out.println("Hello World!"); 
        }
    }
    ```
1. Save the file with the name __HelloWorld.java__
    * Click File -> Save As -> and type HelloWorld.java in the filename box.  Make sure that the PATH or folder chosen for the destination is your ___HOME___ directory you saw above in the step where you opened the terminal/shell.
    * Pay attention to the full path (folder location) where you saved the file, you will need it for the next step

1. Compile the HelloWorld.java file
    * From your terminal/shell you opened previously run the following command:
        > javac HellowWorld.java
    * If you don't see any errors, the compilation is successful.  From your command prompt, if you type the command ___dir___ and hit enter, you should see a directory listing that includes both the _HelloWorld.java_ file, and a new file created by the compiler _HelloWorld.class_.

1. Run your newly compiled file
    * Execute the following command:
        > java -cp . HelloWorld
    * You should see the text _Hello World!_ print to the screen.
    * If you don't see that text Oracle provides some troubleshooting steps for [the most common problems for beginners](https://docs.oracle.com/javase/tutorial/getStarted/problems/index.html)


# The Breakdown
Now that you have successfully run your first Java program, the next question is "Now what?". HelloWorld programs don't teach you how to write functional code, they simply teach you enough to get the environment setup and get your first code executing. This section will talk about the important components of the Java language that new programmers should understand. 

First, here's the snippet of code again:
```java
    /**
    * The HelloWorldApp class implements an application that
    * simply prints "Hello World!" to standard output.
    */
    class HelloWorld {
        public static void main(String[] args) {
            // Display the string.
            System.out.println("Hello World!"); 
        }
    }
```

Below is the same class implementation, but with annotations to explain some of the details in the example code.

The full file can be found [in the solutions directory of this tutorial](../Solutions/HelloWorld.java)

```java
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
```
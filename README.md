# Stonque :rocket:
![Stonque Logo](/img/stonque.jpg)

## Objectives
* Implement a given API
* Evaluate and determine an appropriate data structure to use
* Make use of generics and iterators
* Meet performance guidelines


## Collaboration policy
Please see the syllabus for the full policy. This course permits many forms of collaboration, including with course staff and classmates. However, you must be careful to collaborate only as authorized below. If you get stuck, check out code examples from the CSCI 223 textbook, or post on Discord in the #495 channel (without revealing your solutions), DM the course staff, or visit tutoring.

Activity	| Course staff	| Classmates/others	| CSCI 495 graduates
--|--|--|--
Discuss concepts	| ✔	| ✔	| ✔
Acknowledge collaboration	| ✔	| ✔	| ✔
Expose solutions to	| ✔	| no	| ✔
View solutions from	| no	| no	| no
Plagiarize code from	| no	| no	| no

## Problem Description
A Stonque is an abstract data type (ADT) I made up. It is like a stack, in that it implements push, pop, and peek. But it is like a queue in that it implements enqueue. But it does not implement dequeue. Create a generic, abstract data type Stonque that implements the following API (verbatim). I recommend copy/pasting to avoid typos.

```java
public class Stonque<Item> implements Iterable<Item> {
   public Stonque()                    // construct an empty Stonque
   public boolean empty()              // is the Stonque empty?
   public int size()                   // return the number of items in the Stonque
   public void push(Item item)         // add the item to the front/top of the Stonque
   public void enqueue(Item item)      // add the item to the back/end of the Stonque
   public Item pop()               	   // remove and return the item from the front/top
   public Item peek()                	 // return the item from the front/top but do not remove
   public String toString()            // returns a string of all the items separated by ‘ -> ‘
   public Iterator<Item> iterator()    // return an iterator over items in order from front to end
   public static void main(String[] args)   // unit testing (required)
}
```

## Getting started
Open `src/main/java/edu/citadel/Stonque.java` and add your code to the main method. To run your main method locally, enter the run and debug menu on the left, or right-click the main method and select `Run Java`.

To run the test cases locally, open a terminal and type `mvn test`. Alternatively, you can open the file `src/test/java/edu/citadel/StonqueTest.java` and click the play buttons. You can review the tests in this file, but do not modify any file other than `Stonque.java`.

## Special cases
Throw the specified exception for the following corner cases:
* Throw a `java.util.NoSuchElementException` if the client calls `pop()` or `peek()` when the Stonque is empty.
* Throw a `java.util.NoSuchElementException` if the client calls the `next()` method in the iterator when there are no more items to return.
* Throw a `java.lang.UnsupportedOperationException` if the client calls the `remove()` method in the iterator.

## Unit testing
Your `main()` method must call each public constructor and method directly and help verify that they work as prescribed (e.g., by printing results to standard output). Your main method will not be tested by the auto-grader.
Performance requirements

Your Stonque implementation must support each Stonque operation (including construction) in **constant worst-case time**. A Stonque containing n items can use at most a **linear of memory**, including the iterator. Additionally, your iterator implementation must support each operation (including construction) in **constant worst-case time**.

## Design defense
Be prepared to write a substantive paragraph on what data structres and strategies you chose and why you chose them.

## Submission requirements and collaboration policy
* You may discuss the assignment and strategies for solving it with classmates, but you may not view/share anyone’s code.
* Your code must be in a Java file called Stonque.java in the default package (i.e. no package declaration at the top).
* Add a comment block at the top of your code with your name(s), date, and assignment information. List any resources or collaborators here.
* Submit your code before the deadline. You may re-submit multiple times, but you should be testing your code first in your own client class.
* You can get partial credit if your code compiles. Failing test cases will output simple clues on the results, but it is your job to debug your code, not the auto-grader.

## Q and A for advice
* Develop unit tests as you write each method and constructor to allow for testing. As an example for Stonque, you know that if you call enqueue() with the numbers 1 through n in ascending order, then call pop() n times, you should see the numbers 1 through n in ascending order. As soon as you have those two methods written, you can write a unit test for these methods. Find similar strategies for other methods.
* Test intermixed sequence of operations. Sometimes you want to test two methods in isolation, as above. But, you also need to make sure that all of the methods work together with one another.
* Test your iterator. Test that multiple iterators can be used simultaneously and operate independently of one another. 
* Make sure to test what happens when your data structures are emptied. A common bug is for something to go wrong when your data structure goes from non-empty to empty and then back to non-empty. Make sure to include this in your tests.
* Don’t rely solely on the autograder for debugging. Write your own unit tests; it’s good practice in this course and beyond.
* Should I use arrays or linked lists in my implementations? In general we don’t tell you how to implement your data structures—you can use arrays, linked lists, or maybe even invent your own new structure, provided you abide by the specified time and space requirements.
* Can I call external library functions (other than those that are specifically permitted)? You will receive a substantial deduction if you do this. The goal of this assignment is to implement data types from first principles, using resizing arrays or linked lists.
* Can I add extra public methods to the Stonque API? Can I use different names for the methods? No, you must implement the API exactly as specified. You may add private helper methods if you must.
* What should my Stonque iterator do if the Stonque is structurally modified at any time after the iterator is created (but before it is done iterating)? You don’t need to worry about this in your solution. An industrial-strength solution (used in the Java libraries) is to make the iterator fail-fast: throw a java.util.ConcurrentModificationException as soon as this is detected.
* Can a nested class have a constructor? Yes.
* Will I lose points for loitering? Yes. See p. 137 of the CSCI 223 textbook for a discussion of loitering. Loitering is maintaining a useless reference to an object that could otherwise be garbage collected.

## Possible progress steps
1. Getting started. Review generic stacks and queues with iterators from your previous coursework. Cite any sources that help you.
2. Make sure you understand the performance requirements for Stonque. They are summarized in the table below. Every detail in these performance requirements is important. Do not proceed until you understand them.
  * Non-iterator operations		Constant worst-case time
  * Iterator constructor		Constant worst-case time
  * Other iterator operations	Constant worst-case time
  * Non-iterator memory use	Linear in current # of items
  * Memory per iterator		Constant
3. Decide whether you want to use an array, linked list, or your own data structure. This choice should be made based on the performance requirements discussed above. Make sure that your memory use is linear in the current number of items, as opposed to the greatest number of items that has ever been in the data structure since its instantiation. If you’re using a resizing array, you must resize the array when it becomes sufficiently empty. You must also take care to avoid loitering anytime you remove an item.

## Testing and Submission
When you think you are done, commit your changes to GitHub to trigger the autograder. You can do this on the terminal, or using the Source Control menu option to the left (recommended). You do not need to create a branch or pull request; just commit your changes and push/synchronize them.

If you open the assignment page on GitHub.com you will see the results of your submission. If the tests pass locally when you run `mvn test`, they should also pass there with a little green checkmark.

/*
* srhodes17@georgefox.edu
* Program 2
* 2019-2-13
* */

package ProgrammingAssignment

import scala.io.StdIn.readLine
import scala.util.Random

/**
  * This is a NumberGuessingGame Object
  */

object NumberGuessingGame
{

  def main(args: Array[String]): Unit =
  {
    println("Welcome to the Number Guessing game in Scala!")
    println()

    while (true)
    {
      // variable initialized

      var smallest = 1;
      var biggest = 100;

      // generate number btw 1-100
      var aNumber = new Random().nextInt(100) + 1
      var correct = false
      var guesses = 0;

      /*
      * prompt the user to input data and keep letting the users know to input
      * data as long as they are wrong
      *
      * */
      while (!correct)
      {
        print("Guess a number between " + smallest + " and " + biggest + ": ")

        //
        var input = readLine()


          try
          {

            val anInput = input.toInt
            guesses = guesses + 1

            // After the user failed to input proper value
            if (anInput < smallest || anInput > biggest)
            {
              println("That is not a valid guess.  Try again.")
              guesses = guesses - 1
            } // congratulate the user with its right guess
            else if (anInput == aNumber)
            { // give the user the number of guesses he took
              println("You guessed it!  It only took " + guesses + " guesses.")
              correct = true
              println()
              print("Do you want to play again? [Y/N]: ") // asking the user if he want to play again
              var playAgain = readLine()
              if (playAgain == "N" || playAgain == "n")
              {
                sys.exit() // System function calling exit
              }
            }
            else
            {  // Giving feed back to the user about whether its guess was too low or high
              if (anInput < aNumber)
              {
                smallest = anInput + 1
                println("Too low!  Try again.")
              }
              else
              {
                biggest = anInput - 1
                println("Too high! Try again.")
              }
            }
          }
          catch
          {
            // Let user know of invalid guess
            case ex: NumberFormatException => {
              println("That is not a valid guess.  Try again.")
              //guesses = guesses - 1
              }

          }

      }

    }
  }
}

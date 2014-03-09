===================
Rock-Paper-Scissors
===================

What is it?
-----------

This is a Rock-Paper-Scissors game written in Java. The game is played through
the Java console. It accepts 4 kinds of inputs: (r) Rock, (p) Paper, (s) Scissors
and (q) to quit the game. The user always has 40% probability of winning.


User Inputs
-----------------------

- (r) Rock

	Assigns user move as Rock.

- (p) Paper

	Assigns user move as Paper.

- (s) Scissors

	Assigns user move as Scissors.

- (q)

	Exits the program.

Note: Any other user input is not accepted by the program.

Implementation
--------------

- gameStatus()

	The gameStatus function generates a weighted result where the User has 40%
	probability of winning each round. An array is created with the appropriate
	weight distribution. Then a result is returned with the Java rand function.
	Math.random() is not used because it is less efficient and more biased than
	the Rand function. Math.random() also requires nearly twice the processing
	power.

- computerMove(...)

	Generates a computerMove depending on result and user input. 


Version
-------

0.1

Contacts
--------

Author: Mohd Irteza

Email: irteza1@illinois.edu

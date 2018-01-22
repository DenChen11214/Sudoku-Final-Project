# Sudoku-Final-Project

Usage:
1. Run the java file MenuGui.java by running 
"javac MenuGui.java" and "java MenuGui" in the terminal
2. Once the window pops up, choose the difficulty and enter an integer for the seed if you want
3. Press the play button

Buttons:
1. Play - creates the puzzle gui
2. Check - tells the user whether or not the board is the same as the solution
3. Hint - fills in one of the empty cells with the correct corresponding number
4. Solution - displays the solution onto the grid
5. Back to Menu - brings back the menu and hides the puzzle
6. Reset - clears the whole board except for the initial puzzle

How to Play:
The goal of the puzzle is to fill in all the numbers so that each row, column, and box has the numbers 1-9 with no repeats.

Milestones:
* Making the menu gui have the comboBox and play button
* Make the puzzle Gui with 81 textFields as a grid
* Created files with pre-made puzzles and solutions
* Implemented the files into the puzzleGui (displaying the numbers in the textField)
* Have the program choose a puzzle by random
* Included check and reset buttons on our puzzleGui
* Implemented a difficulty system
* Created a hint button which will give you a number that was previuosly blank on the puzzle
* Created a grid in the puzzle to make it more presentable
* Made the gui keep its shape when it is resized
* Created a seed that a user can input
* Removed the file reading system and created back-tracking to create puzzles

Bugs
* The numbers in the puzzle do not resize like other elements of the puzzle
* There is no seed shown if the user never inputted one


ClojureExperiment
=================

Working on programming assignments to learn clojure. Typically 
I write each program in LISP style then using clojure's tail
recursion. Features a functional recursion-based game (3 of a crime).

Problems Solved (so far)
--
* factorial 
* power function
* lists
    * finding missing element (two lists)
    * binary search
    * maximum value
    * merge (two sorted lists)
    * find missing element using binary search
    * permutations
      * lazy (from stackoverflow)
      * my approach (not performant)
       
A Functioning Functional Game
--

The game namespace features a full spy-themed *functioning fucntional* game, "Three of a Crime." 
Where 3 double-agents are selected from a group of 7 characters. 5 Characters are displayed and 
the player is told how many of the displayed characters are double agents. Through deduction you 
can determine who the double agent is and burn them - BUT - if you guess wrong, you become MIA. 
Once all double agents are detected or all players are MIA the game ends.


Usage 
---
    brew install leiningen
    lein run

#Misc
For all projects and source code under this repository,
* Author: Kenshin Himura *(Sudarsan Balaji)*
* License: *GNU GPL v3* (see COPYING.txt)
* ReadMe Version: 1.1

##Description
After thinking about it a while, I finally got it. There are tons of small things we do, worth showing to the world that we do know how to do those things, but we can't showcase them as a big project. You know, like, single-file projects? Still, they need their own explanations and readme's.

So, here we go. Misc, a project repository which showcases my varied, small-but-significant projects. (Click the headings to view the corresponding source)

##Projects

###[ILIFO (Intelligent LIne FOllower)](ILIFO.cpp)
C++ code to do black box system identification for determining the mathematical model of an AI level 3 line follower using a 7-input, 6-output perceptron. Got the confidence to work on this after [TWILP](https://www.github.com/kenshinthebattosai/TWILP) was successful.

###[Multi-Threading](MTTest.java)
My first attempt at trying out multi-threading in java. Using nested classes, and finding the minimum of a large array using multi-threading was indeed a fun project.

###[Design and Simulation of a Robotic Hand](RoboticHand.oxps)
An XPS document containing the design of a robotic hand (simulated using Workspace 5 Demo). As Workspace 5 only allows for serial manipulators, a complete robotic hand having 5 fingers as 5 end-effectors could not be modelled, as it will be a parallel manipulator. Hence the design was stopped with the Robotic Hand having a thumb alone. It is plain to note that the other fingers may be modelled the same way.

###[A Solution to N-Queens Problem using Simulated Annealing](NQueensSolutionGenerator.java)
Simulated Annealing (SA) is an AI technique which can be used in a variety of scenarios. It has been used to solve a generic n-Queens Problem. An n-Queens Problem is the problem of placing n queens on an nxn board such that no queen can capture any other queen in its immediate move according to the rules of chess. Using SA, the written Java program can solve the n-Queens problem for upto n=2,147,483,647 (which is simply the upper limit of signed integers in java), and display the result both graphically and using row indices from 0 to n in columns from 0 to n. A sample output is present in [nQueens.sample](nQueens.sample)
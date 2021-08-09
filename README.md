# Car Sequencing Problem solving with Constraint Programming approach and Choco Solver

>This project introduces Car Sequencing Problem (CSP) and comes up with mathematical model formulated as a constraint satisfaction problem and then, develop the resulting model with the Java solver named “Choco Solver” to show the way and how of approach in Constraint Programming.

## How to use the application ?

<ol>
<li>Clone the project on your machine with :<br/>
<pre><code>
git clone https://github.com/zakariamejdoul/csp_project.git
</code></pre>
</li>
<li>The program must be run from the main class file named <strong>Main.java</strong>.</li>
<li>There are already three instances of the problem, choose one and comment out the objects of the other instances.
<pre><code>
int[] p = {1, 2, 1, 2, 1};
int[] q = {2, 3, 3, 5, 5};
int[] demand = {1, 1, 2, 2, 2, 2};
int[] demand2 = {2, 2, 3, 2, 2, 4};
int[] demand3 = {3, 1, 2, 4, 3, 3, 2, 1, 1, 2, 2, 1};
int[][] r = {
        {1, 0, 1, 1, 0},
        {0, 0, 0, 1, 0},
        {0, 1, 0, 0, 1},
        {0, 1, 0, 1, 0},
        {1, 0, 1, 0, 0},
        {1, 1, 0, 0, 0},
};
int[][] r2 = {
        {0, 1, 0, 0, 0},
        {1, 0, 1, 0, 1},
        {1, 1, 0, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 0, 1},
        {0, 0, 0, 1, 0},
        {1, 1, 1, 0, 0},
        {1, 0, 0, 1, 0},
        {1, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 1, 1, 0, 0},
        {1, 1, 0, 1, 0},
};
//POVMainModel povModel = new POVMainModel(10, 5, 6, demand, p, q, r);
//POVMainModel povModel = new POVMainModel(15, 5, 6, demand2, p, q, r);
POVMainModel povModel = new POVMainModel(25, 5, 12, demand3, p, q, r2);
</code></pre>
</li>
<li>Run the class <strong>Main.java</strong>.</li>
<li>Enjoy the results !</li>
</ol>
<br/>

> **Results include the optimal sequencing of the car lot from the instance, each car in the sequencing with its class and required options, we also show minimal statistics of the model execution as showed in the first line of the following results.**

<pre><code>
Model[CSP Resolution with Choco-Solver], 1 Solutions, Resolution time 4,795s, 17702 Nodes (3 691,5 n/s), 35341 Backtracks, 0 Backjumps, 17678 Fails, 0 Restarts

=========== CSP Resolution with Choco-Solver ===========

			Required Options
----------------------------------------------------------
Class		        1	2	3	4	5	
----------------------------------------------------------
11			0	1	1	0	0	
4			0	1	0	1	0	
6			0	0	0	1	0	
5			0	1	0	0	1	
1			0	1	0	0	0	
10			0	0	1	0	0	
12			1	1	0	1	0	
1			0	1	0	0	0	
2			1	0	1	0	1	
4			0	1	0	1	0	
1			0	1	0	0	0	
9			1	0	1	0	0	
4			0	1	0	1	0	
5			0	1	0	0	1	
10			0	0	1	0	0	
3			1	1	0	0	0	
6			0	0	0	1	0	
7			1	1	1	0	0	
5			0	1	0	0	1	
8			1	0	0	1	0	
11			0	1	1	0	0	
3			1	1	0	0	0	
6			0	0	0	1	0	
7			1	1	1	0	0	
4			0	1	0	1	0	 
</code></pre>
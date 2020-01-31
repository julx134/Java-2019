This project implements the concepts for LinkedLists.

Each digit is represented as a Counter object. A Counter object has an optional left neighbour
which is also a Counter object. (The absence of a left neighbour is indicated with the keyword null.
The important methods to implement are getCount() and increment().


If there is no left neighbour, the count is the same as the digit.


If there is a left neighbour, the count is the sum of the digit and the modulus times the count of the left
neighbour.


The increment() method increment's the Counter's digit and, if it reaches its maximum (modulus)
value, it is reset to zero. Furthermore, if there is a left neighbour and if the Counter has rolled over, its left
neighbour should be incremented as well.

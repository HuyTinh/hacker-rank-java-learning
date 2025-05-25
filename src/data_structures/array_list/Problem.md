Sometimes it's better to use dynamic size arrays. Java's [Arraylist](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html) can provide you this feature. Try to solve this problem using Arraylist.

You are given lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in position of line.

Take your input from System.in.

**Input Format**  
The first line has an integer . In each of the next lines there will be an integer denoting number of integers on that line and then there will be space-separated integers. In the next line there will be an integer denoting number of queries. Each query will consist of two integers and .

**Constraints**

Each number will fit in signed integer.  
Total number of integers in lines will not cross .

**Output Format**  
In each line, output the number located in position of line. If there is no such position, just print "ERROR!"
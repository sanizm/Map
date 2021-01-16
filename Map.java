
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
 READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
 the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name:Saniz Shahbuddin momin
Student Number:217584749
Course Section:B
*/

package Assignment1;                     //Hello TA, below is my code short and simple.
import java.util.*;                     // I will add comments short and easy to understand just in case there is any line which is hard to understand.
					                   //  ThankYou for your time.
                                      //   Before you proceed i would like to clarify that i will use following symbols as in comments.
                                     //    startRow --> S.R       destRow --> D.R      startCol --> S.C     destCol --> D.C
                                    //     SouthWest-->S.W   SouthEast-->S.E   NorthWest-->N.W NorthEast-->N.E
/*There are many ways to implement recursive method tosoutheast,southwest,northeast,northwest so my way actually goes from final points to starting points but coordinates
 are added in reverse order for example if i am at N.W and wish to go S.E my code will travel from S.E to N.W but will be added in reverse order such that you will see the
final path going from N.W to S.E*/ // HOPE THIS MAKE SENSE :)
/**                                  
 * 
 * @author EECS2030 Team   
 *
 */

public class Map {
	boolean[][] map;
	private int row;
	private int column;

	/**
	 * This is the constructor that constructs the city map, which is a grid of row
	 * by column.
	 * 
	 * @param row    is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) {
		// Please implement the constructor
		this.row = row;                       // Constructor assigns the
		this.column = column;                // value of row and column from client
	}

	/**
	 * This method checks the correctness of the input parameters. If the
	 * preconditions are not met an exception is thrown, otherwise depending to the
	 * direction, it calls one of the four recursive functions of goSouthWest,
	 * goSouthEast, goNorthWest and goNorthEast.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0,
	 *      N) if N is the number of east-west streets and [0, M) if M is the number
	 *      of north-south streets.)
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath(int startRow, int startCol, int destRow, int destCol, String path) {
	/*This first if Statement is written in two lines line 71 and line 72
    so this first statement checks all the condition such that user is not allowed to enter coordinates which are out of the grid
    Or user is not allowed to enter a non empty string otherwise we wont get the desired output.*/		
		if (startRow <= -1 || startRow >= this.row || startCol <= -1 || startCol >= this.column || destRow <= -1
				|| destRow >= this.row || destCol <= -1 || destCol >= this.column || path != "") {
			throw new IllegalArgumentException("Input is invalid");
		} else if (startRow >= destRow && startCol >= destCol) {//If valid coordinates are entered and one wishes to goSouthWest S.R and S.C has to be >= D.R and D.C
			return path = goSouthWest(startRow, startCol, destRow, destCol, path);
		} else if (startRow >= destRow && startCol <= destCol) {//If coordinates are valid and wishes to goSouthEast S.R has to be >= D.R and S.C has to be <= D.C
			return path = goSouthEast(startRow, startCol, destRow, destCol, path);
		} else if (startRow <= destRow && startCol <= destCol) {//If coordinates are valid and wishes to goNorthEast S.R has to be <= D.R and S.C has to be <= D.C
			return path = goNorthEast(startRow, startCol, destRow, destCol, path);
		} else {//If coordinates are valid and no above condition is satisfied means that person wants to goNorthWest
			return path = goNorthWest(startRow, startCol, destRow, destCol, path);
		}
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 *
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and
	 *      <code> startCol >= destCol </code>
	 */

	private String goSouthWest(int startRow, int startCol, int destRow, int destCol, String path) {
/*I Wrote this method short and simple The way this method is called recursively is bit different
First the method is called again such that it coordinates are added up from final points to start points and are added to string in reverse manner
This way we get the desired output for example if you are at (9,9) and you want to go (4,4) than this code will run from (4,4) to (9,9) but its added to string reversely.*/
		
		if (startRow >= destRow && startCol >= destCol) {//This is the main if statement which ensures that if you want to go S.W starting points has to be >= destination points.
			if (startCol != destCol) {//Since starting points shouldn't be included in path this condition makes sure of that.
				path += goSouthWest(startRow, startCol, destRow, destCol + 1, path) + "(" + destRow + "," + destCol	+ ") ";//(D.C add up to go to S.C but inserted to path later).
			} else if (destRow != startRow) {//Since starting points shouldn't be included in path this condition makes sure of that.
				path += goSouthWest(startRow, startCol, destRow + 1, destCol, path) + "(" + destRow + "," + startCol + ") ";//(D.R add up to go to S.R but inserted to path after every method call)
			}
		}
		return path;// path is returned.
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and
	 *      <code> startCol <= destCol </code>
	 */
	private String goSouthEast(int startRow, int startCol, int destRow, int destCol, String path) {
/*This code is similar to goSouthWest except it goes to SouthEast with small changes made in the code
First the method is called than and to go South rows are added but to go east Columns are subtracted but string is added to path in reverse manner such it looks you go from N.W to S.E
for example if you are at (9,3) and wish to go (4,6) than row will be added from 4 to 9 and column will be subtracted from 6 to 3 but will be added to path after method is called
this way desired output is achieved.*/		
		if (startRow >= destRow && startCol <= destCol) {//This is the main IF statement which make sure you want to go to SouthEast
			if (startCol != destCol) {//Since starting points shouldn't be included in path this condition makes sure of that.
				path += goSouthEast(startRow, startCol, destRow, destCol - 1, path) + "(" + destRow + "," + destCol + ") ";//D.C is subtracted but inserted to path later
			} else if (destRow != startRow) {//Since starting points shouldn't be included in path this condition makes sure of that.
				path += goSouthEast(startRow, startCol, destRow + 1, destCol, path) + "(" + destRow + "," + startCol + ") ";//D.R is added but inserted to path later
			}
		}
		return path;//path is returned
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and
	 *      <code> startCol <= destCol </code>
	 */
	private String goNorthEast(int startRow, int startCol, int destRow, int destCol, String path) {
/*This code is similar to goSouthWest except it goes to NorthEast with small changes made in the code
First the method is called than to go NorthEast rows and columns both are subtracted 	
for example if you are at (4,3) and want to go (9,6) 9 is subtracted to 4 and 6 is subtracted to 3 but they are added to path in reverse manner such that it looks you go from S.W to N.E
this way we get desired output.*/		
		if (startRow <= destRow && startCol <= destCol) {//main IF statement which ensures you want to go northEast
			if (startCol != destCol) {//Since starting points shouldn't be included in path this condition makes sure of that.
				path += goNorthEast(startRow, startCol, destRow, destCol - 1, path) + "(" + destRow + "," + destCol + ") ";//D.C is subtracted but added to path after every call 
			} else if (destRow != startRow) {//Since starting points shouldn't be included in path this condition makes sure of that.
				path += goNorthEast(startRow, startCol, destRow - 1, destCol, path) + "(" + destRow + "," + startCol + ") ";// D.R is substracted but added to string after every call
			}
		}
		return path;// path is returned
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and
	 *      <code> startCol <= destCol </code>
	 */
	private String goNorthWest(int startRow, int startCol, int destRow, int destCol, String path) {
/*This code is similar to SouthWest except with small changes in the code.
First the method is called and to go west  Colums are added and to go North Rows are subtracted.
for example if you are at (5,7) and want to go to (6,9) 7 will be added to be added to 9 and 6 will be subtracted to 5;
This way we get the desired output	*/	
		if (startRow <= destRow && startCol >= destCol) {//This is the main IF statement which ensures that you want to go northWest
			if (startCol != destCol) {//Since starting points shouldn't be included in path this condition makes sure of that.(Row is added first)
				path += goNorthWest(startRow, startCol, destRow, destCol + 1, path) + "(" + destRow + "," + destCol + ") ";// D.C is added 
			} else if (destRow != startRow) {//Since starting points shouldn't be included in path this condition makes sure of that(than column is added).
				path += goNorthWest(startRow, startCol, destRow - 1, destCol, path) + "(" + destRow + "," + startCol + ") ";//D.R is subtracted.
			}
		}
		return path;// path is returned.
	}

	/**
	 * This method find a path from (startRow, startCol) to a border point of the
	 * city. Please note that the starting point should be included in the path.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the
	 *         city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */

	public String findPath(int startRow, int startCol) {
/*For this method since what's more important is to run away from police as fast as possible with many choices randomly such that if one path is blocked there are many other paths created
Line 233 checks which is the nearer exit from the location of the car. if its nearer to origin side a path exiting origin side is generated.
otherwise it goes to else statement and a path to north side is generated and its random every time the user runs the program.	*/	
		String path = "";// path will be made 
		if (startRow < this.row && startRow >= 0 && startCol >= 0 && startCol <= this.column) {//Main Statement which ensures car is inside the map
			if ((this.row - startRow) >= startRow || (this.column - startCol) >= startCol) {//read comment on line 228-230
				if (Math.random() < 0.5) {//Math.random helps generate random path every time the user runs program. 
					path += "(" + startRow + "," + startCol + ") " + findPath(startRow - 1, startCol);//prepares a path exiting south side if car is nearer to south
				} else {
					path += "(" + startRow + "," + startCol + ") " + findPath(startRow, startCol - 1);

				}
			} else {
				if (Math.random() < 0.5) {// Math.random generate random path every time user runs program this helps in getting random paths.
					path += "(" + startRow + "," + startCol + ") " + findPath(startRow + 1, startCol); // makes path going north side if car is nearer to north
				} else {
					path += "(" + startRow + "," + startCol + ") " + findPath(startRow, startCol + 1);

				}
			}
		}
		return path;//randomly generated path is returned.
	}

} // end of class

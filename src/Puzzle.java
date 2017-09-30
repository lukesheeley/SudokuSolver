import java.util.ArrayList;

/**Instances of this class represent 9x9 Sudoku puzzles.*/
public class Puzzle {
	
	/**True if the puzzle is solved, false otherwise.  As soon as solved is set to true
	 * the first time, the solved puzzle will be printed.*/
	private boolean solved;
	
	/**The grid you are filling out.  First index represents row, second index
	 * represents column.*/
	private ArrayList<ArrayList<Integer>> board;
	
	/**Lists that hold the possible values for the cells in a specific row.
	 * Row 0 is topmost and row 8 is bottommost*/
	private ArrayList<ArrayList<Integer>> posRow0;
	private ArrayList<ArrayList<Integer>> posRow1;
	private ArrayList<ArrayList<Integer>> posRow2;
	private ArrayList<ArrayList<Integer>> posRow3;
	private ArrayList<ArrayList<Integer>> posRow4;
	private ArrayList<ArrayList<Integer>> posRow5;
	private ArrayList<ArrayList<Integer>> posRow6;
	private ArrayList<ArrayList<Integer>> posRow7;
	private ArrayList<ArrayList<Integer>> posRow8;
	
	/**Lists that hold the possible values for the cells in a specific column.
	 * Column zero is leftmost and column 8 is rightmost.*/
	private ArrayList<ArrayList<Integer>> posCol0;
	private ArrayList<ArrayList<Integer>> posCol1;
	private ArrayList<ArrayList<Integer>> posCol2;
	private ArrayList<ArrayList<Integer>> posCol3;
	private ArrayList<ArrayList<Integer>> posCol4;
	private ArrayList<ArrayList<Integer>> posCol5;
	private ArrayList<ArrayList<Integer>> posCol6;
	private ArrayList<ArrayList<Integer>> posCol7;
	private ArrayList<ArrayList<Integer>> posCol8;
	
	/**Lists that hold the possible values for the cells in a specific 3x3 cell.
	 * Cell 0 is top left corner and cell 8 is bottom right corner, proceeding left
	 * to right with the numbering and then down to the next row, like a telephone.*/
	private ArrayList<ArrayList<Integer>> posCell0;
	private ArrayList<ArrayList<Integer>> posCell1;
	private ArrayList<ArrayList<Integer>> posCell2;
	private ArrayList<ArrayList<Integer>> posCell3;
	private ArrayList<ArrayList<Integer>> posCell4;
	private ArrayList<ArrayList<Integer>> posCell5;
	private ArrayList<ArrayList<Integer>> posCell6;
	private ArrayList<ArrayList<Integer>> posCell7;
	private ArrayList<ArrayList<Integer>> posCell8;

	/**Constructs a new puzzle to solve.  First parses the provided argument to
	 * create the board, then checks to see if it is solved and sets the "solved"
	 * field accordingly.  Next it sets up all the possible value lists and places them
	 * in the appropriate fields so that they overlap between rows, columns, and cells
	 * correctly.  Lastly, it checks the numbers the board starts with and sets the 
	 * possible value lists for such cells.*/
	public Puzzle(String inputPuzzle) {
		//Initialize board
		board = new ArrayList<ArrayList<Integer>>();
		
		//Initialize the elements of board
		board.add(new ArrayList<Integer>());
		board.add(new ArrayList<Integer>());
		board.add(new ArrayList<Integer>());
		board.add(new ArrayList<Integer>());
		board.add(new ArrayList<Integer>());
		board.add(new ArrayList<Integer>());
		board.add(new ArrayList<Integer>());
		board.add(new ArrayList<Integer>());
		board.add(new ArrayList<Integer>());
		
		//Copy the inputed puzzle into board
		for(int i = 0; i < inputPuzzle.length(); i++) {
			board.get(i/9).add(Character.getNumericValue(inputPuzzle.charAt(i)));
		}
		
		//Check if the puzzle is already solved in order to set the solved field correctly
		//Very important for the solve method
		checkIfSolved();
		
		//Initialize all the possible value lists
		posRow0 = new ArrayList<ArrayList<Integer>>();
		posRow1 = new ArrayList<ArrayList<Integer>>();
		posRow2 = new ArrayList<ArrayList<Integer>>();
		posRow3 = new ArrayList<ArrayList<Integer>>();
		posRow4 = new ArrayList<ArrayList<Integer>>();
		posRow5 = new ArrayList<ArrayList<Integer>>();
		posRow6 = new ArrayList<ArrayList<Integer>>();
		posRow7 = new ArrayList<ArrayList<Integer>>();
		posRow8 = new ArrayList<ArrayList<Integer>>();
		posCol0 = new ArrayList<ArrayList<Integer>>();
		posCol1 = new ArrayList<ArrayList<Integer>>();
		posCol2 = new ArrayList<ArrayList<Integer>>();
		posCol3 = new ArrayList<ArrayList<Integer>>();
		posCol4 = new ArrayList<ArrayList<Integer>>();
		posCol5 = new ArrayList<ArrayList<Integer>>();
		posCol6 = new ArrayList<ArrayList<Integer>>();
		posCol7 = new ArrayList<ArrayList<Integer>>();
		posCol8 = new ArrayList<ArrayList<Integer>>();
		posCell0 = new ArrayList<ArrayList<Integer>>();
		posCell1 = new ArrayList<ArrayList<Integer>>();
		posCell2 = new ArrayList<ArrayList<Integer>>();
		posCell3 = new ArrayList<ArrayList<Integer>>();
		posCell4 = new ArrayList<ArrayList<Integer>>();
		posCell5 = new ArrayList<ArrayList<Integer>>();
		posCell6 = new ArrayList<ArrayList<Integer>>();
		posCell7 = new ArrayList<ArrayList<Integer>>();
		posCell8 = new ArrayList<ArrayList<Integer>>();
		
		//Initialize and load a full possible value list
		ArrayList<Integer> posv = new ArrayList<Integer>();
		posv.add(1);
		posv.add(2);
		posv.add(3);
		posv.add(4);
		posv.add(5);
		posv.add(6);
		posv.add(7);
		posv.add(8);
		posv.add(9);
		
		//Create a possible value list for every space in the board and put them in the right places
		for(int posi = 0; posi < inputPuzzle.length(); posi++) {
			//Create a copy of the default possible value list
			ArrayList<Integer> posvtemp = new ArrayList<Integer>(posv);
			
			//Put the possible value list into the right row
			switch (posi/9) {
				case 0: 
					posRow0.add(posvtemp);
					break;
				case 1: 
					posRow1.add(posvtemp);
					break;
				case 2: 
					posRow2.add(posvtemp);
					break;
				case 3: 
					posRow3.add(posvtemp);
					break;
				case 4: 
					posRow4.add(posvtemp);
					break;
				case 5: 
					posRow5.add(posvtemp);
					break;
				case 6: 
					posRow6.add(posvtemp);
					break;
				case 7: 
					posRow7.add(posvtemp);
					break;
				case 8: 
					posRow8.add(posvtemp);
					break;
			}
			
			//Put the possible value list into the right column
			switch (posi%9) {
				case 0: 
					posCol0.add(posvtemp);
					break;
				case 1: 
					posCol1.add(posvtemp);
					break;
				case 2: 
					posCol2.add(posvtemp);
					break;
				case 3: 
					posCol3.add(posvtemp);
					break;
				case 4: 
					posCol4.add(posvtemp);
					break;
				case 5: 
					posCol5.add(posvtemp);
					break;
				case 6: 
					posCol6.add(posvtemp);
					break;
				case 7: 
					posCol7.add(posvtemp);
					break;
				case 8: 
					posCol8.add(posvtemp);
					break;
			}
			//Put the possible list value into the right cell
			if (posi/9 < 3) {
				if (posi%9 < 3) {
					posCell0.add(posvtemp);
				}
				else if (posi%9 < 6) {
					posCell1.add(posvtemp);
				}
				else {
					posCell2.add(posvtemp);
				}
			}
			else if (posi/9 < 6) {
				if (posi%9 < 3) {
					posCell3.add(posvtemp);
				}
				else if (posi%9 < 6) {
					posCell4.add(posvtemp);
				}
				else {
					posCell5.add(posvtemp);
				}
			}
			else {
				if (posi%9 < 3) {
					posCell6.add(posvtemp);
				}
				else if (posi%9 < 6) {
					posCell7.add(posvtemp);
				}
				else {
					posCell8.add(posvtemp);
				}
			}
		}
		
		//Check the board and update the possible value lists accordingly
		for(int ti = 0; ti < inputPuzzle.length(); ti++) {
			if (board.get(ti/9).get(ti%9) != 0) {
				switch (ti/9) {
					case 0: 
						posRow0.get(ti%9).clear();
						posRow0.get(ti%9).add(board.get(ti/9).get(ti%9));
						break;
					case 1: 
						posRow1.get(ti%9).clear();
						posRow1.get(ti%9).add(board.get(ti/9).get(ti%9));
						break;
					case 2: 
						posRow2.get(ti%9).clear();
						posRow2.get(ti%9).add(board.get(ti/9).get(ti%9));
						break;
					case 3: 
						posRow3.get(ti%9).clear();
						posRow3.get(ti%9).add(board.get(ti/9).get(ti%9));
						break;
					case 4: 
						posRow4.get(ti%9).clear();
						posRow4.get(ti%9).add(board.get(ti/9).get(ti%9));
						break;
					case 5: 
						posRow5.get(ti%9).clear();
						posRow5.get(ti%9).add(board.get(ti/9).get(ti%9));
						break;
					case 6: 
						posRow6.get(ti%9).clear();
						posRow6.get(ti%9).add(board.get(ti/9).get(ti%9));
						break;
					case 7: 
						posRow7.get(ti%9).clear();
						posRow7.get(ti%9).add(board.get(ti/9).get(ti%9));
						break;
					case 8: 
						posRow8.get(ti%9).clear();
						posRow8.get(ti%9).add(board.get(ti/9).get(ti%9));
						break;
				}
			}
		}	
	}
	
	/**Checks if this puzzle is solved and sets the "solved" field accordingly.*/
	public void checkIfSolved() {
		//Zeroes represent blanks.  If board contains at least one zero, the puzzle is not yet solved.
		if(board.get(0).contains(0) || board.get(1).contains(0) || board.get(2).contains(0)
				|| board.get(3).contains(0) || board.get(4).contains(0) || board.get(5).contains(0)
				|| board.get(6).contains(0) || board.get(7).contains(0) || board.get(8).contains(0)) {
			solved = false;
		}
		//If there are no zeroes in board, then there are no blanks and the puzzle is solved.
		else {
			solved = true;
		}
	}
	
	/**This method overrides Object's toString method so that when we solve
	 * the puzzle we can print it out in a readable and understandable format.*/
	@Override
	public String toString() {
		return "Puzzle Solved: " + board;
	}
	
	/**This method checks whether a given possible value list has an element
	 * whose sole element is the given number and, if so, removes that number from the
	 * other elements of the possible value list.  For example, checks if column 4 has
	 * a 9 in it, and if it does, takes 9 out of the possible value lists for the rest
	 * of column 4, as no number can appear twice in a column.*/
	public void hasXTrim(ArrayList<ArrayList<Integer>> pos, Integer x) {
		ArrayList<Integer> xarr = new ArrayList<Integer>();
		xarr.add(x);
		//if pos has [x] as an element, x is removed from all other elements of pos.
		if (pos.contains(xarr)) {
			for(int i = 0; i < pos.size(); i++) {
				if (i == pos.indexOf(xarr)) {
					continue;
				}
				else {
					pos.get(i).remove(x);
				}
			}
		}
	}
	
	/**This method runs hasXTrim for all possible values on a possible value list.*/
	public void hasXTrimAll(ArrayList<ArrayList<Integer>> pos) {
		for (int i = 1; i < pos.size() + 1; i++) {
			hasXTrim(pos, i);
		}
	}
	
	/**This method runs hasXTrimAll for all possible value lists repeatedly until
	 * no more trimming can be done.*/
	public void trimLoop() {
		ArrayList<ArrayList<Integer>> preTrim;
		boolean trimDone = false;
		//Trimming one possible value list could result in an element of the form [x],
		//in which case the other possible value lists that contain that element 
		//would need to be trimmed.  Therefore we have to run until nothing else
		//can be trimmed.
		while (!trimDone) {
			preTrim = copyPosBoard(board);
			hasXTrimAll(posRow0);
			hasXTrimAll(posRow1);
			hasXTrimAll(posRow2);
			hasXTrimAll(posRow3);
			hasXTrimAll(posRow4);
			hasXTrimAll(posRow5);
			hasXTrimAll(posRow6);
			hasXTrimAll(posRow7);
			hasXTrimAll(posRow8);
			hasXTrimAll(posCol0);
			hasXTrimAll(posCol1);
			hasXTrimAll(posCol2);
			hasXTrimAll(posCol3);
			hasXTrimAll(posCol4);
			hasXTrimAll(posCol5);
			hasXTrimAll(posCol6);
			hasXTrimAll(posCol7);
			hasXTrimAll(posCol8);
			hasXTrimAll(posCell0);
			hasXTrimAll(posCell1);
			hasXTrimAll(posCell2);
			hasXTrimAll(posCell3);
			hasXTrimAll(posCell4);
			hasXTrimAll(posCell5);
			hasXTrimAll(posCell6);
			hasXTrimAll(posCell7);
			hasXTrimAll(posCell8);
			fillInBoardAll();
			if (board.equals(preTrim)) {
				trimDone = true;
			}
		}
	}
	
	/**This method should take in a ROW of possible values, and will update the board
	 * as needed.  If a possible value list other than one of the posRowx lists is given,
	 * this method will throw everything off.  Row lists are required because the board
	 * is structured by rows.*/
	public void fillInBoard(ArrayList<ArrayList<Integer>> pos, Integer x) {
		//This loop looks for elements in pos that look like [value] and puts them into
		//the board if the corresponding cell in board was previously blank.
		for (int i = 0; i < pos.size(); i++) {
			if(pos.get(i).size() == 1 && board.get(x).get(i) == 0) {
				board.get(x).set(i, pos.get(i).get(0));
			}
		}
	}
	
	/**This method runs fillInBoard for all rows.  Conveniently eliminates having
	 * to worry about only passing rows as arguments, as it has no parameters.*/
	public void fillInBoardAll() {
		fillInBoard(posRow0, 0);
		fillInBoard(posRow1, 1);
		fillInBoard(posRow2, 2);
		fillInBoard(posRow3, 3);
		fillInBoard(posRow4, 4);
		fillInBoard(posRow5, 5);
		fillInBoard(posRow6, 6);
		fillInBoard(posRow7, 7);
		fillInBoard(posRow8, 8);
	}
	
	/**This method checks if there is only one cell represented by the given possible value 
	 * list that still contains the given integer and, if so, makes that the only possible
	 * value for that cell.*/
	public void onlyPosCell(ArrayList<ArrayList<Integer>> pos, Integer x) {
		int count = 0;
		int cell = 0;
		//this loop counts how many times x appears in the possible
		//value lists of pos.  If x is already in pos, (if pos contains [x] as
		//an element), then nothing will happen.  Otherwise, if x is in only one element
		//of pos, it will set that element to [x].  (if statement below).
		for (int i = 0; i < pos.size(); i++) {
			if (pos.get(i).size() > 1 && pos.get(i).contains(x)) {
				count++;
				cell = i;
			}
		}
		if (count == 1) {
			pos.get(cell).clear();
			pos.get(cell).add(x);
		}
	}
	
	/**This method runs onlyPosCell for all possible values on a possible value list.  It
	 * returns false if pos remained unchanged and true if pos was changed.*/
	public void onlyPosCellAll(ArrayList<ArrayList<Integer>> pos) {
		ArrayList<ArrayList<Integer>> preList = copyPosBoard(pos);
		for (int i = 1; i < pos.size() + 1; i++) {
			onlyPosCell(pos, i);
		}
		//If running onlyPosCell for any of the values results in progress, we need to trim
		//Say when running this method for posRow2, you are able to determine that the cell
		//in column 4 is 3.  3 will not be in any possible value lists of that row, but
		//the values in column 4 and cell 1 need 3 trimmed from them.
		if (!preList.equals(pos)) {
			trimLoop();
		}
	}
	
	/**This method runs onlyPosCellAll for all possible value lists, trimming as necessary.*/
	public void onlyPosCellBattery() {
		onlyPosCellAll(posRow0);
		onlyPosCellAll(posRow1);
		onlyPosCellAll(posRow2);
		onlyPosCellAll(posRow3);
		onlyPosCellAll(posRow4);
		onlyPosCellAll(posRow5);
		onlyPosCellAll(posRow6);
		onlyPosCellAll(posRow7);
		onlyPosCellAll(posRow8);
		onlyPosCellAll(posCol0);
		onlyPosCellAll(posCol1);
		onlyPosCellAll(posCol2);
		onlyPosCellAll(posCol3);
		onlyPosCellAll(posCol4);
		onlyPosCellAll(posCol5);
		onlyPosCellAll(posCol6);
		onlyPosCellAll(posCol7);
		onlyPosCellAll(posCol8);
		onlyPosCellAll(posCell0);
		onlyPosCellAll(posCell1);
		onlyPosCellAll(posCell2);
		onlyPosCellAll(posCell3);
		onlyPosCellAll(posCell4);
		onlyPosCellAll(posCell5);
		onlyPosCellAll(posCell6);
		onlyPosCellAll(posCell7);
		onlyPosCellAll(posCell8);
		fillInBoardAll();
	}
	
	/**This method returns an independent copy of the given possible value list or board.
	 * Iterating variable names may be misleading.  This method was originally written
	 * only to copy the board, but it later became useful to copy other 
	 * ArrayList<ArrayList<Integer>>'s as well, so the method was generalized.  When
	 * copying board, the row and col variable names make sense.*/
	public ArrayList<ArrayList<Integer>> copyPosBoard(ArrayList<ArrayList<Integer>> orig) {
		ArrayList<ArrayList<Integer>> copyList = new ArrayList<ArrayList<Integer>>();
		for (int row = 0; row < orig.size(); row++) {
			copyList.add(new ArrayList<Integer>());
			for (int col = 0; col < orig.get(row).size(); col++) {
				copyList.get(row).add(orig.get(row).get(col));
			}
		}
		return copyList;
	}
	
	/**This is the method that actually handles the logical solving of the puzzle.*/
	public void solve() {
		System.out.println(board);
		//This loop will continue trying to solve the puzzle until the whole board is filled.
		while (!solved) {
			//try trimming.
			trimLoop();
			//try onlyPos-ing.
			onlyPosCellBattery();
			System.out.println(board);
			checkIfSolved();
		}
		//While loop quit, so puzzle is solved.
		//Print out the solved puzzle.  This is the end of the program.
		System.out.println(this);
	}

	/**Puzzles that are inputed to be solved should be inputed as a string of digits
	 * The first 9 digits should be the first row in order, the second 9 digits
	 * should be the second row, etc.  Blanks should be represented by 0's.*/
	public static void main(String[] args) {
		//args[0] is the puzzle that we are requesting to be solved.
		String input = args[0];
		//Create a new Puzzle object with our input.
		Puzzle puzzle1 = new Puzzle(input);
		//Call the solve method of our newly created Puzzle object to solve it.
		puzzle1.solve();

	}

}

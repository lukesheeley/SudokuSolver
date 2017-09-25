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
	 * field accordingly.*/
	public Puzzle(String inputPuzzle) {
		//Initialize board
		board = new ArrayList<ArrayList<Integer>>();
		//Initialize the rows of the puzzle, which are the elements of board
		ArrayList<Integer> row0 = new ArrayList<Integer>();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		ArrayList<Integer> row3 = new ArrayList<Integer>();
		ArrayList<Integer> row4 = new ArrayList<Integer>();
		ArrayList<Integer> row5 = new ArrayList<Integer>();
		ArrayList<Integer> row6 = new ArrayList<Integer>();
		ArrayList<Integer> row7 = new ArrayList<Integer>();
		ArrayList<Integer> row8 = new ArrayList<Integer>();
		//Put these rows into the board
		board.add(row0);
		board.add(row1);
		board.add(row2);
		board.add(row3);
		board.add(row4);
		board.add(row5);
		board.add(row6);
		board.add(row7);
		board.add(row8);
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
		
		//use cases for rows and columns, and if statements inside the rows cases for the cells
		
	
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
		return "Puzzle Solved: [" + board + "]";
	}
	
	/**This is the method that actually handles the logical solving of the puzzle.*/
	public void solve() {
		
		while(!solved) {
			//TODO all of the actual logic of solving the puzzle.
		}
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

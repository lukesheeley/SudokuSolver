import java.util.ArrayList;

/**Instances of this class represent 9x9 Sudoku puzzles.*/
public class Puzzle {
	
	/**True if the puzzle is solved, false otherwise.  As soon as solved is set to true
	 * the first time, the solved puzzle will be printed. */
	private boolean solved;
	
	/**The grid you are filling out.  First index represents row, second index
	 * represents column. */
	private ArrayList<ArrayList<Integer>> board;
	
	/**Constructs a new puzzle to solve.  First parses the provided argument to
	 * create the board, then checks to see if it is solved and sets the "solved"
	 * field accordingly.*/
	public Puzzle(String inputPuzzle) {
		System.out.println(inputPuzzle);
		//TODO need to set board to some default value before doing board.get
		//TODO because I'm getting a nullpointerexception because it was never initialized
		for(int i = 0; i < inputPuzzle.length(); i++) {
			int x = Character.getNumericValue(inputPuzzle.charAt(i));
			int rowIndex = i/9;
			int columnIndex = i%9;
			board.get(rowIndex).set(columnIndex, x);
			//board.get(i/9).set(i%9, Character.getNumericValue(inputPuzzle.charAt(i))); 
		}
		checkIfSolved();
	}
	
	/**Checks if this puzzle is solved and sets the "solved" field accordingly.*/
	public void checkIfSolved() {
		if(board.contains(0)) {
			solved = false;
		}
		else {
			solved = true;
			
		}
	}
	
	@Override
	public String toString() {
		return "Puzzle Solved: [" + board + "]";
	}
	
	public void solve() {
		System.out.println(this);
	}

	/**Puzzles that are inputed to be solved should be inputed as a string of digits
	 * The first 9 digits should be the first row in order, the second 9 digits
	 * should be the second row, etc.  Blanks should be represented by 0's.*/
	public static void main(String[] args) {
		String input = args[0];
		Puzzle puzzle1 = new Puzzle(input);
		puzzle1.solve();

	}

}

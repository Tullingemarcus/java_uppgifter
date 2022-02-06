import java.util.*;
import java.lang.*;
public class Chessboard {
	public static class Field
	{
		private char row;
		private byte column;
		private Chesspiece piece = null;
		private boolean marked = false;
		public Field (char row, byte column) {
			this.row = row;
			this.column = column;
		}
		public void put (Chesspiece piece) {}
		public Chesspiece take () {
			return this.piece = null;
		}
		public void mark () {
			this.marked = true;
		}
		public void unmark () {
			this.marked = false;
		}
		public String toString ()
		{
			String s = (marked)? "xx" : "--";
			return (piece == null)? s : piece.toString ();
		}
	}
	public static final int NUMBER_OF_ROWS = 8;
	public static final int NUMBER_OF_COLUMNS = 8;
	public static final int FIRST_ROW = 'a';
	public static final int FIRST_COLUMN = 1;
	private Field[][] fields;
	public Chessboard ()
	{
		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		char row = 0;
		byte column = 0;
		for (int r = 0; r < NUMBER_OF_ROWS; r++)
		{
			row = (char) (FIRST_ROW + r);
			column = FIRST_COLUMN;
			for (int c = 0; c < NUMBER_OF_COLUMNS; c++)
			{
				fields[r][c] = new Field (row, column);
				column++;
			}
		}
	}
	public String toString () {
		Object[][] newString = new Object[NUMBER_OF_ROWS + 1][NUMBER_OF_COLUMNS + 1];
		String Board = "";
		String columns = "";
		String rows = "";
		for(int i = 0; i < NUMBER_OF_COLUMNS; i++) {
			newString[0][i + 1] = i + 1;
			columns = columns + "  " + newString[0][i + 1];
		}
		Board = columns + "\n";
		for(int i = 0; i < NUMBER_OF_ROWS; i++) {
			newString[i + 1][0] = (char)(65 + i) + "";
			rows = rows + newString[i + 1][0];
			for(int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				rows = rows + " " + this.fields[i][j];
			}
			rows = rows + "\n";
		}
		
		Board = Board + rows;
		return Board;
	}
	public boolean isValidField (char row, byte column) {
		return 0 < row && FIRST_ROW > row && 0 < column && NUMBER_OF_COLUMNS > column;
	}
	public abstract class Chesspiece
	{
		public class  NotValidFieldException extends Exception{
			public NotValidFieldException() {
				super();
			}
			public NotValidFieldException(String s) {
				super(s);
			}
		}
		private char color;
		// w - white, b - black
		private char name;
		// K - King, Q - Queen, R - Rook, B - Bishop, N - Knight,
		// P – Pawn
		protected char row = 0;
		protected byte column = -1;
		protected Chesspiece (char color, char name) {}
		public String toString ()
		{
			return "" + color + name;
		}
		public boolean isOnBoard ()
		{
			return Chessboard.this.isValidField (row, column);
		}
		public void moveTo (char row, byte column) throws NotValidFieldException
		{
			if (!Chessboard.this.isValidField (row, column)) {
				throw new NotValidFieldException ("bad field: " + row + column );
			}
			this.row = row;
			this.column = column;
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			Chessboard.this.fields[r][c].put (this);
		}
		public void moveOut () {}
		public abstract void markReachableFields ();
		public abstract void unmarkReachableFields ();
	}
	public class Pawn extends Chesspiece
	{
		public Pawn (char color, char name)
		{
			super (color, name);
		}
		public void markReachableFields ()
		{
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col))
			{
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark ();
			}
		}
		public void unmarkReachableFields ()
		{
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col))
			{
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark ();
			}
		}
	}
	
	public class Rook extends Chesspiece {
		public Rook (char color, char name)
		{
			super (color, name);
		}
		public void markReachableFields ()
		{
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col))
			{
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark ();
			}
		}
		public void unmarkReachableFields ()
		{
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col))
			{
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark ();
			}
		}
	}
	/*
	public class Knight extends Chesspiece {}
	public class Bishop extends Chesspiece {}
	public class Queen extends Chesspiece {}
	public class King extends Chesspiece {}
	*/
}

public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && (column == toColumn)) {
            if (color.equals("White") && line == 1) {
                if (Math.abs(line - toLine) < 2) {
                    return true;
                }
                if (Math.abs(line - toLine) == 2 && chessBoard.board[2][toColumn] == null) {
                    return true;
                } else return false;
            }
            if (color.equals("Black") && line == 6) {
                if (Math.abs(line - toLine) < 2) {
                    return true;
                }
                if (Math.abs(line - toLine) == 2 && chessBoard.board[5][toColumn] == null) {
                    return true;
                } else return false;
            }
            if (Math.abs(line - toLine) == 1) {
                return true;
            } else return false;

        } else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}

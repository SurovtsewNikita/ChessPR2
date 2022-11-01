public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if ((line != toLine) || (column != toColumn)) {
                if (column == toColumn) {
                    boolean waleLine = true;
                    for (int i = 1; i < Math.abs(line - toLine) - 1; i++) {
                        if (chessBoard.board[Math.min(line, toLine) + i][toColumn] != null) {
                            waleLine = false;
                            break;
                        }
                    }
                    if (check)
                        check = false;
                    return waleLine;
                }
                if (line == toLine) {
                    boolean waleColumn = true;
                    for (int i = 1; i < Math.abs(column - toColumn) - 1; i++) {
                        if (chessBoard.board[Math.min(column, toColumn) + i][toColumn] != null) {
                            waleColumn = false;
                            break;
                        }
                    }
                    if (check)
                        check = false;
                    return waleColumn;
                } else return false;
            } else return false;

        } else return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}

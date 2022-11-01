public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {

            if (isUnderAttack(chessBoard, toLine, toColumn)) return false;

            if ((line != toLine) || (column != toColumn)) {
                if (((Math.abs(line - toLine)) == Math.abs(column - toColumn)) && (Math.abs(column - toColumn) == 1)) {
                    if (check)
                        check = false;
                    return true;
                }
                if ((column == toColumn) && (Math.abs(toLine - line) == 1)) {
                    if (check)
                        check = false;
                    return true;
                }
                if ((line == toLine) && (Math.abs(toColumn - column) == 1)) {
                    if (check)
                        check = false;
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (checkPos(line) && checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }
}

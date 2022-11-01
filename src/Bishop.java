public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if ((line != toLine) && (column != toColumn)) {
                if ((Math.abs(line - toLine)) == Math.abs(column - toColumn)) {
                    if ((Math.abs(line - toLine)) > 1) {
                        boolean way = true;
                        for (int i = 1; i < Math.abs(line - toLine) - 1; i++) {
                            if (line > toLine)
                                toLine += i;
                            else toLine -= i;
                            if (column > toColumn)
                                toColumn += i;
                            else toColumn -= i;
                            if (chessBoard.board[toLine][toColumn] != null)
                                way = false;
                        }
                        return way;
                    }
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}

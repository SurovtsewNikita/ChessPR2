public class Queen extends ChessPiece{

    public Queen(String color) {
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
                if ((Math.abs(line - toLine)) == Math.abs(column - toColumn)) {
                    //if ((Math.abs(line - toLine)) == 1) return true;
                    if ((Math.abs(line - toLine)) > 1) {
                        boolean way = true;
                        for (int i = 1; i < Math.max(line, toLine); i++) {
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
                }
                if (column == toColumn) {
                    boolean waleLine = true;
                    for (int i = 1; i <Math.abs(line-toLine)-1; i++) {
                        if (chessBoard.board[Math.min(line, toLine) + i][toColumn] != null) {
                            waleLine = false;
                            break;
                        }
                    }
                    return waleLine;
                }
                if (line == toLine) {
                    boolean waleColumn = true;
                    for (int i = 1; i <Math.max(column,toColumn)-1; i++) {
                        if (chessBoard.board[Math.min(column,toColumn) + i][toColumn] != null) {
                            waleColumn = false;
                            break;
                        }
                    }
                    return waleColumn;
                } else return false;
            } else return false;
        }else return false;
    }
    @Override
    public String getSymbol() {
        return "Q";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}

public class Board {
    Integer size;
    Cell[][] board;

    public Board(Integer size) {
        this.size = size;
        initBoard();
    }

    private void initBoard() {
        board = new Cell[size][size];
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                cell = new Cell(false);
            }
        }
    }

    public Cell getCell(int row, int col){
        return board[row][col];
    }

    public Integer getNumOfLiveNeighbors(int row, int col){
        Integer numOfLiveNeighbors = 0;

        int startRow = row > 0 ? row -1 : row;
        int startCol = col > 0 ? col -1 : col;
        int endRow = row < size - 1 ? row + 1 : row;
        int endCol = col < size - 1 ? col + 1 :col;

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++){
                if (!(row == i && col == j)){
                    if (getCell(i,j).getLive()){
                        numOfLiveNeighbors++;
                    }
                }
            }
        }
        return numOfLiveNeighbors;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}

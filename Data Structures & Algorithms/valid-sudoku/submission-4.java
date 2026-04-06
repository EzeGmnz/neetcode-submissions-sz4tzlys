class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        char cellSymbol = '.';
        String boxIndex = "";
        boolean rowDidntContain = false;
        boolean columnDidntContain = false;
        boolean boxDidntContain = false;
        boolean isEmptySymbol = false;
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int colIndex = 0; colIndex < 9; colIndex++) {
                cellSymbol = board[rowIndex][colIndex];
                isEmptySymbol = this.isEmptySymbol(cellSymbol);
                if (isEmptySymbol) {
                    continue;
                }
                boxIndex = this.getBoxIndex(rowIndex, colIndex);

                rowDidntContain = rows.computeIfAbsent(rowIndex, k -> new HashSet<>()).add(cellSymbol);
                columnDidntContain = columns.computeIfAbsent(colIndex, k -> new HashSet<>()).add(cellSymbol);
                boxDidntContain = boxes.computeIfAbsent(boxIndex, k -> new HashSet<>()).add(cellSymbol);

                if (!rowDidntContain || !columnDidntContain || !boxDidntContain) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isEmptySymbol(char symbol) {
        return symbol == '.';
    }

    private String getBoxIndex(int row, int col) {
        return (row/3) + "_" + (col/3);
    }
}

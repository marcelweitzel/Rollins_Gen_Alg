package main;

import java.util.Arrays;
import java.util.List;

public class Damenproblem {
    private List<Dame> damen;
    private ProblemSolver solver;

    public Damenproblem(ProblemSolver solver) {
        this.solver = solver;
    }

    public static void main(String[] args) {
        Damenproblem damenproblem = new Damenproblem(new GeneticAlgorithm());
        damenproblem.printBoard(damenproblem.solve(), 8);

    }

    public List<Dame> solve() {
        return solver.solve(300, null);
    }

    public void printBoard(List<Dame> damen, int boardSize) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < boardSize*boardSize; i++) {
            stringBuilder.append("#");
        }
        String board = stringBuilder.toString();
        char[] boardChars = board.toCharArray();
        damen.forEach(dame -> boardChars[dame.getPosX() + dame.getPosY() * boardSize] = 'X');
        board = new String(boardChars);
        for (int i = 0; i < boardSize; i++) {
            System.out.println(board.substring(i*boardSize, i*boardSize+boardSize));
        }

    }
}

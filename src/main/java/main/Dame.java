package main;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Dame {
    private final int boardSize;
    private int posX;
    private int posY;

    public Dame(int boardSize) {
        this.boardSize = boardSize;
        Random r = new Random(System.nanoTime());
        posX = r.nextInt(boardSize);
        posY = r.nextInt(boardSize);
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public double getFitness(List<Dame> damen) {
        List<Dame> collided = damen.stream().filter(dame -> this.collidesWith(dame)).collect(Collectors.toList());
        return boardSize / collided.size();
    }

    private boolean collidesWith(Dame dame) {
        if (this.posX == dame.getPosX() || this.posY == dame.getPosY())
            return true;
        for (int i = 0; i < boardSize; i++) {
            if (((this.posX + i) % boardSize == dame.getPosX()
                    && (this.posY + i) % boardSize == dame.getPosY())
                    ||
                    ((this.posX + i) % boardSize == dame.getPosX()
                            && (this.posY - i) % boardSize == dame.getPosY())) {
                return true;
            }
        }
        return false;
    }

    public Dame mutate() {
        Dame mutant = new Dame(this.boardSize);
        Random random = new Random(System.nanoTime());
        int low = -1;
        int high = 1;
        int yModifier= random.nextInt(high-low) + low;
        int xModifier= random.nextInt(high-low) + low;
        mutant.setPosX((posX+xModifier)%boardSize);
        mutant.setPosY((posY+yModifier)%boardSize);
        return mutant;
    }
}

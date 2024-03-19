package model;
import java.util.Random;

public class Sheep extends Animal {
    public Sheep(int x, int y, boolean isFemale) {
        super(x, y, isFemale);
    }

    @Override
    public int move() {
        Random rand = new Random();
        int dx, dy;
        do {
        	int d = rand.nextInt(2);
            if(d==0) {
            	int e = rand.nextInt(2);
            	if(e==0) {
            		dx = 2;
            		dy = 0;
            	}
            	else {
            		dx = -2;
            		dy = 0;
            	}
            }
            else {
            	int e = rand.nextInt(2);
            	if(e==0) {
            		dx = 0;
            		dy = 2;
            	}
            	else {
            		dx = 0;
            		dy = -2;
            	}
            }
        }while((x+dx<0)||(x+dx>500)||(y+dy<0)||(y+dy>500));
        x += dx;
        y += dy;
        return 2;
    }
}
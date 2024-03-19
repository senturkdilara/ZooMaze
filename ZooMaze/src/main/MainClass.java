package main;
import model.Animal;
import model.Chicken;
import model.Cow;
import model.Hunter;
import model.Lion;
import model.Rooster;
import model.Sheep;
import model.Wolf;

import java.util.Random;

public class MainClass {
	static int calculateDistance(int a, int b, int c, int d) {
        int dx = a-c;
        int dy = b-d;
        return (int) Math.sqrt(dx * dx + dy * dy); // Pythagoras teoremi ile mesafe hesaplama
    }
	
	
	
	public static void main(String[] args) {
		//I will use a matrix in this problem and replace animals in this matrix
		Animal[][] matrix = new Animal[500][500];
		int a,b, gender;
		
		//first animals are put their initial position randomly according to declared numbers
		Random rand = new Random();
        for (int i = 0; i < 30; ++i) {
        	int x = rand.nextInt(500);
            int y = rand.nextInt(500);
            while(matrix[x][y] != null) {
            	x = rand.nextInt(500);
                y = rand.nextInt(500);
            }
            if(i<15) {
            	matrix[x][y] = new Sheep(x, y, false);
            }else {
            	matrix[x][y] = new Sheep(x, y, true);
            }
            
        }
        for (int i = 0; i < 10; ++i) {
            int x = rand.nextInt(500);
            int y = rand.nextInt(500);
            while(matrix[x][y] != null) {
            	x = rand.nextInt(500);
                y = rand.nextInt(500);
            }
            if(i<5) {
            	matrix[x][y] = new Cow(x, y, false);
            }else {
            	matrix[x][y] = new Cow(x, y, true);
            }
        }
        for (int i = 0; i < 10; ++i) {
            int x = rand.nextInt(500);
            int y = rand.nextInt(500);
            while(matrix[x][y] != null) {
            	x = rand.nextInt(500);
                y = rand.nextInt(500);
            }
            
            matrix[x][y] = new Chicken(x, y, true);
            
        }
        for (int i = 0; i < 10; ++i) {
            int x = rand.nextInt(500);
            int y = rand.nextInt(500);
            while(matrix[x][y] != null) {
            	x = rand.nextInt(500);
                y = rand.nextInt(500);
            }
            if(i<5) {
            	matrix[x][y] = new Wolf(x, y, false);
            }else {
            	matrix[x][y] = new Wolf(x, y, true);
            }
        }
        for (int i = 0; i < 8; ++i) {
            int x = rand.nextInt(500);
            int y = rand.nextInt(500);
            while(matrix[x][y] != null) {
            	x = rand.nextInt(500);
                y = rand.nextInt(500);
            }
            if(i<4) {
            	matrix[x][y] = new Lion(x, y, false);
            }else {
            	matrix[x][y] = new Lion(x, y, true);
            }
        }
        
        for (int i = 0; i < 10; ++i) {
            int x = rand.nextInt(500);
            int y = rand.nextInt(500);
            while(matrix[x][y] != null) {
            	x = rand.nextInt(500);
                y = rand.nextInt(500);
            }
            
            matrix[x][y] = new Rooster(x, y, false);
            
        }
        
        //fonskiyonlar icinde local variable kullanmak istedigim icin
        //hunterı da loop icerisinde yazdım
        for (int i = 0; i < 1; ++i) {
            int x = rand.nextInt(500);
            int y = rand.nextInt(500);
            while(matrix[x][y] != null) {
            	x = rand.nextInt(500);
                y = rand.nextInt(500);
            }
            matrix[x][y] = new Hunter(x, y, true);
        }
        
        int animal_count = 78;
        
        int distance = 0;
        //When distance becomes 1000 the loop will terminate(break from outer loop
        outerloop:
        for (int j = 0; j < 500; ++j) {
            for (int k = 0; k < 500; ++k) {
                if (matrix[j][k] != null) {
                    distance += matrix[j][k].move();
                    
                    if (matrix[j][k] instanceof Wolf) {
                    	for (int i = Math.max(0, j - 4); i <= Math.min(499, j + 4); i++) {
                            for (int l = Math.max(0, k - 4); l <= Math.min(499, k + 4); l++) {
                                
                                if (i == j && l == k) {
                                    continue; 
                                }

                                // Diğer hayvanları kontrol etme
                                if (matrix[i][l] != null) {
                                    Animal animal = matrix[i][l];
                                    // Kurtun avlayabileceği hayvanları kontrol etme
                                    if (animal instanceof Sheep || animal instanceof Chicken || animal instanceof Rooster) {
                                    	int dist = calculateDistance(j, k, i, l);
                                        if (distance <= 4) {
                                        	matrix[i][l] = null;
                                        	animal_count -= 1;
                                        }
                                    }
                                    else if(animal instanceof Wolf && (matrix[i][l].isFemale != matrix[j][k].isFemale)) {
                                    	int dist = calculateDistance(j, k, i, l);
                                        if (distance <= 3) {
                                        	a = rand.nextInt(500);
                                            b = rand.nextInt(500);
                                        	while(matrix[a][b] != null) {
                                            	a = rand.nextInt(500);
                                                b = rand.nextInt(500);
                                            }
                                        	gender = rand.nextInt(2);
                                            if(gender==0) {
                                            	matrix[a][b] = new Wolf(a, b, false);
                                            }else {
                                            	matrix[a][b] = new Wolf(a, b, true);
                                            }
                                            animal_count+=1;
                                        }
                                    }
                                }
                            }
                        }
 
                    }
                    
                    else if(matrix[j][k] instanceof Lion) {
                    	for (int i = Math.max(0, j - 5); i <= Math.min(499, j + 5); i++) {
                            for (int l = Math.max(0, k - 5); l <= Math.min(499, k + 5); l++) {
                                if (i == j && l == k) {
                                    continue; 
                                }

                                if (matrix[i][l] != null) {
                                    Animal animal = matrix[i][l];
                                    // Aslanın avlayabileceği hayvanları kontrol etme
                                    if (animal instanceof Sheep || animal instanceof Cow) {
                                    	int dist = calculateDistance(j, k, i, l);
                                        if (distance <= 8) {
                                        	matrix[i][l] = null;
                                        	animal_count-=1;
                                        }
                                    }
                                    else if(animal instanceof Lion && (matrix[i][l].isFemale != matrix[j][k].isFemale)) {
                                    	int dist = calculateDistance(j, k, i, l);
                                        if (distance <= 3) {
                                        	a = rand.nextInt(500);
                                            b = rand.nextInt(500);
                                        	while(matrix[a][b] != null) {
                                            	a = rand.nextInt(500);
                                                b = rand.nextInt(500);
                                            }
                                        	gender = rand.nextInt(2);
                                            if(gender==0) {
                                            	matrix[a][b] = new Lion(a, b, false);
                                            }else {
                                            	matrix[a][b] = new Lion(a, b, true);
                                            }
                                            animal_count+=1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(matrix[j][k] instanceof Hunter){
                    	for (int i = Math.max(0, j - 8); i <= Math.min(499, j + 8); i++) {
                            for (int l = Math.max(0, k - 8); l <= Math.min(499, k + 8); l++) {
                                if (i == j && l == k) {
                                    continue; 
                                }

                                if (matrix[i][l] != null) {
                                	int dist = calculateDistance(j, k, i, l);
                                    if (distance <= 8) {
                                    	matrix[i][l] = null;
                                    	animal_count-=1;
                                    }
                                	
                                }
                            }
                        }
                    	
                    }
                    else if(matrix[j][k] instanceof Sheep) {
                    	for (int i = Math.max(0, j - 3); i <= Math.min(499, j + 3); i++) {
                            for (int l = Math.max(0, k - 3); l <= Math.min(499, k + 3); l++) {
                                if (i == j && l == k) {
                                    continue; 
                                }

                                if (matrix[i][l] != null) {
                                    Animal animal = matrix[i][l];
                                    if(animal instanceof Sheep && (matrix[i][l].isFemale != matrix[j][k].isFemale)) {
                                    	int dist = calculateDistance(j, k, i, l);
                                        if (distance <= 3) {
                                        	a = rand.nextInt(500);
                                            b = rand.nextInt(500);
                                        	while(matrix[a][b] != null) {
                                            	a = rand.nextInt(500);
                                                b = rand.nextInt(500);
                                            }
                                        	gender = rand.nextInt(2);
                                            if(gender==0) {
                                            	matrix[a][b] = new Sheep(a, b, false);
                                            }else {
                                            	matrix[a][b] = new Sheep(a, b, true);
                                            }
                                            animal_count+=1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(matrix[j][k] instanceof Chicken) {
                    	for (int i = Math.max(0, j - 3); i <= Math.min(499, j + 3); i++) {
                            for (int l = Math.max(0, k - 3); l <= Math.min(499, k + 3); l++) {
                                if (i == j && l == k) {
                                    continue; 
                                }

                                if (matrix[i][l] != null) {
                                    Animal animal = matrix[i][l];
                                    if(animal instanceof Rooster) {
                                    	int dist = calculateDistance(j, k, i, l);
                                        if (distance <= 3) {
                                        	a = rand.nextInt(500);
                                            b = rand.nextInt(500);
                                        	while(matrix[a][b] != null) {
                                            	a = rand.nextInt(500);
                                                b = rand.nextInt(500);
                                            }
              
                                            matrix[a][b] = new Chicken(a, b, true);
                                            animal_count+=1;
                                        }
                                    }
                                }
                            }
                        }
                    	
                    }
                    
                    else if(matrix[j][k] instanceof Rooster) {
                    	for (int i = Math.max(0, j - 3); i <= Math.min(499, j + 3); i++) {
                            for (int l = Math.max(0, k - 3); l <= Math.min(499, k + 3); l++) {
                                if (i == j && l == k) {
                                    continue; 
                                }

                                if (matrix[i][l] != null) {
                                    Animal animal = matrix[i][l];
                                    if(animal instanceof Chicken) {
                                    	int dist = calculateDistance(j, k, i, l);
                                        if (distance <= 3) {
                                        	a = rand.nextInt(500);
                                            b = rand.nextInt(500);
                                        	while(matrix[a][b] != null) {
                                            	a = rand.nextInt(500);
                                                b = rand.nextInt(500);
                                            }
                                        	matrix[a][b] = new Rooster(a, b, false);
                                        	animal_count+=1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(matrix[j][k] instanceof Cow ) {
                    	for (int i = Math.max(0, j - 3); i <= Math.min(499, j + 3); i++) {
                            for (int l = Math.max(0, k - 3); l <= Math.min(499, k + 3); l++) {
                                if (i == j && l == k) {
                                    continue; 
                                }

                                if (matrix[i][l] != null) {
                                    Animal animal = matrix[i][l];
                                    if(animal instanceof Cow && (matrix[i][l].isFemale != matrix[j][k].isFemale)) {
                                    	int dist = calculateDistance(j, k, i, l);
                                        if (distance <= 3) {
                                        	a = rand.nextInt(500);
                                            b = rand.nextInt(500);
                                        	while(matrix[a][b] != null) {
                                            	a = rand.nextInt(500);
                                                b = rand.nextInt(500);
                                            }
                                        	gender = rand.nextInt(2);
                                            if(gender==0) {
                                            	matrix[a][b] = new Cow(a, b, false);
                                            }else {
                                            	matrix[a][b] = new Cow(a, b, true);
                                            }
                                            animal_count+=1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    
                    else {
                    	continue;
                    }
                    
                    if(distance>1000) {
                    	break outerloop;
                    }
                	

                }
            }
        }
        
        System.out.println("Recent animal count is "+animal_count);
        
	}
}

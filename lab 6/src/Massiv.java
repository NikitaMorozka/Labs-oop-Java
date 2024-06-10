import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.awt.Rectangle;

public class Massiv {
	private int W = 0; 
	private int H = 0; 
    private int[][] array;
    int i = 0; 
    int j = 0; 
   // private boolean rowsSwapped = false;

    public Massiv() {
        readArraySizeFrmFile("C:\\Users\\nikit\\eclipse-workspace\\lab 6\\src\\cin.txt");
    }
    
    public void readArraySizeFrmFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextInt()) {
                W = scanner.nextInt();
                H = scanner.nextInt();
                
                array = new int[W][H];
                for ( i = 0; i < W; i++) {
                    for ( j = 0; j < H; j++) {
                        array[i][j] = scanner.nextInt();
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found.");
            e.printStackTrace();
        }
    }
    
//-------------------------------------МАССИВ ИЗНАЧАЛЬНО---------------------------------------------

    public void drawing(Graphics g ) {
        System.out.println("МАССИВ ИЗНАЧАЛЬНО ");
        int value = 0; 
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                Rectangle r1 = new Rectangle();
                r1.x = 10 + j * 50; 
                r1.y = 10 + i * 50; 
                r1.width = 50; 
                r1.height = 50;
                value = array[i][j];
                if (value <= 0) {
                    int  R = (10 + value * -10 + 60)%256;
                    int  G = (10 + value  * -120 - 50)%256;
                    int  B = (10 + value * -80 - 50)%256;
                    g.setColor(new Color(R, G, B)); 
                }
                if (value > 0) {
                int  R = (10 + value * 10 + 60)%256;
                int  G = (10 + value  * 120 - 50)%256;
                int  B = (10 + value * 80 - 50)%256;
                g.setColor(new Color(R, G, B)); 
                }
                g.fillRect(r1.x, r1.y, r1.width, r1.height);
                System.out.print(value + " ");

            }
            System.out.println(); // Переход на новую строку после вывода всех элементов в текущей строке

        }

    }

  //-------------------------------------МАССИВ A9-----------------------------------------------------
    public void drawingANine(Graphics g) {
        System.out.print("МАССИВ ЗАДАНИЕ A9 ");

        System.out.println(); // Переход на новую строку после вывода всех элементов в текущей строке

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                Rectangle r1 = new Rectangle();
                r1.x = 250 + j * 50;
                r1.y = 10 + i * 50;
                r1.width = 50;
                r1.height = 50;
                int value = array[i][j];
                if (i < W - 1 && array[i + 1][j] % 2 != 0) { // Проверка, если элемент ниже текущего - нечетный
                    value *= 10; // Увеличение значения текущего элемента в 10 раз
                }
                
                
                if (value <= 0) {
                    int R = (10 + value * -80 + 60) % 256;
                    int G = (10 + value * -200 - 50) % 256;
                    int B = (10 + value * -800 - 50) % 256;
                    g.setColor(new Color(R, G, B));
                    
                } else {
                    int R = (10 + value * 10 + 60) % 256;
                    int G = (10 + value * 120 - 50) % 256;
                    int B = (10 + value * 80 - 50) % 256;
                    g.setColor(new Color(R, G, B));
                }
                	g.fillRect(r1.x, r1.y, r1.width, r1.height);
                    System.out.print(value + " ");
            }
            System.out.println(); // Переход на новую строку после вывода всех элементов в текущей строке
        }
    }
    //-------------------------------------МАССИВ A9-----------------------------------------------------

    public void isColmn(Graphics g) {
        System.out.println("массив задание 3");

        int[] colSum = new int[H];

        // Рассчитываем сумму элементов в каждом столбце
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                colSum[j] += array[i][j];
            }
        }

        // Находим индекс столбца с максимальной суммой
        int mxSum = 0;
        for (int j = 0; j < H; j++) {
            if (colSum[j] > colSum[mxSum]) {
                mxSum = j;
            }
        }

        // Создаем новый массив с дополнительным столбцом
        int[][] newArray = new int[W][H + 1];

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                newArray[i][j] = array[i][j];
            }
            // Добавляем нули в дополнительный столбец
            newArray[i][H] = 0;
        }

        // Вставляем столбец с нулями рядом со столбцом с максимальной суммой
        for (int i = 0; i < W; i++) {
            for (int j = H; j > mxSum; j--) {
                newArray[i][j] = newArray[i][j - 1];
            }
            // Устанавливаем значения нулей в дополнительном столбце
            newArray[i][mxSum] = 0;
        }

        // Рисуем прямоугольники, представляющие значения массива, с учетом цвета
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H + 1; j++) {
                int R, G, B;
                if (newArray[i][j] < 0) {
                    R = (10 + newArray[i][j] * -80 + 60) % 256;
                    G = (10 + newArray[i][j] * -200 - 50) % 256;
                    B = (10 + newArray[i][j] * -800 - 50) % 256;
                } else if (newArray[i][j] > 0) {
                    R = (10 + newArray[i][j] * 10 + 60) % 256;
                    G = (10 + newArray[i][j] * 120 - 50) % 256;
                    B = (10 + newArray[i][j] * 80 - 50) % 256;
                } else { // Значение равно 0
                    R = (10 + newArray[i][j] * 10 + 60) % 256;
                    G = (10 + newArray[i][j] * 120 + 50) % 256;
                    B = (10 + newArray[i][j] * 80 + 150) % 256;
                }
                g.setColor(new Color(R, G, B));
                Rectangle r1 = new Rectangle();
                r1.x = 500 + j * 50;
                r1.y = 10 + i * 50;
                r1.width = 50;
                r1.height = 50;
                g.fillRect(r1.x, r1.y, r1.width, r1.height);
                System.out.print(newArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    

    
    public void draw(Graphics g ) {
    	drawing(g); 
    	drawingANine(g);
    	isColmn(g); 

    }
}
  




























	
    



		

	


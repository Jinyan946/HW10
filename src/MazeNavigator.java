import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * HW 10 - maze
 *
 * <p> Purdue University -- CS 180 -- 2021</p>
 *
 * @author Jin Yan Purdue CS
 *
 * @version Nov 3rd, 2021
 */
//thread is a class which has all the functions in it, mazeNavigator inherits things from thread
public class MazeNavigator extends Thread { //command + press thread to see the thread class
    private static int currentRow = 4 ; //static 静态；和class在一起；可修改
    private static int currentColumn = 4 ;
    private static int moveNumber = 0 ;
    private static boolean started = false;
    private static char[][] maze = new char[10][10];
    private int playerNumber;
    private String fileName;

    //constructor 构造参数；每new一个mazeNavigator都跟着playerNumber和fileName
    public MazeNavigator(int playerNumber, String fileName) {
        this.playerNumber = playerNumber; //this指mazeNavigator; the first playerNumber is
        // private int playerNumber; the 2nd one is 参数，从外面传递过来的
        this.fileName = fileName;
    }

    public void run() {
      if (playerNumber == 1) {
          System.out.println("Welcome! Initial Maze:");

          for (int i = 0; i < 10; i++) {
              System.out.print("[");
              for (int j = 0; j < 10; j++) {
                  if (i == currentRow && j == currentColumn) {
                      System.out.print("X");
                  } else {
                      System.out.print(" ");
                  }
                  if (j < 9) {
                      System.out.print(",");
                  }
              }
              System.out.println("]");
          }
      }

        try {
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            File f1 = new File(fileName);
            FileReader fr1 = new FileReader(f1);
            BufferedReader bfr1 = new BufferedReader(fr1);
            String line = bfr1.readLine();
            while (line!= null) {
                int i = Integer.parseInt(line);
                list1.add(i);
                line = bfr1.readLine();
            }
            bfr1.close();

            for(int i = 0; i < list1.size(); i++) {
                int number = list1.get(i);
                move(number, playerNumber);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void move (int num, int playerNumber) {
        moveNumber ++;

        System.out.println("Move Number:" + moveNumber);
        System.out.println("Player: " + playerNumber);

        if (num == 1) {
            if (currentColumn == 0) {
                currentColumn = 9;
            } else {
                currentColumn --;
            }
            System.out.println("Move: Left");
        } else if (num == 2) {
            if (currentColumn == 9) {
                currentColumn = 0;
            } else {
                currentColumn ++;
            }
            System.out.println("Move: Right");
        } else if (num == 3) {
            if (currentRow == 0) {
                currentRow = 9;
            } else {
                currentRow --;
            }
            System.out.println("Move: Up");
        } else if (num == 4) {
            if (currentRow == 9) {
                currentRow = 0;
            } else {
                currentRow ++;
            }
            System.out.println("Move: Down");
        } else {
            System.out.println("Error, invalid input!");
        }

        for(int i = 0; i < 10; i++){
            System.out.print("[");
            for (int j= 0; j < 10; j++){
                if(i == currentRow && j == currentColumn) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
                if (j < 9) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }

    }
   
}

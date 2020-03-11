import javax.swing.*;
import java.awt.*;

public class Life {
    public static void main(String[] args) throws InterruptedException {
        int[][] current;
        int[][] previous;
        int n = Integer.parseInt(args[0]);
        int i = Integer.parseInt(args[1]);
        String selection = args[2];
        current = new int[n][n];
        previous = new int[n][n];
        if (selection.equals("R")) {
            for (int x = 0; x < current.length; x++) {
                for (int y = 0; y < current.length; y++) {
                    if (x>0 && y>0 && y<n-1 && x<n-1 ) {
                        current[x+1][y-1] = 1;
                    } else current[x][y] = 0;
                }
            }
        } else if (selection.equals("G")) {
            for (int x = 0; x < current.length; x++) {
                for (int y = 0; y < current.length; y++) {
                    if (x == 2 && y == 26) current[x][y] = 1;
                    else if (y == 24 && x == 3) current[x][y] = 1;
                    else if (y == 26 && x == 3) current[x][y] = 1;
                    else if (y == 14 && x == 4) current[x][y] = 1;
                    else if (y == 15 && x == 4) current[x][y] = 1;
                    else if (y == 22 && x == 4) current[x][y] = 1;
                    else if (y == 23 && x == 4) current[x][y] = 1;
                    else if (y == 36 && x == 4) current[x][y] = 1;
                    else if (y == 37 && x == 4) current[x][y] = 1;
                    else if (y == 13 && x == 5) current[x][y] = 1;
                    else if (y == 17 && x == 5) current[x][y] = 1;
                    else if (y == 22 && x == 5) current[x][y] = 1;
                    else if (y == 23 && x == 5) current[x][y] = 1;
                    else if (y == 36 && x == 5) current[x][y] = 1;
                    else if (y == 37 && x == 5) current[x][y] = 1;
                    else if (y == 2 && x == 6) current[x][y] = 1;
                    else if (y == 3 && x == 6) current[x][y] = 1;
                    else if (y == 12 && x == 6) current[x][y] = 1;
                    else if (y == 18 && x == 6) current[x][y] = 1;
                    else if (y == 22 && x == 6) current[x][y] = 1;
                    else if (y == 23 && x == 6) current[x][y] = 1;
                    else if (y == 2 && x == 7) current[x][y] = 1;
                    else if (y == 3 && x == 7) current[x][y] = 1;
                    else if (y == 12 && x == 7) current[x][y] = 1;
                    else if (y == 16 && x == 7) current[x][y] = 1;
                    else if (y == 18 && x == 7) current[x][y] = 1;
                    else if (y == 19 && x == 7) current[x][y] = 1;
                    else if (y == 24 && x == 7) current[x][y] = 1;
                    else if (y == 26 && x == 7) current[x][y] = 1;
                    else if (y == 12 && x == 8) current[x][y] = 1;
                    else if (y == 18 && x == 8) current[x][y] = 1;
                    else if (y == 26 && x == 8) current[x][y] = 1;
                    else if (y == 13 && x == 9) current[x][y] = 1;
                    else if (y == 17 && x == 9) current[x][y] = 1;
                    else if (y == 14 && x == 10) current[x][y] = 1;
                    else if (y == 15 && x == 10) current[x][y] = 1;
                    else current[x][y] = 0;
                }
            }
        }
        JFrame frame = new JFrame("Life");
        JPanel panel = new JPanel();
        JPanel pn= new JPanel();
        panel.setLayout(new GridLayout(n,n));
        JButton [][] buttons= new JButton[n][n];

        /**
         * Adding Buttons to the Panel
         */

        for(int x=0; x<n;x++){
            for(int y=0;y<n;y++){
                buttons[x][y]=new JButton();
                panel.add(buttons[x][y]);
            }

        }
        /**
         * Fixing up the panel with the Frame
         */
        panel.setBounds(0,0,750,750);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int j=0; j<=i;j++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (current[x][y] == 1) {
                        buttons[x][y].setBackground(Color.BLACK);
                        ;
                    } else {
                        buttons[x][y].setBackground(Color.WHITE);
                    }
                    previous[x][y] = current[x][y];
                }

            }
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    int sum;
                        if (x - 1 >= 0 && y - 1 >= 0 && x + 1 <= n-1 && y + 1 <= n-1) {
                            sum = previous[x - 1][y - 1] + previous[x - 1][y] + previous[x - 1][y + 1] + previous[x][y - 1] + previous[x][y + 1] + previous[x + 1][y - 1] + previous[x + 1][y] + previous[x + 1][y + 1];
                            if (current[x][y] == 1 && sum < 2) current[x][y] = 0;
                            else if (current[x][y] == 1 && sum >= 2 && sum <= 3) current[x][y] = 1;
                            else if (current[x][y] == 1 && sum > 3) current[x][y] = 0;
                            else if (current[x][y] == 0 && sum == 3) current[x][y] = 1;
                        }
                        else {
                            if (x == 0 && y > 0 && y < n - 1) {
                                sum = previous[n - 1][y - 1] + previous[n - 1][y] + previous[n - 1][y + 1] + previous[x][y - 1] + previous[x][y + 1] + previous[x + 1][y - 1] + previous[x + 1][y] + previous[x + 1][y + 1];
                                if (current[x][y] == 1 && sum < 2) current[x][y] = 0;
                                else if (current[x][y] == 1 && sum >= 2 && sum <= 3) current[x][y] = 1;
                                else if (current[x][y] == 1 && sum > 3) current[x][y] = 0;
                                else if (current[x][y] == 0 && sum == 3) current[x][y] = 1;
                            } else if (x == n - 1 && y > 0 && y < n - 1) {
                                sum = previous[x - 1][y - 1] + previous[x - 1][y] + previous[x - 1][y + 1] + previous[x][y - 1] + previous[x][y + 1] + previous[0][y - 1] + previous[0][y] + previous[0][y + 1];
                                if (current[x][y] == 1 && sum < 2) current[x][y] = 0;
                                else if (current[x][y] == 1 && sum >= 2 && sum <= 3) current[x][y] = 1;
                                else if (current[x][y] == 1 && sum > 3) current[x][y] = 0;
                                else if (current[x][y] == 0 && sum == 3) current[x][y] = 1;
                            } else if (x > 0 && x < n - 1 && y == 0) {
                                sum = previous[x - 1][n - 1] + previous[x - 1][y] + previous[x - 1][y + 1] + previous[x][n - 1] + previous[x][y + 1] + previous[x + 1][n - 1] + previous[x + 1][y] + previous[x + 1][y + 1];
                                if (current[x][y] == 1 && sum < 2) current[x][y] = 0;
                                else if (current[x][y] == 1 && sum >= 2 && sum <= 3) current[x][y] = 1;
                                else if (current[x][y] == 1 && sum > 3) current[x][y] = 0;
                                else if (current[x][y] == 0 && sum == 3) current[x][y] = 1;
                            } else if (x > 0 && x < n - 1 && y == n - 1) {
                                sum = previous[x - 1][y - 1] + previous[x - 1][y] + previous[x - 1][0] + previous[x][y - 1] + previous[x][0] + previous[x + 1][y - 1] + previous[x + 1][y] + previous[x + 1][0];
                                if (current[x][y] == 1 && sum < 2) current[x][y] = 0;
                                else if (current[x][y] == 1 && sum >= 2 && sum <= 3) current[x][y] = 1;
                                else if (current[x][y] == 1 && sum > 3) current[x][y] = 0;
                                else if (current[x][y] == 0 && sum == 3) current[x][y] = 1;
                            } else if (x == 0 && y == 0) {
                                sum = previous[n - 1][n - 1] + previous[n - 1][y] + previous[n - 1][y + 1] + previous[x][n - 1] + previous[x][y + 1] + previous[x + 1][n - 1] + previous[x + 1][y] + previous[x + 1][y + 1];
                                if (current[x][y] == 1 && sum < 2) current[x][y] = 0;
                                else if (current[x][y] == 1 && sum >= 2 && sum <= 3) current[x][y] = 1;
                                else if (current[x][y] == 1 && sum > 3) current[x][y] = 0;
                                else if (current[x][y] == 0 && sum == 3) current[x][y] = 1;
                            } else if (x == 0 && y == n - 1) {
                                sum = previous[n - 1][y - 1] + previous[n - 1][y] + previous[n - 1][0] + previous[x][y - 1] + previous[x][0] + previous[x + 1][y - 1] + previous[x + 1][y] + previous[x + 1][0];
                                if (current[x][y] == 1 && sum < 2) current[x][y] = 0;
                                else if (current[x][y] == 1 && sum >= 2 && sum <= 3) current[x][y] = 1;
                                else if (current[x][y] == 1 && sum > 3) current[x][y] = 0;
                                else if (current[x][y] == 0 && sum == 3) current[x][y] = 1;
                            } else if (x == n - 1 && y == 0) {
                                sum = previous[x - 1][n - 1] + previous[x - 1][y] + previous[x - 1][y + 1] + previous[x][n - 1] + previous[x][y + 1] + previous[0][n - 1] + previous[0][y] + previous[0][y + 1];
                                if (current[x][y] == 1 && sum < 2) current[x][y] = 0;
                                else if (current[x][y] == 1 && sum >= 2 && sum <= 3) current[x][y] = 1;
                                else if (current[x][y] == 1 && sum > 3) current[x][y] = 0;
                                else if (current[x][y] == 0 && sum == 3) current[x][y] = 1;
                            } else if (x == n - 1 && y == n - 1) {
                                sum = previous[x - 1][y - 1] + previous[x - 1][y] + previous[x - 1][0] + previous[x][y - 1] + previous[x][0] + previous[0][y - 1] + previous[0][y] + previous[0][0];
                                if (current[x][y] == 1 && sum < 2) current[x][y] = 0;
                                else if (current[x][y] == 1 && sum >= 2 && sum <= 3) current[x][y] = 1;
                                else if (current[x][y] == 1 && sum > 3) current[x][y] = 0;
                                else if (current[x][y] == 0 && sum == 3) current[x][y] = 1;
                            }

                        }
                    }

                    }
            Thread.sleep(100);
                }


    }
}
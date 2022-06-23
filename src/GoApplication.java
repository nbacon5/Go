import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class GoApplication extends Go{

    private int boardDimension;
    private int length = 1000;
    private JFrame frame;

    public GoApplication(int a){
        super(a);
        boardDimension = a;
        frame = new JFrame("Go");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);        
        frame.setSize(length, length);
        frame.setResizable(true);
        Grid board = new Grid();
        frame.add(board);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new GoApplication(Integer.parseInt(args[0]));
    }

    class Grid extends JPanel{

        public Grid(){
            this.addMouseListener(new MouseListener());
        }
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int size = ((int)frame.getSize().getHeight()-15) / boardDimension-1;
            int x = size/2;
            int y = size/2;
            for (int i = 0; i < boardDimension-1; i++){
                for (int j = 0; j < boardDimension-1; j++){
                    g.drawRect(x, y, size, size);
                    y += size;
                }
                x += size;
                y = size/2;
            }
            x = 0;
            y = 0;
            for (int i = 0; i < boardDimension; i++){
                for (int j = 0; j < boardDimension; j++){
                    if (board[i][j] == PointStatus.BLACK){
                        g.setColor(Color.BLACK);
                        g.fillOval(x, y, size, size);
                    }
                    else if (board[i][j] == PointStatus.WHITE){
                        g.setColor(Color.WHITE);
                        g.fillOval(x, y, size, size);
                    }
                    y += size;
                }
                x += size;
                y = 0;
            }
            g2d.dispose();
        }

        private class MouseListener extends MouseAdapter{
            public void mouseClicked(MouseEvent e){
                int size = ((int)frame.getSize().getHeight()-15) / boardDimension-1;
                int x = 0;
                int y = 0;
                for (int i = 0; i < boardDimension; i++){
                    for (int j = 0; j < boardDimension; j++){
                        if (e.getX() < x+size && e.getX() > x && e.getY() < y+size && e.getY() > y){
                            play(i, j);
                        }
                        y += size;
                    }
                    x += size;
                    y = 0;
                }
                repaint();
            }
        }
    }
}

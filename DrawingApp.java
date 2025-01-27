package DrawingApp;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingApp {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("My First Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // Create a custom JPanel with a white background
        DrawingPanel panel = new DrawingPanel();
        panel.setBackground(Color.WHITE);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}

class DrawingPanel extends JPanel {
    private final ArrayList<int[]> points = new ArrayList<>();

    public DrawingPanel() {
        // Add mouse listener to capture drawing points
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.add(new int[]{e.getX(), e.getY()});
                repaint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                points.add(new int[]{e.getX(), e.getY()});
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (int[] point : points) {
            g.fillOval(point[0], point[1], 5, 5);
        }
    }
}
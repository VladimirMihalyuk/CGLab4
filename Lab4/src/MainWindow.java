import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private DrawPanel drawingPanel = new DrawPanel();

    private JTextField x1Input = new JTextField(25);
    private JTextField y1Input = new JTextField(25);
    private JTextField x2Input = new JTextField(25);
    private JTextField y2Input = new JTextField(25);
    private JTextField radiusInput = new JTextField(25);

    public MainWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int WIDTH = 1100;
        int HEIGHT = 900;
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setLayout(null);

        drawingPanel.setBounds(0, 0, WIDTH, 560);
        add(drawingPanel);

        Font labelFont = new Font("Serif", Font.PLAIN, 25);

        JLabel timeLabel = new JLabel("Время:");
        timeLabel.setFont(labelFont);
        timeLabel.setBounds(10, 800, 250, 40);
        add(timeLabel);

        JLabel x1Label = new JLabel("X1: ");
        x1Label.setFont(labelFont);
        x1Label.setBounds(10, 570, 50, 40);
        add(x1Label);

        x1Input.setBounds(70, 570, 130, 40);
        x1Input.setFont(labelFont);
        add(x1Input);

        JLabel y1Label = new JLabel("Y1: ");
        y1Label.setFont(labelFont);
        y1Label.setBounds(10, 610, 50, 40);
        add(y1Label);

        y1Input.setBounds(70, 610, 130, 40);
        y1Input.setFont(labelFont);
        add(y1Input);


        JLabel x2Label = new JLabel("X2: ");
        x2Label.setFont(labelFont);
        x2Label.setBounds(10, 670, 50, 40);
        add(x2Label);

        x2Input.setBounds(70, 670, 130, 40);
        x2Input.setFont(labelFont);
        add(x2Input);


        JLabel y2Label = new JLabel("Y2: ");
        y2Label.setFont(labelFont);
        y2Label.setBounds(10, 710, 50, 40);
        add(y2Label);

        y2Input.setBounds(70, 710, 130, 40);
        y2Input.setFont(labelFont);
        add(y2Input);

        JLabel radiusLabel = new JLabel("Радиус: ");
        radiusLabel.setFont(labelFont);
        radiusLabel.setBounds(10, 760, 100, 40);
        add(radiusLabel);

        radiusInput.setBounds(100, 760, 100, 40);
        radiusInput.setFont(labelFont);
        add(radiusInput);


        JButton stepByStepButton = new JButton("Пошаговый алгоритм");
        stepByStepButton.setBounds(260, 570, 200, 40);
        stepByStepButton.addActionListener(e -> {
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            try {
                x1 = Integer.parseInt(x1Input.getText());
                y1 = Integer.parseInt(y1Input.getText());
                x2 = Integer.parseInt(x2Input.getText());
                y2 = Integer.parseInt(y2Input.getText());
            } catch (Exception ex) { }
            TimeTracker.start();
            drawingPanel.drawPoints(StepByStep.stepByStep(x1, y1, x2, y2));
            timeLabel.setText("Time: "  + TimeTracker.getTime() / 1000 + " ms");
        });
        add(stepByStepButton);

        JButton CDAButton = new JButton("ЦДА");
        CDAButton.setBounds(260, 620, 200, 40);
        CDAButton.addActionListener(e -> {
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            try {
                x1 = Integer.parseInt(x1Input.getText());
                y1 = Integer.parseInt(y1Input.getText());
                x2 = Integer.parseInt(x2Input.getText());
                y2 = Integer.parseInt(y2Input.getText());
            } catch (Exception ex) { }
            TimeTracker.start();
            drawingPanel.drawPoints(CDA.cda(x1, y1, x2, y2));
            timeLabel.setText("Время: "  + TimeTracker.getTime() / 1000  + " мс");

        });
        add(CDAButton);

        JButton bresenhamButton = new JButton("Алгоритм Брезенхема");
        bresenhamButton.setBounds(260, 670, 200, 40);
        bresenhamButton.addActionListener(e -> {
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            try {
                x1 = Integer.parseInt(x1Input.getText());
                y1 = Integer.parseInt(y1Input.getText());
                x2 = Integer.parseInt(x2Input.getText());
                y2 = Integer.parseInt(y2Input.getText());
            } catch (Exception ex) { }
            TimeTracker.start();
            drawingPanel.drawPoints(Bresenham.bresenham(x1, y1, x2, y2));
            timeLabel.setText("Time: "  + TimeTracker.getTime() / 1000  + " ms");

        });
        add(bresenhamButton);

        JButton bresenhamCircleButton = new JButton("Окружность Брезенхема");
        bresenhamCircleButton.setBounds(260, 720, 200, 40);
        bresenhamCircleButton.addActionListener(e -> {
            int x1 = 0, y1 = 0, r = 0;
            try {
                x1 = Integer.parseInt(x1Input.getText());
                y1 = Integer.parseInt(y1Input.getText());
                r = Integer.parseInt(radiusInput.getText());
            } catch (Exception ex) { }
            TimeTracker.start();
            drawingPanel.drawPoints( BresenhamCircle.bresenhamCircle(x1, y1, r));
            timeLabel.setText("Time: "  +  TimeTracker.getTime() / 1000  + " ms");
        });
        add(bresenhamCircleButton);

        JButton clearButton = new JButton("Очистить");
        clearButton.setBounds(260, 770, 200, 40);
        clearButton.addActionListener(e -> drawingPanel.drawPoints(new ArrayList<Point>()));
        add(clearButton);

        setResizable(false);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.repaint();
    }
}

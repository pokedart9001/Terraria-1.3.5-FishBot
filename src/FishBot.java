import javax.swing.*;
import java.awt.*;

public class FishBot {
    private JPanel fishBot;
    private JButton startButton;
    private JSpinner secondsSpinner;
    private JSpinner repeatsSpinner;
    private JSpinner castsSpinner;
    private JCheckBox waitBox;
    private JCheckBox warningBox;
    private boolean waiting;
    private boolean warning;
    private int casts;
    private int repeats;
    private int seconds;

    private static void setDimensions(JSpinner spinner)
    {
        Component spinnerEditor = spinner.getEditor();
        JFormattedTextField field = ((JSpinner.DefaultEditor) spinnerEditor).getTextField();
        field.setColumns(3);
    }

    private FishBot() {
        setDimensions(secondsSpinner);
        setDimensions(repeatsSpinner);
        setDimensions(castsSpinner);
        startButton.addActionListener(e -> {
            waiting = waitBox.isSelected();
            warning = warningBox.isSelected();
            casts = (Integer)castsSpinner.getValue();
            repeats = (Integer)repeatsSpinner.getValue();
            seconds = (Integer)secondsSpinner.getValue();

            if (casts < 1 || (!waiting && repeats < 1) || seconds < 1)
                JOptionPane.showMessageDialog(fishBot,
                        "Please make sure each value is greater than or equal to 1.",
                        "Invalid values",
                        JOptionPane.ERROR_MESSAGE);
            else
            {
                if (warning) {
                    JOptionPane.showMessageDialog(fishBot,
                            "Make sure the mouse is hovered over the throwaway item stack.",
                            "Prepare yourself",
                            JOptionPane.WARNING_MESSAGE);
                }
                FishBotScript script = new FishBotScript(waiting, casts, repeats, seconds);
                script.start();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FishBot");
        frame.setContentPane(new FishBot().fishBot);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

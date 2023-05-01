import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScientificCalculator extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField displayField;
    private JButton[] buttons;
    private String[] buttonLabels = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
    private double currentValue = 0.0;
    private String currentOperation = "=";

    public ScientificCalculator() {
        super("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(200,100,500,500);
        setLayout(new BorderLayout());

        displayField = new JTextField("0");
        displayField.setBounds(100,100,300,100);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String buttonLabel = event.getActionCommand();
        switch (buttonLabel) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".":
                if (displayField.getText().equals("0") || currentOperation.equals("=")) {
                    displayField.setText(buttonLabel);
                } else {
                    displayField.setText(displayField.getText() + buttonLabel);
                }
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "=":
                performOperation(buttonLabel);
                break;
        }
    }

    private void performOperation(String operation) {
        double newValue = Double.parseDouble(displayField.getText());
        switch (currentOperation) {
            case "+":
                currentValue += newValue;
                break;
            case "-":
                currentValue -= newValue;
                break;
            case "*":
                currentValue *= newValue;
                break;
            case "/":
                currentValue /= newValue;
                break;
            case "=":
                currentValue = newValue;
                break;
        }
        displayField.setText("" + currentValue);
        currentOperation = operation;
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }

}

package no.uib.this OOP course.calculator.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import no.uib.this OOP course.calculator.Calculator;
import no.uib.this OOP course.calculator.expression.Expression;
import no.uib.this OOP course.calculator.expression.ExpressionParser;

/**
 * A graphical user interface for a calculator application.
 * Provides a visual interface for entering mathematical expressions and
 * displaying results.
 */
public class CalculatorGUI {

	/**
	 * Text displayed when an invalid expression is entered.
	 */
	private final String ERROR_TEXT = "Invalid";

	private final JFrame frame;
	private JTextField textField;
	private final Calculator calculator;

	/**
	 * Constructs a CalculatorGUI instance with the given Calculator object.
	 *
	 * @param calculator the Calculator instance used to evaluate expressions
	 */
	public CalculatorGUI(Calculator calculator) {
		this.calculator = calculator;

		this.frame = new JFrame("this OOP course Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 600);
		frame.setLayout(new BorderLayout());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		setIcon("src/resources/calculator.png");
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 20));

		addTextField();
		addButtons();

		frame.setVisible(true);
	}

	/**
	 * Sets the application icon for the JFrame.
	 *
	 * @param filename the path to the icon image file
	 */
	private void setIcon(String filename) {
		ImageIcon img = new ImageIcon(filename);
		frame.setIconImage(img.getImage());
	}

	/**
	 * Adds a text field to the GUI for displaying input and results.
	 */
	private void addTextField() {
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Arial", Font.BOLD, 90));
		textField.setHorizontalAlignment(JTextField.RIGHT);
		frame.add(textField, BorderLayout.NORTH);
		textField.setText("0");
	}

	/**
	 * Adds all the buttons (numbers, operators, and controls) to the GUI.
	 */
	/**
	 * Adds all the buttons (numbers, operators, and controls) to the GUI.
	 */
	private void addButtons() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout(10, 10)); // Use BorderLayout for main panel

		// Create a panel for number and control buttons
		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new GridLayout(6, 3, 15, 15));
		numberPanel.setBackground(new Color(240, 240, 240));

		addTopButtons(numberPanel);
		addNumberButtons(numberPanel);
		addBottomButtons(numberPanel);

		// Create a panel for operator buttons
		JPanel operatorPanel = new JPanel();
		operatorPanel.setLayout(new GridLayout(1, calculator.getOperatorSymbols().size(), 15, 15)); // Adjust grid
																									// layout
		operatorPanel.setBackground(new Color(240, 240, 240));

		addOperatorButtons(operatorPanel);

		// Add number buttons panel to the top (North) of the main panel
		buttonPanel.add(numberPanel, BorderLayout.CENTER);
		// Add operator buttons panel to the bottom (South) of the main panel
		buttonPanel.add(operatorPanel, BorderLayout.SOUTH);

		frame.add(buttonPanel, BorderLayout.CENTER);
	}

	/**
	 * Adds the top row of buttons (Clear, Backspace, and Easter Egg) to the panel.
	 *
	 * @param buttonPanel the panel to which buttons are added
	 */
	private void addTopButtons(JPanel buttonPanel) {
		addButton(buttonPanel, "C", "Clear: \"Remove all characters\"", clearActionListener());
		addButton(buttonPanel, "<--", "Erase: \"Remove one character\"", backspaceActionListener());
		addButton(buttonPanel, " ", "", emptyActionListener());
	}

	/**
	 * Adds number buttons (0-9) and parentheses to the panel.
	 *
	 * @param buttonPanel the panel to which buttons are added
	 */
	private void addNumberButtons(JPanel buttonPanel) {
		String[] numbersLabels = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "(", ")" };
		for (String label : numbersLabels) {
			if (label.equals("(") || label.equals(")")) {
				addButton(buttonPanel, label, "Parenthesis", appendParenthesisActionListener(label));
			} else {
				addButton(buttonPanel, label, "", appendNumberActionListener(label));
			}
		}
	}

	/**
	 * Adds the bottom row of buttons (Decimal and Equals) to the panel.
	 *
	 * @param buttonPanel the panel to which buttons are added
	 */
	private void addBottomButtons(JPanel buttonPanel) {
		addButton(buttonPanel, ".", "Decimal", appendDecimalActionListener());
		addButton(buttonPanel, "=", "Equals: \"Perform calculation\"", equalsActionListener());
	}

	/**
	 * Adds operator buttons (e.g., +, -, *, /) to the panel.
	 *
	 * @param buttonPanel the panel to which buttons are added
	 */
	private void addOperatorButtons(JPanel buttonPanel) {
		for (String operatorSymbol : calculator.getOperatorSymbols()) {
			String operatorDescription = calculator.getOperatorDescription(operatorSymbol);
			addButton(buttonPanel, operatorSymbol,
					operatorDescription, appendOperatorActionListener(operatorSymbol));
		}
	}

	/**
	 * Creates an ActionListener for clearing the text field.
	 *
	 * @return the ActionListener for the Clear button
	 */
	private ActionListener clearActionListener() {
		return e -> textField.setText("0");
	}

	/**
	 * Creates an ActionListener for removing the last character from the text
	 * field.
	 *
	 * @return the ActionListener for the Backspace button
	 */
	private ActionListener backspaceActionListener() {
		return e -> {
			String text = textField.getText();
			if (text.length() > 1) {
				textField.setText(text.substring(0, text.length() - 1));
			} else {
				textField.setText("0");
			}
		};
	}

	/**
	 * Creates an ActionListener for the Easter Egg button.
	 * Opens a URL when clicked.
	 *
	 * @return the ActionListener for the Easter Egg button
	 */
	private ActionListener emptyActionListener() {
		return e -> {
			textField.setText("Gottem");
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
				} catch (Exception ex) {
				}
			}
		};
	}

	/**
	 * Creates an ActionListener for appending a number to the text field.
	 *
	 * @param number the number to append
	 * @return the ActionListener for number buttons
	 */
	private ActionListener appendNumberActionListener(String number) {
		return e -> {
			String currentText = textField.getText();
			if (currentText.equals(ERROR_TEXT)) {
				currentText = "0"; // Reset if an error was previously displayed
			}
	
			// Allow functions like "ln(" or "log(" at the beginning
			if (currentText.equals("0")) {
				textField.setText(number); 
			} else if (currentText.matches(".*[a-zA-Z]+\\($")) { 
				textField.setText(currentText + number); 
			} else {
				textField.setText(currentText + number);
			}
		};
	}
	
	/**
	 * Creates an ActionListener for appending a parenthesis to the text field.
	 * Ensures that parentheses are balanced.
	 *
	 * @param parenthesis the parenthesis to append
	 * @return the ActionListener for parenthesis buttons
	 */
	private ActionListener appendParenthesisActionListener(String parenthesis) {
		return e -> {
			String currentText = textField.getText();
			if (currentText.equals(ERROR_TEXT)) {
				currentText = ""; // Reset if the current text is "Invalid"
			}

			int openCount = currentText.length() - currentText.replace("(", "").length();
			int closeCount = currentText.length() - currentText.replace(")", "").length();

			if (parenthesis.equals("(")) {
				textField.setText(currentText + "(");
			} else if (parenthesis.equals(")") && closeCount < openCount) {
				textField.setText(currentText + ")");
			}
		};
	}

	/**
	 * Creates an ActionListener for appending a decimal point to the text field.
	 * Ensures only one decimal point is added per number.
	 *
	 * @return the ActionListener for the Decimal button
	 */
	private ActionListener appendDecimalActionListener() {
		return e -> {
			String currentText = textField.getText();
			if (currentText.equals(ERROR_TEXT)) {
				currentText = "0"; // Reset if an error was previously displayed
			}

			// Allow "0." if currently "0"
			if (currentText.equals("0")) {
				textField.setText("0.");
				return;
			}

			// Split by operators to check the last number
			String[] parts = currentText.split("[+\\-*/]");
			String lastNumber = parts[parts.length - 1];

			// Only add decimal if there isn't already one in the last number
			if (!lastNumber.contains(".")) {
				textField.setText(currentText + ".");
			}
		};
	}

	/**
	 * Creates an ActionListener for appending an operator to the text field.
	 *
	 * @param operator the operator to append
	 * @return the ActionListener for operator buttons
	 */
	private ActionListener appendOperatorActionListener(String operator) {
		return e -> {
			String currentText = textField.getText();
			if (currentText.equals(ERROR_TEXT)) {
				currentText = "0"; // Reset if an error was previously displayed
			}

			// Allow minus sign (-) as the first character for negative numbers
			if (operator.equals("-") && currentText.equals("0")) {
				textField.setText("-");
			}
			// Prevent consecutive operators but allow unary minus at the start
			else if (currentText.equals("0")) {
				List<String> suffixOperators = Arrays.asList("ln", "log", "√");
				if (suffixOperators.contains(operator)) {
					textField.setText(operator + "(");
				}
				else {
					textField.setText(currentText + operator);
				}

			} else {
				textField.setText(currentText + operator);
			}
		};
	}

	/**
	 * Creates an ActionListener for evaluating the expression in the text field.
	 * Displays the result or an error message if the expression is invalid.
	 *
	 * @return the ActionListener for the Equals button
	 */
	private ActionListener equalsActionListener() {
		return e -> {
			try {
				Expression expression = ExpressionParser.parse(textField.getText());
				double value = calculator.evaluate(expression);
				textField.setText(formatNumber(value));
			} catch (IllegalArgumentException ex) {
				textField.setText(ERROR_TEXT);
			}
		};
	}

	/**
	 * Adds a button to the panel with the given label, description, and action.
	 *
	 * @param panel          the panel to which the button is added
	 * @param label          the text displayed on the button
	 * @param description    the tooltip text for the button
	 * @param actionListener the action performed when the button is clicked
	 */
	private void addButton(JPanel panel, String label, String description, ActionListener actionListener) {
		JButton button = new JButton(label);
		button.setFont(new Font("Arial", Font.BOLD, 24));
		button.setPreferredSize(new Dimension(100, 80));
		button.setFocusPainted(false);
		button.setBackground(new Color(220, 220, 220));
		button.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
		button.addActionListener(actionListener);
		if (!description.isEmpty()) {
			button.setToolTipText(description);
		}
		panel.add(button);
	}

	/**
	 * Formats a number for display, removing trailing decimal zeros if applicable.
	 *
	 * @param number the number to format
	 * @return the formatted number as a String
	 */
	private static String formatNumber(double number) {
		if (number % 1 == 0) {
			return String.format("%d", (int) number);
		} else {
			return String.format("%s", number);
		}
	}
}

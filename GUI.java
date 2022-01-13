import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI implements ActionListener {

	JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, equal, plus, minus, multiply, divide, clear, percent, plusMinus, delete, dot;
	JTextArea text;
	int num = 0;
	int sum = 0;

	ActionEvent lastOp = null;
	
	GUI(String title){
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		frame.add(panel);
		
		text = new JTextArea(3, 30);
		text.setEditable(false);
//		text.setText("0");
		panel.add(text, BorderLayout.PAGE_START);
		
		JPanel digits = new JPanel();
		digits.setLayout(new GridLayout(5, 4));

		
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		button0 = new JButton("0");
		clear = new JButton("C");
		plus = new JButton("+");
		minus = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		equal = new JButton("=");
		percent = new JButton("%");
		plusMinus = new JButton("+/-");
		delete = new JButton("Del");
		dot = new JButton(".");
		

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		clear.addActionListener(this);
		
		plus.addActionListener(this);
		minus.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		equal.addActionListener(this);
		
		digits.add(clear);
		digits.add(percent);
		digits.add(plusMinus);
		digits.add(divide);
		
		digits.add(button7);
		digits.add(button8);
		digits.add(button9);
		digits.add(multiply);
		
		digits.add(button4);
		digits.add(button5);
		digits.add(button6);
		digits.add(minus);
		
		digits.add(button1);
		digits.add(button2);
		digits.add(button3);
		digits.add(plus);
		
		digits.add(delete);
		digits.add(button0);
		digits.add(dot);
		digits.add(equal);

		panel.add(digits, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			text.append("1");
		}
		if(e.getSource() == button2) {
			text.append("2");
		}
		if(e.getSource() == button3) {
			text.append("3");
		}
		if(e.getSource() == button4) {
			text.append("4");
		}
		if(e.getSource() == button5) {
			text.append("5");
		}
		if(e.getSource() == button6) {
			text.append("6");
		}
		if(e.getSource() == button7) {
			text.append("7");
		}
		if(e.getSource() == button8) {
			text.append("8");
		}
		if(e.getSource() == button9) {
			text.append("9");
		}
		if(e.getSource() == button0) {
			text.append("0");
		}
		if(e.getSource() == clear) {
			text.setText("");
			sum = 0;
		}

		if(e.getSource() == equal) {			
			String eq = text.getText();
			System.out.println(eq);
			text.setText(eval(eq));
		}
		if(e.getSource() == plus) {			
			text.append("+");
		}
		if(e.getSource() == minus) {
			text.append("-");
		}
		if(e.getSource() == multiply) {
			text.append("*");
		}
		if(e.getSource() == divide) {
			text.append("/");
		}
		
	}

	private String eval(String eq) {
		String[] splitStrings = (eq.split("((?<=[+-/*])|(?=[+-/*]))"));
		int result = 0;
		int left = Integer.parseInt(splitStrings[0]);
		
		for(int i = 1; i < splitStrings.length; i+=2) {

			String op = splitStrings[i];
			int right = Integer.parseInt(splitStrings[i+1]);
			
			switch(op) {
				case "+":
					result = left + right;
					left = left + right;
					break;
				case "-":
					result = left - right;
					left = left - right;
					break;
				case "*":
					result = left * right;
					left = left * right;
					break;
				case "/":
					result = left/right;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
					left = left/right;
					break;
			}
		}
		return Integer.toString(result);
	}


}

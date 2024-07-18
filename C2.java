package calculations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class C2 implements ActionListener{

	//we need JFrame...
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[10];
	JButton sinButton,cosButton,tanButton,logButton;	 
	JButton decButton,equButton,delButton,clrButton,negButton,modButton;	
	JPanel panel;
	
	Font myFont = new Font("Times New Roman",Font.BOLD,30); //custom Font
	Font myFont1 = new Font("Times New Roman",Font.BOLD,18);
	double num1=0,num2=0,result=0;
	String operator;

	//constructor of calculator
	public C2()
	{
		frame = new JFrame("**CALCULATOR** Mode(3/4)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		frame.setResizable(false);
		ImageIcon icon = new ImageIcon("calculator.png");
		frame.setIconImage(icon.getImage());  //icon of frame
		frame.getContentPane().setBackground(new Color(255,255,255));
		//JLebel
		JLabel backgroundlabel = new JLabel(new ImageIcon("math2.jpg"));
		frame.setContentPane(backgroundlabel);
		
		textfield = new JTextField();
		textfield.setBounds(30,25,340,50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
	
		sinButton = new JButton("sin");	sinButton.setBackground(Color.WHITE);
		cosButton = new JButton("cos"); cosButton.setBackground(Color.WHITE);
		tanButton = new JButton("tan");	tanButton.setBackground(Color.WHITE);
		logButton = new JButton("log");	logButton.setBackground(Color.PINK);
		decButton = new JButton(".");	decButton.setBackground(Color.PINK);
		equButton = new JButton("=");	equButton.setBackground(Color.PINK);
		delButton = new JButton("Dlt");	delButton.setBackground(new Color(255,255,255));
		clrButton = new JButton("Clr");	clrButton.setBackground(new Color(255,0,0));
		negButton = new JButton("(-)");	negButton.setBackground(new Color(255,255,255));
		modButton = new JButton("Mo");	modButton.setBackground(new Color(255,0,0));

		functionButtons[0] = sinButton;
		functionButtons[1] = cosButton;
		functionButtons[2] = tanButton;
		functionButtons[3] = logButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;	
		functionButtons[8] = negButton;
		functionButtons[9] = modButton;	

		for(int i=0;i<10;i++)
		{
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont1);
			functionButtons[i].setFocusable(false);
		}
		for(int i=0;i<10;i++)
		{
			numberButtons[i] = new JButton(String.valueOf(i)); // value of i in string form
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		delButton.setBounds(50,430,67,70);
		clrButton.setBounds(127,430,67,70);
		negButton.setBounds(204,430,67,70);
		modButton.setBounds(281,430,69,70);

		//for other button we need panel which is above declared
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,5,10,10));
		panel.setBackground(Color.BLACK);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(sinButton);

		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(cosButton);

		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(tanButton);

		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(logButton);	
	
		frame.add(panel);
		frame.add(delButton);
		frame.add(negButton);	
		frame.add(clrButton);
		frame.add(modButton);
		frame.add(textfield);
		frame.setVisible(true);	
	}
	public static void main(String[] args){
	//instance of Calculator class
	
	//C2 calc = new C2();
	
	}

	//Actionlistener auto-method
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0;i<10;i++)		
		{
			if(e.getSource() == numberButtons[i]){
			textfield.setText(textfield.getText().concat(String.valueOf(i)));
		}	}
		
		if(e.getSource() == decButton){
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == sinButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "sin";
			textfield.setText("");
		}
		if(e.getSource() == cosButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "cos";
			textfield.setText("");
		}
		if(e.getSource() == tanButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "tan";
			textfield.setText("");
		}
		if(e.getSource() == logButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "log";
			textfield.setText("");
		}
		if(e.getSource() == equButton){
			
			switch(operator)
			{
				case"sin":
				result=(Math.sin(num1));
				break;
				case"cos":
				result=(Math.cos(num1));
				break;
				case"tan":
				result=(Math.tan(num1));
				break;
				case"log":
				result=(Math.log10(num1));
			}
			textfield.setText(String.valueOf(result));
			num1=result; // we want to continue with previous value..	
		}
		if(e.getSource() == clrButton){
			textfield.setText("");
		}
		if(e.getSource() == delButton){
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++){
			textfield.setText(textfield.getText()+string.charAt(i));
			}
		}

		if(e.getSource() == negButton){
		double temp = Double.parseDouble(textfield.getText());
		temp*=-1;
		textfield.setText(String.valueOf(temp));	
		}	
		if(e.getSource() == modButton){
		textfield.setText("");
		C3 obj = new C3(); 
		frame.setVisible(false);
		}

			
	} //action listener ends.
}
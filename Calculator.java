/* 
* Author    : Adeel Ahmed Qureshi
* CMS	    : 023-22-0141
* Department: BsCs(ii) - D
* project   : Caluclator GUI based
* Date      : 01/05/2023.
* Created in : Notepad.
*/
package calculations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
public class Calculator implements ActionListener{

	//we need JFrame...
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[10];
	JButton addButton,subButton,mulButton,divButton;	 
	JButton decButton,equButton,delButton,clrButton,negButton,modButton;	
	JPanel panel;
	
	Font myFont = new Font("Times New Roman",Font.BOLD,30); //custom Font
	Font myFont1 = new Font("Times New Roman",Font.BOLD,22);
	double num1=0,num2=0,result=0;
	char operator;

	//constructor of calculator
	public Calculator()
	{
		frame = new JFrame("**CALCULATOR** Mode(1/4)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		frame.setResizable(false);
		ImageIcon icon = new ImageIcon("calculator.png");
		frame.setIconImage(icon.getImage());  //icon of frame
		frame.getContentPane().setBackground(new Color(255,255,255));
		
		//JLebel
		JLabel backgroundlabel = new JLabel(new ImageIcon("math.jpg"));
		frame.setContentPane(backgroundlabel);
		
		
		textfield = new JTextField();
		textfield.setBounds(30,25,340,50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
	
		addButton = new JButton("+");	addButton.setBackground(Color.PINK);
		subButton = new JButton("-"); 	subButton.setBackground(Color.PINK);
		mulButton = new JButton("*");	mulButton.setBackground(Color.PINK);
		divButton = new JButton("/");	divButton.setBackground(Color.PINK);
		decButton = new JButton(".");	decButton.setBackground(new Color(220,220,220));
		equButton = new JButton("=");	equButton.setBackground(new Color(220,220,220));
		delButton = new JButton("Dlt");	delButton.setBackground(new Color(255,255,255));
		clrButton = new JButton("Clr");	clrButton.setBackground(new Color(255,0,0));
		negButton = new JButton("(-)");	negButton.setBackground(new Color(255,255,255));
		modButton = new JButton("Mo");	modButton.setBackground(new Color(255,0,0));

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;	
		functionButtons[8] = negButton;
		functionButtons[9] = modButton;	

		for(int i=0;i<10;i++)
		{
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		//different font for last 4 buttons
		functionButtons[6].setFont(myFont1);
		functionButtons[7].setFont(myFont1);
		functionButtons[8].setFont(myFont1);
		functionButtons[9].setFont(myFont1);
				
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
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.CYAN);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);

		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);

		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);

		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);	
	
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
	
	Calculator calc = new Calculator();
	
	}
	public static void MainMenu()
	{ 
		//Calculator c = new Calculator(); 
	}
	//Actionlistener auto-method
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0;i<10;i++)		
		{
			if(e.getSource() == numberButtons[i]){
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton){
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource() == subButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource() == mulButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource() == divButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource() == equButton){
			num2= Double.parseDouble(textfield.getText());
			
			switch(operator)
			{
				case'+':
				result=num1+num2;
				break;
				case'-':
				result=num1-num2;
				break;
				case'*':
				result=num1*num2;
				break;
				case'/':
				result=num1/num2;	// exceptions?
				break;
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
			C1 c = new C1();
			frame.setVisible(false);
		}
	}
}
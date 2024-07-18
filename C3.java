package calculations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
public class C3 implements ActionListener{

	//we need JFrame...
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[10];
	JButton asinButton,acosButton,atanButton,lnButton;	 
	JButton decButton,equButton,delButton,clrButton,negButton,modButton;	
	JPanel panel;
	
	Font myFont = new Font("Times New Roman",Font.BOLD,30); //custom Font
	Font myFont1 = new Font("Times New Roman",Font.BOLD,17);
	double num1=0,num2=0,result=0;
	String operator;

	//constructor of calculator
	public C3()
	{
		frame = new JFrame("**CALCULATOR** Mode(4/4)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		frame.setResizable(false);
		ImageIcon icon = new ImageIcon("calculator.png");
		frame.setIconImage(icon.getImage());  //icon of frame
		frame.getContentPane().setBackground(new Color(255,255,255));
		//JLebel
		JLabel backgroundlabel = new JLabel(new ImageIcon("math3.jpg"));
		frame.setContentPane(backgroundlabel);
		
		textfield = new JTextField();
		textfield.setBounds(30,25,340,50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
	
		asinButton = new JButton("asin"); asinButton.setBackground(Color.MAGENTA);
		acosButton = new JButton("acos"); acosButton.setBackground(Color.MAGENTA);
		atanButton = new JButton("atan"); atanButton.setBackground(Color.MAGENTA);
		lnButton = new JButton("ln");	lnButton.setBackground(Color.PINK);
		decButton = new JButton(".");	decButton.setBackground(Color.PINK);
		equButton = new JButton("=");	equButton.setBackground(Color.PINK);
		delButton = new JButton("Dlt");	delButton.setBackground(new Color(255,255,255));
		clrButton = new JButton("Clr");	clrButton.setBackground(new Color(255,0,0));
		negButton = new JButton("(-)");	negButton.setBackground(new Color(255,255,255));
		modButton = new JButton("Mo");	modButton.setBackground(new Color(255,0,0));

		functionButtons[0] = asinButton;
		functionButtons[1] = acosButton;
		functionButtons[2] = atanButton;
		functionButtons[3] = lnButton;
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
		panel.setBackground(Color.BLUE);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(asinButton);

		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(acosButton);

		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(atanButton);

		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(lnButton);	
	
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

	//C3 calc = new C3();	
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
		if(e.getSource() == asinButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "asin";
			textfield.setText("");
		}
		if(e.getSource() == acosButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "acos";
			textfield.setText("");
		}
		if(e.getSource() == atanButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "atan";
			textfield.setText("");
		}
		if(e.getSource() == lnButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "ln";
			textfield.setText("");
		}
		if(e.getSource() == equButton){
			
			switch(operator)
			{
				case"asin":
				result=(Math.asin(num1));
				break;
				case"acos":
				result=(Math.acos(num1));
				break;
				case"atan":
				result=(Math.atan(num1));
				break;
				case"ln":
				result=(Math.log(num1));
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
			Calculator c = new Calculator();
			frame.setVisible(false);
		}
	}
}
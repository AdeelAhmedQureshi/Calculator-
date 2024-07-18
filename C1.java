package calculations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class C1 implements ActionListener{

	//we need JFrame...
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[10];
	JButton perButton,powButton,rootButton,facButton;	 
	JButton decButton,equButton,delButton,clrButton,negButton,modButton;	
	JPanel panel;
	
	Font myFont = new Font("Times New Roman",Font.BOLD,30); //custom Font
	Font myFont1 = new Font("Times New Roman",Font.BOLD,22);
	double num1=0,num2=0,result=0;
	char operator;

	//constructor of calculator
	public C1()
	{
		frame = new JFrame("**CALCULATOR** Mode(2/4)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		frame.setResizable(false);
		ImageIcon icon = new ImageIcon("calculator.png");
		frame.setIconImage(icon.getImage());  //icon of frame
		frame.getContentPane().setBackground(new Color(255,255,255));	
			//JLebel
		JLabel backgroundlabel = new JLabel(new ImageIcon("math1.jpg"));
		frame.setContentPane(backgroundlabel);

		textfield = new JTextField();
		textfield.setBounds(30,25,340,50);
		textfield.setFont(myFont);
		textfield.setEditable(false);

		perButton = new JButton("%");	perButton.setBackground(Color.PINK);
		powButton = new JButton("^"); 	powButton.setBackground(Color.PINK);
		rootButton = new JButton("Rt");	rootButton.setBackground(Color.PINK);
		facButton = new JButton("x!");	facButton.setBackground(Color.PINK);
		decButton = new JButton(".");	decButton.setBackground(new Color(220,220,220));
		equButton = new JButton("=");	equButton.setBackground(new Color(220,220,220));
		delButton = new JButton("Dlt");	delButton.setBackground(new Color(255,255,255));
		clrButton = new JButton("Clr");	clrButton.setBackground(new Color(255,0,0));
		negButton = new JButton("(-)");	negButton.setBackground(new Color(255,255,255));
		modButton = new JButton("Mo");	modButton.setBackground(new Color(255,0,0));

		functionButtons[0] = perButton;
		functionButtons[1] = powButton;
		functionButtons[2] = rootButton;
		functionButtons[3] = facButton;
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
		panel.setBackground(new Color(128,175,175));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(perButton);

		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(powButton);

		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(rootButton);

		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(facButton);	
	
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
	
	//C1 calc = new C1();
	
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
		if(e.getSource() == perButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '%';
			textfield.setText("");
		}
		if(e.getSource() == powButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '^';
			textfield.setText("");
		}
		if(e.getSource() == rootButton){
			try{
			num1 = Double.parseDouble(textfield.getText());
			if(num1<0){ throw new Exception();}
			}catch(Exception e1) {JOptionPane.showMessageDialog(null,"Radicand must be +ve!");}
			operator = 'r';
			textfield.setText("");
		}
		if(e.getSource() == facButton){
			try{
			num1 = Double.parseDouble(textfield.getText());
			if(num1<0) {throw new Exception();}
			}catch(Exception e2) {JOptionPane.showMessageDialog(null,"number must be +ve!");}
			operator = '!';
			textfield.setText("");
		}
		if(e.getSource() == equButton){
			if(operator!= '!')
			{num2= Double.parseDouble(textfield.getText());}
			switch(operator)
			{
				case'%':
				result=((num1/100)*num2);
				break;
				case'^':
				result=Math.pow(num1,num2);
				break;
				case'r':
				if(num1<0)
				{result=0.0000;}
				else
				{
					if(num1>=0){
					num2=1/num2;
					result=Math.pow(num1,num2);
					result=result*1000;
					result=Math.round(result);
					if(result % 10 ==9) {result=Math.round(result);}
					else
					{result=result/1000;}}
				}
				break;
				case'!':
				result=Factorial((int)num1);
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
			C2 c = new C2();
			frame.setVisible(false);
		}
	} //actionPerformed ends

	//method of factorial.
	public static int Factorial(int n){
	if(n==0){return 1;}
	else{return n*Factorial(n-1);}
	}
} // class ends.

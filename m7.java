package m7;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
public  class m7 implements ActionListener {
	
	JFrame  menu;// to create the frame
	JCheckBox[] items;// an array for all the items on the menu 
	double[] prices= {12.90,7.50,5.25,4.00,7.00,5.00,12.87,8.00,9.00,1.00};//the prices in an array  
	
    // 1-"pizza",2-"nachos ",3-"icecrem",4- "milkshake",5-"salat",6-"fries",7-"burger",8-"sandwich",9-"pasta", 10-"water"
	// i put the item here so i can see them when making the price i am sure there is a better way to do this but this worked  
	//is there a better way you would recommend to to this? 
	
	JLabel t; //this label is for the art for the frame 
	JLabel totalLabel;//this is for the total 
	JButton button;//Buttons for calculation 
	m7(){  //this is the constructed 
		
		//------------part 1 create the main window add a layout ,size , color, font ... -------- 
    menu = new JFrame("menu");// to create the window 
	menu.getContentPane().setBackground(new Color(201,71,119));// Background color only the frame  with RGB 
	menu.setSize(400,600); //the size 
	menu.setResizable(false);// i added this so gored layout will work well 
	menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close it  when i press X 
    menu.setLayout(new GridLayout(13,1));//Using gored layout with 14 rows and 1 column 

    //fonts 
    Font titleFont=new Font("SansSerif",Font.PLAIN,34);// title font 
	Font CheckBoxFont=new Font ("Tahoma",Font.PLAIN,24);//boxes font 
	Font totalFont=new Font("SansSerif",Font.BOLD,34);// u know
	
	//----------part 2 create title label -------
    t=new JLabel("restaurant menu");// the title 
    t.setHorizontalAlignment(JLabel.CENTER);//center the title 
    t.setFont(titleFont);//font type titleFont 
    t.setForeground(Color.WHITE);// color for the setForeground
    t.setOpaque(true);//to allow it to show 
    t.setBackground(new Color(120,154,194));// color for title 
	menu.add(t); //add all to the frame 
	
	//------part 3 add a list of items ------
	String[] food= { "pizza","nachos","ice cream", "milkshake","salad","fries"
			,"burger","sandwich","pasta", "water"};
	
	//-------part4  create checkbooks list for the food --------
	items=new JCheckBox[10];// array with 10 items  
	for(int i=0;i<food.length;i++) { 
		 items[i]=new JCheckBox(food[i]+" - $"+prices[i]);// Checkbooks for each of the items
		 items[i].setFont(CheckBoxFont); //font of it 
		 menu.add(items[i]);//add it all to the frame 
	 }
	
	//----part 5 add buttons that calculate the total price --
	 button = new JButton ("calculate the total");
	 button.setFont(CheckBoxFont);//font for the button 
	 button.setBackground(new Color(120,154,90));// color 
	 button.setForeground(Color.BLACK);//  text color 
	 button.addActionListener(this); //this will  connect the button to the action method 
	 menu.add(button);// add it all to the frame 
	 
	 //------part 6  add label that shows the total price 
	 totalLabel=new JLabel("Total: $0.00");
	 totalLabel.setFont(totalFont);//font 
	 totalLabel.setForeground(Color.WHITE);// color 
	 menu.add(totalLabel);//add this all to the frame 
     menu.setVisible(true);//this will show the frame 
	}
	
	//------- part 7 make the buttons run an click and calculate total of the items that are selected -------
	public void actionPerformed(ActionEvent e) {
		double total=0;
	for(int i=0;i<items.length;i++) {//loop through all of the items 
		if(items[i].isSelected()) {//check if the item was selected 
			total+=prices[i];//add it to total 
		}
	}
	totalLabel.setText(String.format("Total: $%.2f",total));// Display the end result 
}
	//-------- part 8 start the program ----------
     public static void main(String[] args) {
	  new m7();   
	}
	
}
// thank you so much this was fun :)

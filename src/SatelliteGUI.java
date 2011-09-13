import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import gov.nasa.worldwind.*;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

/**
* Represents a satellite in orbit around the Earth's equator.
* @author CIS 112 ONLINE Class of Fall 2011
*/

public class SatelliteGUI extends JFrame
{ 


public SatelliteGUI()
{
	initComponents();
}

private void initComponents() {
	//Set Gravity
	gravity = 6.67 * Math.pow(10,-11);
	mass = 5.97 * Math.pow(10,24);
	
	//Add NASA GUI
	WorldWindowGLCanvas wwd = new WorldWindowGLCanvas();
	wwd.setModel(new BasicModel());
	
	setTitle("Satellite Orbit");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	// Instantiates the satellite
	satellite = new Satellite(7392000,0,0,7349);
	
	// Create X position textfield
	textfieldX = new JTextField(""); 
	textfieldX.setPreferredSize(new Dimension(100, 25));

	// Create Y position textfield
	textfieldY = new JTextField(""); 
	textfieldY.setPreferredSize(new Dimension(100, 25));

	// Create X velocity textfield
	textfieldVX = new JTextField("");
	textfieldVX.setPreferredSize(new Dimension(100, 25));

	// Create Y velocity textfield 
	textfieldVY = new JTextField("");
	textfieldVY.setPreferredSize(new Dimension(100, 25));
	
	// Create Time textfield 
	textfieldTime = new JTextField("");
	textfieldTime.setPreferredSize(new Dimension(100, 25));
	
    jScrollPane1 = new javax.swing.JScrollPane();
    output = new javax.swing.JTextArea();
	
	// Create X position label 
	labelX = new JLabel("X Position:"); 

	// Create Y position label
	labelY = new JLabel("Y Position:"); 

	// Create X velocity label
	labelVX = new JLabel("X Velocity:");

	// Create Y velocity label
	labelVY = new JLabel("Y Velocity:");

	// Create Time label
	labelTime = new JLabel("Time:");
	
	// Create X position display label
	displayX = new JLabel("X Position: ");

	// Create Y position display label
	displayY = new JLabel("Y Position: "); 

	// Create X velocity display label
	displayVX = new JLabel("X Velocity: ");
 
	// Create Y velocity display label
	displayVY = new JLabel("Y Velocity: ");

	// Create simulation button
	simulateB = new JButton("Simulate");
    simulateB.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            simulateBActionPerformed(evt);
        }
    });

    output.setColumns(20);
    output.setRows(5);
    jScrollPane1.setViewportView(output);
//Set GroupLayout

	GroupLayout layout = new GroupLayout(getContentPane());
	getContentPane().setLayout(layout);
	layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textfieldX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelY)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textfieldY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelVX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textfieldVX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelVY)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(simulateB)
                                    .addComponent(textfieldVY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(displayX))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(displayY))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(displayVX))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(displayVY)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addComponent(wwd, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
	
	 layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(32, 32, 32)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(textfieldX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(labelX))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(textfieldY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(labelY))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(textfieldVX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(labelVX))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(textfieldVY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(labelVY))
	                .addGap(18, 18, 18)
	                .addComponent(simulateB)
	                .addGap(18, 18, 18)
	                .addComponent(displayX)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(displayY)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(displayVX)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(displayVY)
	                .addGap(174, 174, 174))
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(wwd, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	 pack();
}

private void simulateBActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
	//JOptionPane.showMessageDialog(this,"Someone please implement me =p !!!");

	this.setX(Integer.parseInt(textfieldX.getText()));
	this.setY(Integer.parseInt(textfieldY.getText()));
	this.setVX(Integer.parseInt(textfieldVX.getText()));
	this.setVY(Integer.parseInt(textfieldVY.getText()));

	output.append("x: " + this.getX());
	output.append("\ny: " + this.getY());
	output.append("\nvx: " + this.getVX());
	output.append("\nvy: " + this.getVY());
	
}

//sets the x variable
public void setX(int x){
	this.x = x;
}
//gets the x variable
public int getX(){return x;}

//sets the y variable
public void setY(int y){
	this.y = y;
}
//gets the vx variable
public int getY(){return y;}

//sets the vx variable
public void setVX(int vx){
	this.vx = vx;
}
//gets the vx variable
public int getVX(){return vx;}

//sets the vy variable
public void setVY(int vy){
	this.vy = vy;
}
//gets the vy variable
public int getVY(){return vy;}


//get ax using the formula
public double getAX(){
	ax =  (gravity * -1)* mass * (x/Math.pow(getDistance(), 3));
	return ax;
	}

public double getAY(){
	ay =  (gravity * -1)* mass * (y/Math.pow(getDistance(), 3));
	return ay;	
}

//calculate and get distance
public double getDistance(){
	return distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y,2));
}
public static void main(String[] args)
{
java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        new SatelliteGUI().setVisible(true);
    }
});
} 

//Text fields and labels for x, y, vx, and vy, and button to start the simulation
private JTextField textfieldX, textfieldY, textfieldVX, textfieldVY, textfieldTime;
private JLabel labelX, labelY, labelVX, labelVY, labelTime, displayX, displayY, displayVX, displayVY;
private int x,y,vx,vy,time;
private double ax,ay,d;
private double gravity, mass, distance;
private JButton simulateB;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTextArea output;

//Satellite Object
private Satellite satellite;

}

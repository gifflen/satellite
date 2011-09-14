import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Represents a satellite in orbit around the Earth's equator.
 * @author CIS 112 ONLINE Class of Fall 2011
 */
 
public class SatelliteGUITest extends JFrame
{  
   // Width and Height of the window
   private int sizeW = 1000;
   private int sizeH = 600;
   
   // Text fields and labels for x, y, vx, and vy, and button to start the simulation
   private JTextField textfieldX, textfieldY, textfieldVX, textfieldVY;
   private JLabel labelX, labelY, labelVX, labelVY;
   private JButton simulateB;
   private SimulatorHandler simulatorHandler;
    
  // Panel for the satellite information
   private SatellitePanel satellitePanel;
   
   // Satellite Object
   private Satellite satellite;
   
   // Simulator Thread
   private Simulator simulator;
    
   public SatelliteGUITest()
   {     
      setTitle("Satellite Orbit");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(sizeW, sizeH);
      
      // Create satellite panel
      satellitePanel = new SatellitePanel();
      getContentPane().add(satellitePanel);
   
      setVisible(true);
   }
    
   // Panel for satellite information
   public class SatellitePanel extends JPanel
   {
      // Earths position on the window and radius
      private int earthX = 500;
      private int earthY = 300;
      private int earthR = 100;
      
      public SatellitePanel()
      {
         // Set color, size, and location
         setBackground(new Color(125,125,125));
      
         // Create X position textfield
         textfieldX = new JTextField(""); 
         textfieldX.setSize(100,25);
         textfieldX.setLocation(110,10);  
         
         // Create Y position textfield
         textfieldY = new JTextField(""); 
         textfieldY.setSize(100,25);   
         textfieldY.setLocation(110,40);
         
         // Create X velocity textfield
         textfieldVX = new JTextField("");
         textfieldVX.setSize(100,25);  
         textfieldVX.setLocation(110,70);
         
         // Create Y velocity textfield   
         textfieldVY = new JTextField("");
         textfieldVY.setSize(100,25);
         textfieldVY.setLocation(110,100);
            
         // Create X position label 
         labelX = new JLabel("X Position:"); 
         labelX.setSize(100,25);
         labelX.setLocation(10,10); 
        
         // Create Y position label
         labelY = new JLabel("Y Position:"); 
         labelY.setSize(100,25); 
         labelY.setLocation(10,40);
         
         // Create X velocity label
         labelVX = new JLabel("X Velocity:");
         labelVX.setSize(100,25);   
         labelVX.setLocation(10,70);
            
         // Create Y velocity label
         labelVY = new JLabel("Y Velocity:");
         labelVY.setSize(100,25);
         labelVY.setLocation(10,100);
         
         // Create simulation button
         simulateB = new JButton("Simulate");
         simulateB.setSize(100,30);
        simulateB.setLocation(50,140);
         simulatorHandler = new SimulatorHandler();
         simulateB.addActionListener(simulatorHandler);
         
         // Get pane
         Container pane = getContentPane();
         
         // Add elements
         pane.add(labelX);
         pane.add(textfieldX);
         pane.add(labelY);
         pane.add(textfieldY);
         pane.add(labelVX);
         pane.add(textfieldVX);
         pane.add(labelVY);
         pane.add(textfieldVY);
         pane.add(simulateB);
      }
      
      // Paints the world and satellite
      public void paintComponent(Graphics g)
     {
         super.paintComponent(g);
         
         // paints the world, satellite, and satellite info
         g.setColor(Color.BLUE);
         g.fillOval(earthX-earthR,earthY-earthR,earthR*2,earthR*2);
         g.setColor(Color.BLACK);
         if (satellite != null)
         {
            g.fillOval((int)(100*satellite.getX()/satellite.r+earthX),(int)(earthY-(100*satellite.getY()/satellite.r)),5,5);
            g.drawString("X Position: " + String.format("%.2f",satellite.getX()) + "m", 10,200);
            g.drawString("Y Position: " + String.format("%.2f",satellite.getY()) + "m", 10,230);
            g.drawString("X Velocity: " + String.format("%.2f",satellite.getVx()) + "m/s", 10,260);
            g.drawString("Y Velocity: " + String.format("%.2f",satellite.getVy()) + "m/s", 10,290);
         }
            
      }
   } 
   
   // Class to start the satellite simulation
   public class SimulatorHandler implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (!textfieldX.getText().equals("") && !textfieldY.getText().equals("") && 
            !textfieldVX.getText().equals("") && !textfieldVY.getText().equals(""))
         {
            double x = Long.parseLong(textfieldX.getText());
            double y = Long.parseLong(textfieldY.getText());
            double vx = Long.parseLong(textfieldVX.getText());
            double vy = Long.parseLong(textfieldVY.getText());
            
            // create the satellite
            satellite = new Satellite(x,y,vx,vy);
            
            // Starts the simulator
            if (simulator != null)
               simulator.quit();
            simulator = new Simulator();
            simulator.start();
         }
      }
   }
   
   // Simulator Thread
   public class Simulator extends Thread
   {
      private boolean done;
      
      public Simulator()
      {
         done = false;
      }
      
      // quit the simulator
      public void quit()
      {
         done = true;
      }
      
      public void run()
      {
         while (!satellite.isCrashed() && !done)
         {
            // repaint the visual
            satellitePanel.repaint();
            
            // move the satellite by 1 second
            satellite.moveSatellite(1);
            
            try {Thread.sleep(1);}
            catch (Exception e){}
         }
      }
   }
    
   // Create the Application
   public static void main(String[] args)
   {
      SatelliteGUITest s = new SatelliteGUITest();
   }    
}
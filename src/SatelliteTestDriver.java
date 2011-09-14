
import java.util.Scanner;

/**
 * Test the Satellite Class
 * @author CIS 112 ONLINE Class of Fall 2011
 */
public class SatelliteTestDriver
{
    /**
     * Instantiates a Satellite object and tests it.
     * @param args command-line arguments provided by the user
     */
    public static void main(String[] args)
    {
        
        Satellite sat;                  // Satellite object
        double x, y, vx, vy;            // positions and accelerations
        int time, elapsedTime;          // the time to simulate        
        Scanner input = new Scanner(System.in);     // Create a Scanner
        
        // Get user input
        System.out.print("Initial x  : ");
        x = input.nextDouble();
        System.out.print("Initial y  : ");
        y = input.nextDouble();
        System.out.print("Initial vx : ");
        vx = input.nextDouble();
        System.out.print("Initial vy : ");
        vy = input.nextDouble();
        System.out.print("Time to Simulate: ");
        time = input.nextInt();
        
        // Create Satellite
        sat = new Satellite(x, y, vx, vy);
        
        // Print headings and initial sat info
        System.out.printf("%10s%15s%15s%15s%15s%15s%15s%20s%20s\n", "Time",
                "X Position","Y Position","X Velocity","Y Velocity",
                "Distance","Altitude","X Accelerations","Y Accelerations");
        printSatInfo(0, sat);   
        

        // Move Sat for 1 second and print
        sat.moveSatellite();
        printSatInfo(1, sat);

        // Move Sat for 59 seconds and print
        sat.moveSatellite(59);
        printSatInfo(60, sat);
        
        // Move Sat for 3540 seconds and print
        sat.moveSatellite(3540);
        printSatInfo(3600, sat);
        
        // While elapsedTime is less than time and sat is not crashed move sat
        elapsedTime = 3600;
        while (elapsedTime < time && !sat.isCrashed())
        {
            sat.moveSatellite();             
            elapsedTime++;
            
            // Uncomment below to print every second
            //printSatCoords(elapsedTime, sat);
            
            // Uncomment below to print every minute
            /*
            if (elapsedTime % 60 == 0)
            {
                printSatInfo(elapsedTime, sat);
            }
             */
            
            // Uncomment below to print every hour
            /*
            if (elapsedTime % 3600 == 0)
            {
                printSatInfo(elapsedTime, sat);
            }
             */
        }
        
        // Print final position of sat
        printSatInfo(elapsedTime, sat);
        
    }
    
    /**
     * Prints a Satellite's Information
     * @param time 
     *      The time that has elapsed since launch in seconds
     * @param sat 
     *      The object whose information to print
     */
    public static void printSatInfo(int time, Satellite sat)
    {
        System.out.printf("%10s%15.2f%15.2f%15.2f%15.2f%15.2f%15.2f%20.2f"
                + "%20.2f\n",time,
                sat.getX(),sat.getY(),sat.getVx(),sat.getVy(),
                sat.getD(),sat.getAltitude(),sat.getAx(),sat.getAy());
    }
    
    
}

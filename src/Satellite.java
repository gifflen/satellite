/**
 * Represents a satellite in orbit around the Earth's equator.
 * @author CIS 112 ONLINE Class of Fall 2011
 */
public class Satellite
{
    /*Constant variables*/
    //Gravitational constant in n-m^2/sec^2

    public static final double G = 6.67 * (Math.pow(10, -11));
    //Mass of the Earth in kilograms
    public static final double M = 5.97 * (Math.pow(10, 24));
    //The equatorial radius of the Earth
    public static final double r = 12756300;
    // x and y position of satellite in a coordinate system with the origin at
    //the center of the Earth
    private double x;
    private double y;
    // current velocity of the the satellite in the x and y directions
    // measured in meters per second
    private double vx;
    private double vy;

    /**
     * Constructs a Satellite at the desired location with desired speed
     * @precondition
     *      //TODO insert precondition
     * @param x
     *      The starting x position in meters of a satellite in a coordinate 
     *      system with the origin at the center of the Earth
     * @param y
     *      The starting y position in meters of a satellite in a coordinate 
     *      system with the origin at the center of the Earth
     * @param vx
     *      current velocity of the the satellite in the x direction measured 
     *      in meters per second
     * @param vy 
     *      current velocity of the the satellite in the y direction measured 
     *      in meters per second
     * @postcondition
     *      This Satellite has been initialized with the given information.
     */
    public Satellite(double x, double y, double vx, double vy)
    {
        //TODO code sanity check
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    /**
     * Get the x coordinate
     * @param - none
     * @return 
     *      The position of x in meters of a satellite in a coordinate 
     *      system with the origin at the center of the Earth
     */
    public double getX()
    {
        return this.x;
    }

    /**
     * Set the x coordinate
     * @precondition 
     *      //TODO insert precondition
     * @param x 
     *      The position of x in meters of a satellite in a coordinate 
     *      system with the origin at the center of the Earth
     * @postcondition
     *      x has been set to the specified double      
     */
    public void setX(double x)
    {
        //TODO code sanity check
        this.x = x;
    }

    /**
     * Get the y coordinate
     * @param - none
     * @return 
     *      The position of y in meters of a satellite in a coordinate 
     *      system with the origin at the center of the Earth
     */
    public double getY()
    {
        return this.y;
    }

    /**
     * Set the y coordinate
     * @precondition 
     *      //TODO insert precondition
     * @param y 
     *      The position of y in meters of a satellite in a coordinate 
     *      system with the origin at the center of the Earth
     * @postcondition
     *      y has been set to the specified double      
     */
    public void setY(double y)
    {
        //TODO code sanity check
        this.y = y;
    }

    /**
     * Get the x velocity
     * @param - none
     * @return 
     *      current velocity of the the satellite in the x direction measured 
     *      in meters per second
     */
    public double getVx()
    {
        return this.vx;
    }

    /**
     * Sets the x velocity
     * @precondition 
     *      //TODO insert precondition
     * @param vx 
     *      current velocity of the the satellite in the x direction measured 
     *      in meters per second
     * @postcondition
     *      vx has been set to the specified double   
     */
    public void setVx(double vx)
    {
        //TODO code sanity check
        this.vx = vx;
    }

    /**
     * Get the y velocity
     * @param - none
     * @return 
     *      current velocity of the the satellite in the y direction measured 
     *      in meters per second
     */
    public double getVy()
    {
        return this.vy;
    }

    /**
     * Sets the y velocity
     * @precondition 
     *      //TODO insert precondition
     * @param vx 
     *      current velocity of the the satellite in the y direction measured 
     *      in meters per second
     * @postcondition
     *      vy has been set to the specified double   
     */
    public void setVy(double vy)
    {
        //TODO code sanity check
        this.vy = vy;
    }

    /**
     * Simulate movement of the Satellite for the specified numbers of seconds
     * @precondition
     *      //TODO insert precondition
     * @param t 
     *      The numbers of seconds to simulate moving the satellite
     * @postcondition
     *      The satellite will have moved to a new position in accordance with 
     *      the specified time
     */
    public void moveSatellite(int t)
    {
        setX(x + vx * t);
        setY(y + vy * t);
        
        if(isCrashed())
        {
            setVx(0);
            setVy(0);
        } else {
            setVx(vx + getAx() * t);
            setVy(vx + getAy() * t);
        }
    }
    
    /**
     * Simulate movement of the Satellite for 1 second
     * @postcondition
     *      The satellite will have moved for 1 second into a new position
     * @param - none
     */
    public void moveSatellite()
    {
        moveSatellite(1);
    }
    
    /**
     * Simulate movement of the Satellite for 60 seconds(1 minute)
     * @postcondition
     *      The satellite will have moved for 60 seconds into a new position
     * @param - none
     */
    public void moveSatelliteOneMin()
    {
        moveSatellite(60);
    }
    
    /**
     * Simulate movement of the Satellite for 3600 seconds(1 hour)
     * @postcondition
     *      The satellite will have moved for 3600 seconds into a new position
     * @param - none
     */
    public void moveSatelliteOneHour()
    {
        moveSatellite(3600);
    }

    /**
     * Get the current accelerations from gravity along the x axes
     * @param - none
     * @return 
     *      The current accelerations from gravity along the x axes
     */
    public double getAx()
    {
        return (-(G * M * this.x) / (Math.pow(getD(), 3)));
    }

    /**
     * Get the current accelerations from gravity along the y axes
     * @param - none
     * @return 
     *      The current accelerations from gravity along the y axes
     */
    public double getAy()
    {
        return (-(G * M * this.y) / (Math.pow(getD(), 3)));
    }

    
    /**
     * Get the distance of the satellite from center of Earth
     * @param - none
     * @return 
     *      The distance of the satellite from center of Earth
     */
    public double getD()
    {
        //Distance of the satellite from center of Earth
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    /**
     * Get the satellites current altitude above the surface of the Earth
     * @param - none
     * @return 
     *      The satellites current altitude above the surface of the Earth
     */
    public double getAltitude()
    {
        //the satellite's current altitude above the surface of
        //the Earth
        return (getD() - r);
    }

    /**
     * Check if the satellite has crashed into earth
     * @param - none
     * @return 
     *      true- if the satellite has crashed into earth
     *      false- if the satellite has NOT crashed into earth
     */
    public boolean isCrashed()
    {

        if (getAltitude() <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   

 /**      
* Check if the initial data points are valid and not already on earth     
* @param x     
* @param y     
* @return true if satellite not on earth     
*         false if satellite on earth     
*/    
public boolean isValid(double x, double y){        
	if (Math.pow(x,2) + Math.pow(y, 2) > Math.pow(r, 2)){
            return true;
        }
        else return false;
  }
}
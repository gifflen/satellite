/**
* Represents a satellite in orbit around the Earth's equator.
* @author CIS 112 ONLINE Class of Fall 2011
*/
public class Satellite
{
/*Constant variables*/
//Gravitational constant in n-m^2/sec^2
public static final long G = (long)(6.67 *(Math.pow(10, -11)));

//Mass of the Earth in kilograms 
public static final long M = (long)(5.97 *(Math.pow(10, 24)));

//The equitorial radius of the Earth
public static final long r = 12756300;

// x and y position of satellite in a coordinate system with the origin at 
//the center of the Earth
private long x; 
private long y;

// current velocity of the the satellite in the x and y directions
// measured in meters per second
private long vx;
private long vy;

public Satellite(long x, long y, long vx, long vy)
{
setX(x);
setY(y);
setVx(vx);
setVy(vy);
}

public long getX()
{
return this.x; 
}

public void setX(long x)
{
//TODO code setter
this.x = x;
}

public long getY()
{
//TODO code getter
return this.y; 
}

public void setY(long y)
{
//TODO code setter
this.y = y; 
}

public long getVx()
{
//TODO code getter
return this.vx;
}

public void setVx(long vx)
{
//TODO code setter
this.vx = vx;
}

public long getVy()
{
//TODO code getter
return this.vy; 
}

public void setVy(long vy)
{
//TODO code setter 
this.vy = vy;
}

public void moveSatellite(int t)
{
//TODO code modification
setX(x+vx*t);
setY(y+vy*t);
setVx(vx+getAx()*t);
setVy(vx+getAy()*t); 
} 

public long getAx()
{
//TODO code getter
return (-(G*M*this.x)/((long)(Math.pow(getD(), 3)))); 
}

public long getAy()
{
//TODO code getter
return (-(G*M*this.y)/((long)(Math.pow(getD(), 3))));
}

public long getD()
{
//Distance of the satellite from center of Earth
return (long)(Math.sqrt(Math.pow(this.x , 2)+ Math.pow(this.y , 2)));
}

public long getAltitude()
{
//the satellite's current altitude above the surface of
//the Earth
return (getD() - r);
}

public boolean isCrashed()
{
//TODO code check
throw new UnsupportedOperationException("Not yet implemented");
} 
}

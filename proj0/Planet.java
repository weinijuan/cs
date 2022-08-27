public class Planet
{
	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;
	static final double G = 6.67e-11;
	public Planet(double xxPos,double yyPos,double xxVel,double yyVel,double mass,String imgFileName)
	{
		this.xxPos = xxPos;
		this.yyPos = yyPos;
		this.xxVel = xxVel;
		this.yyVel = yyVel;
		this.mass = mass;
		this.imgFileName = imgFileName;
	}
	public Planet(Planet body)
	{
		this.xxPos = body.xxPos;
		this.yyPos = body.yyPos;
		this.xxVel = body.xxVel;
		this.yyVel = body.yyVel;
		this.mass = body.mass;
		this.imgFileName = body.imgFileName;
	}
	public double calcDistance(Planet b)
	{
		return Math.sqrt((b.yyPos - this.yyPos)*(b.yyPos - this.yyPos)+(b.xxPos-this.xxPos)*(b.xxPos-this.xxPos));
	}
	public double calcForceExertedBy(Planet b)
	{
		double dis = this.calcDistance(b);
		return G*b.mass*this.mass/(dis * dis);
	}
	public double calcForceExertedByX(Planet b)
	{
		double dis = this.calcDistance(b);
		return G*b.mass*this.mass*(b.xxPos - this.xxPos)/(dis * dis*dis);
	}
	public double calcForceExertedByY(Planet b)
	{
		double dis = this.calcDistance(b);
		return G*b.mass*this.mass*(b.yyPos - this.yyPos)/(dis * dis*dis);
	}
	public double calcNetForceExertedByX(Planet[] planets)
	{
		double sumX = 0;
		for (Planet p :planets)
		{
			if (this.equals(p)) {
				continue;
			} else {
				sumX += this.calcForceExertedByX(p);
			}
		}
		return sumX;
	}
	public double calcNetForceExertedByY(Planet[] planets)
	{
		double sumY = 0;
		for (Planet p :planets)
		{
			if (this.equals(p)) {
				continue;
			} else {
				sumY += this.calcForceExertedByY(p);
			}
		}
		return sumY;
	}
	private double calcNetForceExertedByXY(Planet[] planets)
	{
		double sumX = this.calcNetForceExertedByX(planets);
		double sumY = this.calcNetForceExertedByY(planets);
		return Math.sqrt(sumX*sumX+sumY*sumY);
	}
	public void update(double dt,double fx, double fy)
	{
		xxVel = dt*fx/mass+xxVel;
		yyVel = dt*fy/mass+yyVel;
		xxPos += xxVel*dt;
		yyPos += yyVel*dt;
	}
	public void draw()
	{
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
		StdDraw.show();
	}
}
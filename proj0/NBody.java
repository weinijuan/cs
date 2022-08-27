public class NBody
{
	public static double readRadius(String f)
	{
		In in = new In(f);
		if (!in.isEmpty())
		{
			in.readInt();
			return in.readDouble();
		}
		System.out.println("Something bad in read file1");
		return 0;
	}
	public static Planet[] readPlanets(String f)
	{
		In in = new In(f);
		if (!in.isEmpty()) 
		{
			int n = in.readInt();
			in.readDouble();
			Planet[] planets = new Planet[n];
			for (int i = 0;i < n;i++ ) {
				planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
			}
			return planets;
		}
		System.out.println("something bad in read file2");
		return new Planet[1];

	}
	public static void drawBackground()
	{
		StdDraw.setScale(-100,100);
		StdDraw.clear();
		StdDraw.picture(0,0,"images/starfield.jpg");
		StdDraw.show();
	}
	public static void main(String[] args)
	{
		double T = Double.parseDouble(args[0]);
		double t = 0;
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double r = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.enableDoubleBuffering();
		while(t <= T)
		{
			StdDraw.clear();
			drawBackground();
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for (int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
			}
			for (int i = 0; i < planets.length; i++) {
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i < planets.length; i++) {
				planets[i].update(dt,xForces[i],yForces[i]);
			}
			for (Planet plant:planets) {
				plant.draw(r);
			}
			StdDraw.pause(10);
			t += dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < planets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}
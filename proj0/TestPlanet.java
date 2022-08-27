public class TestPlanet
{
	public static void main(String[] args)
	{
		Planet p1 = new Planet(0,0,10,10,1.5e11," ");
		Planet p2 = new Planet(10,10,10,10,1e11," ");
		Planet[] planets = {p1,p2};
		System.out.println(p1.calcNetForceExertedByXY(planets));
		System.out.println(p2.calcNetForceExertedByXY(planets));
	}
}
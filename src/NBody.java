import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NBody {
    public static double readRadius(String fname) {
        try {
            Scanner scan = new Scanner(new File(fname));
            scan.nextInt();
            double radius = scan.nextDouble();
            scan.close();
            return radius;   // must return a double here
        } catch (FileNotFoundException e) {
            System.out.println("Error!");
                    System.exit(1);
                    return 0;
        }
    }
    public static Planet[] readPlanets(String fname){
        try {
            Scanner scan = new Scanner(new File(fname));
            int length = scan.nextInt();
            Planet[] ans = new Planet[length];
            scan.nextDouble();
            for (int i = 0; i < length; i++){
                double xpos = scan.nextDouble();
                double ypos = scan.nextDouble();
                double xvel = scan.nextDouble();
                double yvel = scan.nextDouble();
                double mass = scan.nextDouble();
                String filename;
                filename = scan.next();
                Planet p = new Planet(xpos,ypos,xvel,yvel,mass,filename);
                ans[i] = p;
            }
            scan.close();
            return ans;
        } catch (FileNotFoundException e) {
            Planet[] ans = {};
            System.out.println("Error!");
            System.exit(1);
            return ans;
        }
    }
    public static void main(String[] args) {
        double totalTime = 157788000.0;
        double dt = 25000.0;
        String pfile = "data/planets.txt";
        if (args.length > 2) {
            totalTime = Double.parseDouble(args[0]);
            dt = Double.parseDouble(args[1]);
            pfile = args[2];
        }


        String fname = "./data/planets.txt";


		Planet[] planets = readPlanets(fname); // readPlanets(fname);


        double radius = readRadius(fname); // readRadius(fname);


		System.out.printf("%d\n", planets.length);
		System.out.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
		    System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		   		              planets[i].myXPos, planets[i].myYPos,
		                      planets[i].myXVel, planets[i].myYVel,
		                      planets[i].myMass, planets[i].myFileName);
		}


        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0,0,"images/starfield.jpg");
        for (int i = 0; i < planets.length; i++){
            planets[i].draw();
        }

        for (double t = 0.0; t < totalTime; t += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            for (int i = 0; i < planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++){
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.setScale(-radius, radius);
            StdDraw.picture(0,0,"images/starfield.jpg");
            for (int i = 0; i < planets.length; i++){
                planets[i].draw();
            }
            StdDraw.show(10);
        }
    }
}

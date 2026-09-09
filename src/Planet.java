public class Planet {
    double myXPos;
    double myYPos;
    double myXVel;
    double myYVel;
    double myMass;
    String myFileName;
    public Planet(double xp, double yp, double xv, double yv, double mass, String filename){
        this.myXPos = xp;
        this.myYPos = yp;
        this.myXVel = xv;
        this.myYVel = yv;
        this.myMass = mass;
        this.myFileName = filename;
    }
    public Planet(Planet p){
        new Planet(p.myXPos,p.myYPos,p.myXVel,p.myYVel,p.myMass,p.myFileName);
    }



}

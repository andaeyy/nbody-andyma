public class Planet {
    double myXPos;
    double myYPos;
    double myXVel;
    double myYVel;
    double myMass;
    String myFileName;
    final double G = 6.67e-11;
    public Planet(double xp, double yp, double xv, double yv, double mass, String filename){
        myXPos = xp;
        myYPos = yp;

        myXVel = xv;

        myYVel = yv;

        myMass = mass;

        myFileName = filename;
    }
    public Planet(Planet p){
        myXPos = p.myXPos;
        myYPos = p.myYPos;

        myXVel = p.myXVel;

        myYVel = p.myYVel;

        myMass = p.myMass;

        myFileName = p.myFileName;
    }
    public double calcDistance(Planet p){
        return Math.sqrt(Math.pow((p.myXPos-myXPos),2) + Math.pow(p.myYPos-myYPos,2));
    }
    public double calcForceExertedBy(Planet p){
        return G*(p.myMass*myMass)/(calcDistance(p) * calcDistance(p));
    }
    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p) * (p.myXPos - myXPos)/(calcDistance(p));
    }
    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p) * (p.myYPos - myYPos)/(calcDistance(p));
    }
    public double calcNetForceExertedByX(Planet[] planets){
        double ans = 0;
        for (Planet p: planets){
            if (!p.equals(this)) ans += calcForceExertedByX(p);
        }
        return Math.round(ans*10.0)/10.0;
    }
    public double calcNetForceExertedByY(Planet[] planets){
        double ans = 0;
        for (Planet p: planets){
            if (!p.equals(this)) ans += calcForceExertedByY(p);
        }
        return ans;
    }
    public void update(double seconds, double xforce, double yforce){

    }



}

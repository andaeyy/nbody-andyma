public class Planet {
    double myxpos;
    double myypos;
    double myxvel;
    double myyvel;
    double mymass;
    String myfilename;
    public Planet(double xp, double yp, double xv, double yv, double mass, String filename){
        this.myxpos = xp;
        this.myypos = yp;
        this.myxvel = xv;
        this.myyvel = yv;
        this.mymass = mass;
        this.myfilename = filename;
    }
    public Planet(Planet p){
            myxpos = p.myxpos;
            myypos = p.myypos;
            myxvel = p.myxvel;
            myyvel = p.myyvel;
            mymass = p.mymass;
            myfilename = p.myfilename;
    }

}

package principles.examples.level3;

public class ServiceB extends Service {


    public int featureB(){ return 1;}

    private int legacyFeature(){return 0;}

    @Override
    public int feature(){
        return legacyFeature();
    }
}



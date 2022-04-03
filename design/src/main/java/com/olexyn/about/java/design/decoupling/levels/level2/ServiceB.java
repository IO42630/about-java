package decoupling.levels.level2;

public class ServiceB extends Service {

    private int featureB(){ return 1;}

    @Override
    public int feature(){
        return featureB();
    }
}



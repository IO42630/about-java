package decoupling.levels.level3;

public class ServiceA extends Service {


    private int featureA(){ return 0;}

    @Override
    public int feature(){
        return featureA();
    }
}

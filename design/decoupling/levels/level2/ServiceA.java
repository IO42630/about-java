package decoupling.levels.level2;

public class ServiceA extends Service {


    private int featureA(){ return 0;}

    @Override
    public int feature(){
        return featureA();
    }
}

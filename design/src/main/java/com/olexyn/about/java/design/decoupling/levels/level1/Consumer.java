package decoupling.levels.level1;

public class Consumer {


    public int consume() {
        Service service = new Service();
        return service.feature();
    }


}

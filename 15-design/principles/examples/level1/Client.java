package principles.examples.level1;

public class Client {


    public int consume() {
        Service service = new Service();
        return service.feature();
    }


}

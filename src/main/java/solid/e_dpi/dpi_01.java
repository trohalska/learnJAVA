package solid.e_dpi;

public class dpi_01 {
    public static void main(String[] args) {
        Client01 client01 = new Client01();
        client01.doJob();
    }
}

class DataAccess01{
    void execute(){
        System.out.println("execute");
    }
}

class Client01{
    DataAccess01 dataAccess01 = new DataAccess01();
    void doJob(){
        dataAccess01.execute();
    }
}

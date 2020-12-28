package solid.e_dpi;

public class dpi_02_correct {
    public static void main(String[] args) {
        DAO dataAccess = new DataAccess02();
        Client02 client02 = new Client02();
        client02.doJob(dataAccess);
    }
}

interface DAO{
    void execute();
}

class DataAccess02 implements DAO{
    public void execute(){
        System.out.println("execute");
    }
}

class Client02{
    void doJob(DAO dataAccess){
        dataAccess.execute();
    }
}

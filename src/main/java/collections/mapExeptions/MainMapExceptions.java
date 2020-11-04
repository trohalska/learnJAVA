package collections.mapExeptions;

public class MainMapExceptions {
    public MainMapExceptions() {
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(new User(true));
        userRepository.addUser(new User(false));
//        userRepository.addUser(new User(true));
        userRepository.validateAll();
    }
}

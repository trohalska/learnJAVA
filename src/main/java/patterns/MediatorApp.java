package patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * клиент отправляет одно сообщение через медиатор,
 * который знает, каким клиетам переслать сообшение
 */
public class MediatorApp {
    public static void main(String[] args) {

        TextChat chat = new TextChat();

        Client admin = new Admin(chat, "Admin");
        Client u1 = new SimpleClient(chat, "John");
        Client u2 = new SimpleClient(chat, "Anna");
        Client u3 = new SimpleClient(chat, "Vova");
        u2.setEnable(false);

        chat.setAdmin(admin);
        chat.addClient(u1);
        chat.addClient(u2);
        chat.addClient(u3);

        u1.sendMessage("Hi, I'm user.");
        admin.sendMessage("Admin said hi.");
    }
}


// simple client - mediator
//interface Client {
//    void sendMessage(String message);
//    void getMessage(String message);
//}

/**
 * CLIENT
 */
abstract class Client {
    Chat chat;
    String name;
    boolean isEnable = true;

    public boolean isEnable() {
        return isEnable;
    }
    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }
    public String getName() {
        return name;
    }

    public Client(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Client [ name=" + name + ']';
    }
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
    abstract void getMessage(String message);
}

class Admin extends Client {
    public Admin(Chat chat, String name) { super(chat, name); }
    public void getMessage(String message) {
        System.out.println("Admin " + getName() + " gets message: '" + message + "'");
    }
}
class SimpleClient extends Client {
    Chat chat;
    public SimpleClient(Chat chat, String name) { super(chat, name); }
    public void getMessage(String message) {
        System.out.println("Client " + getName() + " gets message: '" + message + "'");
    }
}
/**
 * MEDIATOR
 */
interface Chat {
    void sendMessage(String message, Client client);
}

/**
 * админ пишет всем
 * клиет пишет всем, кто enable
 * клиент не может зайти в чат без админа
 */
class TextChat implements Chat {
    Client admin;
    List<Client> clients = new ArrayList<>();

    public void setAdmin(Client admin) {
        if (admin != null && admin instanceof Admin) {
            this.admin = admin;
        } else {
            throw new RuntimeException("Access denied!");
        }
    }
    public void addClient(Client client) {
        if (admin == null) {
            throw new RuntimeException("Admin is not present in this chat!");
        }
        if (client instanceof SimpleClient) {
            clients.add(client);
        } else {
            throw new RuntimeException("Admin cannot enter another chat!");
        }
    }

    public void sendMessage(String message, Client client) {
        if (client instanceof Admin) {
            for (Client c : clients) {
                c.getMessage(message);
            }
        }
        if (client instanceof SimpleClient) {
            for (Client c : clients) {
                if (c != client && c.isEnable()) {
                    c.getMessage(client.getName() + ": " + message);
                }
            }
            if (admin.isEnable()) {
                admin.getMessage(client.getName() + ": " + message);
            }
        }
    }
}
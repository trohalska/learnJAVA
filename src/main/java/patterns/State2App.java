package patterns;

/**
 * разница с первым state в том, что там контекст переключал слстояния,
 * а здесь переключение делают сами состояния
 *
 * есть контекст (человек), который может делать разные активности
 * в активность передается ссылка на человека
 * работа сутки-трое
 *
 * состояния меняют сами активности (state)
 */
public class State2App {
    public static void main(String[] args) {

        HumanContext human = new HumanContext();
        human.setActivity(new Work());

        for (int i = 0; i < 10; ++i) {
            human.doSomething();
        }
    }
}

/**
 * STATE
 */
interface Activity {
    void doSomething(HumanContext context);
}

class Work implements Activity {
    public void doSomething(HumanContext context) {
        System.out.println("Working!!!");
        context.setActivity(new Relax());
    }
}
class Relax implements Activity {
    private int count = 0;
    public void doSomething(HumanContext context) {
        if (count < 3) {
            System.out.println("Relax...");
            count++;
        } else {
            context.setActivity(new Work());
        }
    }
}

/**
 * CONTEXT
 */
class HumanContext {
    private Activity state;
    void setActivity(Activity state) {
        this.state = state;
    }
    void doSomething() {
        state.doSomething(this);
    }
}
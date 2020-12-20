package reflections;

import java.lang.reflect.*;

// все основные приемы доступа к членам
public class AccessToMembers {
    public int a;

    public AccessToMembers(int a) { this.a = a; }
    public void b() { a = 1; }
    public void b(int p1) { a = p1; }
    public String toString() { return a + ""; }
    public static void main(String[] args) throws Exception {
        Class clazz = AccessToMembers.class;

        Constructor c = clazz.getConstructor(new Class[] {int.class});

        Object o = c.newInstance(new Object[] {new Integer(23)});
        Field f = clazz.getField("a");
        System.out.println(f.getInt(o));
        f.setInt(o,24);
        System.out.println(o);

        Method m = clazz.getMethod("b", new Class[] {});
        m.invoke(o,new Object[] {});
        System.out.println(o);

        m= clazz.getMethod("b", new Class[] {int.class});
        m.invoke(o,new Object[] {new Integer(2)});
        System.out.println(o);
    }
}

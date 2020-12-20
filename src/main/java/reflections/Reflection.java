package reflections;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

class Reflection {

    //  функция для подсчета объема памяти, занятого массивом примитивных типов
    public static int sizeOfArray(Object v) {
        if (v == null) return 0;
        Class componentClass = v.getClass().getComponentType();
        if (componentClass == null)
            throw new IllegalArgumentException("Not an array");
        int s = componentClass == byte.class ? 2 :
                componentClass == short.class ? 4 :
                        componentClass == char.class ? 4 :
                                componentClass == int.class ? 4 :
                                        componentClass == float.class ? 8 :
                                                componentClass == long.class ? 8 :
                                                        componentClass == double.class ? 16 : -1;
        // не обрабатываем тип boolean: для него размер элемента не специфицирован документацией по языку Java
        if (s == -1)
            throw new IllegalArgumentException("Unknown component type");
        return java.lang.reflect.Array.getLength(v) * s;
        // метод getLength() класса java.lang.reflect.Array получает на входе массив произвольного типа и возвращает его длину
    }

    // преобразующую произвольный массив в строку
    public static String toS(Object v, String separator) {
        if (v == null)
            return "";
        if (v.getClass().isArray()) {
            int len;
            if ((len = java.lang.reflect.Array.getLength(v)) == 0)
                return "";
            StringBuilder result = new StringBuilder();
            for (int k = 0; k < len; k++) {
                if (k > 0)
                    result.append(separator);
                result.append(String.valueOf(java.lang.reflect.Array.get(v, k)));
            }
            return result.toString();
        }
        return String.valueOf(v);
    }

    // функци, возвращающей полный путь к class-файлу.
    public static java.io.File getClassFile(Class clazz) {
        // The file will exist only if it is usual class-file,
        // not a part of JAR or Web resource
        String s = clazz.getName();
        s = s.substring(s.lastIndexOf(".") + 1);
        s = clazz.getResource(s + ".class").getFile();
        s = java.net.URLDecoder.decode(s, StandardCharsets.UTF_8);
        return new java.io.File(s);
    }

    // динамическая загрузка ------------------
    public interface LanguageTranslator {
        public String translate(String source, String sourceLanguage, String targetLanguage);
        // переводит текст source с языка sourceLanguage на язык targetLanguage
    }

    public String translate() throws Exception {
        String source = "текст, требующий перевода";
        String sourceLanguage = "Russian";
        String targetLanguage = "English";
        Class clazz = Class.forName("полное_имя_класса_переводчика");
        Object object = clazz.newInstance();
        if (!(object instanceof LanguageTranslator)) {
            // сообщаем об ошибке: указанный класс не реализует требуемый интерфейс,
            // т.е. не является переводчиком
            throw new Exception("...");
        }
        return ((LanguageTranslator) object).translate(source, sourceLanguage, targetLanguage);
    }

    // как можно добраться до этого самого поля и «нелегально» изменить строку
    // вопреки известному утверждению, что тип String является абсолютно неизменяемым:
    public static void main(String[] args) throws Exception {
        String s = "Hello!";
        System.out.println(s);
        Field f = s.getClass().getDeclaredField("value");
        // Именно getDeclaredField, а не getField: последний метод просто не нашел бы скрытого поля
        f.setAccessible(true);
        char[] value = (char[]) f.get(s);
        value[5] = '?';
        System.out.println(s);
    }
}


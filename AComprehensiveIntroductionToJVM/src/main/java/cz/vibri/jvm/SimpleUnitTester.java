package cz.vibri.jvm;

import java.lang.reflect.Method;
import java.util.Locale;

public class SimpleUnitTester {

    public static void main(String[] args) throws Exception {
        SimpleUnitTester sut = new SimpleUnitTester();
        System.out.println(sut.execute(Reflection.class));
    }

    public int execute(Class clazz) throws Exception {
        int failedCount = 0;

        Object object = clazz.getDeclaredConstructor().newInstance();

        System.out.println("Class name: " + object.getClass().getName());

        for (Method m : clazz.getMethods()) {
            System.out.println(m.getReturnType());
            if (m.getName().toLowerCase(Locale.ROOT).startsWith("test") && boolean.class.equals(m.getReturnType())) {
                Object result = m.invoke(object);
                if ((Boolean)result == true) {
                    failedCount++;
                }

            }
        }

        return failedCount;
    }

}

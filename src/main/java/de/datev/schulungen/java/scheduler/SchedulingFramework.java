package de.datev.schulungen.java.scheduler;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SchedulingFramework {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @SneakyThrows
    private void execute(Method m, Object o) {
        m.invoke(o);
    }

    public void handle(Object o) {
        // alle Methoden nach @Schedule durchsuchen
        // Reflection API
        Class<?> clazz = o.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        // für jede annotierte Methode: Scheduling
        for(Method m : declaredMethods) {
            Schedule annotation = m.getAnnotation(Schedule.class);
            if(annotation != null) {
                scheduler.scheduleAtFixedRate(
                  () -> execute(m,o),
                  0,
                  annotation.value(),
                  annotation.unit()
                );
            }
        }
    }

}

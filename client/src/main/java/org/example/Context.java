package org.example;

import lombok.SneakyThrows;
import org.example.gui.utils.StyleCustomizer;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class Context {

    private static final Map<String, Object> map = new HashMap<>() {
        @Override
        public Object put(String key, Object value) {
            if (containsKey(key)) {
                throw new IllegalArgumentException("Компонент с именем " + key + " уже добавлен");
            } else {
                return super.put(key, value);
            }
        }
    };

    @SneakyThrows
    public static <T> T init(Class<T> type) {
        return init(type.getName(), type);
    }

    @SneakyThrows
    public static <T> T init(String name, Class<T> type) {
        Constructor<T> constructor = resolveConstructor(type);
        T bean = constructor.newInstance(resolveArguments(constructor));
        map.put(name, bean);
        return bean;
    }

    @SneakyThrows
    public static <T extends JComponent> T initJComponent(Class<T> type, int x, int y) {
        return initJComponent(type.getName(), type, x, y);
    }

    @SneakyThrows
    public static <T extends JComponent> T initJComponent(String name, Class<T> type, int x, int y) {
        T bean = init(name, type);
        bean.setName(name);
        bean.setPreferredSize(new Dimension(x, y));
        StyleCustomizer.setBorder(bean);
        return bean;
    }

    public static void register(String key, Object value) {
        map.put(key, value);
    }

    public static <T> T get(Class<T> type) {
        List<T> collect = map.values().stream()
                .filter(bean -> type.isAssignableFrom(bean.getClass()))
                .map(type::cast)
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            throw new IllegalArgumentException("Не найден компонент с типом " + type);
        } else if (collect.size() > 1) {
            throw new IllegalArgumentException("Найдено больше одного компонента с типом " + type);
        } else {
            return collect.get(0);
        }
    }

    private static Object[] resolveArguments(Constructor<?> constructor) {
        return Arrays.stream(constructor.getParameterTypes())
                .map(Context::get)
                .toArray(Object[]::new);
    }

    private static <T> Constructor<T> resolveConstructor(Class<T> type) {
        return Arrays.stream(type.getConstructors())
                .map(constructor -> ((Constructor<T>) constructor))
                .max(Comparator.comparing(Constructor::getParameterCount))
                .orElseThrow(() -> new IllegalArgumentException("Не найден конструктор для типа " + type));
    }

    private static <T extends JComponent> Constructor<T> getConstructorWithoutParams(Class<T> type) {
        return Arrays.stream(type.getConstructors())
                .map(constructor -> ((Constructor<T>) constructor))
                .filter(constructor -> constructor.getParameterCount() == 0)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Не найден конструктор без параметров для типа " + type));
    }

}

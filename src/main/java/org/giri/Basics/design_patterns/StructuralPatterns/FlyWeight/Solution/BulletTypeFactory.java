package main.java.org.giri.Basics.design_patterns.StructuralPatterns.FlyWeight.Solution;

import java.util.HashMap;
import java.util.Map;

public class BulletTypeFactory {
    private static Map<String, BulletType> bulletTypes = new HashMap<>();

    public static BulletType getBulletType(String color) {
        if(!bulletTypes.containsKey(color)) {
            bulletTypes.put(color, new BulletType(color));
        }
        return bulletTypes.get(color);
    }
}

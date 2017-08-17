package GenericsTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Glass<L extends Parent & Serializable> {
    private L liquid;

    private void testMethod() {
        liquid.method();
    }

    Glass(L liquid) {
        this.liquid = liquid;
    }

    private <J extends Parent> void mix(J j) {
        j.method();
        System.out.println("mix" + j.getClass());
    }

    private static <J> void mix1(J j) {
        System.out.println("static mix1" + j.getClass());
    }
    private void mix2(List<? super L> list,List<? extends L> list2) {
        System.out.println(list.size()+" "+list2.size());
    }

    public static void main(String[] args) {
        Glass<Water> glassOfWater = new Glass<>(new Water());
        glassOfWater.testMethod();
        glassOfWater.mix(new Juice());
        glassOfWater.mix2(new ArrayList<Water>(),new ArrayList<Water>());
        glassOfWater.mix2(new ArrayList<Parent>(),new ArrayList<CleanWater>());
        /*
        glassOfWater.mix2(new ArrayList<Juice>(),new ArrayList<Water>()); // Juice is not a super of Water
        glassOfWater.mix2(new ArrayList<Water>(),new ArrayList<Parent>()); // Parent does not extend Water
        glassOfWater.mix2(new ArrayList<Parent>(),new ArrayList<Juice>()); // Juice does not extend Water
        */

        Glass<CleanWater> glassOfCleanWater = new Glass<>(new CleanWater());
        glassOfCleanWater.mix2(new ArrayList<CleanWater>(),new ArrayList<CleanWater>());
        glassOfCleanWater.mix2(new ArrayList<Parent>(),new ArrayList<CleanWater>());
        glassOfCleanWater.mix2(new ArrayList<Water>(),new ArrayList<CleanWater>());

        /*
        glassOfCleanWater.mix2(new ArrayList<CleanWater>(),new ArrayList<Water>()); // Water does not extend CleanWater
        glassOfCleanWater.mix2(new ArrayList<CleanWater>(),new ArrayList<Juice>()); // Juice does not extend CleanWater
        glassOfCleanWater.mix2(new ArrayList<CleanWater>(),new ArrayList<Parent>()); // Parent does not extend CleanWater
        glassOfCleanWater.mix2(new ArrayList<Juice>(),new ArrayList<CleanWater>()); // Juice is not a super of CleanWater
        */

        Glass.mix1(new Water());

        Glass<Juice> glassOfJuice = new Glass<>(new Juice());
        glassOfJuice.testMethod();

        Glass<Wine> glassOfWine = new WineGlass<>(new Wine());
        glassOfWine.testMethod();
    }
}

interface Parent {
    void method();
}

class Water implements Parent, Serializable {

    @Override
    public void method() {
        System.out.println("water");
    }
}

class CleanWater extends Water{}

class Juice implements Parent, Serializable {

    @Override
    public void method() {
        System.out.println("juice");
    }
}

class Wine implements Parent, Serializable {

    @Override
    public void method() {
        System.out.println("wine");
    }
}

class WineGlass<T extends Parent & Serializable> extends Glass<T> {
    WineGlass(T liquid) {
        super(liquid);
    }
}

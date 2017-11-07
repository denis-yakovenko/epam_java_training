package GenericsTest;

public class Colour<R, G, B> {
    private R red;
    private G green;
    private B blue;

    private Colour(R red, G green, B blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "Colour{" + red.getClass().getSimpleName() +
                "," + green.getClass().getSimpleName() +
                "," + blue.getClass().getSimpleName() + "}";
    }

    public static void main(String[] args) {
        Colour<Red, Green, Blue> colour = new Colour<>(new Red(), new Green(), new Blue());
        System.out.println(colour);

    }
}

class Red {
}

class Green {
}

class Blue {
}


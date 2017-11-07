package task5.Flower;

public enum FlowerColor {

    GREEN, RED, BLUE, BLACK, YELLOW, WHITE;

    public String toString() {

        switch (this) {
            case GREEN:
                return "Green";
            case RED:
                return "Red";
            case BLUE:
                return "Blue";
            case BLACK:
                return "Black";
            case YELLOW:
                return "Yellow";
            case WHITE:
                return "White";
            default:
                return "no color";
        }

    }

}

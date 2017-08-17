package task5.Flower;

public enum FlowerType {

    ROMASHKA, MAK, ROZA, TULPAN, CACTUS;

    public String toString() {
        switch (this) {
            case ROMASHKA:
                return "Romashka";
            case MAK:
                return "Mak";
            case ROZA:
                return "Roza";
            case TULPAN:
                return "Tulpan";
            case CACTUS:
                return "Cactus";
            default:
                return "no color";
        }

    }
}

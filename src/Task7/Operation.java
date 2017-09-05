package Task7;

public enum Operation {
    MENU, INPUT_ORDER, SHOW_ORDERS, EXIT;

    public static Operation getAllowableOperationByOrdinal (Integer i){
        switch (i){
            case 1: return MENU;
            case 2: return INPUT_ORDER;
            case 3: return SHOW_ORDERS;
            case 4: return EXIT;
            default: throw new IllegalArgumentException();
        }
    }
}

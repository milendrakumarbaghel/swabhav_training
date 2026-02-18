package enums;

public class EnumWithConstructor {
    public static void main(String[] args) {
        enum Level {
            LOW(1),
            MEDIUM(2),
            HIGH(3);

            private int code;

            Level(int code) {
                this.code = code;
            }

            public int getCode() {
                return code;
            }
        }

        Level level = Level.HIGH;

        System.out.println("Level: " + level);
        System.out.println("Code: " + level.getCode());
    }
}

package domain.rpn;

public enum OperandPriority {
    PLUS("+", 1),
    MINUS("+", 1),
    DIVISION("/", 2),
    MULTIPLICATION("*", 2);

    private final String title;
    private final int priority;

    OperandPriority(String title, int priority) {
        this.title = title;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }
}

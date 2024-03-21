package Objects;

public class User {
    private String name;
    private Type type;

    private static final User instance = new User();

    public User() {
        this.name = "";
        this.type = Type.ADMIN;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public String getName() {
        return this.name;
    }
    public Type getType() {
        return this.type;
    }`
}

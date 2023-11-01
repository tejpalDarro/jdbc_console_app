class UserDetails {
    private String name;
    private String email;
    private String pass;

    public UserDetails(String a, String b, String c) {
        this.name = a;
        this.email = b;
        this.pass = c;
    }
    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPass() {
        return this.pass;
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", email: " + this.email + ", pass: " + this.pass  + " ";
    }
}

package bank;

public class Account {

   private String name;
    private String Surname;
    private int id;

    public Account(String name, String surname, int id) {
        this.name = name;
        this.Surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

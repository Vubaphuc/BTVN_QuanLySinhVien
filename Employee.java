import java.time.LocalDate;
public class Employee {
    private String id;
    private String name;
    private String birthDay;
    private Gender gender;
    private double lương;

    public Employee() {
    }

    public Employee(String id, String name, String birthDay, Gender gender, double lương) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.lương = lương;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getLương() {
        return lương;
    }

    public void setLương(double lương) {
        this.lương = lương;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", gender=" + gender +
                ", lương=" + lương +
                '}';
    }
}

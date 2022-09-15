package sample;

public class Members {
    Integer id;
    String name, gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    Double weight, height, bmi;

    public Members(Integer id, String name, String gender, Double weight, Double height, Double bmi) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }

}

package be.iccbxl.poo;

public class Artist extends  Person{

    private Style style;


    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", genre=" + getGender() +
                ", status=" + style +
                '}';
    }
}

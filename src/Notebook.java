public class Notebook {
    private Integer ram;
    private Integer hdd;
    private String os;
    private String color;

    public Notebook(Integer ram, Integer hdd, String os, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }
    Integer getRam() {
        return ram;
    }
    Integer getHdd() {
        return hdd;
    }
    String getOs() {
        return os;
    }
    String getColor() {
        return color;
    }
}
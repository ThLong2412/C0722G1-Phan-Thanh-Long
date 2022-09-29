package ss16_IO_text_file.exersice.ss2_read_file.model;

public class Nations {
    private int id;
    private String code;
    private String name;

    public Nations() {}

    public Nations(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return String.format("%s,%s,%s", this.id, this.getCode(), name);
    }
}

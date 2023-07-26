package sfpd.pojo;

public class FilePOJO {

    private String name;
    private Long size;
    private String message;

    public FilePOJO(){}

    public FilePOJO(String name, Long size, String message)
    {
        this.name = name;
        this.size = size;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("Name=%s, Size=%s, Message=%s}", getName(), getSize(), getMessage());
    }
}

package Info;

public class member {
    private String email;
    private String key;
    private String name;
    private String phone;
    private String img;

    public member(String email,String key, String name, String phone, String img) {
        this.email = email;
        this.key = key;
        this.name = name;
        this.phone = phone;
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

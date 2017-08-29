package fr.prepavenir.guide.models;

/**
 * Created by brune on 28/08/2017.
 */

public class Hotel {

    private String name;
    private String category;
    private String email;
    private String phone;
    private String url;
    private String stars;
    private String image;

    public Hotel(String name, String category, String email, String phone, String url,  String stars,String image) {
        this.name = name;
        this.category = category;
        this.email = email;
        this.phone = phone;
        this.url = url;
        this.stars = stars;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

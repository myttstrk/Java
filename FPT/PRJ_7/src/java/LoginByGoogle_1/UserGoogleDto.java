package LoginByGoogle_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author myths
 */
public class UserGoogleDto {

    private String id;
    private String email;
    private boolean verify_email;
    private String name;
    private String given_name;
    private String famili_name;
    private String picture;

    public UserGoogleDto() {
    }

    public UserGoogleDto(String id, String email, boolean verify_email, String name, String given_name, String famili_name, String picture) {
        this.id = id;
        this.email = email;
        this.verify_email = verify_email;
        this.name = name;
        this.given_name = given_name;
        this.famili_name = famili_name;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerify_email() {
        return verify_email;
    }

    public void setVerify_email(boolean verify_email) {
        this.verify_email = verify_email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamili_name() {
        return famili_name;
    }

    public void setFamili_name(String famili_name) {
        this.famili_name = famili_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "UserGoogleDto{" + "id=" + id + ", email=" + email + ", verify_email=" + verify_email + ", name=" + name + ", given_name=" + given_name + ", famili_name=" + famili_name + ", picture=" + picture + '}';
    }

}

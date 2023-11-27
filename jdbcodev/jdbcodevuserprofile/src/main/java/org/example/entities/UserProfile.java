package org.example.entities;

public class UserProfile {

    private int id;
    private String email;
    private String username;
    private String password;
    private String name;
    private String surname;

    public UserProfile() {
    }

    public UserProfile(String email, String username, String password, String name, String surname) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }


    public static class UserProfileBuilder{
        private int id;
        private String email;
        private String username;
        private String password;
        private String name;
        private String surname;

        public static UserProfileBuilder startBuilder() {
            return new UserProfileBuilder();
        }
        public UserProfile build(){
            UserProfile userProfile=new UserProfile();
            userProfile.setSurname(surname);
            userProfile.setSurname(name);
            userProfile.setId(id);
            userProfile.setPassword(password);
            userProfile.setEmail(email);
            userProfile.setUsername(username);

            return userProfile;
        }

        public int getId() {
            return id;
        }

        public UserProfileBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserProfileBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserProfileBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserProfileBuilder setPassword(String password) {
            this.password = password;
            return this;
        }
        public UserProfileBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public UserProfileBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }
    }

}



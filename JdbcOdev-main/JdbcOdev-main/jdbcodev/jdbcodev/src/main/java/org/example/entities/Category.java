package org.example.entities;

public class Category extends BaseEntity{



    private int id ;

    private String categoryname;







    public Category() {
    }

    public Category(int id, String createDate, String updateDate, org.example.entities.State state, int id1, String categoryname) {
        super(id, createDate, updateDate, state);
        this.id = id1;
        this.categoryname = categoryname;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryname='" + categoryname + '\'' +
                '}'+super.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }


}

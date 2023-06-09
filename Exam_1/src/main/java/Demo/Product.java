package Demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private long id;
    private String name;
    private String description;
    private float price;
    private Date createAt;

    public Product() {
    }

    public Product(long id, String name, String description, float price, Date createAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        //5284,Iphone XXX,Dep lam,23000.0,2023-06-05 17:30:25
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return String.format("%s,%s,%s,%s,%s\n", this.id, this.name, this.description, this.price, simpleDateFormat.format(this.createAt) );
    }
}

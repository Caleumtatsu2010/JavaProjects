package Objects;

public class Product
{
    private int id;
    private String name;
    private String image;
    private double price;
    private String title;
    private String sell_id;
    private int cid;

    public String getSell_id() {
        return sell_id;
    }

    public void setSell_id(String sell_id) {
        this.sell_id = sell_id;
    }

    public Product(int id, String name, String image, double price, String title, String sell_id, int cid) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.sell_id = sell_id;
        this.cid = cid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Product() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", sell_id='" + sell_id + '\'' +
                ", cid=" + cid +
                '}';
    }
}

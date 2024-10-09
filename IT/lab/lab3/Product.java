

class Product{
    private String article;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(String article, String name, String description, double price, int quantity){
        this.article = article;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getArticle(){
        return article;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    @Override
    public String toString(){
        return   "Название: " + name
        + ", Описание:  " + description
        + ", цена= " + price
        + ", количество= " + quantity;
    }
}
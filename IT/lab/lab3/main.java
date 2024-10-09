public class main{
    public static void main(String[] args) {
        HashTable<String, Product> productsTable = new HashTable<>(5);
        
        Product product1 = new Product("1", "Телефон", "Самое современное средство связи",21000.00 ,50);
        Product product2 = new Product("2", "Ноутбук", "Удобное решение для работы в любом месте", 75000.00 ,25);
        Product product3 = new Product("3", "Клавиатура", "Стильная механическая клавиатура для эстетичного рабочего стола", 5000.00 ,60);


        productsTable.put(product1.getArticle(), product1);
        productsTable.put(product2.getArticle(), product2);
        productsTable.put(product3.getArticle(), product3);

        System.out.println("Поиск по артикулу '2': "+productsTable.get("2"));

        System.out.println("Количество позиций: " + productsTable.size());

        productsTable.remove("3");

        System.out.println("Ого, клавиатуры пользуются большим спросом! К сожалению, они уже закончились. Оставшееся количество позиций: "+productsTable.size());

        if (productsTable.isEmpty()==true){
            System.out.println("Упс, кажется никаких товаров нет в наличии");
        }
        else{
            System.out.println("Вы можете присмотреть себе что-то новенькое!!");
        }

    }
}

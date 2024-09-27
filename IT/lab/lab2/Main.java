public class Main {
    public static void main(String[] args) {
        
        Audiobook audiobook1 = new Audiobook("Поиски утраченного завтра", "Сергей Лукьяненко", 2024, 12, "Кирилл Радциг");
        audiobook1.displayInfo();

        Film movie1 = new Film("Груз 200", "Алексей Балабанов", 2007, 90.0, "Алексей Балабанов");
        movie1.displayInfo();
        
        movie1.HowMuchTimeToTheEnd(50);

        Musical musical1 = new Musical("Ла-Ла Ленд", "Дэмьен Шазелл", 2016, 128, "Дэмьен Шазелл");
        musical1.displayInfo();

        Audiobook audiobook2 = new Audiobook();
        audiobook2.setTitle("1984");
        audiobook2.setAuthor("Джордж Оруэлл");
        audiobook2.setYear(1949);
        audiobook2.setDuration(11.5);
        audiobook2.setReader("Саймон Преббл");
        
        audiobook2.displayInfo();

        
        Documentary doc1 = new Documentary("Наша планета", "Дэвид Аттенборо", 2019, 50.0, "Аластер Фотергилл", "Природа", "Дэвид Аттенборо");
        doc1.displayInfo();
    }
}
class Audiobook extends Book {
    private double duration;
    private String reader;
    private static int audiobookCount = 0;

    public Audiobook() {
        super();
        this.duration = 0.0;
        this.reader = "Unknown";
        audiobookCount++;
    }

    public Audiobook(String title, String author, int year, double duration, String reader) {
        super(title, author, year);
        this.duration = duration;
        this.reader = reader;
        audiobookCount++;
    }

    @Override
    public void displayInfo() {
        System.out.println("Название аудиокниги: " + getTitle());
        System.out.println("Автор: " + getAuthor());
        System.out.println("Год издания: " + getYear());
        System.out.println("Длительность: " + duration + " часов");
        System.out.println("Читает: " + reader);
        System.out.println("Всего аудиокниг: " + audiobookCount);
    }

    
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }
}
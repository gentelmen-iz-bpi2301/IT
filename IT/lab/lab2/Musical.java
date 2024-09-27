class Musical extends Book {
    private double musical_duration;
    private String composer;
    private static int musicalCount = 0;

    public Musical() {
        super();
        this.musical_duration = 0.0;
        this.composer = "Unknown";
        musicalCount++;
    }

    public Musical(String title, String author, int yearPublished, double musical_duration, String composer) {
        super(title, author, yearPublished);
        this.musical_duration = musical_duration;
        this.composer = composer;
        musicalCount++;
    }

    @Override
    public void displayInfo() {
        System.out.println("Название мюзикла: " + getTitle());
        System.out.println("Автор " + getAuthor());
        System.out.println("Год выхода: " + getYear());
        System.out.println("Длительность: " + musical_duration + " минут");
        System.out.println("Композитор: " + composer);
        System.out.println("Всего мюзиклов: " + musicalCount);
    }

    public double getDuration() {
        return musical_duration;
    }

    public void setDuration(double musical_duration) {
        this.musical_duration = musical_duration;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }
}
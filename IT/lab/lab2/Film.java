class Film extends Book {
    private double Film_duration;
    private String director;
    private static int movieCount = 0;
    public Film() {
        super();
        this.Film_duration = 0.0;
        this.director = "Unknown";
        movieCount++;
    }
    public Film(String title, String author, int year, double Film_duration, String director) {
        super(title, author, year);
        this.Film_duration = Film_duration;
        this.director = director;
        movieCount++;
    }

    @Override
    public void displayInfo() {
        System.out.println("Название фильма: " + getTitle());
        System.out.println("Автор: " + getAuthor());
        System.out.println("Год выхода " + getYear());
        System.out.println("Длительность: " + Film_duration + " минут");
        System.out.println("Режиссёр: " + director);
        System.out.println("Всего фильмов: " + movieCount);
    }

    public void HowMuchTimeToTheEnd(double val) {
        if(val<Film_duration)
        System.out.println("Вы остановились на: "+val+" минуте. "+" Осталось смотреть ещё: "+(Film_duration-val)+" минут.");
        else if (val == Film_duration)
        System.out.println("Вы досмотрели фильм!!!!");
        else System.out.println("Ты чо, дурак что ли? Ты как это сделал?....");
    }

    public double getDuration() {
        return Film_duration;
    }

    public void setDuration(double Film_duration) {
        this.Film_duration = Film_duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
class Documentary extends Film{
    private String subject;
    private String reader;



    public Documentary() {
        super();
        this.subject = "Неизвестно";
        this.reader = "Неизвестно";
}

    public Documentary(String title, String author, int yearPublished, double filmDuration, String director, String subject, String reader) {
        super(title, author, yearPublished, filmDuration, director);
        this.subject = subject;
        this.reader = reader;
}
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Тема: " + subject);
        System.out.println("Читает: " + reader);
}
    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getReader() {
        return reader;
    }
}

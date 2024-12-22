public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        FilterProcessor filterProcessor = new FilterProcessor();
        TransformProcessor transformProcessor = new TransformProcessor();

        dataManager.registerDataProcessor(filterProcessor);
        dataManager.registerDataProcessor(transformProcessor);

        dataManager.loadData("input_file.txt");

        dataManager.processData();
    }
}
package riddles.error_observers;

public class PrinterLogger implements ErrorObserver {
    @Override
    public void error(String message) {
        System.out.println("Printer Logger: printing " + message);
    }
}

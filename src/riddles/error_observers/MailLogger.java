package riddles.error_observers;

public class MailLogger implements ErrorObserver {
    @Override
    public void error(String message) {
        System.out.println("Mail Logger: emailing " + message);
    }
}

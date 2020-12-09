package DojoClient.installer;

public class FeedbackHandler {

    public void close(){
        Installer.getInstance().stopTheApplication();
    }
}

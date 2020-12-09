package DojoClient.installer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Constants {

    public static final String MC_LAUNCHER_ICON = "data:image/png;base64,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";

    private static final String BASE_URL = "https://raw.githubusercontent.com/DojoClientReleaseUser/Releases/master/";

    private static String versionNumber = null;

    public static String getVersionNumber() {
        if(versionNumber == null){

            try {
                InputStream stream = FileHelper.getStreamFromUrl(BASE_URL + "version.txt");
                InputStreamReader reader = new InputStreamReader(stream);
                BufferedReader buffReader = new BufferedReader(reader);
                versionNumber = buffReader.readLine();
                buffReader.close();
                reader.close();
                stream.close();

            }catch (IOException e){
                e.printStackTrace();
                Installer.getInstance().die(e);
            }

        }
        return versionNumber;
    }

    public static InputStream getIcon(){
        return ClassLoader.getSystemResourceAsStream("assets/icon.png");
    }

    public static InputStream getJar() throws IOException {
        return FileHelper.getStreamFromUrl(BASE_URL + getVersionNumber() + "/" + "DojoClient.jar");
    }

    public static InputStream getJSON() throws IOException {
        return FileHelper.getStreamFromUrl(BASE_URL + getVersionNumber() + "/" + "DojoClient.json");
    }

    public static URL getAudio() {
        return ClassLoader.getSystemResource("assets/audio.mp3");
    }
}

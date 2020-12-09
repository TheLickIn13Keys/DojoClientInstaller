package DojoClient.installer;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class InstallerThread extends Thread{

    private final Installer installer;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);

    public InstallerThread(Installer installer) {
        this.installer = installer;
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        final File mcDir = new File(OSHelper.getOS().getMc());
        if(mcDir.exists()){
            mcDir.mkdirs();
        }

    }

    @Override
    public void run() {

        final String mc = OSHelper.getOS().getMc();

        try{

            File userDir = new File(mc, "DojoClient/");
            //FileHelper.deleteDirectory(verDir);

            File verDir = new File(mc,"versions/DojoClient/");
            FileHelper.deleteDirectory(verDir);
            verDir.mkdirs();

            final String installDate = sdf.format(new Date());

            final JsonObject newProfile = new JsonObject();
            newProfile.addProperty("created", installDate);
            newProfile.addProperty("icon", Constants.MC_LAUNCHER_ICON);
            newProfile.addProperty("lastUsed", installDate);
            newProfile.addProperty("lastVersionId", "DojoClient");
            newProfile.addProperty("name", "DojoClient v" + Constants.getVersionNumber());
            newProfile.addProperty("type", "custom");

            final File launcherProfileFile = new File(mc, "/launcher_profiles.json");
            System.out.println(launcherProfileFile.toString());
            JsonObject launcherProfile = new JsonObject();
            if(launcherProfileFile.exists()){
                System.out.println("found");
                launcherProfile = new JsonParser().parse(FileHelper.readFile(launcherProfileFile)).getAsJsonObject();
            }
            else{
                launcherProfile.add("profiles", new JsonObject());
            }

            launcherProfile.get("profiles").getAsJsonObject().add("DojoClient", newProfile);
            launcherProfile.addProperty("selectedProfile", "DojoClient");

            String jsonToWrite = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(launcherProfile);

            FileHelper.writeFile(jsonToWrite, launcherProfileFile);

            FileHelper.writeFile(Constants.getJSON(), new File(verDir + "/DojoClient.json"));
            installer.moveForward();

            FileHelper.writeFile(Constants.getJar(), new File(verDir + "/DojoClient.jar"));
            installer.moveForward();


        }catch (Exception e){
            installer.die(e);
            System.err.println("Failed to download client. Shutting Down.");
        }

    }
}

package DojoClient.installer;

import java.io.File;

public enum OSHelper {

    WINDOWS("AppData" + File.separator + "Roaming" + File.separator + ".minecraft"),
    MAC("Library" + File.separator + "Application Support" + File.separator + "minecraft"),
    LINUX(".minecraft");

    private final String mc;
    private OSHelper(String mc){
        this.mc = File.separator + mc + File.separator;
    }

    public String getMc() {
        return System.getProperty("user.home") + mc;
    }

    public static final OSHelper getOS(){
        final String currentOS = System.getProperty("os.name").toLowerCase();

        if(currentOS.startsWith("windows")){
            return WINDOWS;
        }
        else if(currentOS.startsWith("mac")){
            return MAC;
        }
        else{
            return LINUX;
        }
    }
}

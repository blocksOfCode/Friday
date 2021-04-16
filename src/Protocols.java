import java.io.File;

public class Protocols {


    static void Vex(File file){
        for (File subFile : file.listFiles()) {
            if(subFile.isDirectory()) {
                Vex(subFile);
            } else {
                subFile.delete();
            }
        }
        file.delete();
    }

}

package GalenUtilities;

import java.io.IOException;

public class GalenGenerate
{
    public static void main(String[] args) throws IOException {

        String json_path="\"C:\\Users\\Vijay\\Documents\\GSPEC Files\\Fireflink\\GooglePageDumps\\page.json\"";
        String dumpPath="\"C:\\Users\\Vijay\\Documents\\GSPEC Files\\Fireflink\\iphone.gspec\"";
        String Command="galen generate "+json_path +"--export "+dumpPath;
        Runtime.getRuntime().exec(Command);

    }
}


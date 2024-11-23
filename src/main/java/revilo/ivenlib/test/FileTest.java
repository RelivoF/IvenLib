package revilo.ivenlib.test;

import net.minecraft.client.Minecraft;
import revilo.ivenlib.file.File;
import revilo.ivenlib.file.Folder;

public class FileTest {
    public static File test = new File(new java.io.File(Minecraft.getMinecraft().gameDir, "test.txt"));

    public static Folder testFolder = new Folder(new java.io.File(Minecraft.getMinecraft().gameDir, "test"));
}

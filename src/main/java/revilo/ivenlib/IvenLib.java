package revilo.ivenlib;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import revilo.ivenlib.test.FileTest;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class IvenLib {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FileTest.test.create();
        List<String> data = new ArrayList<>();
        data.add("Test");
        data.add("Holy moly.");
        FileTest.test.write(data);

        FileTest.testFolder.getFolder().getFile().mkdir();
        FileTest.testFolder.addNewFile("test.c");
        FileTest.testFolder.addNewFile("omh.zs", data);
    }

}

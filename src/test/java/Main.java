
import io.github.ssaltedfish.aria2.cpp.*;
import io.github.ssaltedfish.aria2.global.Aria2;
import org.bytedeco.javacpp.LongPointer;
import org.bytedeco.javacpp.Pointer;
import org.junit.jupiter.api.Test;


public class Main {
     @Test
      void test() {
        System.setProperty("org.bytedeco.javacpp.logger.debug", "true");

        class call extends DownloadEventCallback {
            @Override
            public int call(Session session, Aria2.DownloadEvent event, long gid, Pointer userData) {
               // return super.call(session, event, gid, userData);
                System.out.println(gid + "##################### " + event.toString());
                return  0;
            }
        }
         Aria2.libraryInit();
         StringStingPairVector option = new StringStingPairVector();
         option.pushBack(new StringStingPair("dir", "E:\\aria2Download"));
         SessionConfig sessionConfig = new SessionConfig();
         sessionConfig.downloadEventCallback(new call());
         Session session = Aria2.sessionNew(option, sessionConfig);

         LongPointer pointer = new LongPointer(1);
         // Aria2.addUri(session,pointer,new StringVector("https://blog.csdn.net/qq_39408435/article/details/116007189"),option);
         Aria2.addUri(session, pointer, new StringVector("https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe?utm_source=docker&utm_medium=webreferral&utm_campaign=dd-smartbutton&utm_location=module"), option);
         while (true) {
             // System.out.println(pointer.get());
             int ret = Aria2.run(session, Aria2.RunMode.RUN_ONCE);
             if (ret != 1) {
                 System.out.println(ret);
                 break;
             }
             System.out.println("###########################");
             System.out.println(pointer.get());
             System.out.println(Aria2.getDownloadHandle(session, pointer.get()).getDownloadSpeed() / 1024);
             System.out.println("###########################");

         }


     }
}


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
                System.out.println(gid + "##################### "+ gid);
                return  0;
            }
        }
        StringVector vector = new StringVector();
        vector.pushBack("aaaa");
        vector.pushBack("bbbb");
         for (StringVector.Iterator iterator = vector.begin(); !iterator.equals(vector.end()) ; iterator.increment()) {
             System.out.println(iterator.get().getString());
         }
        Aria2.libraryInit();
        StringStingPairVector option = new StringStingPairVector();
        StringStingPair pair = new StringStingPair("out","a.html");
        option.pushBack(pair);
        option.pushBack(new StringStingPair("dir","E:\\aria2Download"));
        System.out.println(option.size());
         for ( StringStingPairVector.Iterator  iterator = option.begin(); !iterator.equals(option.end()) ; iterator.increment()) {
             System.out.println("["+iterator.get().first().getString() +" "+iterator.get().second().getString()+"]");
         }
         SessionConfig sessionConfig = new SessionConfig();
         sessionConfig.downloadEventCallback(new call());
         Session session = Aria2.sessionNew(option,sessionConfig);

         LongPointer pointer = new LongPointer(1);
        Aria2.addUri(session,pointer,new StringVector("https://blog.csdn.net/qq_39408435/article/details/116007189"),option);

        while (true){
           // System.out.println(pointer.get());
            int ret = Aria2.run(session, Aria2.RunMode.RUN_DEFAULT);
            if (ret != 1){
                System.out.println(ret);
                break;
            }
            System.out.println();
            System.out.println(pointer.get());
            System.out.println(Pointer.formatBytes(Aria2.getDownloadHandle(session,pointer.get()).getDownloadSpeed()));
            System.out.println();

        }







    }
}

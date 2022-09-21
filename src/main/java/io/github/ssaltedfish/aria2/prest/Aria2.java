package io.github.ssaltedfish.aria2.prest;


import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Namespace;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.presets.javacpp;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

// ,"libcares",
//         "libexpat"
//         ,"libgmp","libsqlite",
//         "zlib",   "libstdc++",
//         "libgcc_s_seh","libwinpthread"
@Properties(
        inherit = javacpp.class,
        value = {
                @Platform(include = {"aria2/aria2.h"},
                        link = {
                                "aria2@.0"
                        })
                ,
                @Platform(value = "windows",
                        preload = {
                                "libcares-2",
                                "libexpat-1",
                                "libgcc_s_seh-1",
                                "libgmp-10",
                                "libsqlite3-0",
                                "libwinpthread-1",
                                "libstdc++-6",
                                "zlib1",
                                "libssh2-1",
                                "libaria2-0"
                        })
        },
        global = "io.github.ssaltedfish.aria2.global.Aria2",
        target = "io.github.ssaltedfish.aria2.cpp"

)
@Namespace("aria2")
public class Aria2 implements InfoMapper {

    // static { Loader.load(); }

    @Override
    public void map(InfoMap infoMap) {
        infoMap.put(new Info("A2Gid").valueTypes("long").pointerTypes("LongPointer", "LongBuffer", "long[]"))
                .put(new Info("std::vector<std::string>").pointerTypes("StringVector").define())
                .put(new Info("std::pair<std::string,std::string>").pointerTypes("StringStingPair").define())
                .put(new Info("KeyVals").valueTypes("std::pair<std::string,std::string>"))
                .put(new Info("std::vector<std::pair<std::string,std::string> >").pointerTypes("StringStingPairVector").define())
                .put(new Info("std::vector<A2Gid>").pointerTypes("A2GidVector").define())
                .put(new Info("std::vector<FileData>").pointerTypes("FileDataVector").define())
                .put(new Info("std::vector<UriData>").pointerTypes("UriDataVector").define())
                .put(new Info("std::vector<std::vector<std::string> >").pointerTypes("StringVectorVector").define())
                .put(new Info("aria2::DownloadEvent").enumerate(true).javaNames("DownloadEvent"))

        ;

        ;

//std::vector<FileData>
    }
}
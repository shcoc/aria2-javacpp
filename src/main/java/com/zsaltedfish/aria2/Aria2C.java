package com.zsaltedfish.aria2;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(
        inherit = {com.zsaltedfish.aria2.prest.Aria2.class},
        value = @Platform(executable = "aria2c")
)
public class Aria2C {
    static { Loader.load(); }
}

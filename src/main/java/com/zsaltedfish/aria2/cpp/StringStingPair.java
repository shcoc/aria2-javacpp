// Targeted by JavaCPP version 1.5.7: DO NOT EDIT THIS FILE

package com.zsaltedfish.aria2.cpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static com.zsaltedfish.aria2.global.Aria2.*;

@NoOffset @Name("std::pair<std::string,std::string>") @Properties(inherit = com.zsaltedfish.aria2.prest.Aria2.class)
public class StringStingPair extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StringStingPair(Pointer p) { super(p); }
    public StringStingPair(BytePointer firstValue, BytePointer secondValue) { this(); put(firstValue, secondValue); }
    public StringStingPair(String firstValue, String secondValue) { this(); put(firstValue, secondValue); }
    public StringStingPair()       { allocate();  }
    private native void allocate();
    public native @Name("operator =") @ByRef StringStingPair put(@ByRef StringStingPair x);


    @MemberGetter public native @StdString BytePointer first(); public native StringStingPair first(BytePointer first);
    @MemberGetter public native @StdString BytePointer second();  public native StringStingPair second(BytePointer second);
    @MemberSetter @Index public native StringStingPair first(@StdString String first);
    @MemberSetter @Index public native StringStingPair second(@StdString String second);

    public StringStingPair put(BytePointer firstValue, BytePointer secondValue) {
        first(firstValue);
        second(secondValue);
        return this;
    }

    public StringStingPair put(String firstValue, String secondValue) {
        first(firstValue);
        second(secondValue);
        return this;
    }
}


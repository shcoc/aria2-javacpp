// Targeted by JavaCPP version 1.5.7: DO NOT EDIT THIS FILE

package io.github.ssaltedfish.aria2.cpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static io.github.ssaltedfish.aria2.global.Aria2.*;


/**
 * \class
 *
 * The interface to get information of download item.
 */
@Namespace("aria2") @Properties(inherit = io.github.ssaltedfish.aria2.prest.Aria2.class)
public class DownloadHandle extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DownloadHandle(Pointer p) { super(p); }

  /**
   * Returns status of this download.
   */
  public native DownloadStatus getStatus();
  /**
   * Returns the total length of this download in bytes.
   */
  public native @Cast("int64_t") long getTotalLength();
  /**
   * Returns the completed length of this download in bytes.
   */
  public native @Cast("int64_t") long getCompletedLength();
  /**
   * Returns the uploaded length of this download in bytes.
   */
  public native @Cast("int64_t") long getUploadLength();
  /**
   * Returns the download progress in byte-string. The highest bit
   * corresponds to piece index 0. The set bits indicate the piece is
   * available and unset bits indicate the piece is missing. The spare
   * bits at the end are set to zero. When download has not started
   * yet, returns empty string.
   */
  public native @StdString BytePointer getBitfield();
  /**
   * Returns download speed of this download measured in bytes/sec.
   */
  public native int getDownloadSpeed();
  /**
   * Returns upload speed of this download measured in bytes/sec.
   */
  public native int getUploadSpeed();
  /**
   * Returns 20 bytes InfoHash if BitTorrent transfer is
   * involved. Otherwise the empty string is returned.
   */
  public native @StdString BytePointer getInfoHash();
  /**
   * Returns piece length in bytes.
   */
  public native @Cast("size_t") long getPieceLength();
  /**
   * Returns the number of pieces.
   */
  public native int getNumPieces();
  /**
   * Returns the number of peers/servers the client has connected to.
   */
  public native int getConnections();
  /**
   * Returns the last error code occurred in this download. The error
   * codes are defined in :ref:{@code exit-status} section of
   * :manpage:{@code aria2c(1)}. This value has its meaning only for
   * stopped/completed downloads.
   */
  public native int getErrorCode();
  /**
   * Returns array of GIDs which are generated by the consequence of
   * this download. For example, when aria2 downloaded Metalink file,
   * it generates downloads described in it (see
   * :option:{@code --follow-metalink} option). This value is useful to
   * track these auto generated downloads. If there is no such
   * downloads, this function returns empty array.
   */
  public native @Cast("aria2::A2Gid*") @StdVector LongPointer getFollowedBy();
  /**
   * Returns the GID of the download which generated this download.
   * This is a reverse link of
   * :func:{@code DownloadHandle::getFollowedBy()}.
   */
  public native @Cast("aria2::A2Gid") long getFollowing();
  /**
   * Returns the GID of a parent download. Some downloads are a part
   * of another download. For example, if a file in Metalink has
   * BitTorrent resource, the download of ".torrent" is a part of that
   * file. If this download has no parent, the invalid GID is returned
   * ({@code }isNull(gid){@code } is true).
   */
  public native @Cast("aria2::A2Gid") long getBelongsTo();
  /**
   * Returns the directory to save files.
   */
  public native @StdString BytePointer getDir();
  /**
   * Returns the array of files this download contains.
   */
  public native @StdVector FileData getFiles();
  /**
   * Returns the number of files. The return value is equivalent to
   * {@code }DownloadHandle::getFiles().size(){@code }.
   */
  public native int getNumFiles();
  /**
   * Returns the FileData of the file at the specified |index|. Please
   * note that the index is 1-based. It is undefined when the |index|
   * is out-of-bound.
   */
  public native @ByVal FileData getFile(int index);
  /**
   * Returns the information retrieved from ".torrent" file. This
   * function is only meaningful only when BitTorrent transfer is
   * involved in the download and the download is not
   * stopped/completed.
   */
  public native @ByVal BtMetaInfoData getBtMetaInfo();
  /**
   * Returns the option value denoted by the |name|.  If the option
   * denoted by the |name| is not available, returns empty string.
   *
   * Calling this function for the download which is not in
   * :c:macro:{@code DOWNLOAD_ACTIVE}, :c:macro:{@code DOWNLOAD_PAUSED} or
   * :c:macro:{@code DOWNLOAD_WAITING} will return empty string.
   */
  public native @StdString BytePointer getOption(@StdString BytePointer name);
  public native @StdString String getOption(@StdString String name);
  /**
   * Returns options for this download. Note that this function does
   * not return options which have no default value and have not been
   * set by :func:{@code sessionNew()}, configuration files or API
   * functions.
   */
  public native @ByVal @Cast("aria2::KeyVals*") StringStingPairVector getOptions();
}

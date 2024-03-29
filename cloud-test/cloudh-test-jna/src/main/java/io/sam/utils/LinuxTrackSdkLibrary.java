package io.sam.utils;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
/**
 * JNA Wrapper for library <b>GXX_NSPP_TRACK_SDK</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public interface LinuxTrackSdkLibrary extends Library {
	public static final String JNA_LIBRARY_NAME = "GXX_NSPP_TRACK_SDK";
	public static final NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(LinuxTrackSdkLibrary.JNA_LIBRARY_NAME);
	public static final LinuxTrackSdkLibrary INSTANCE = (LinuxTrackSdkLibrary)Native.loadLibrary(LinuxTrackSdkLibrary.JNA_LIBRARY_NAME, LinuxTrackSdkLibrary.class);
	/**
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:35</i><br>
	 * enum values
	 */
	public static interface EN_NSPP_ERROT_CODE {
		/**
		 * \ufffd\u0279\ufffd<br>
		 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:36</i>
		 */
		public static final int NSPP_SDK_SUCCEED = 0;
		/**
		 * \u03b4\u05aa\ufffd\ufffd\ufffd\ufffd<br>
		 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:37</i>
		 */
		public static final int NSPP_SDK_UNKNOWN_ERROR = 1;
		/**
		 * \ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd<br>
		 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:38</i>
		 */
		public static final int NSPP_SDK_INVAILD_PARAM = 2;
		/**
		 * \ufffd\u3de8\ufffd\ufffd\u03b4\u05e2\ufffd\ufffd/\ufffd\ufffd\ufffd\ufffd<br>
		 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:39</i>
		 */
		public static final int NSPP_SDK_UNREGISTERED = 3;
		/**
		 * \ufffd\ufffd\ufffd\ufffd\ufffd\ufffd<br>
		 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:40</i>
		 */
		public static final int NSPP_SDK_NO_EXIST = 4;
		/**
		 * \u03f5\u0373\ufffd\ufffd\u0534\ufffd\ufffd\ufffd\ufffd<br>
		 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:41</i>
		 */
		public static final int NSPP_SDK_OUTOF_RES = 5;
		/**
		 * \u03b4\ufffd\ufffd\ufffd\ufffd\u0123\ufffd\ufffd<br>
		 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:42</i>
		 */
		public static final int NSPP_SDK_UNLOADMODEL = 6;
		/**
		 * \u03b4\u02b5\ufffd\ufffd<br>
		 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:43</i>
		 */
		public static final int NSPP_SDK_UNIMPLEMENTATION = 7;
		/**
		 * \u03b4\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\u0427\ufffd\ufffd\u03e2<br>
		 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:44</i>
		 */
		public static final int NSPP_SDK_UNSETVALUE = 8;
	};
	/**
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:47</i><br>
	 * enum values
	 */
	public static interface EN_NSPP_REGION_TYPE {
		/**
		 * \ufffd\ufffd\ufffd\ufffd\ufffd\ufffd<br>
		 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:48</i>
		 */
		public static final int NSPP_REGION_TYPE_ROOM = 1;
		/**
		 * \ufffd\ufffd\ufffd\ufffd<br>
		 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:49</i>
		 */
		public static final int NSPP_REGION_TYPE_CORRIDOR = 2;
	};
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_GetVersion(char*)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:57</i><br>
	 * @deprecated use the safer methods {@link #GXX_NSPP_TRACK_GetVersion(ByteBuffer)} and {@link #GXX_NSPP_TRACK_GetVersion(Pointer)} instead
	 */
	@Deprecated 
	int GXX_NSPP_TRACK_GetVersion(Pointer version_num);
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_GetVersion(char*)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:57</i>
	 */
	int GXX_NSPP_TRACK_GetVersion(ByteBuffer version_num);
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_Init(const char*)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:64</i><br>
	 * @deprecated use the safer methods {@link #GXX_NSPP_TRACK_Init(String)} and {@link #GXX_NSPP_TRACK_Init(Pointer)} instead
	 */
	@Deprecated 
	int GXX_NSPP_TRACK_Init(Pointer lic_path);
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_Init(const char*)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:64</i>
	 */
	int GXX_NSPP_TRACK_Init(String lic_path);
	/**
	 * Original signature : <code>void GXX_NSPP_TRACK_CleanUp()</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:71</i>
	 */
	void GXX_NSPP_TRACK_CleanUp();
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_CreateScene(long long*)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:75</i><br>
	 * @deprecated use the safer methods {@link #GXX_NSPP_TRACK_CreateScene(LongBuffer)} and {@link #GXX_NSPP_TRACK_CreateScene(LongByReference)} instead
	 */
	@Deprecated 
	int GXX_NSPP_TRACK_CreateScene(LongByReference scene_id);
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_CreateScene(long long*)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:75</i>
	 */
	int GXX_NSPP_TRACK_CreateScene(LongBuffer scene_id);
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_SetRegionConnectInfo(long long, const char*, int)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:85</i><br>
	 * @deprecated use the safer methods {@link #GXX_NSPP_TRACK_SetRegionConnectInfo(long, String, int)} and {@link #GXX_NSPP_TRACK_SetRegionConnectInfo(long, Pointer, int)} instead
	 */
	@Deprecated 
	int GXX_NSPP_TRACK_SetRegionConnectInfo(long scene_id, Pointer szJsonParm, int nJsonLen);
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_SetRegionConnectInfo(long long, const char*, int)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:85</i>
	 */
	int GXX_NSPP_TRACK_SetRegionConnectInfo(long scene_id, String szJsonParm, int nJsonLen);
	/**
	 * Original signature : <code>void GXX_NSPP_TRACK_ReleaseScene(long long)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:87</i>
	 */
	void GXX_NSPP_TRACK_ReleaseScene(long scene_id);
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_Create(long long*, long long)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:96</i><br>
	 * @deprecated use the safer methods {@link #GXX_NSPP_TRACK_Create(LongBuffer, long)} and {@link #GXX_NSPP_TRACK_Create(LongByReference, long)} instead
	 */
	@Deprecated 
	int GXX_NSPP_TRACK_Create(LongByReference handle, long scene_id);
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_Create(long long*, long long)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:96</i>
	 */
	int GXX_NSPP_TRACK_Create(LongBuffer handle, long scene_id);
	/**
	 * Original signature : <code>void GXX_NSPP_TRACK_Release(long long)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:104</i>
	 */
	void GXX_NSPP_TRACK_Release(long handle);
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_PathSearch(long long, const char*, int, char*, int*)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:117</i><br>
	 * @deprecated use the safer methods {@link #GXX_NSPP_TRACK_PathSearch(long, String, int, ByteBuffer, IntBuffer)} and {@link #GXX_NSPP_TRACK_PathSearch(long, Pointer, int, Pointer, IntByReference)} instead
	 */
	@Deprecated 
	int GXX_NSPP_TRACK_PathSearch(long handle, Pointer szInJsonParm, int nInJsonLen, Pointer szOutJsonParm, IntByReference nOutJsonLen);
	/**
	 * Original signature : <code>int GXX_NSPP_TRACK_PathSearch(long long, const char*, int, char*, int*)</code><br>
	 * <i>native declaration : linux/GXX_NSPP_TRACK_SDK.h:117</i>
	 */
	int GXX_NSPP_TRACK_PathSearch(long handle, String szInJsonParm, int nInJsonLen, ByteBuffer szOutJsonParm, IntBuffer nOutJsonLen);
}

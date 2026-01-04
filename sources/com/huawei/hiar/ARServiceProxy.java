package com.huawei.hiar;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.Surface;
import com.huawei.arengine.service.IAREngine;
import com.huawei.hiar.annotations.UsedByNative;
import com.huawei.hiar.exceptions.ARCameraNotAvailableException;
import com.huawei.hiar.exceptions.ARCameraPermissionDeniedException;
import com.huawei.hiar.exceptions.ARDeadlineExceededException;
import com.huawei.hiar.exceptions.ARFatalException;
import com.huawei.hiar.exceptions.ARMissingGlContextException;
import com.huawei.hiar.exceptions.ARNotTrackingException;
import com.huawei.hiar.exceptions.ARNotYetAvailableException;
import com.huawei.hiar.exceptions.ARResourceExhaustedException;
import com.huawei.hiar.exceptions.ARSessionNotPausedException;
import com.huawei.hiar.exceptions.ARSessionPausedException;
import com.huawei.hiar.exceptions.ARTextureNotSetException;
import com.huawei.hiar.exceptions.ARUnSupportedConfigurationException;
import com.huawei.hiar.exceptions.ARUnavailableClientSdkTooOldException;
import com.huawei.hiar.exceptions.ARUnavailableConnectServerTimeOutException;
import com.huawei.hiar.exceptions.ARUnavailableDeviceNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableEmuiNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableServiceApkTooOldException;
import com.huawei.hiar.exceptions.ARUnavailableServiceNotInstalledException;
import com.huawei.hiar.exceptions.ARUnavailableUserDeclinedInstallationException;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@UsedByNative("HiARSession.cpp")
/* loaded from: classes5.dex */
class ARServiceProxy implements SurfaceTexture.OnFrameAvailableListener {
    private static final int DEFAULT_PREVIEW_SIZE_HEIGHT = 960;
    private static final int DEFAULT_PREVIEW_SIZE_WIDTH = 1280;
    private static final float FLOAT_2F = 2.0f;
    static final int HWAR_ERROR_CAMERA_NOT_AVAILABLE = -13;
    static final int HWAR_ERROR_CAMERA_PERMISSION_NOT_GRANTED = -9;
    static final int HWAR_ERROR_DEADLINE_EXCEEDED = -10;
    static final int HWAR_ERROR_FATAL = -2;
    static final int HWAR_ERROR_INVALID_ARGUMENT = -1;
    static final int HWAR_ERROR_MISSING_GL_CONTEXT = -7;
    static final int HWAR_ERROR_NOT_TRACKING = -5;
    static final int HWAR_ERROR_NOT_YET_AVAILABLE = -12;
    static final int HWAR_ERROR_RESOURCE_EXHAUSTED = -11;
    static final int HWAR_ERROR_SESSION_NOT_PAUSED = -4;
    static final int HWAR_ERROR_SESSION_PAUSED = -3;
    static final int HWAR_ERROR_TEXTURE_NOT_SET = -6;
    static final int HWAR_ERROR_UNSUPPORTED_CONFIGURATION = -8;
    static final int HWAR_SUCCESS = 0;
    static final int HWAR_UNAVAILABLE_APK_TOO_OLD = -103;
    static final int HWAR_UNAVAILABLE_ARSERVICE_NOT_INSTALLED = -100;
    static final int HWAR_UNAVAILABLE_CONNECT_SERVER_TIME_OUT = -1001;
    static final int HWAR_UNAVAILABLE_DEVICE_NOT_COMPATIBLE = -101;
    static final int HWAR_UNAVAILABLE_EMUI_NOT_COMPATIBLE = -1000;
    static final int HWAR_UNAVAILABLE_SDK_TOO_OLD = -104;
    static final int HWAR_UNAVAILABLE_USER_DECLINED_INSTALLATION = -105;
    private static final int INT_16 = 16;
    private static final boolean IS_USE_64_BIT_LIB = false;
    private static final String NAME_ARENGINE_REMOTE_SERVICE = "com.huawei.arengine.service.AREngineServer";
    private static final long NANOSECONDS_IN_MILLISECOND = 1000000;
    private static final String PACKAGE_ARENGINE_REMOTE_SERVICE = "com.huawei.arengine.service";
    private static final String TAG = "ARServiceProxy";
    private static int previewSizeWidth;
    private static int previewWidthHeight;
    private Context context;
    private IAREngine hiArService;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private int[] metaDatas;
    private long sessionHandle;
    private AtomicBoolean textureAvailable = new AtomicBoolean(false);
    private SurfaceTexture surfaceTexture = null;
    private Surface surface = null;
    private final Object syncObject = new Object();
    private boolean isSetMetaData = false;
    private ServiceConnection connection = new ServiceConnectionC4830a();

    /* renamed from: com.huawei.hiar.ARServiceProxy$a */
    public class ServiceConnectionC4830a implements ServiceConnection {
        public ServiceConnectionC4830a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (ARServiceProxy.this.syncObject) {
                Log.d(ARServiceProxy.TAG, "onServiceConnected");
                ARServiceProxy.this.hiArService = IAREngine.AbstractBinderC4593a.m28132h(iBinder);
                if (ARServiceProxy.this.hiArService == null) {
                    Log.w(ARServiceProxy.TAG, "onServiceConnected hiArService is null.");
                    return;
                }
                try {
                    ARServiceProxy aRServiceProxy = ARServiceProxy.this;
                    aRServiceProxy.metaDatas = aRServiceProxy.hiArService.getMetaData();
                } catch (RemoteException unused) {
                    Log.e(ARServiceProxy.TAG, "getMetaData failed!");
                }
                ARServiceProxy aRServiceProxy2 = ARServiceProxy.this;
                aRServiceProxy2.nativeStart(aRServiceProxy2.sessionHandle);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(ARServiceProxy.TAG, "onServiceDisconnected called since the service is lost or stop!");
            ARServiceProxy.this.hiArService = null;
        }
    }

    @UsedByNative("HiARSession.cpp")
    @Deprecated
    public ARServiceProxy(Object obj, long j10) {
        if (!(obj instanceof Context)) {
            Log.e(TAG, "ARServiceProxy context invalid.");
            return;
        }
        this.context = (Context) obj;
        this.sessionHandle = j10;
        previewSizeWidth = DEFAULT_PREVIEW_SIZE_WIDTH;
        previewWidthHeight = 960;
        HandlerThread handlerThread = new HandlerThread("OnFrameAvailableThread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        if (this.mHandlerThread.getLooper() != null) {
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
        } else {
            Log.e(TAG, "ARServiceProxy create mHandler failed!");
        }
        arBindService(this.context);
    }

    private void arBindService(Context context) {
        Log.d(TAG, "arBindService");
        Intent intent = new Intent();
        intent.setClassName(context, NAME_ARENGINE_REMOTE_SERVICE);
        context.bindService(new Intent(createExplicitStartIntent(intent)), this.connection, 1);
    }

    private void arUnbindService(Context context) {
        String str = TAG;
        Log.d(str, "arUnbindService");
        if (context == null) {
            Log.e(str, "context is null");
        } else {
            context.unbindService(this.connection);
        }
    }

    private Intent createExplicitStartIntent(Intent intent) {
        ComponentName componentName = new ComponentName("com.huawei.arengine.service", NAME_ARENGINE_REMOTE_SERVICE);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    private static String getAbsolutePath(Context context) {
        StringBuilder sb2;
        String str;
        String packageResourcePath = context.getPackageResourcePath();
        int length = packageResourcePath.length() - 1;
        while (length >= 0 && packageResourcePath.charAt(length) != '/') {
            length--;
        }
        if (length < 0) {
            return null;
        }
        String strSubstring = packageResourcePath.substring(0, length);
        if (Process.is64Bit()) {
            Log.d(TAG, "current process is 64bit, use arm64");
            sb2 = new StringBuilder();
            sb2.append(strSubstring);
            str = "/lib/arm64/";
        } else {
            Log.d(TAG, "current process is 32bit, use arm");
            sb2 = new StringBuilder();
            sb2.append(strSubstring);
            str = "/lib/arm/";
        }
        sb2.append(str);
        return sb2.toString();
    }

    @UsedByNative("session_impl.cpp")
    private static String getAbsoluteRemoteLibName(Object obj, String str) {
        String str2 = TAG;
        Log.d(str2, "into getAbsoluteRemoteLibName");
        try {
            if (obj instanceof Context) {
                return getAbsolutePath(((Context) obj).createPackageContext(str, 3));
            }
            Log.w(str2, "context transform failed");
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "create context failed");
            return null;
        }
    }

    @UsedByNative("HiARSession.cpp")
    @Deprecated
    private Surface getPreviewSurfaceWithTexture(int i10) {
        if (i10 < 0) {
            Log.e(TAG, "invalid textureId yet");
            return null;
        }
        if (this.surfaceTexture == null) {
            SurfaceTexture surfaceTexture = new SurfaceTexture(i10);
            this.surfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this, this.mHandler);
            this.surfaceTexture.setDefaultBufferSize(previewSizeWidth, previewWidthHeight);
            this.surface = new Surface(this.surfaceTexture);
        }
        if (this.surface == null) {
            Log.e(TAG, "GetSurfaceWithTexture failed, lost surface");
        }
        return this.surface;
    }

    @UsedByNative("HiARHelper.cpp")
    private FileDescriptor getSharedFile(String str) {
        ParcelFileDescriptor sharedFile;
        IAREngine iAREngine = this.hiArService;
        if (iAREngine == null) {
            Log.w(TAG, "AR service is not ready.");
            return null;
        }
        try {
            sharedFile = iAREngine.getSharedFile(str);
        } catch (RemoteException unused) {
            Log.w(TAG, "Failed to bind remote.");
            sharedFile = null;
        }
        if (sharedFile != null) {
            return sharedFile.getFileDescriptor();
        }
        Log.i(TAG, "Failed to get file descriptor.");
        return null;
    }

    private static Map<Integer, Exception> loadExceptionMap() {
        HashMap map = new HashMap();
        map.put(-1, new IllegalArgumentException());
        map.put(-2, new ARFatalException());
        map.put(-3, new ARSessionPausedException());
        map.put(-4, new ARSessionNotPausedException());
        map.put(-5, new ARNotTrackingException());
        map.put(-6, new ARTextureNotSetException());
        map.put(-7, new ARMissingGlContextException());
        map.put(-8, new ARUnSupportedConfigurationException());
        map.put(-9, new ARCameraPermissionDeniedException());
        map.put(-10, new ARDeadlineExceededException());
        map.put(-11, new ARResourceExhaustedException());
        map.put(Integer.valueOf(HWAR_ERROR_NOT_YET_AVAILABLE), new ARNotYetAvailableException());
        map.put(Integer.valueOf(HWAR_ERROR_CAMERA_NOT_AVAILABLE), new ARCameraNotAvailableException());
        map.put(-100, new ARUnavailableServiceNotInstalledException());
        map.put(-101, new ARUnavailableDeviceNotCompatibleException());
        map.put(-1000, new ARUnavailableEmuiNotCompatibleException());
        map.put(Integer.valueOf(HWAR_UNAVAILABLE_CONNECT_SERVER_TIME_OUT), new ARUnavailableConnectServerTimeOutException());
        map.put(-103, new ARUnavailableServiceApkTooOldException());
        map.put(-104, new ARUnavailableClientSdkTooOldException());
        map.put(-105, new ARUnavailableUserDeclinedInstallationException());
        return map;
    }

    private native void nativeSetMetaData(long j10, int[] iArr, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStart(long j10);

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a A[Catch: all -> 0x0018, LOOP:0: B:10:0x001a->B:25:0x004a, LOOP_END, TryCatch #2 {all -> 0x0018, blocks: (B:4:0x000c, B:6:0x0016, B:12:0x0020, B:13:0x0024, B:15:0x0027, B:19:0x0038, B:21:0x0040, B:22:0x0047, B:25:0x004a, B:18:0x0031, B:26:0x0053), top: B:36:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0040 A[SYNTHETIC] */
    @com.huawei.hiar.annotations.UsedByNative("HiARSession.cpp")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean newFrameAvaliableByWait(long r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r3 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r1 * r3
            java.util.concurrent.atomic.AtomicBoolean r7 = r0.textureAvailable
            monitor-enter(r7)
            java.util.concurrent.atomic.AtomicBoolean r8 = r0.textureAvailable     // Catch: java.lang.Throwable -> L18
            r9 = 0
            boolean r8 = r8.getAndSet(r9)     // Catch: java.lang.Throwable -> L18
            r10 = 1
            if (r8 == 0) goto L1a
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L18
            return r10
        L18:
            r0 = move-exception
            goto L70
        L1a:
            r11 = 0
            int r8 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r8 <= 0) goto L53
            long r11 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L18
            long r13 = r5 / r3
            r15 = r11
            long r10 = r5 % r3
            java.util.concurrent.atomic.AtomicBoolean r12 = r0.textureAvailable     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L31
            int r10 = (int) r10     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L31
            r12.wait(r13, r10)     // Catch: java.lang.Throwable -> L18 java.lang.InterruptedException -> L31
            goto L38
        L30:
            r15 = r11
        L31:
            java.lang.String r10 = com.huawei.hiar.ARServiceProxy.TAG     // Catch: java.lang.Throwable -> L18
            java.lang.String r11 = "Interrupted: localInterrupted"
            android.util.Log.d(r10, r11)     // Catch: java.lang.Throwable -> L18
        L38:
            java.util.concurrent.atomic.AtomicBoolean r10 = r0.textureAvailable     // Catch: java.lang.Throwable -> L18
            boolean r10 = r10.getAndSet(r9)     // Catch: java.lang.Throwable -> L18
            if (r10 == 0) goto L4a
            java.lang.String r0 = com.huawei.hiar.ARServiceProxy.TAG     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "newFrameAvailableByWait: notifyed by onFrameAvailable"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L18
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L18
            r8 = 1
            return r8
        L4a:
            r8 = 1
            long r10 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L18
            long r10 = r10 - r15
            long r5 = r5 - r10
            r10 = r8
            goto L1a
        L53:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L18
            java.lang.String r0 = com.huawei.hiar.ARServiceProxy.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "texture unavailable for "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " ms"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            android.util.Log.d(r0, r1)
            return r9
        L70:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L18
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hiar.ARServiceProxy.newFrameAvaliableByWait(long):boolean");
    }

    @UsedByNative("HiARSession.cpp")
    public static float[] projectionMatrixFromCameraIntrinsics(int i10, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        float[] fArr = new float[32];
        Matrix.setIdentityM(fArr, 0);
        fArr[0] = 1.0f / f12;
        fArr[5] = 1.0f / f13;
        Matrix.frustumM(fArr, 16, (((-f16) * f14) / 2.0f) - f18, ((f14 * f16) / 2.0f) - f18, (((-f17) * f15) / 2.0f) - f19, ((f15 * f17) / 2.0f) - f19, f10, f11);
        float[] fArr2 = new float[16];
        Matrix.multiplyMM(fArr2, i10, fArr, 0, fArr, 16);
        return fArr2;
    }

    public static void setPreviewSize(int i10, int i11) {
        previewSizeWidth = i10;
        previewWidthHeight = i11;
    }

    @UsedByNative("HiARSession.cpp")
    private void stop() {
        arUnbindService(this.context);
    }

    @UsedByNative("hiarsession_jni.cpp")
    public static void throwExceptionFromArStatus(int i10, boolean z10) throws Exception {
        if (i10 == 0) {
            return;
        }
        if (!z10 && i10 == -8) {
            throw new ARUnSupportedConfigurationException(ARConfigBase.AR_TYPE_UNSUPPORTED_MESSAGE);
        }
        Map<Integer, Exception> mapLoadExceptionMap = loadExceptionMap();
        if (mapLoadExceptionMap.containsKey(Integer.valueOf(i10))) {
            throw mapLoadExceptionMap.get(Integer.valueOf(i10));
        }
        throw new ARFatalException("Unexpected error code: " + i10);
    }

    @UsedByNative("HiARSession.cpp")
    private long updatePreview() {
        this.surfaceTexture.updateTexImage();
        return this.surfaceTexture.getTimestamp();
    }

    public void finalize() throws Throwable {
        this.mHandlerThread.quit();
        super.finalize();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.textureAvailable) {
            this.textureAvailable.set(true);
            this.textureAvailable.notifyAll();
        }
    }

    @UsedByNative("HiARSession.cpp")
    public void update(long j10, long j11) {
        if (this.hiArService == null) {
            Log.w(TAG, "AR service is not ready.");
        } else {
            if (this.isSetMetaData) {
                return;
            }
            int[] iArr = this.metaDatas;
            nativeSetMetaData(j10, iArr, iArr.length);
            this.isSetMetaData = true;
        }
    }
}

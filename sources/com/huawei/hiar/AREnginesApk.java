package com.huawei.hiar;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes5.dex */
public class AREnginesApk {
    private static final String LIBRARY_NAME = "huawei_arengine_jni";
    private static final String TAG = "AREnginesApk";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Deprecated
    public static class ARAvailability {
        private static final /* synthetic */ ARAvailability[] $VALUES;
        public static final ARAvailability SUPPORTED_APK_TOO_OLD;
        public static final ARAvailability SUPPORTED_INSTALLED;
        public static final ARAvailability SUPPORTED_NOT_INSTALLED;
        public static final ARAvailability UNKNOWN_CHECKING;
        public static final ARAvailability UNKNOWN_ERROR;
        public static final ARAvailability UNKNOWN_TIMED_OUT;
        public static final ARAvailability UNSUPPORTED_DEVICE_NOT_CAPABLE;
        public static final ARAvailability UNSUPPORTED_EMUI_NOT_CAPABLE;
        final int nativeCode;

        /* renamed from: com.huawei.hiar.AREnginesApk$ARAvailability$a */
        public enum C4819a extends ARAvailability {
            public C4819a(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.AREnginesApk.ARAvailability
            public boolean isUnknown() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.AREnginesApk$ARAvailability$b */
        public enum C4820b extends ARAvailability {
            public C4820b(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.AREnginesApk.ARAvailability
            public boolean isTransient() {
                return true;
            }

            @Override // com.huawei.hiar.AREnginesApk.ARAvailability
            public boolean isUnknown() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.AREnginesApk$ARAvailability$c */
        public enum C4821c extends ARAvailability {
            public C4821c(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.AREnginesApk.ARAvailability
            public boolean isUnknown() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.AREnginesApk$ARAvailability$d */
        public enum C4822d extends ARAvailability {
            public C4822d(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.AREnginesApk.ARAvailability
            public boolean isUnsupported() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.AREnginesApk$ARAvailability$e */
        public enum C4823e extends ARAvailability {
            public C4823e(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.AREnginesApk.ARAvailability
            public boolean isUnsupported() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.AREnginesApk$ARAvailability$f */
        public enum C4824f extends ARAvailability {
            public C4824f(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.AREnginesApk.ARAvailability
            public boolean isSupported() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.AREnginesApk$ARAvailability$g */
        public enum C4825g extends ARAvailability {
            public C4825g(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.AREnginesApk.ARAvailability
            public boolean isSupported() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.AREnginesApk$ARAvailability$h */
        public enum C4826h extends ARAvailability {
            public C4826h(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.AREnginesApk.ARAvailability
            public boolean isSupported() {
                return true;
            }
        }

        static {
            C4819a c4819a = new C4819a("UNKNOWN_ERROR", 0, 0);
            UNKNOWN_ERROR = c4819a;
            C4820b c4820b = new C4820b("UNKNOWN_CHECKING", 1, 1);
            UNKNOWN_CHECKING = c4820b;
            C4821c c4821c = new C4821c("UNKNOWN_TIMED_OUT", 2, 2);
            UNKNOWN_TIMED_OUT = c4821c;
            C4822d c4822d = new C4822d("UNSUPPORTED_DEVICE_NOT_CAPABLE", 3, 100);
            UNSUPPORTED_DEVICE_NOT_CAPABLE = c4822d;
            C4823e c4823e = new C4823e("UNSUPPORTED_EMUI_NOT_CAPABLE", 4, 5000);
            UNSUPPORTED_EMUI_NOT_CAPABLE = c4823e;
            C4824f c4824f = new C4824f("SUPPORTED_NOT_INSTALLED", 5, 201);
            SUPPORTED_NOT_INSTALLED = c4824f;
            C4825g c4825g = new C4825g("SUPPORTED_APK_TOO_OLD", 6, 202);
            SUPPORTED_APK_TOO_OLD = c4825g;
            C4826h c4826h = new C4826h("SUPPORTED_INSTALLED", 7, 203);
            SUPPORTED_INSTALLED = c4826h;
            $VALUES = new ARAvailability[]{c4819a, c4820b, c4821c, c4822d, c4823e, c4824f, c4825g, c4826h};
        }

        private ARAvailability(String str, int i10, int i11) {
            this.nativeCode = i11;
        }

        public static ARAvailability forNumber(int i10) {
            for (ARAvailability aRAvailability : values()) {
                if (aRAvailability.nativeCode == i10) {
                    return aRAvailability;
                }
            }
            return UNKNOWN_ERROR;
        }

        public static ARAvailability valueOf(String str) {
            return (ARAvailability) Enum.valueOf(ARAvailability.class, str);
        }

        public static ARAvailability[] values() {
            return (ARAvailability[]) $VALUES.clone();
        }

        public boolean isSupported() {
            return false;
        }

        public boolean isTransient() {
            return false;
        }

        public boolean isUnknown() {
            return false;
        }

        public boolean isUnsupported() {
            return false;
        }
    }

    @Deprecated
    public enum ARInstallStatus {
        UNKNOWN_STATUS(-1),
        INSTALLED(0),
        INSTALL_REQUESTED(1);

        final int nativeCode;

        ARInstallStatus(int i10) {
            this.nativeCode = i10;
        }

        public static ARInstallStatus forNumber(int i10) {
            for (ARInstallStatus aRInstallStatus : values()) {
                if (aRInstallStatus.nativeCode == i10) {
                    return aRInstallStatus;
                }
            }
            return UNKNOWN_STATUS;
        }
    }

    static {
        System.loadLibrary(LIBRARY_NAME);
    }

    private AREnginesApk() {
    }

    @Deprecated
    public static ARAvailability checkAvailability(Context context) {
        return ARAvailability.forNumber(203);
    }

    public static boolean isAREngineApkReady(Context context) {
        return nativeIsAREngineApkReady(context);
    }

    private static native boolean nativeIsAREngineApkReady(Context context);

    @Deprecated
    public static ARInstallStatus requestInstall(Activity activity, boolean z10) {
        return ARInstallStatus.forNumber(0);
    }
}

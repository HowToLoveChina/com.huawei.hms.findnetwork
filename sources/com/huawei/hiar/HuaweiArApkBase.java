package com.huawei.hiar;

import android.content.Context;
import com.huawei.hiar.annotations.UsedByNative;
import com.huawei.hiar.exceptions.ARFatalException;

/* loaded from: classes5.dex */
public class HuaweiArApkBase {

    @UsedByNative("HuaweiArapk.cpp")
    static final int CURRENT_SDK_VERSIONCODE = 158;

    @UsedByNative("HuaweiArapk.cpp")
    static final int REQUIRED_MIN_APK_VERSIONCODE = 55;

    public static class ARAvailability extends Enum<ARAvailability> {
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

        /* renamed from: com.huawei.hiar.HuaweiArApkBase$ARAvailability$a */
        public enum C4833a extends ARAvailability {
            public C4833a(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.HuaweiArApkBase.ARAvailability
            public boolean isUnknown() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.HuaweiArApkBase$ARAvailability$b */
        public enum C4834b extends ARAvailability {
            public C4834b(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.HuaweiArApkBase.ARAvailability
            public boolean isTransient() {
                return true;
            }

            @Override // com.huawei.hiar.HuaweiArApkBase.ARAvailability
            public boolean isUnknown() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.HuaweiArApkBase$ARAvailability$c */
        public enum C4835c extends ARAvailability {
            public C4835c(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.HuaweiArApkBase.ARAvailability
            public boolean isUnknown() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.HuaweiArApkBase$ARAvailability$d */
        public enum C4836d extends ARAvailability {
            public C4836d(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.HuaweiArApkBase.ARAvailability
            public boolean isUnsupported() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.HuaweiArApkBase$ARAvailability$e */
        public enum C4837e extends ARAvailability {
            public C4837e(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.HuaweiArApkBase.ARAvailability
            public boolean isUnsupported() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.HuaweiArApkBase$ARAvailability$f */
        public enum C4838f extends ARAvailability {
            public C4838f(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.HuaweiArApkBase.ARAvailability
            public boolean isSupported() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.HuaweiArApkBase$ARAvailability$g */
        public enum C4839g extends ARAvailability {
            public C4839g(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.HuaweiArApkBase.ARAvailability
            public boolean isSupported() {
                return true;
            }
        }

        /* renamed from: com.huawei.hiar.HuaweiArApkBase$ARAvailability$h */
        public enum C4840h extends ARAvailability {
            public C4840h(String str, int i10, int i11) {
                super(str, i10, i11);
            }

            @Override // com.huawei.hiar.HuaweiArApkBase.ARAvailability
            public boolean isSupported() {
                return true;
            }
        }

        static {
            C4833a c4833a = new C4833a("UNKNOWN_ERROR", 0, 0);
            UNKNOWN_ERROR = c4833a;
            C4834b c4834b = new C4834b("UNKNOWN_CHECKING", 1, 1);
            UNKNOWN_CHECKING = c4834b;
            C4835c c4835c = new C4835c("UNKNOWN_TIMED_OUT", 2, 2);
            UNKNOWN_TIMED_OUT = c4835c;
            C4836d c4836d = new C4836d("UNSUPPORTED_DEVICE_NOT_CAPABLE", 3, 100);
            UNSUPPORTED_DEVICE_NOT_CAPABLE = c4836d;
            C4837e c4837e = new C4837e("UNSUPPORTED_EMUI_NOT_CAPABLE", 4, 5000);
            UNSUPPORTED_EMUI_NOT_CAPABLE = c4837e;
            C4838f c4838f = new C4838f("SUPPORTED_NOT_INSTALLED", 5, 201);
            SUPPORTED_NOT_INSTALLED = c4838f;
            C4839g c4839g = new C4839g("SUPPORTED_APK_TOO_OLD", 6, 202);
            SUPPORTED_APK_TOO_OLD = c4839g;
            C4840h c4840h = new C4840h("SUPPORTED_INSTALLED", 7, 203);
            SUPPORTED_INSTALLED = c4840h;
            $VALUES = new ARAvailability[]{c4833a, c4834b, c4835c, c4836d, c4837e, c4838f, c4839g, c4840h};
        }

        private ARAvailability(String str, int i10, int i11) {
            super(str, i10);
            this.nativeCode = i11;
        }

        public static ARAvailability forNumber(int i10) {
            for (ARAvailability aRAvailability : values()) {
                if (aRAvailability.nativeCode == i10) {
                    return aRAvailability;
                }
            }
            StringBuilder sb2 = new StringBuilder(60);
            sb2.append("Unexpected value for native Availability, value=");
            sb2.append(i10);
            throw new ARFatalException(sb2.toString());
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

        public /* synthetic */ ARAvailability(String str, int i10, int i11, C4841a c4841a) {
            this(str, i10, i11);
        }
    }

    public enum ARInstallStatus {
        UNKNOWN_Status(-1),
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
            return UNKNOWN_Status;
        }
    }

    /* renamed from: a */
    public static HuaweiArApkBase m29080a() {
        return C4845c.m29082d();
    }

    /* renamed from: b */
    public boolean mo29081b(Context context) {
        throw null;
    }
}

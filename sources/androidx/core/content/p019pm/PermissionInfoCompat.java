package androidx.core.content.p019pm;

import android.annotation.SuppressLint;
import android.content.pm.PermissionInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class PermissionInfoCompat {

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static int getProtection(PermissionInfo permissionInfo) {
            return permissionInfo.getProtection();
        }

        public static int getProtectionFlags(PermissionInfo permissionInfo) {
            return permissionInfo.getProtectionFlags();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Protection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"UniqueConstants"})
    public @interface ProtectionFlags {
    }

    private PermissionInfoCompat() {
    }

    @SuppressLint({"WrongConstant"})
    public static int getProtection(PermissionInfo permissionInfo) {
        return Api28Impl.getProtection(permissionInfo);
    }

    @SuppressLint({"WrongConstant"})
    public static int getProtectionFlags(PermissionInfo permissionInfo) {
        return Api28Impl.getProtectionFlags(permissionInfo);
    }
}

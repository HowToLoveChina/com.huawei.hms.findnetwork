package com.huawei.remoteLoader.client;

/* loaded from: classes5.dex */
public class ARLoaderException extends Exception {
    public static final int ERROR_PACKAGE_NOT_AVAILABLE = 1;
    public static final int ERROR_PACKAGE_OBSOLETE = 2;
    private static final long serialVersionUID = -2628796958218702209L;
    private final int errorCode;

    public ARLoaderException(int i10) {
        this.errorCode = i10;
    }

    private static String errorCodeToString(int i10) {
        return i10 != 1 ? i10 != 2 ? "Unknown error" : "Package obsolete" : "Package not available";
    }

    @Override // java.lang.Throwable
    public String toString() {
        String strErrorCodeToString = errorCodeToString(this.errorCode);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strErrorCodeToString).length() + 17);
        sb2.append("LoaderException{");
        sb2.append(strErrorCodeToString);
        sb2.append("}");
        return sb2.toString();
    }
}

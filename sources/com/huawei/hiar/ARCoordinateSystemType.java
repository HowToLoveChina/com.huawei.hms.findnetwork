package com.huawei.hiar;

/* loaded from: classes5.dex */
public enum ARCoordinateSystemType {
    COORDINATE_SYSTEM_TYPE_UNKNOWN(-1),
    COORDINATE_SYSTEM_TYPE_3D_WORLD(0),
    COORDINATE_SYSTEM_TYPE_3D_SELF(1),
    COORDINATE_SYSTEM_TYPE_2D_IMAGE(2),
    COORDINATE_SYSTEM_TYPE_3D_CAMERA(3);

    private static final int DEFAULT_SIZE = 16;
    final int nativeCode;

    ARCoordinateSystemType(int i10) {
        this.nativeCode = i10;
    }

    public static ARCoordinateSystemType forNumber(int i10) {
        for (ARCoordinateSystemType aRCoordinateSystemType : values()) {
            if (aRCoordinateSystemType.nativeCode == i10) {
                return aRCoordinateSystemType;
            }
        }
        return COORDINATE_SYSTEM_TYPE_UNKNOWN;
    }

    public int getKeyValues() {
        return this.nativeCode;
    }
}

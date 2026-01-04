package com.huawei.hms.common.size;

import com.huawei.hms.common.internal.Objects;
import com.huawei.openalliance.p169ad.constant.Constants;

/* loaded from: classes8.dex */
public class Size {

    /* renamed from: a */
    private final int f23532a;

    /* renamed from: b */
    private final int f23533b;

    public Size(int i10, int i11) {
        this.f23532a = i10;
        this.f23533b = i11;
    }

    public static Size parseSize(String str) {
        try {
            int iIndexOf = str.indexOf(Constants.MULTIPLE_SIGN);
            if (iIndexOf < 0) {
                iIndexOf = str.indexOf("*");
            }
            return new Size(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(iIndexOf + 1)));
        } catch (Exception unused) {
            throw new IllegalArgumentException("Size parses failed");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f23532a == size.f23532a && this.f23533b == size.f23533b;
    }

    public final int getHeight() {
        return this.f23533b;
    }

    public final int getWidth() {
        return this.f23532a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
    }

    public final String toString() {
        return "Width is " + this.f23532a + " Height is " + this.f23533b;
    }
}

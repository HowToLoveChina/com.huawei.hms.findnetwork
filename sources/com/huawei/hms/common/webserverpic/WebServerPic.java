package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* loaded from: classes8.dex */
public class WebServerPic {
    public static final Parcelable.Creator<WebServerPic> CREATOR = new WebServerPicCreator();

    /* renamed from: a */
    private final Uri f23560a;

    /* renamed from: b */
    private final int f23561b;

    /* renamed from: c */
    private final int f23562c;

    public WebServerPic(Uri uri, int i10, int i11) throws IllegalArgumentException {
        this.f23560a = uri;
        this.f23561b = i10;
        this.f23562c = i11;
        if (uri == null) {
            throw new IllegalArgumentException("url is not able to be null");
        }
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("width and height should be positive or 0");
        }
    }

    public final int getHeight() {
        return this.f23562c;
    }

    public final Uri getUrl() {
        return this.f23560a;
    }

    public final int getWidth() {
        return this.f23561b;
    }

    public final String toString() {
        return String.format(Locale.ENGLISH, "Image %dx%d %s", Integer.valueOf(this.f23561b), Integer.valueOf(this.f23562c), this.f23560a.toString());
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUrl(), i10, false);
        SafeParcelWriter.writeInt(parcel, 2, getWidth());
        SafeParcelWriter.writeInt(parcel, 3, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public WebServerPic(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }
}

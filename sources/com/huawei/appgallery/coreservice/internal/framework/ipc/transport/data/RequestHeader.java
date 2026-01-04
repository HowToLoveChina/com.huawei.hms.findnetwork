package com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

/* loaded from: classes4.dex */
public class RequestHeader extends AutoParcelable {
    public static final Parcelable.Creator<RequestHeader> CREATOR = new AutoParcelable.AutoCreator(RequestHeader.class);

    @EnableAutoParcel(3)
    private String mMediaPkg;

    @EnableAutoParcel(2)
    private String mPackageName;

    @EnableAutoParcel(4)
    private int mRequireVersionCode;

    @EnableAutoParcel(1)
    private int mSdkVersion = 9;

    /* renamed from: a */
    public void m28055a(int i10) {
        this.mRequireVersionCode = i10;
    }

    /* renamed from: c */
    public void m28056c(String str) {
        this.mMediaPkg = str;
    }

    /* renamed from: d */
    public void m28057d(String str) {
        this.mPackageName = str;
    }
}

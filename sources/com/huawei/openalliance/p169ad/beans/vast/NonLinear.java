package com.huawei.openalliance.p169ad.beans.vast;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.utils.C7789ci;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class NonLinear {
    private int height;

    @InterfaceC6929a
    private String htmlResource;

    @InterfaceC6929a
    private String iframeResource;

    @InterfaceC6929a
    private String nonLinearClickThrough;
    private String nonLinearId;
    private StaticResource staticResource;
    private List<Tracking> trackings = new ArrayList();
    private int width;

    /* renamed from: a */
    public StaticResource m40988a() {
        return this.staticResource;
    }

    /* renamed from: b */
    public String m40993b() {
        return this.nonLinearClickThrough;
    }

    /* renamed from: c */
    public void m40996c(String str) {
        this.htmlResource = str;
    }

    /* renamed from: d */
    public void m40997d(String str) {
        this.nonLinearClickThrough = str;
    }

    /* renamed from: a */
    public void m40989a(int i10) {
        this.height = i10;
    }

    /* renamed from: b */
    public void m40994b(int i10) {
        this.width = i10;
    }

    /* renamed from: a */
    public void m40990a(StaticResource staticResource) {
        this.staticResource = staticResource;
    }

    /* renamed from: b */
    public void m40995b(String str) {
        this.iframeResource = str;
    }

    /* renamed from: a */
    public void m40991a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = C7789ci.m48041a(8);
        }
        this.nonLinearId = str;
    }

    /* renamed from: a */
    public void m40992a(List<Tracking> list) {
        this.trackings = list;
    }
}

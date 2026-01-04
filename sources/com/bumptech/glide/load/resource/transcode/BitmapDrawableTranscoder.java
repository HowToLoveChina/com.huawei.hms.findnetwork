package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import p306g2.C9870v;
import p441l2.InterfaceC11225d;
import p630s2.C12676k;
import p759x1.C13684i;
import p829z1.InterfaceC14083v;

/* loaded from: classes.dex */
public class BitmapDrawableTranscoder implements InterfaceC11225d<Bitmap, BitmapDrawable> {

    /* renamed from: a */
    public final Resources f7101a;

    public BitmapDrawableTranscoder(Context context) {
        this(context.getResources());
    }

    @Override // p441l2.InterfaceC11225d
    /* renamed from: a */
    public InterfaceC14083v<BitmapDrawable> mo9169a(InterfaceC14083v<Bitmap> interfaceC14083v, C13684i c13684i) {
        return C9870v.m61307e(this.f7101a, interfaceC14083v);
    }

    public BitmapDrawableTranscoder(Resources resources) {
        this.f7101a = (Resources) C12676k.m76276d(resources);
    }
}

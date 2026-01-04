package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.bumptech.glide.load.resource.bitmap.C1599a;
import p003a2.InterfaceC0009d;

@Deprecated
/* loaded from: classes.dex */
public class VideoBitmapDecoder extends C1599a<ParcelFileDescriptor> {
    public VideoBitmapDecoder(Context context) {
        this(ComponentCallbacks2C1546b.m8898c(context).m8907f());
    }

    public VideoBitmapDecoder(InterfaceC0009d interfaceC0009d) {
        super(interfaceC0009d, new C1599a.g());
    }
}

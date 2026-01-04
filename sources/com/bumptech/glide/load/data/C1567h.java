package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.data.h */
/* loaded from: classes.dex */
public class C1567h extends AbstractC1561b<AssetFileDescriptor> {
    public C1567h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: a */
    public Class<AssetFileDescriptor> mo9017a() {
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.AbstractC1561b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void mo9023c(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.AbstractC1561b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public AssetFileDescriptor mo9026f(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str);
    }
}

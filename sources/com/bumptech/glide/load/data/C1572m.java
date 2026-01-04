package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.data.m */
/* loaded from: classes.dex */
public class C1572m extends AbstractC1561b<InputStream> {
    public C1572m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: a */
    public Class<InputStream> mo9017a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.AbstractC1561b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void mo9023c(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.AbstractC1561b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public InputStream mo9026f(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }
}

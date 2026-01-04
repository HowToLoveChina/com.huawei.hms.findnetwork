package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.data.a */
/* loaded from: classes.dex */
public final class C1560a extends AbstractC1571l<AssetFileDescriptor> {
    public C1560a(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: a */
    public Class<AssetFileDescriptor> mo9017a() {
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.AbstractC1571l
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void mo9018c(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.AbstractC1571l
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public AssetFileDescriptor mo9019f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return assetFileDescriptorOpenAssetFileDescriptor;
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }
}

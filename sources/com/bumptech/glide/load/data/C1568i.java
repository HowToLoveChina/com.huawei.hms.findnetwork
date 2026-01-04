package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.data.i */
/* loaded from: classes.dex */
public class C1568i extends AbstractC1571l<ParcelFileDescriptor> {
    public C1568i(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: a */
    public Class<ParcelFileDescriptor> mo9017a() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.AbstractC1571l
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void mo9018c(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.AbstractC1571l
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor mo9019f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return assetFileDescriptorOpenAssetFileDescriptor.getParcelFileDescriptor();
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }
}

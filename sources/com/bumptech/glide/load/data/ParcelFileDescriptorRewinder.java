package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bumptech.glide.load.data.InterfaceC1564e;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ParcelFileDescriptorRewinder implements InterfaceC1564e<ParcelFileDescriptor> {

    /* renamed from: a */
    public final InternalRewinder f6937a;

    public static final class InternalRewinder {

        /* renamed from: a */
        public final ParcelFileDescriptor f6938a;

        public InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.f6938a = parcelFileDescriptor;
        }

        public ParcelFileDescriptor rewind() throws IOException, ErrnoException {
            try {
                Os.lseek(this.f6938a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.f6938a;
            } catch (ErrnoException e10) {
                throw new IOException(e10);
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$a */
    public static final class C1559a implements InterfaceC1564e.a<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.data.InterfaceC1564e.a
        /* renamed from: a */
        public Class<ParcelFileDescriptor> mo9014a() {
            return ParcelFileDescriptor.class;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1564e.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC1564e<ParcelFileDescriptor> mo9015b(ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.f6937a = new InternalRewinder(parcelFileDescriptor);
    }

    /* renamed from: c */
    public static boolean m9010c() {
        return !"robolectric".equals(Build.FINGERPRINT);
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1564e
    /* renamed from: b */
    public void mo9012b() {
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1564e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor mo9011a() throws IOException {
        return this.f6937a.rewind();
    }
}

package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import p214d2.InterfaceC8994h;
import p599r2.C12459b;
import p630s2.C12666a;
import p759x1.C13684i;
import p759x1.EnumC13676a;

/* renamed from: com.bumptech.glide.load.model.c */
/* loaded from: classes.dex */
public class C1586c implements InterfaceC1589f<File, ByteBuffer> {

    /* renamed from: com.bumptech.glide.load.model.c$a */
    public static final class a implements InterfaceC1563d<ByteBuffer> {

        /* renamed from: a */
        public final File f7009a;

        public a(File file) {
            this.f7009a = file;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: a */
        public Class<ByteBuffer> mo9017a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: b */
        public void mo9022b() {
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: d */
        public EnumC13676a mo9024d() {
            return EnumC13676a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: e */
        public void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super ByteBuffer> aVar) {
            try {
                aVar.mo9031f(C12666a.m76246a(this.f7009a));
            } catch (IOException e10) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e10);
                }
                aVar.mo9030c(e10);
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.model.c$b */
    public static class b implements InterfaceC8994h<File, ByteBuffer> {
        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<File, ByteBuffer> mo9074b(C1591h c1591h) {
            return new C1586c();
        }
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<ByteBuffer> mo9071b(File file, int i10, int i11, C13684i c13684i) {
        return new InterfaceC1589f.a<>(new C12459b(file), new a(file));
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(File file) {
        return true;
    }
}

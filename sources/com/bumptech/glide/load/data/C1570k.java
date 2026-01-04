package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.InterfaceC1564e;
import com.huawei.feedback.constant.FeedbackConst;
import java.io.IOException;
import java.io.InputStream;
import p003a2.InterfaceC0007b;
import p306g2.C9872x;

/* renamed from: com.bumptech.glide.load.data.k */
/* loaded from: classes.dex */
public final class C1570k implements InterfaceC1564e<InputStream> {

    /* renamed from: a */
    public final C9872x f6961a;

    /* renamed from: com.bumptech.glide.load.data.k$a */
    public static final class a implements InterfaceC1564e.a<InputStream> {

        /* renamed from: a */
        public final InterfaceC0007b f6962a;

        public a(InterfaceC0007b interfaceC0007b) {
            this.f6962a = interfaceC0007b;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1564e.a
        /* renamed from: a */
        public Class<InputStream> mo9014a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1564e.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC1564e<InputStream> mo9015b(InputStream inputStream) {
            return new C1570k(inputStream, this.f6962a);
        }
    }

    public C1570k(InputStream inputStream, InterfaceC0007b interfaceC0007b) {
        C9872x c9872x = new C9872x(inputStream, interfaceC0007b);
        this.f6961a = c9872x;
        c9872x.mark(FeedbackConst.Mail.LOG_MAX_LENGTH);
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1564e
    /* renamed from: b */
    public void mo9012b() {
        this.f6961a.m61315t();
    }

    /* renamed from: c */
    public void m9045c() {
        this.f6961a.m61314s();
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1564e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream mo9011a() throws IOException {
        this.f6961a.reset();
        return this.f6961a;
    }
}

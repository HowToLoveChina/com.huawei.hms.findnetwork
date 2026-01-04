package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.ba */
/* loaded from: classes8.dex */
public interface InterfaceC5867ba {

    /* renamed from: a */
    public static final InterfaceC5867ba f26520a = new a();

    /* renamed from: com.huawei.hms.network.embedded.ba$a */
    public class a implements InterfaceC5867ba {
        @Override // com.huawei.hms.network.embedded.InterfaceC5867ba
        /* renamed from: a */
        public void mo33904a(int i10, EnumC6077r9 enumC6077r9) {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5867ba
        /* renamed from: a */
        public boolean mo33905a(int i10, InterfaceC5896db interfaceC5896db, int i11, boolean z10) throws IOException {
            interfaceC5896db.skip(i11);
            return true;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5867ba
        /* renamed from: a */
        public boolean mo33906a(int i10, List<C6090s9> list) {
            return true;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5867ba
        /* renamed from: a */
        public boolean mo33907a(int i10, List<C6090s9> list, boolean z10) {
            return true;
        }
    }

    /* renamed from: a */
    void mo33904a(int i10, EnumC6077r9 enumC6077r9);

    /* renamed from: a */
    boolean mo33905a(int i10, InterfaceC5896db interfaceC5896db, int i11, boolean z10) throws IOException;

    /* renamed from: a */
    boolean mo33906a(int i10, List<C6090s9> list);

    /* renamed from: a */
    boolean mo33907a(int i10, List<C6090s9> list, boolean z10);
}

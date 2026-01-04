package com.huawei.hms.drive;

import java.io.IOException;
import java.util.List;
import p022ay.InterfaceC1056f;

/* renamed from: com.huawei.hms.drive.dg */
/* loaded from: classes8.dex */
public interface InterfaceC5258dg {

    /* renamed from: a */
    public static final InterfaceC5258dg f24446a = new InterfaceC5258dg() { // from class: com.huawei.hms.drive.dg.1
        @Override // com.huawei.hms.drive.InterfaceC5258dg
        /* renamed from: a */
        public void mo31626a(int i10, EnumC5246cw enumC5246cw) {
        }

        @Override // com.huawei.hms.drive.InterfaceC5258dg
        /* renamed from: a */
        public boolean mo31627a(int i10, InterfaceC1056f interfaceC1056f, int i11, boolean z10) throws IOException {
            interfaceC1056f.skip(i11);
            return true;
        }

        @Override // com.huawei.hms.drive.InterfaceC5258dg
        /* renamed from: a */
        public boolean mo31628a(int i10, List<C5247cx> list) {
            return true;
        }

        @Override // com.huawei.hms.drive.InterfaceC5258dg
        /* renamed from: a */
        public boolean mo31629a(int i10, List<C5247cx> list, boolean z10) {
            return true;
        }
    };

    /* renamed from: a */
    void mo31626a(int i10, EnumC5246cw enumC5246cw);

    /* renamed from: a */
    boolean mo31627a(int i10, InterfaceC1056f interfaceC1056f, int i11, boolean z10) throws IOException;

    /* renamed from: a */
    boolean mo31628a(int i10, List<C5247cx> list);

    /* renamed from: a */
    boolean mo31629a(int i10, List<C5247cx> list, boolean z10);
}

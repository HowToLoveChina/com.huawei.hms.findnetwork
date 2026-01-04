package p755wx;

import java.io.IOException;
import java.util.List;
import p022ay.InterfaceC1056f;

/* renamed from: wx.l */
/* loaded from: classes9.dex */
public interface InterfaceC13663l {

    /* renamed from: a */
    public static final InterfaceC13663l f61538a = new a();

    /* renamed from: wx.l$a */
    public class a implements InterfaceC13663l {
        @Override // p755wx.InterfaceC13663l
        /* renamed from: a */
        public void mo82185a(int i10, EnumC13653b enumC13653b) {
        }

        @Override // p755wx.InterfaceC13663l
        /* renamed from: b */
        public boolean mo82186b(int i10, List<C13654c> list) {
            return true;
        }

        @Override // p755wx.InterfaceC13663l
        /* renamed from: c */
        public boolean mo82187c(int i10, List<C13654c> list, boolean z10) {
            return true;
        }

        @Override // p755wx.InterfaceC13663l
        /* renamed from: d */
        public boolean mo82188d(int i10, InterfaceC1056f interfaceC1056f, int i11, boolean z10) throws IOException {
            interfaceC1056f.skip(i11);
            return true;
        }
    }

    /* renamed from: a */
    void mo82185a(int i10, EnumC13653b enumC13653b);

    /* renamed from: b */
    boolean mo82186b(int i10, List<C13654c> list);

    /* renamed from: c */
    boolean mo82187c(int i10, List<C13654c> list, boolean z10);

    /* renamed from: d */
    boolean mo82188d(int i10, InterfaceC1056f interfaceC1056f, int i11, boolean z10) throws IOException;
}

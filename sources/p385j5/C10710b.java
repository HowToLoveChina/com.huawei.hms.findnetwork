package p385j5;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: j5.b */
/* loaded from: classes.dex */
public class C10710b implements InterfaceC10709a {

    /* renamed from: a */
    public List<InterfaceC10709a> f51358a = new ArrayList();

    @Override // p385j5.InterfaceC10709a
    public InterfaceC10709a addBuilder(InterfaceC10709a interfaceC10709a) {
        if (interfaceC10709a != null) {
            this.f51358a.add(interfaceC10709a);
        }
        return this;
    }

    @Override // p385j5.InterfaceC10709a
    public String build() {
        StringBuilder sb2 = new StringBuilder();
        for (InterfaceC10709a interfaceC10709a : this.f51358a) {
            if (!TextUtils.isEmpty(interfaceC10709a.build())) {
                if (sb2.length() > 0) {
                    sb2.append(" or ");
                    sb2.append(interfaceC10709a.build());
                } else {
                    sb2.append(interfaceC10709a.build());
                }
            }
        }
        return sb2.toString();
    }
}

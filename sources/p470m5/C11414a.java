package p470m5;

import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.utils.C2157a;
import p385j5.InterfaceC10709a;

/* renamed from: m5.a */
/* loaded from: classes.dex */
public class C11414a implements InterfaceC10709a {

    /* renamed from: a */
    public Context f53189a;

    /* renamed from: b */
    public boolean f53190b;

    public C11414a(Context context, boolean z10) {
        this.f53189a = context;
        this.f53190b = z10;
    }

    @Override // p385j5.InterfaceC10709a
    public InterfaceC10709a addBuilder(InterfaceC10709a interfaceC10709a) {
        return this;
    }

    @Override // p385j5.InterfaceC10709a
    public String build() {
        if (this.f53190b) {
            return "(account_type = 'com.google')";
        }
        if (BackupObject.isOppositePhoneSupportGms() || !C2157a.m13173H(this.f53189a)) {
            return "";
        }
        C2111d.m12653i("GmsToNoGmsContactConditionBuilder", "need to backup contacts of gmail account.");
        return "(account_type = 'com.google')";
    }
}

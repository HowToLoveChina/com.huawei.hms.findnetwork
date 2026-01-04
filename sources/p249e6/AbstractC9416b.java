package p249e6;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import java.util.HashMap;
import p006a5.AbstractC0048c;
import p279f6.C9662e;

/* renamed from: e6.b */
/* loaded from: classes.dex */
public abstract class AbstractC9416b extends BackupObject {

    /* renamed from: a */
    public InterfaceC2155n f47061a;

    public AbstractC9416b(InterfaceC2155n interfaceC2155n) {
        this.f47061a = interfaceC2155n;
    }

    /* renamed from: a */
    public abstract boolean mo59047a();

    /* renamed from: b */
    public abstract boolean mo59048b();

    /* renamed from: c */
    public abstract int mo59049c();

    /* renamed from: d */
    public abstract boolean mo59050d();

    /* renamed from: e */
    public abstract boolean mo59051e(Handler.Callback callback, Object obj);

    /* renamed from: f */
    public abstract int mo59052f();

    /* renamed from: g */
    public abstract int mo59053g();

    /* renamed from: h */
    public abstract String mo59054h();

    /* renamed from: i */
    public abstract int mo59055i();

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        return false;
    }

    /* renamed from: j */
    public abstract int mo59056j();

    /* renamed from: k */
    public final void m59057k() {
        InterfaceC2155n interfaceC2155n = this.f47061a;
        if (interfaceC2155n != null) {
            interfaceC2155n.mo309e();
        }
    }

    /* renamed from: l */
    public final void m59058l() {
        InterfaceC2155n interfaceC2155n = this.f47061a;
        if (interfaceC2155n != null) {
            interfaceC2155n.mo313i();
        }
    }

    /* renamed from: m */
    public final void m59059m() {
        InterfaceC2155n interfaceC2155n = this.f47061a;
        if (interfaceC2155n != null) {
            interfaceC2155n.mo312h();
        }
    }

    /* renamed from: n */
    public final void m59060n() {
        InterfaceC2155n interfaceC2155n = this.f47061a;
        if (interfaceC2155n != null) {
            interfaceC2155n.mo307c();
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        return 0;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        return null;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        return 0;
    }

    /* renamed from: e6.b$a */
    public abstract class a extends BackupObject.SubKeyInfo {
        public a(Uri uri, String str, HashMap<String, Integer> map, String str2) {
            super(uri, str, map, str2);
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyBackupOneFail(Handler.Callback callback, Object obj) {
            AbstractC9416b.this.m59057k();
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyBackupOneSuccess(Handler.Callback callback, Object obj) {
            AbstractC9416b.this.m59058l();
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyRestoreOneFail(Handler.Callback callback, Object obj) {
            AbstractC9416b.this.m59059m();
        }

        @Override // com.huawei.android.backup.service.logic.BackupObject.SubKeyInfo
        public void notifyRestoreOneSuccess(Handler.Callback callback, Object obj) {
            AbstractC9416b.this.m59060n();
        }

        public a(Uri uri, String str, HashMap<String, Integer> map, String str2, C9662e c9662e) {
            super(uri, str, map, str2);
            setSelection(c9662e.m60333c());
            setSelectionArgs(c9662e.m60334d());
            setSortOrder(c9662e.m60335e());
        }
    }
}

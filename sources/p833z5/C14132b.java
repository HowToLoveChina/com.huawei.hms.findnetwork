package p833z5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import p006a5.AbstractC0048c;

/* renamed from: z5.b */
/* loaded from: classes.dex */
public class C14132b extends AbstractC14131a {

    /* renamed from: z5.b$a */
    public class a implements InterfaceC2155n {

        /* renamed from: a */
        public Handler.Callback f63187a;

        /* renamed from: b */
        public Object f63188b;

        public a(Handler.Callback callback, Object obj) {
            this.f63187a = callback;
            this.f63188b = obj;
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: a */
        public void mo305a(Bundle bundle) {
            C14132b.this.sendMsg(102, bundle, this.f63187a, this.f63188b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: b */
        public void mo306b(int i10) {
            C14132b.m84809g(C14132b.this, i10);
            C14132b c14132b = C14132b.this;
            c14132b.sendMsg(0, ((BackupObject) c14132b).subKeyCurCount, ((BackupObject) C14132b.this).subKeyTotalNum, this.f63187a, this.f63188b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: c */
        public void mo307c() {
            C14132b.m84820r(C14132b.this);
            C14132b c14132b = C14132b.this;
            c14132b.sendMsg(3, ((BackupObject) c14132b).subKeyCurCount, ((BackupObject) C14132b.this).subKeyTotalNum, this.f63187a, this.f63188b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: d */
        public void mo308d(String str) {
            Bundle bundle = new Bundle();
            bundle.putString(C2126b.ERROR_MESSAGE_INFO, str);
            C14132b.this.sendMsg(100, bundle, this.f63187a, this.f63188b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: e */
        public void mo309e() {
            C14132b c14132b = C14132b.this;
            c14132b.sendMsg(2, ((BackupObject) c14132b).subKeyCurCount, ((BackupObject) C14132b.this).subKeyTotalNum, this.f63187a, this.f63188b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: f */
        public void mo310f(String str) {
            Bundle bundle = new Bundle();
            bundle.putString(C2126b.ERROR_MESSAGE_INFO, str);
            C14132b.this.sendMsg(101, bundle, this.f63187a, this.f63188b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: g */
        public void mo311g(int i10) {
            C14132b.m84812j(C14132b.this, i10);
            C2111d.m12654j("BackupSmsImp", "onRestoreBatchSuccess batchNum ", Integer.valueOf(i10), ", ", Integer.valueOf(((BackupObject) C14132b.this).subKeyCurCount), ", ", Integer.valueOf(((BackupObject) C14132b.this).subKeyTotalNum));
            C14132b c14132b = C14132b.this;
            c14132b.sendMsg(3, ((BackupObject) c14132b).subKeyCurCount, ((BackupObject) C14132b.this).subKeyTotalNum, this.f63187a, this.f63188b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: h */
        public void mo312h() {
            C14132b c14132b = C14132b.this;
            c14132b.sendMsg(5, ((BackupObject) c14132b).subKeyCurCount, ((BackupObject) C14132b.this).subKeyTotalNum, this.f63187a, this.f63188b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: i */
        public void mo313i() {
            C14132b.m84807e(C14132b.this);
            C14132b c14132b = C14132b.this;
            c14132b.sendMsg(0, ((BackupObject) c14132b).subKeyCurCount, ((BackupObject) C14132b.this).subKeyTotalNum, this.f63187a, this.f63188b);
        }
    }

    /* renamed from: e */
    public static /* synthetic */ int m84807e(C14132b c14132b) {
        int i10 = c14132b.subKeyCurCount;
        c14132b.subKeyCurCount = i10 + 1;
        return i10;
    }

    /* renamed from: g */
    public static /* synthetic */ int m84809g(C14132b c14132b, int i10) {
        int i11 = c14132b.subKeyCurCount + i10;
        c14132b.subKeyCurCount = i11;
        return i11;
    }

    /* renamed from: j */
    public static /* synthetic */ int m84812j(C14132b c14132b, int i10) {
        int i11 = c14132b.subKeyCurCount + i10;
        c14132b.subKeyCurCount = i11;
        return i11;
    }

    /* renamed from: r */
    public static /* synthetic */ int m84820r(C14132b c14132b) {
        int i10 = c14132b.subKeyCurCount;
        c14132b.subKeyCurCount = i10 + 1;
        return i10;
    }

    /* renamed from: w */
    private int m84825w(Context context) {
        char c10;
        int i10 = 0;
        int iMo84863j = new AbstractC14140j[]{new C14134d(null, context, null)}[0].mo84863j();
        if (iMo84863j >= 0) {
            i10 = iMo84863j;
            c10 = 0;
        } else {
            c10 = 1;
        }
        if (c10 >= 1) {
            return -1;
        }
        C2111d.m12653i("BackupSmsImp", "getBackupItemCount total = " + i10);
        return i10;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        if (abstractC0048c == null) {
            return 2;
        }
        C14134d c14134d = new C14134d(new a(callback, obj), context, abstractC0048c);
        if (!c14134d.mo84858e()) {
            C2111d.m12648d("BackupSmsImp", " Backup Failed at init!");
            return 2;
        }
        int iMo84861h = this.subKeyTotalNum + c14134d.mo84861h();
        this.subKeyTotalNum = iMo84861h;
        if (iMo84861h == 0) {
            return 2;
        }
        C2111d.m12653i("BackupSmsImp", "onBackup subkeyTotalNum = " + this.subKeyTotalNum);
        int iMo84857d = c14134d.mo84857d();
        c14134d.reportModuleBackupFinish(str, callback, obj);
        C2111d.m12653i("BackupSmsImp", "onBackup sum = " + iMo84857d);
        if (iMo84857d == 0) {
            C2111d.m12648d("BackupSmsImp", "No record backup sucess!");
            return 2;
        }
        c14134d.mo84855b();
        String strMo84862i = c14134d.mo84862i();
        StringBuilder sb2 = new StringBuilder(strMo84862i);
        if (!strMo84862i.isEmpty()) {
            sb2.append(strMo84862i);
        }
        this.backupFileModuleInfo.updateModuleInfo(iMo84857d, 8, sb2.toString());
        if (this.backupFileModuleInfo.hasRecord()) {
            return 1;
        }
        abstractC0048c.m190h();
        return 1;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        int iM84825w = m84825w(context);
        C2111d.m12653i("BackupSmsImp", "onBackupModulesDataItemTotal begin,moduleName: " + str + ",totalNumber: " + iM84825w + ",packageSize: " + l10);
        if (iM84825w < 0) {
            return null;
        }
        long appInfoSize = getAppInfoSize(context, l10.longValue(), iM84825w);
        Bundle bundle = new Bundle();
        bundle.putInt("ModuleCount", iM84825w);
        bundle.putLong("ModuleSize", appInfoSize);
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupSmsImp", "BackupSms onRestore start!");
        return m84826x(context, abstractC0048c, callback, obj, str);
    }

    /* renamed from: x */
    public final int m84826x(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C14134d c14134d = new C14134d(new a(callback, obj), context, abstractC0048c);
        if (!c14134d.mo84859f()) {
            return 5;
        }
        int iMo84864l = this.subKeyTotalNum + c14134d.mo84864l();
        this.subKeyTotalNum = iMo84864l;
        if (iMo84864l == 0) {
            C2111d.m12648d("BackupSmsImp", "There is no value in back table!");
            return 5;
        }
        c14134d.mo84860g();
        c14134d.reportModuleRestoreFinish(str);
        c14134d.mo84856c();
        m84805c(context);
        m84806d(context);
        return 4;
    }
}

package p048c6;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p006a5.AbstractC0048c;
import p030b6.C1119a;
import p249e6.AbstractC9416b;
import p249e6.C9417c;
import p249e6.C9418d;
import p386j6.C10713c;

/* renamed from: c6.b */
/* loaded from: classes.dex */
public class C1388b extends AbstractC1387a {

    /* renamed from: c6.b$a */
    public class a implements InterfaceC2155n {

        /* renamed from: a */
        public Handler.Callback f5948a;

        /* renamed from: b */
        public Object f5949b;

        public a(Handler.Callback callback, Object obj) {
            this.f5948a = callback;
            this.f5949b = obj;
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: a */
        public void mo305a(Bundle bundle) {
            C1388b.this.sendMsg(102, bundle, this.f5948a, this.f5949b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: b */
        public void mo306b(int i10) {
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: c */
        public void mo307c() {
            C1388b.m7954l(C1388b.this);
            C1388b c1388b = C1388b.this;
            c1388b.sendMsg(3, ((BackupObject) c1388b).subKeyCurCount, ((BackupObject) C1388b.this).subKeyTotalNum, this.f5948a, this.f5949b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: d */
        public void mo308d(String str) {
            Bundle bundle = new Bundle();
            bundle.putString(C2126b.ERROR_MESSAGE_INFO, str);
            C1388b.this.sendMsg(100, bundle, this.f5948a, this.f5949b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: e */
        public void mo309e() {
            C1388b.m7943a(C1388b.this);
            C1388b c1388b = C1388b.this;
            c1388b.sendMsg(2, ((BackupObject) c1388b).subKeyCurCount, ((BackupObject) C1388b.this).subKeyTotalNum, this.f5948a, this.f5949b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: f */
        public void mo310f(String str) {
            Bundle bundle = new Bundle();
            bundle.putString(C2126b.ERROR_MESSAGE_INFO, str);
            C1388b.this.sendMsg(101, bundle, this.f5948a, this.f5949b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: g */
        public void mo311g(int i10) {
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: h */
        public void mo312h() {
            C1388b.m7951i(C1388b.this);
            C1388b c1388b = C1388b.this;
            c1388b.sendMsg(5, ((BackupObject) c1388b).subKeyCurCount, ((BackupObject) C1388b.this).subKeyTotalNum, this.f5948a, this.f5949b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: i */
        public void mo313i() {
            C1388b.m7948f(C1388b.this);
            C1388b c1388b = C1388b.this;
            c1388b.sendMsg(0, ((BackupObject) c1388b).subKeyCurCount, ((BackupObject) C1388b.this).subKeyTotalNum, this.f5948a, this.f5949b);
        }
    }

    /* renamed from: a */
    public static /* synthetic */ int m7943a(C1388b c1388b) {
        int i10 = c1388b.subKeyCurCount;
        c1388b.subKeyCurCount = i10 + 1;
        return i10;
    }

    /* renamed from: f */
    public static /* synthetic */ int m7948f(C1388b c1388b) {
        int i10 = c1388b.subKeyCurCount;
        c1388b.subKeyCurCount = i10 + 1;
        return i10;
    }

    /* renamed from: i */
    public static /* synthetic */ int m7951i(C1388b c1388b) {
        int i10 = c1388b.subKeyCurCount;
        c1388b.subKeyCurCount = i10 + 1;
        return i10;
    }

    /* renamed from: l */
    public static /* synthetic */ int m7954l(C1388b c1388b) {
        int i10 = c1388b.subKeyCurCount;
        c1388b.subKeyCurCount = i10 + 1;
        return i10;
    }

    /* renamed from: m */
    public static AbstractC9416b m7955m(int i10, InterfaceC2155n interfaceC2155n, Context context, AbstractC0048c abstractC0048c) {
        if (i10 == -1) {
            return null;
        }
        short s10 = (short) (i10 >> 16);
        short s11 = (short) (i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        if (s10 <= 1) {
            return m7956n(s11, interfaceC2155n, context, abstractC0048c);
        }
        C2111d.m12653i("BackupWeatherImp", "nothing build");
        return null;
    }

    /* renamed from: n */
    public static AbstractC9416b m7956n(short s10, InterfaceC2155n interfaceC2155n, Context context, AbstractC0048c abstractC0048c) {
        if (s10 == 1) {
            C9417c c9417c = new C9417c(interfaceC2155n, context, abstractC0048c);
            C2111d.m12653i("BackupWeatherImp", "WeatherImpV1 build");
            return c9417c;
        }
        if (s10 != 2) {
            C2111d.m12646b("BackupWeatherImp", "no weatherImp build");
            return null;
        }
        C9418d c9418d = new C9418d(interfaceC2155n, context, abstractC0048c);
        C2111d.m12653i("BackupWeatherImp", "WeatherImpV2 build");
        return c9418d;
    }

    /* renamed from: q */
    private int m7957q(Context context) {
        AbstractC9416b abstractC9416bM7955m = m7955m(m7959o(context), null, context, null);
        int iMo59055i = abstractC9416bM7955m != null ? abstractC9416bM7955m.mo59055i() : 0;
        if (iMo59055i >= 0) {
            return iMo59055i;
        }
        return -1;
    }

    /* renamed from: r */
    public static int m7958r(AbstractC0048c abstractC0048c) {
        ContentValues contentValues;
        if (abstractC0048c == null) {
            return -1;
        }
        ContentValues[] contentValuesArrM200s = abstractC0048c.m200s("weather_data_info", null, null, null, null);
        return (contentValuesArrM200s == null || contentValuesArrM200s.length <= 0 || (contentValues = contentValuesArrM200s[0]) == null) ? ARImageMetadata.CONTROL_AE_EXPOSURE_COMPENSATION : contentValues.getAsInteger("version").intValue();
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        int iM65395e = C10713c.m65395e(BackupObject.getExecuteParameter(), CloneService.KEY_ACTION_FLAG, 1);
        if ((iM65395e == 3 || iM65395e == 2) && C2157a.m13211s() < 8) {
            return false;
        }
        AbstractC9416b abstractC9416bM7955m = m7955m(m7959o(context), null, context, null);
        return abstractC9416bM7955m == null || abstractC9416bM7955m.mo59055i() >= 0;
    }

    /* renamed from: o */
    public final int m7959o(Context context) {
        return 65536 + (C1119a.m6671a(context) != null ? 2 : 1);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupWeatherImp", "Backup weather.");
        if (abstractC0048c == null) {
            return 2;
        }
        int iM7959o = m7959o(context);
        AbstractC9416b abstractC9416bM7955m = m7955m(iM7959o, new a(callback, obj), context, abstractC0048c);
        if (abstractC9416bM7955m == null || !abstractC9416bM7955m.mo59050d()) {
            C2111d.m12646b("BackupWeatherImp", " Backup Failed at init!");
            return 2;
        }
        int iMo59053g = this.subKeyTotalNum + abstractC9416bM7955m.mo59053g();
        this.subKeyTotalNum = iMo59053g;
        if (iMo59053g == 0) {
            return 2;
        }
        int iMo59049c = abstractC9416bM7955m.mo59049c();
        if (iMo59049c == 0) {
            C2111d.m12646b("BackupWeatherImp", "No record backup success!");
            return 2;
        }
        abstractC9416bM7955m.mo59047a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("version", Integer.valueOf(iM7959o));
        abstractC0048c.m185A("weather_data_info", contentValues);
        StringBuilder sb2 = new StringBuilder();
        String strMo59054h = abstractC9416bM7955m.mo59054h();
        if (strMo59054h != null && !strMo59054h.isEmpty()) {
            sb2.append(strMo59054h);
        }
        this.backupFileModuleInfo.updateModuleInfo(iMo59049c, 8, sb2.toString());
        if (this.backupFileModuleInfo.hasRecord()) {
            return 1;
        }
        abstractC0048c.m190h();
        return 1;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        int iM7957q = m7957q(context);
        C2111d.m12654j("BackupWeatherImp", "onBackupModulesDataItemTotal begin,moduleName: ", str, ",totalNumber: ", Integer.valueOf(iM7957q), ",packageSize: ", l10);
        if (iM7957q < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("ModuleCount", iM7957q);
        bundle.putLong("ModuleSize", l10.longValue());
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupWeatherImp", "Restore Weather.");
        AbstractC9416b abstractC9416bM7955m = m7955m(m7960p(context, m7958r(abstractC0048c)), new a(callback, obj), context, abstractC0048c);
        if (abstractC9416bM7955m == null || !abstractC9416bM7955m.mo59051e(callback, obj)) {
            C2111d.m12653i("BackupWeatherImp", "Restore failed at init!");
            return 5;
        }
        int iMo59056j = this.subKeyTotalNum + abstractC9416bM7955m.mo59056j();
        this.subKeyTotalNum = iMo59056j;
        if (iMo59056j == 0) {
            C2111d.m12653i("BackupWeatherImp", "There is no value in back table!");
            return 5;
        }
        abstractC9416bM7955m.mo59052f();
        abstractC9416bM7955m.mo59048b();
        return 4;
    }

    /* renamed from: p */
    public final int m7960p(Context context, int i10) {
        return (((short) (i10 >> 16)) > 1 || C1119a.m6671a(context) != null) ? i10 : ARImageMetadata.CONTROL_AE_EXPOSURE_COMPENSATION;
    }
}

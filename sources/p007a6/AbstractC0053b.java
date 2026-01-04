package p007a6;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.AbstractC2127c;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import p006a5.AbstractC0048c;
import p007a6.C0052a;
import p229di.C9142g;
import p386j6.C10711a;
import p386j6.C10713c;
import p648t5.C12938a;
import p699v4.C13333b;
import p699v4.C13334c;
import p699v4.C13342k;
import p699v4.C13347p;
import p699v4.C13348q;

/* renamed from: a6.b */
/* loaded from: classes.dex */
public abstract class AbstractC0053b extends AbstractC2127c {

    /* renamed from: a */
    public static final String f151a;

    /* renamed from: a6.b$a */
    public class a implements InterfaceC2155n {

        /* renamed from: a */
        public Handler.Callback f152a;

        /* renamed from: b */
        public Object f153b;

        public a(Handler.Callback callback, Object obj) {
            this.f152a = callback;
            this.f153b = obj;
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: a */
        public void mo305a(Bundle bundle) {
            AbstractC0053b.this.sendMsg(102, bundle, this.f152a, this.f153b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: b */
        public void mo306b(int i10) {
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: c */
        public void mo307c() {
            AbstractC0053b.m291t(AbstractC0053b.this);
            AbstractC0053b abstractC0053b = AbstractC0053b.this;
            ((BackupObject) abstractC0053b).subKeyCurCount = ((BackupObject) abstractC0053b).subKeyCurCount < ((BackupObject) AbstractC0053b.this).subKeyTotalNum ? ((BackupObject) AbstractC0053b.this).subKeyCurCount : ((BackupObject) AbstractC0053b.this).subKeyTotalNum;
            AbstractC0053b abstractC0053b2 = AbstractC0053b.this;
            abstractC0053b2.sendMsg(3, ((BackupObject) abstractC0053b2).subKeyCurCount, ((BackupObject) AbstractC0053b.this).subKeyTotalNum, this.f152a, this.f153b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: d */
        public void mo308d(String str) {
            Bundle bundle = new Bundle();
            bundle.putString(C2126b.ERROR_MESSAGE_INFO, str);
            C2111d.m12653i("UncoupledModuleBase", "onBackupOneFail errorMsg = " + str);
            AbstractC0053b.this.sendMsg(new C2126b.b(100, ((BackupObject) AbstractC0053b.this).subKeyCurCount, ((BackupObject) AbstractC0053b.this).subKeyTotalNum), this.f152a, this.f153b, bundle);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: e */
        public void mo309e() {
            AbstractC0053b.m288q(AbstractC0053b.this);
            AbstractC0053b abstractC0053b = AbstractC0053b.this;
            abstractC0053b.sendMsg(2, ((BackupObject) abstractC0053b).subKeyCurCount, ((BackupObject) AbstractC0053b.this).subKeyTotalNum, this.f152a, this.f153b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: f */
        public void mo310f(String str) {
            Bundle bundle = new Bundle();
            bundle.putString(C2126b.ERROR_MESSAGE_INFO, str);
            AbstractC0053b.this.sendMsg(new C2126b.b(101, ((BackupObject) AbstractC0053b.this).subKeyCurCount, ((BackupObject) AbstractC0053b.this).subKeyTotalNum), this.f152a, this.f153b, bundle);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: g */
        public void mo311g(int i10) {
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: h */
        public void mo312h() {
            AbstractC0053b.m279h(AbstractC0053b.this);
            AbstractC0053b abstractC0053b = AbstractC0053b.this;
            abstractC0053b.sendMsg(5, ((BackupObject) abstractC0053b).subKeyCurCount, ((BackupObject) AbstractC0053b.this).subKeyTotalNum, this.f152a, this.f153b);
        }

        @Override // com.huawei.android.backup.service.logic.InterfaceC2155n
        /* renamed from: i */
        public void mo313i() {
            AbstractC0053b.m274c(AbstractC0053b.this);
            AbstractC0053b abstractC0053b = AbstractC0053b.this;
            abstractC0053b.sendMsg(0, ((BackupObject) abstractC0053b).subKeyCurCount, ((BackupObject) AbstractC0053b.this).subKeyTotalNum, this.f152a, this.f153b);
        }
    }

    /* renamed from: a6.b$b */
    public static class b {

        /* renamed from: a */
        public String f155a;

        /* renamed from: b */
        public String f156b;

        public b(String str, String str2) {
            this.f155a = str;
            this.f156b = str2;
        }

        /* renamed from: a */
        public String m314a() {
            return this.f156b;
        }

        /* renamed from: b */
        public String m315b() {
            return this.f155a;
        }
    }

    /* renamed from: a6.b$c */
    public static class c {

        /* renamed from: y */
        public static final List<String> f157y = Collections.unmodifiableList(Arrays.asList(HNConstants.DataType.CONTACT, NavigationUtils.SMS_SCHEMA_PREF, "chatSms", "Memo", "soundrecorder", "callRecorder", "calllog", "calendar"));

        /* renamed from: b */
        public InterfaceC2155n f159b;

        /* renamed from: c */
        public Context f160c;

        /* renamed from: d */
        public AbstractC0048c f161d;

        /* renamed from: e */
        public ArrayList<String> f162e;

        /* renamed from: f */
        public ArrayList<String> f163f;

        /* renamed from: g */
        public ArrayList<String> f164g;

        /* renamed from: h */
        public ArrayList<String> f165h;

        /* renamed from: i */
        public ArrayList<String> f166i;

        /* renamed from: j */
        public ArrayList<String> f167j;

        /* renamed from: k */
        public Bundle f168k;

        /* renamed from: l */
        public Bundle f169l;

        /* renamed from: m */
        public ArrayList<String> f170m;

        /* renamed from: n */
        public ArrayList<String> f171n;

        /* renamed from: o */
        public boolean f172o;

        /* renamed from: p */
        public int f173p;

        /* renamed from: q */
        public String f174q;

        /* renamed from: r */
        public C0052a f175r;

        /* renamed from: s */
        public String f176s;

        /* renamed from: t */
        public String f177t;

        /* renamed from: u */
        public ArrayList<String> f178u;

        /* renamed from: v */
        public long f179v;

        /* renamed from: w */
        public String f180w;

        /* renamed from: a */
        public HashMap<String, HashMap<String, String>> f158a = new HashMap<>();

        /* renamed from: x */
        public List<String> f181x = new ArrayList();

        public c(InterfaceC2155n interfaceC2155n, Context context, AbstractC0048c abstractC0048c, C0052a c0052a, String str, String str2) {
            this.f160c = context;
            this.f161d = abstractC0048c;
            this.f159b = interfaceC2155n;
            this.f175r = c0052a;
            this.f176s = str;
            this.f177t = str2;
        }

        /* renamed from: A */
        public Bundle m316A() {
            return this.f169l;
        }

        /* renamed from: B */
        public final String m317B() {
            if (this.f177t == null) {
                return null;
            }
            return this.f177t + "_data_tar_file_info";
        }

        /* renamed from: C */
        public ArrayList<String> m318C() {
            return this.f165h;
        }

        /* renamed from: D */
        public Bundle m319D() {
            return this.f168k;
        }

        /* renamed from: E */
        public int m320E() {
            m347c0();
            return mo370o();
        }

        /* renamed from: F */
        public long m321F() {
            m347c0();
            return this.f179v;
        }

        /* renamed from: G */
        public final Map<String, Integer> m322G(Cursor cursor) {
            HashMap map = new HashMap(16);
            String[] columnNames = cursor.getColumnNames();
            for (int i10 = 0; i10 < columnNames.length; i10++) {
                map.put(columnNames[i10], Integer.valueOf(m352f(cursor.getType(i10))));
            }
            return map;
        }

        /* renamed from: H */
        public final Bundle m323H() {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", this.f176s);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, HashMap<String, String>> entry : this.f158a.entrySet()) {
                HashMap<String, String> value = entry.getValue();
                value.put(C2126b.MODULE_INFO_URI, entry.getKey());
                arrayList.add(value);
            }
            bundle.putString(C2126b.MODULE_INFO_LIST, new Gson().toJson(arrayList));
            return bundle;
        }

        /* renamed from: I */
        public int mo324I() {
            return 1000;
        }

        /* renamed from: J */
        public int m325J() {
            int i10 = 0;
            if (!C13348q.m80082b(this.f162e) && !C13348q.m80082b(this.f163f)) {
                m332Q();
                Iterator<String> it = this.f162e.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (this.f163f.contains(next)) {
                        int iMo203v = this.f161d.mo203v(mo343a0(next));
                        i10 += iMo203v;
                        m344b(next, C2126b.MODULE_INFO_PREPARE_COUNT, String.valueOf(iMo203v));
                    }
                }
            }
            return i10;
        }

        /* renamed from: K */
        public boolean m326K() {
            return this.f172o;
        }

        /* renamed from: L */
        public ArrayList<String> m327L() {
            return this.f170m;
        }

        /* renamed from: M */
        public ArrayList<String> m328M() {
            return this.f178u;
        }

        /* renamed from: N */
        public String m329N() {
            return this.f180w;
        }

        /* renamed from: O */
        public final ArrayList<String> m330O(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
            if (C13348q.m80082b(arrayList)) {
                return arrayList2;
            }
            if (C13348q.m80082b(arrayList2)) {
                return null;
            }
            ArrayList<String> arrayList3 = new ArrayList<>(16);
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (arrayList.contains(arrayList2.get(i10))) {
                    arrayList3.add(arrayList2.get(i10));
                }
            }
            return arrayList3;
        }

        /* renamed from: P */
        public ArrayList<String> m331P() {
            return this.f164g;
        }

        /* renamed from: Q */
        public void m332Q() {
            Iterator<String> it = this.f162e.iterator();
            while (true) {
                String str = "1";
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                boolean zContains = this.f163f.contains(next);
                HashMap<String, String> map = new HashMap<>();
                map.put(C2126b.MODULE_INFO_IS_NEED_BACKUP_URI, "1");
                if (!zContains) {
                    str = "0";
                }
                map.put(C2126b.MODULE_INFO_IS_NEED_COUNT_URI, str);
                this.f158a.put(next, map);
            }
            Iterator<String> it2 = this.f163f.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (!this.f162e.contains(next2)) {
                    HashMap<String, String> map2 = new HashMap<>();
                    map2.put(C2126b.MODULE_INFO_IS_NEED_BACKUP_URI, "1");
                    map2.put(C2126b.MODULE_INFO_IS_NEED_COUNT_URI, "1");
                    this.f158a.put(next2, map2);
                }
            }
        }

        /* renamed from: R */
        public void m333R() {
            InterfaceC2155n interfaceC2155n = this.f159b;
            if (interfaceC2155n != null) {
                interfaceC2155n.mo309e();
            }
        }

        /* renamed from: S */
        public void m334S(String str) {
            InterfaceC2155n interfaceC2155n = this.f159b;
            if (interfaceC2155n != null) {
                interfaceC2155n.mo308d(str);
            }
        }

        /* renamed from: T */
        public void m335T() {
            if (this.f159b == null || !f157y.contains(this.f176s) || this.f158a.isEmpty()) {
                return;
            }
            this.f159b.mo305a(m323H());
        }

        /* renamed from: U */
        public void m336U() {
            InterfaceC2155n interfaceC2155n = this.f159b;
            if (interfaceC2155n != null) {
                interfaceC2155n.mo313i();
            }
        }

        /* renamed from: V */
        public final void m337V() {
            InterfaceC2155n interfaceC2155n = this.f159b;
            if (interfaceC2155n != null) {
                interfaceC2155n.mo312h();
            }
        }

        /* renamed from: W */
        public final void m338W(String str) {
            InterfaceC2155n interfaceC2155n = this.f159b;
            if (interfaceC2155n != null) {
                interfaceC2155n.mo310f(str);
            }
        }

        /* renamed from: X */
        public void m339X() {
            if (!f157y.contains(this.f176s) || this.f158a.isEmpty()) {
                return;
            }
            C2111d.m12653i("UncoupledModuleBase", "Restore Finish: " + m323H());
        }

        /* renamed from: Y */
        public final void m340Y() {
            InterfaceC2155n interfaceC2155n = this.f159b;
            if (interfaceC2155n != null) {
                interfaceC2155n.mo307c();
            }
        }

        /* renamed from: Z */
        public final int m341Z(String str, List<ContentValues> list, String str2, AtomicInteger atomicInteger) {
            int i10 = 0;
            if (C13348q.m80082b(list)) {
                return 0;
            }
            boolean zContains = this.f163f.contains(str);
            this.f161d.mo169a();
            for (ContentValues contentValues : list) {
                if (BackupObject.isAbort()) {
                    break;
                }
                try {
                    if (AbstractC0053b.m271F(str, contentValues)) {
                        C2111d.m12653i("UncoupledModuleBase", "oneBatchBackup sms permission will not clone.");
                    } else {
                        int iM185A = this.f161d.m185A(str2, contentValues);
                        if (iM185A != 1) {
                            m357h0(str, zContains, "write sql fail error code = " + iM185A);
                        } else if (zContains) {
                            atomicInteger.set(atomicInteger.get() + 1);
                            m336U();
                            i10++;
                        }
                    }
                } catch (SQLException unused) {
                    C2111d.m12648d("UncoupledModuleBase", "oneBatchBackup write to db fail.");
                    m357h0(str, zContains, "SQLException");
                } catch (Exception unused2) {
                    C2111d.m12648d("UncoupledModuleBase", "oneBatchBackup fail, unknown exception.");
                    m357h0(str, zContains, "Exception");
                }
            }
            this.f161d.mo171c();
            return i10;
        }

        /* renamed from: a */
        public void m342a() {
            this.f163f.add(C12938a.f58980b);
            this.f163f.add("content://com.hihonor.provider.NotePad.backup/super_tasks");
            this.f163f.add("content://com.hihonor.provider.NotePad.backup/super_notes");
        }

        /* renamed from: a0 */
        public String mo343a0(String str) {
            if (str == null || this.f177t == null) {
                return null;
            }
            String strM80078a = C13347p.m80078a(str);
            if (strM80078a != null) {
                if (strM80078a.contains("_backup") && !strM80078a.contains("booklist")) {
                    strM80078a = strM80078a.substring(0, strM80078a.indexOf("_backup"));
                }
                strM80078a = strM80078a + "_tb";
            }
            if (strM80078a == null) {
                return null;
            }
            return this.f177t + strM80078a;
        }

        /* renamed from: b */
        public void m344b(String str, String str2, String str3) {
            HashMap<String, String> map = this.f158a.get(str);
            if (map != null) {
                map.put(str2, str3);
            }
        }

        /* renamed from: b0 */
        public boolean mo345b0() {
            return false;
        }

        /* renamed from: c */
        public int mo346c(String str) {
            int iM341Z = 0;
            if (this.f161d == null || str == null || this.f163f == null) {
                return 0;
            }
            String strMo343a0 = mo343a0(str);
            if (TextUtils.isEmpty(strMo343a0)) {
                C2111d.m12653i("UncoupledModuleBase", "backupOneTable backTable is empty.");
                return 0;
            }
            Cursor cursorM12618d = null;
            try {
                try {
                    cursorM12618d = C2108a.m12618d(this.f160c, C13347p.m80079b(str), null, null, null, null);
                } catch (SQLException unused) {
                } catch (Exception e10) {
                    e = e10;
                }
                if (cursorM12618d != null && cursorM12618d.moveToFirst()) {
                    Map<String, Integer> mapM322G = m322G(cursorM12618d);
                    ArrayList arrayList = new ArrayList();
                    AtomicInteger atomicInteger = new AtomicInteger(0);
                    int i10 = 0;
                    do {
                        try {
                            if (BackupObject.isAbort()) {
                                break;
                            }
                            ContentValues contentValuesM13213u = C2157a.m13213u(cursorM12618d, mapM322G);
                            if (iM341Z < mo324I()) {
                                arrayList.add(contentValuesM13213u);
                                iM341Z++;
                            } else {
                                int iM341Z2 = m341Z(str, arrayList, strMo343a0, atomicInteger) + i10;
                                arrayList.clear();
                                arrayList.add(contentValuesM13213u);
                                i10 = iM341Z2;
                                iM341Z = 1;
                            }
                        } catch (SQLException unused2) {
                            iM341Z = i10;
                            C2111d.m12648d("UncoupledModuleBase", "backupOneTable write to db fail.");
                            m344b(str, C2126b.MODULE_INFO_ERROR_INFO, "backupOneTable write to db fail.");
                            if (cursorM12618d != null) {
                                cursorM12618d.close();
                            }
                            return iM341Z;
                        } catch (Exception e11) {
                            e = e11;
                            iM341Z = i10;
                            String str2 = "backupOneTable fail, unknown exception. error: " + e.getMessage();
                            C2111d.m12648d("UncoupledModuleBase", str2);
                            m344b(str, C2126b.MODULE_INFO_ERROR_INFO, str2);
                            if (cursorM12618d != null) {
                                cursorM12618d.close();
                            }
                            return iM341Z;
                        }
                    } while (cursorM12618d.moveToNext());
                    iM341Z = i10 + m341Z(str, arrayList, strMo343a0, atomicInteger);
                    m344b(str, "count", String.valueOf(atomicInteger.get()));
                    cursorM12618d.close();
                    return iM341Z;
                }
                return 0;
            } finally {
                if (0 != 0) {
                    cursorM12618d.close();
                }
            }
        }

        /* renamed from: c0 */
        public final void m347c0() {
            C0052a.a aVarMo221b;
            C0052a c0052a = this.f175r;
            if (c0052a == null || (aVarMo221b = c0052a.mo221b(this.f160c, CloudBackupConstant.Command.PMS_CMD_BACKUP)) == null) {
                return;
            }
            this.f162e = aVarMo221b.m248v();
            this.f163f = aVarMo221b.m249w();
            this.f164g = aVarMo221b.m246t();
            this.f165h = aVarMo221b.m240n();
            this.f166i = aVarMo221b.m244r();
            this.f167j = aVarMo221b.m242p();
            this.f173p = aVarMo221b.m241o();
            this.f174q = aVarMo221b.m243q();
            this.f178u = aVarMo221b.m247u();
            this.f179v = aVarMo221b.m245s();
        }

        /* renamed from: d */
        public final boolean m348d(String str) {
            return (this.f160c == null || this.f161d == null) || (str == null || this.f163f == null);
        }

        /* renamed from: d0 */
        public final void m349d0() throws Throwable {
            Bundle bundle;
            if (this.f175r == null) {
                return;
            }
            if ("galleryData".equals(this.f176s)) {
                bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("is_sd_gallery_checked", C10713c.m65392b(BackupObject.getExecuteParameter(), "isCheckSdGallery", false));
                bundle.putBundle("extra_data", bundle2);
            } else {
                bundle = null;
            }
            C0052a.a aVarMo222c = this.f175r.mo222c(this.f160c, CloudBackupConstant.Command.PMS_CMD_BACKUP, bundle);
            if (aVarMo222c != null) {
                this.f162e = aVarMo222c.m248v();
                this.f163f = aVarMo222c.m249w();
                this.f164g = aVarMo222c.m246t();
                this.f165h = aVarMo222c.m240n();
                this.f166i = aVarMo222c.m244r();
                this.f167j = aVarMo222c.m242p();
                this.f173p = aVarMo222c.m241o();
                this.f174q = aVarMo222c.m243q();
                this.f178u = aVarMo222c.m247u();
            }
        }

        /* renamed from: e */
        public final boolean m350e() {
            return (this.f161d == null || this.f175r == null) || (C13348q.m80082b(this.f162e) || C13348q.m80082b(this.f163f));
        }

        /* renamed from: e0 */
        public void m351e0() {
            AbstractC0048c abstractC0048c = this.f161d;
            if (abstractC0048c == null) {
                return;
            }
            ContentValues[] contentValuesArrM200s = abstractC0048c.m200s(m377u(), null, null, null, null);
            if (contentValuesArrM200s == null) {
                this.f162e = null;
                this.f163f = null;
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>(16);
            ArrayList<String> arrayList2 = new ArrayList<>(16);
            for (ContentValues contentValues : contentValuesArrM200s) {
                if (contentValues != null) {
                    String strM57465d = C9142g.m57465d(contentValues.getAsString("value"));
                    arrayList.add(strM57465d);
                    if (contentValues.getAsBoolean("need_count").booleanValue()) {
                        arrayList2.add(strM57465d);
                    }
                }
            }
            this.f162e = arrayList;
            this.f163f = arrayList2;
            mo345b0();
        }

        /* renamed from: f */
        public final int m352f(int i10) {
            return i10 == 4 ? 4 : 1;
        }

        /* renamed from: f0 */
        public void m353f0() {
            AbstractC0048c abstractC0048c = this.f161d;
            if (abstractC0048c == null) {
                return;
            }
            ContentValues[] contentValuesArrM200s = abstractC0048c.m200s(m376t(), null, null, null, null);
            if (contentValuesArrM200s == null) {
                C2111d.m12648d("UncoupledModuleBase", "readBackupDataFileList: restoreValues is null.");
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for (ContentValues contentValues : contentValuesArrM200s) {
                if (contentValues != null) {
                    arrayList.add(C9142g.m57465d(contentValues.getAsString("value")));
                }
            }
            this.f164g = arrayList;
        }

        /* renamed from: g */
        public boolean m354g() {
            m369n0();
            m371o0();
            m367m0();
            m365l0(this.f165h, m317B());
            m365l0(this.f166i, m373q());
            m365l0(this.f167j, m374r());
            C0052a c0052a = this.f175r;
            if (c0052a == null) {
                return true;
            }
            c0052a.m220a(this.f160c);
            return true;
        }

        /* renamed from: g0 */
        public ContentValues m355g0(AbstractC0048c abstractC0048c) throws C10711a {
            ContentValues contentValues;
            if (abstractC0048c == null) {
                throw new C10711a("storeHandler is null");
            }
            ContentValues[] contentValuesArrM200s = abstractC0048c.m200s(m378v(), null, null, null, null);
            if (contentValuesArrM200s == null || (contentValues = contentValuesArrM200s[0]) == null) {
                throw new C10711a("version info is not exist");
            }
            return contentValues;
        }

        /* renamed from: h */
        public boolean m356h() {
            C0052a c0052a = this.f175r;
            if (c0052a == null) {
                return true;
            }
            c0052a.m224e(this.f160c);
            return true;
        }

        /* renamed from: h0 */
        public void m357h0(String str, boolean z10, String str2) {
            C2111d.m12648d("UncoupledModuleBase", "write events values failed: " + str2);
            if (z10) {
                m333R();
            }
            if (this.f181x.contains(str)) {
                return;
            }
            this.f181x.add(str);
            m334S(C2111d.m12652h("UncoupledModuleBase", this.f177t, "backupOneTable", str2 + ";uri = " + C13347p.m80078a(str)));
        }

        /* renamed from: i */
        public int m358i() {
            int iMo346c = 0;
            if (C13348q.m80082b(this.f162e)) {
                return 0;
            }
            this.f181x.clear();
            Iterator<String> it = this.f162e.iterator();
            while (it.hasNext()) {
                iMo346c += mo346c(it.next());
            }
            m335T();
            return iMo346c;
        }

        /* renamed from: i0 */
        public final int m359i0(String str) {
            if (m348d(str)) {
                return 0;
            }
            int iMo203v = this.f161d.mo203v(mo343a0(str));
            C2111d.m12654j("UncoupledModuleBase", "restoreOneTable ", Integer.valueOf(iMo203v));
            if (iMo203v == 0) {
                return 0;
            }
            int iMo324I = (iMo203v / mo324I()) + (iMo203v % mo324I() == 0 ? 0 : 1);
            boolean zContains = this.f163f.contains(str);
            int i10 = 0;
            boolean zM363k0 = false;
            for (int i11 = 0; i11 < iMo324I; i11++) {
                ContentValues[] contentValuesArrM380x = m380x(i11, mo343a0(str));
                if (contentValuesArrM380x == null || mo343a0(str) == null) {
                    C2111d.m12653i("UncoupledModuleBase", "restoreOneTable no value of this uri to restore.");
                    return 0;
                }
                ContentProviderClient contentProviderClientM12617c = C2108a.m12617c(this.f160c, C13347p.m80079b(str));
                try {
                    for (ContentValues contentValues : contentValuesArrM380x) {
                        if (!BackupObject.isAbort()) {
                            if (AbstractC0053b.m271F(str, contentValues)) {
                                C2111d.m12653i("UncoupledModuleBase", "restoreOneTable continue sms ");
                            } else if (!C13333b.m79953a(contentProviderClientM12617c, C13347p.m80079b(str), contentValues)) {
                                zM363k0 = m363k0(str, zM363k0, zContains, "insert failed, uri = " + C13347p.m80078a(str));
                            } else if (zContains) {
                                m340Y();
                                i10++;
                            }
                        }
                    }
                } finally {
                    if (contentProviderClientM12617c != null) {
                        contentProviderClientM12617c.close();
                    }
                }
            }
            return i10;
        }

        /* renamed from: j */
        public boolean m360j() throws Throwable {
            m349d0();
            return true;
        }

        /* renamed from: j0 */
        public final int m361j0(String str, int i10) {
            if (m348d(str)) {
                return 0;
            }
            boolean zContains = this.f163f.contains(str);
            String strMo343a0 = mo343a0(str);
            int iMo203v = this.f161d.mo203v(mo343a0(str));
            if (iMo203v == 0) {
                return 0;
            }
            int iMo324I = (iMo203v / mo324I()) + (iMo203v % mo324I() == 0 ? 0 : 1);
            int iM364l = 0;
            for (int i11 = 0; i11 < iMo324I; i11++) {
                ContentValues[] contentValuesArrM200s = this.f161d.m200s(strMo343a0, null, null, null, "limit" + (mo324I() * i11) + "," + mo324I());
                if (contentValuesArrM200s == null || strMo343a0 == null) {
                    C2111d.m12649e("UncoupledModuleBase", "The table [", strMo343a0, "] has no data in old phone backuped database.");
                    return 0;
                }
                iM364l += m364l(str, contentValuesArrM200s, this.f160c, zContains, i10);
            }
            return iM364l;
        }

        /* renamed from: k */
        public boolean mo362k() throws Throwable {
            AbstractC0048c abstractC0048c;
            if (this.f160c == null || (abstractC0048c = this.f161d) == null || this.f175r == null) {
                return false;
            }
            try {
                C0052a.c cVarM225f = this.f175r.m225f(this.f160c, this.f161d, m355g0(abstractC0048c), m382z(), m375s());
                if (cVarM225f == null) {
                    return true;
                }
                this.f172o = cVarM225f.m263g();
                this.f171n = cVarM225f.m261e();
                this.f170m = cVarM225f.m260d();
                m351e0();
                m353f0();
                if (BackupConstant.m13135i().contains(this.f176s)) {
                    this.f162e = m379w(cVarM225f.m262f(), this.f162e);
                    this.f164g = m379w(cVarM225f.m259c(), this.f164g);
                } else {
                    if ("chatSms".equals(this.f176s) && !C9142g.m57463b()) {
                        this.f164g = m379w(cVarM225f.m259c(), this.f164g);
                    }
                    this.f162e = m330O(cVarM225f.m262f(), this.f162e);
                }
                this.f168k = cVarM225f.m258b();
                this.f169l = cVarM225f.m257a();
                return true;
            } catch (C10711a unused) {
                C2111d.m12648d("UncoupledModuleBase", "doBeforeRestore BackupException");
                return true;
            } catch (Exception unused2) {
                C2111d.m12648d("UncoupledModuleBase", "doBeforeRestore doBeforeRestore error");
                this.f172o = false;
                return false;
            }
        }

        /* renamed from: k0 */
        public final boolean m363k0(String str, boolean z10, boolean z11, String str2) {
            C2111d.m12648d("UncoupledModuleBase", "restoreOneTable  Failed: " + str2);
            String strM12652h = C2111d.m12652h("UncoupledModuleBase", this.f177t, "restoreOneTable", str2 + ";uri = " + str);
            if (!z10) {
                m338W(strM12652h);
                z10 = true;
            }
            if (z11) {
                m337V();
            }
            m344b(str, C2126b.MODULE_INFO_ERROR_INFO, strM12652h);
            return z10;
        }

        /* renamed from: l */
        public final int m364l(String str, ContentValues[] contentValuesArr, Context context, boolean z10, int i10) {
            int iBulkInsert;
            int i11 = 0;
            if (str == null) {
                return 0;
            }
            List listAsList = Arrays.asList(contentValuesArr);
            int size = listAsList.size() / i10;
            try {
                if (listAsList.size() < i10) {
                    iBulkInsert = context.getContentResolver().bulkInsert(C13347p.m80079b(str), (ContentValues[]) listAsList.toArray(new ContentValues[listAsList.size()]));
                } else {
                    int iBulkInsert2 = 0;
                    int i12 = 0;
                    while (i12 < size) {
                        int i13 = i12 * i10;
                        i12++;
                        try {
                            List listSubList = listAsList.subList(i13, i12 * i10);
                            iBulkInsert2 += context.getContentResolver().bulkInsert(C13347p.m80079b(str), (ContentValues[]) listSubList.toArray(new ContentValues[listSubList.size()]));
                        } catch (SQLException unused) {
                            i11 = iBulkInsert2;
                            m366m(str, z10, "SqlException!");
                            return i11;
                        } catch (Exception unused2) {
                            i11 = iBulkInsert2;
                            m366m(str, z10, "doBulkInsert Exception!");
                            return i11;
                        }
                    }
                    if (listAsList.size() % i10 > 0) {
                        List listSubList2 = listAsList.subList(size * i10, listAsList.size());
                        iBulkInsert = context.getContentResolver().bulkInsert(C13347p.m80079b(str), (ContentValues[]) listSubList2.toArray(new ContentValues[listSubList2.size()])) + iBulkInsert2;
                    } else {
                        iBulkInsert = iBulkInsert2;
                    }
                }
                if (!z10) {
                    return iBulkInsert;
                }
                for (int i14 = 0; i14 < iBulkInsert; i14++) {
                    try {
                        m340Y();
                    } catch (SQLException unused3) {
                        i11 = iBulkInsert;
                        m366m(str, z10, "SqlException!");
                        return i11;
                    } catch (Exception unused4) {
                        i11 = iBulkInsert;
                        m366m(str, z10, "doBulkInsert Exception!");
                        return i11;
                    }
                }
                int size2 = listAsList.size() - iBulkInsert;
                boolean z11 = false;
                while (i11 < size2) {
                    if (!z11) {
                        m338W(C2111d.m12652h("UncoupledModuleBase", this.f177t, "doBulkInsert", "bulkInsert fail uri = " + C13347p.m80078a(str)));
                        z11 = true;
                    }
                    m337V();
                    i11++;
                }
                return iBulkInsert;
            } catch (SQLException unused5) {
            } catch (Exception unused6) {
            }
        }

        /* renamed from: l0 */
        public final void m365l0(ArrayList<String> arrayList, String str) {
            if (this.f161d == null || TextUtils.isEmpty(str) || C13348q.m80082b(arrayList)) {
                C2111d.m12648d("UncoupledModuleBase", "mStoreHandler tableName or backupList is empty.");
                return;
            }
            ContentValues contentValues = new ContentValues();
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                contentValues.put("_id", Integer.valueOf(i10));
                contentValues.put("value", arrayList.get(i10));
                this.f161d.m185A(str, contentValues);
                contentValues.clear();
            }
        }

        /* renamed from: m */
        public final void m366m(String str, boolean z10, String str2) {
            if (z10) {
                m337V();
            }
            m338W(C2111d.m12652h("UncoupledModuleBase", this.f177t, "doBulkInsert", str2) + ";uri = " + C13347p.m80078a(str));
        }

        /* renamed from: m0 */
        public final void m367m0() {
            if (this.f161d == null || C13348q.m80082b(this.f164g)) {
                C2111d.m12648d("UncoupledModuleBase", "mStoreHandler tableName or mUriOpenFileList is empty.");
                return;
            }
            Iterator<String> it = this.f164g.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                String next = it.next();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Integer.valueOf(i10));
                contentValues.put("value", C9142g.m57462a(next));
                this.f161d.m185A(m376t(), contentValues);
                i10++;
            }
        }

        /* renamed from: n */
        public int m368n() {
            int i10 = 0;
            if (!C13348q.m80082b(this.f162e) && this.f172o) {
                HashMap map = new HashMap(16);
                if (C13348q.m80084d(this.f171n)) {
                    Iterator<String> it = this.f171n.iterator();
                    while (it.hasNext()) {
                        String[] strArrSplit = it.next().split(",");
                        try {
                            if (strArrSplit.length >= 2) {
                                map.put(strArrSplit[0], Integer.valueOf(C13342k.m80055d(strArrSplit[1])));
                            }
                        } catch (NumberFormatException unused) {
                            C2111d.m12648d("UncoupledModuleBase", "doRestore NumberFormatException");
                        }
                    }
                } else {
                    C2111d.m12653i("UncoupledModuleBase", "mSupportBulkInsertList is empty");
                }
                Iterator<String> it2 = this.f162e.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (BackupObject.isAbort()) {
                        break;
                    }
                    if (next != null) {
                        C2111d.m12654j("UncoupledModuleBase", "restore uri = ", C13347p.m80078a(next));
                        int iM359i0 = (!map.containsKey(next) || ((Integer) map.get(next)).intValue() < 0) ? m359i0(next) : m361j0(next, ((Integer) map.get(next)).intValue());
                        m344b(next, "count", String.valueOf(iM359i0));
                        i10 += iM359i0;
                    }
                }
                m339X();
            }
            return i10;
        }

        /* renamed from: n0 */
        public final void m369n0() {
            if (m350e()) {
                return;
            }
            Iterator<String> it = this.f162e.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                String next = it.next();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Integer.valueOf(i10));
                contentValues.put("need_count", Boolean.valueOf(this.f163f.contains(next)));
                contentValues.put("value", C9142g.m57462a(next));
                this.f161d.m185A(m377u(), contentValues);
                i10++;
            }
        }

        /* renamed from: o */
        public int mo370o() {
            int i10 = 0;
            if (!C13348q.m80082b(this.f162e) && !C13348q.m80082b(this.f163f)) {
                m332Q();
                Iterator<String> it = this.f162e.iterator();
                Cursor cursorM12618d = null;
                while (it.hasNext()) {
                    String next = it.next();
                    if (this.f163f.contains(next)) {
                        try {
                            try {
                                try {
                                    cursorM12618d = C2108a.m12618d(this.f160c, C13347p.m80079b(next), null, null, null, null);
                                    if (cursorM12618d != null) {
                                        int count = cursorM12618d.getCount();
                                        i10 += count;
                                        m344b(next, C2126b.MODULE_INFO_PREPARE_COUNT, String.valueOf(count));
                                    }
                                } catch (IllegalArgumentException e10) {
                                    String str = "Get backup numbers IllegalArgumentException. error: " + e10.getMessage();
                                    C2111d.m12648d("UncoupledModuleBase", str);
                                    m344b(next, C2126b.MODULE_INFO_ERROR_INFO, str);
                                    if (cursorM12618d != null) {
                                    }
                                }
                            } catch (Exception e11) {
                                String str2 = "Get backup numbers failed. error: " + e11.getMessage();
                                C2111d.m12648d("UncoupledModuleBase", str2);
                                m344b(next, C2126b.MODULE_INFO_ERROR_INFO, str2);
                                if (cursorM12618d != null) {
                                }
                            }
                            if (cursorM12618d != null) {
                                cursorM12618d.close();
                            }
                        } catch (Throwable th2) {
                            if (cursorM12618d != null) {
                                cursorM12618d.close();
                            }
                            throw th2;
                        }
                    }
                }
            }
            return i10;
        }

        /* renamed from: o0 */
        public final void m371o0() {
            if (this.f161d == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("version", Integer.valueOf(this.f173p));
            contentValues.put("extra_data", this.f174q);
            this.f161d.m185A(m378v(), contentValues);
        }

        /* renamed from: p */
        public String m372p() {
            return this.f177t;
        }

        /* renamed from: q */
        public final String m373q() {
            if (this.f177t == null) {
                return null;
            }
            return this.f177t + "_copy_file_list_info";
        }

        /* renamed from: r */
        public final String m374r() {
            if (this.f177t == null) {
                return null;
            }
            return this.f177t + "_default_file_list_info";
        }

        /* renamed from: s */
        public final HashMap<String, String> m375s() {
            HashMap<String, String> map = new HashMap<>();
            if (!TextUtils.isEmpty(m317B())) {
                map.put("data_tar_file_path_list", m317B());
            }
            if (!TextUtils.isEmpty(m373q())) {
                map.put("copyfile_path_list", m373q());
            }
            return map;
        }

        /* renamed from: t */
        public final String m376t() {
            if (this.f177t == null) {
                return null;
            }
            return this.f177t + "_open_file_info";
        }

        /* renamed from: u */
        public final String m377u() {
            if (this.f177t == null) {
                return null;
            }
            return this.f177t + "_uri_info";
        }

        /* renamed from: v */
        public final String m378v() {
            if (this.f177t == null) {
                return null;
            }
            return this.f177t + "_version_info";
        }

        /* renamed from: w */
        public final ArrayList<String> m379w(ArrayList<String> arrayList, List<String> list) {
            if (C13348q.m80082b(arrayList)) {
                C2111d.m12648d("UncoupledModuleBase", "newPhoneSupportList is empty.");
                return null;
            }
            if (C13348q.m80082b(list)) {
                C2111d.m12648d("UncoupledModuleBase", "oldPhoneList is empty.");
                return null;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (String str : list) {
                if (arrayList.contains(str)) {
                    arrayList2.add(str);
                }
            }
            return arrayList2;
        }

        /* renamed from: x */
        public final ContentValues[] m380x(int i10, String str) {
            return this.f161d.m200s(str, null, null, null, "limit" + (mo324I() * i10) + "," + mo324I());
        }

        /* renamed from: y */
        public ArrayList<String> m381y() {
            return this.f166i;
        }

        /* renamed from: z */
        public final long m382z() {
            AbstractC0048c abstractC0048c;
            if (this.f160c == null || (abstractC0048c = this.f161d) == null) {
                return 0L;
            }
            String strM193k = abstractC0048c.m193k();
            if (TextUtils.isEmpty(strM193k)) {
                return 0L;
            }
            return C2157a.m13209q(this.f160c, strM193k + "/SDCardClone");
        }
    }

    static {
        f151a = C9142g.m57463b() ? "content://com.hihonor.permissionmanager.provider.PermissionDataProvider" : "content://com.huawei.permissionmanager.provider.PermissionDataProvider";
    }

    /* renamed from: F */
    public static boolean m271F(String str, ContentValues contentValues) {
        return str.contains(f151a) && (NextRestoreConstants.PKG_NAME_SMS.equalsIgnoreCase(contentValues.getAsString("packageName")) || "com.hihonor.mms".equalsIgnoreCase(contentValues.getAsString("packageName")));
    }

    /* renamed from: c */
    public static /* synthetic */ int m274c(AbstractC0053b abstractC0053b) {
        int i10 = abstractC0053b.subKeyCurCount;
        abstractC0053b.subKeyCurCount = i10 + 1;
        return i10;
    }

    /* renamed from: h */
    public static /* synthetic */ int m279h(AbstractC0053b abstractC0053b) {
        int i10 = abstractC0053b.subKeyCurCount;
        abstractC0053b.subKeyCurCount = i10 + 1;
        return i10;
    }

    /* renamed from: q */
    public static /* synthetic */ int m288q(AbstractC0053b abstractC0053b) {
        int i10 = abstractC0053b.subKeyCurCount;
        abstractC0053b.subKeyCurCount = i10 + 1;
        return i10;
    }

    /* renamed from: t */
    public static /* synthetic */ int m291t(AbstractC0053b abstractC0053b) {
        int i10 = abstractC0053b.subKeyCurCount;
        abstractC0053b.subKeyCurCount = i10 + 1;
        return i10;
    }

    /* renamed from: A */
    public int m294A(List<? extends c> list) {
        int iM358i = 0;
        if (list == null) {
            return 0;
        }
        for (c cVar : list) {
            if (cVar != null) {
                iM358i += cVar.m358i();
            }
        }
        return iM358i;
    }

    /* renamed from: B */
    public final int m295B(String str) {
        File[] fileArrListFiles;
        if (str == null) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return 0;
        }
        int iM295B = 0;
        for (File file2 : fileArrListFiles) {
            if (file2.isFile() && file2.length() > 0) {
                iM295B++;
            } else if (file2.isDirectory()) {
                iM295B += m295B(C13334c.m79991x(file2));
            } else {
                C2111d.m12657m("UncoupledModuleBase", "other file");
            }
        }
        return iM295B;
    }

    /* renamed from: C */
    public abstract ArrayList<String> mo296C(Context context, String str, String str2);

    /* renamed from: D */
    public String m297D(Uri uri) {
        String authority;
        if (uri == null || (authority = uri.getAuthority()) == null) {
            return null;
        }
        return C9142g.m57462a(authority).replace(".", "");
    }

    /* renamed from: E */
    public int m298E(List<? extends c> list) {
        int iMo370o = 0;
        if (list == null) {
            return 0;
        }
        for (c cVar : list) {
            if (cVar != null) {
                iMo370o += cVar.mo370o();
            } else {
                C2111d.m12657m("UncoupledModuleBase", "getSubModuleTotalNum imp is null");
            }
        }
        C2111d.m12657m("UncoupledModuleBase", "getSubModuleTotalNum retTotalNum = " + iMo370o);
        return iMo370o;
    }

    /* renamed from: G */
    public boolean mo299G(Context context, String str, String str2) {
        ArrayList<String> arrayListM65401k;
        if (str == null) {
            C2111d.m12648d("UncoupledModuleBase", "moduleName is null");
            return false;
        }
        if (BackupConstant.m13133g().containsKey(str)) {
            Bundle bundleM300H = m300H(context, BackupConstant.m13133g().get(str), str, str2);
            if (bundleM300H == null) {
                C2111d.m12649e("UncoupledModuleBase", str, str2, "query result is null");
                return false;
            }
            if (!C13348q.m80082b(C10713c.m65401k(bundleM300H, "openfile_uri_list"))) {
                return true;
            }
            try {
                arrayListM65401k = C10713c.m65401k(bundleM300H, "data_tar_file_path_list");
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                C2111d.m12648d("UncoupledModuleBase", "wrong type.");
                arrayListM65401k = null;
            }
            if (!C13348q.m80082b(arrayListM65401k)) {
                return true;
            }
            if (C13348q.m80084d(C10713c.m65401k(bundleM300H, "copyfile_path_list"))) {
                long jM13217y = C2157a.m13217y(context, str, reassembleExtra(null));
                if (jM13217y > 0) {
                    return true;
                }
                if (("soundrecorder".equals(str) || "callRecorder".equals(str)) && jM13217y == 0 && !isCloudBackup()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: H */
    public Bundle m300H(Context context, String str, String str2, String str3) {
        if (C2108a.m12621g(context, str2)) {
            C2111d.m12653i("UncoupledModuleBase", "NeedDelForm");
            return new Bundle();
        }
        boolean zM13194b = C2157a.m13194b(context, str);
        C2111d.m12653i("UncoupledModuleBase", "query provider " + str2 + " result is : " + zM13194b);
        if (zM13194b) {
            return C2108a.m12616b(context, str, "backup_query", str3, reassembleExtra(null));
        }
        return null;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        return !mo301w(context, null, null, str, "restore").isEmpty();
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        String strM372p;
        if (abstractC0048c == null) {
            return 2;
        }
        List<c> listMo301w = mo301w(context, abstractC0048c, new a(callback, obj), str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        if (listMo301w.isEmpty()) {
            C2111d.m12648d("UncoupledModuleBase", "impList is empty!");
            return 2;
        }
        if (!m302x(listMo301w)) {
            return 2;
        }
        int iM298E = m298E(listMo301w);
        this.subKeyTotalNum = iM298E;
        if (iM298E == 0) {
            return 2;
        }
        int iM294A = m294A(listMo301w);
        if (iM294A == 0) {
            C2111d.m12648d("UncoupledModuleBase", "No record backup success!");
            return 2;
        }
        for (c cVar : listMo301w) {
            if (cVar != null) {
                cVar.m354g();
            }
        }
        StringBuilder sb2 = new StringBuilder(16);
        for (c cVar2 : listMo301w) {
            if (cVar2 != null && (strM372p = cVar2.m372p()) != null) {
                sb2.append(strM372p);
                sb2.append(";");
            }
        }
        this.backupFileModuleInfo.updateModuleInfo(iM294A, 8, sb2.toString());
        if (this.backupFileModuleInfo.hasRecord()) {
            return 1;
        }
        abstractC0048c.m190h();
        return 1;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        if (C2108a.m12621g(context, str)) {
            C2111d.m12653i("UncoupledModuleBase", "NeedDelForm");
            return new Bundle();
        }
        if ("galleryData".equals(str)) {
            notifyModuleStart(context, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        }
        if (str.equals("phoneManager")) {
            boolean zMo299G = mo299G(context, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
            Bundle bundle = new Bundle();
            bundle.putInt("ModuleCount", 1);
            bundle.putLong("ModuleSize", l10.longValue());
            bundle.putBoolean("isSupportClone", zMo299G);
            return bundle;
        }
        int iMo303y = mo303y(context, str);
        if (str.equals("galleryData")) {
            iMo303y = m304z(context, str);
        }
        int i11 = iMo303y;
        boolean zMo299G2 = mo299G(context, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        C2111d.m12654j("UncoupledModuleBase", "moduleName = ", str, ", totalItemNum = ", Integer.valueOf(i11), ", isSupportClone = ", Boolean.valueOf(zMo299G2));
        if (i11 < 0) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("ModuleCount", i11);
        if ("huaweiBrowser".equals(str)) {
            bundle2.putLong("ModuleSize", i11 * RippleView.SINGLE_RIPPLE_TIME);
        } else {
            bundle2.putLong("ModuleSize", l10.longValue());
        }
        bundle2.putBoolean("isSupportClone", zMo299G2);
        return bundle2;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        List<c> listMo301w = mo301w(context, abstractC0048c, new a(callback, obj), str, "restore");
        if (listMo301w.isEmpty()) {
            return 5;
        }
        ArrayList<c> arrayList = new ArrayList(16);
        for (c cVar : listMo301w) {
            if (cVar != null && cVar.mo362k()) {
                arrayList.add(cVar);
            }
        }
        for (c cVar2 : arrayList) {
            if (cVar2 != null) {
                this.subKeyTotalNum += cVar2.m325J();
            }
        }
        if (this.subKeyTotalNum == 0) {
            C2111d.m12648d("UncoupledModuleBase", "There is no value in back table!");
            return 5;
        }
        for (c cVar3 : arrayList) {
            if (cVar3 != null) {
                cVar3.m368n();
            }
        }
        for (c cVar4 : arrayList) {
            if (cVar4 != null) {
                cVar4.m356h();
            }
        }
        return 4;
    }

    /* renamed from: w */
    public List<c> mo301w(Context context, AbstractC0048c abstractC0048c, InterfaceC2155n interfaceC2155n, String str, String str2) {
        if (context == null) {
            C2111d.m12648d("UncoupledModuleBase", "buildImp context is null");
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(16);
        ArrayList<String> arrayListMo296C = mo296C(context, str, str2);
        if (arrayListMo296C == null) {
            C2111d.m12658n("UncoupledModuleBase", "uri list = null! module name = ", str);
            return arrayList;
        }
        Iterator<String> it = arrayListMo296C.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                Uri uriM80079b = C13347p.m80079b(next);
                arrayList.add(new c(interfaceC2155n, context, abstractC0048c, new C0052a(uriM80079b, reassembleExtra(null)), str, m297D(uriM80079b)));
            }
        }
        return arrayList;
    }

    /* renamed from: x */
    public boolean m302x(List<? extends c> list) {
        if (list == null) {
            return true;
        }
        for (c cVar : list) {
            if (cVar != null && !cVar.m360j()) {
                C2111d.m12648d("UncoupledModuleBase", "[onBackup] Backup Failed at init!");
                return false;
            }
        }
        return true;
    }

    /* renamed from: y */
    public int mo303y(Context context, String str) {
        List<c> listMo301w = mo301w(context, null, null, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        if (listMo301w.isEmpty()) {
            return -1;
        }
        Iterator<c> it = listMo301w.iterator();
        int iM320E = 0;
        while (it.hasNext()) {
            iM320E += it.next().m320E();
        }
        return iM320E;
    }

    /* renamed from: z */
    public int m304z(Context context, String str) {
        ArrayList<String> arrayListM65401k = null;
        Bundle bundleM300H = m300H(context, BackupConstant.m13133g().containsKey(str) ? BackupConstant.m13133g().get(str) : null, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        if (bundleM300H == null) {
            return -1;
        }
        try {
            arrayListM65401k = C10713c.m65401k(bundleM300H, "copyfile_path_list");
        } catch (BadParcelableException unused) {
            C2111d.m12648d("UncoupledModuleBase", "wrong data.");
        } catch (ArrayIndexOutOfBoundsException unused2) {
            C2111d.m12648d("UncoupledModuleBase", "ArrayIndexOutOfBoundsException");
        }
        if (C13348q.m80082b(arrayListM65401k)) {
            return -1;
        }
        Iterator<String> it = arrayListM65401k.iterator();
        int iM295B = 0;
        while (it.hasNext()) {
            iM295B += m295B(it.next());
        }
        return iM295B;
    }
}

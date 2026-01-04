package p633s5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.backup.backupremoteservice.C2105a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import p006a5.C0047b;
import p328h6.C10104d;
import p328h6.C10112l;
import p386j6.C10712b;
import p544p4.C12086a;
import p566q4.C12284c;
import p601r4.C12462b;
import p632s4.C12697a;
import p632s4.C12698b;
import p632s4.C12702f;
import p632s4.C12703g;
import p699v4.C13332a;
import p699v4.C13334c;
import p699v4.C13341j;
import p699v4.C13345n;
import p699v4.C13348q;

/* renamed from: s5.c */
/* loaded from: classes.dex */
public abstract class AbstractC12706c extends BackupObject {

    /* renamed from: c */
    public static Comparator<String> f58256c = new a();

    /* renamed from: a */
    public long f58257a = 0;

    /* renamed from: b */
    public String f58258b = null;

    /* renamed from: s5.c$a */
    public class a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str == null || str2 == null) {
                return 0;
            }
            if (str.endsWith(".hwtmp") && !str2.endsWith(".hwtmp")) {
                return 1;
            }
            if (!str.endsWith(".hwtmp") && str2.endsWith(".hwtmp")) {
                return -1;
            }
            C2111d.m12646b("BackupMediaBaseObject", "not need comparator");
            return str.compareToIgnoreCase(str2) < 0 ? -1 : 1;
        }
    }

    /* renamed from: s5.c$b */
    public static class b {

        /* renamed from: a */
        public final C12718o f58259a;

        /* renamed from: b */
        public final String f58260b;

        /* renamed from: c */
        public final String f58261c;

        /* renamed from: d */
        public final ArrayList<String> f58262d;

        /* renamed from: e */
        public final Set<String> f58263e;

        /* renamed from: f */
        public final ArrayList<String> f58264f;

        public /* synthetic */ b(C12718o c12718o, String str, String str2, ArrayList arrayList, Set set, ArrayList arrayList2, a aVar) {
            this(c12718o, str, str2, arrayList, set, arrayList2);
        }

        /* renamed from: a */
        public String m76511a() {
            return this.f58261c;
        }

        /* renamed from: b */
        public Set<String> m76512b() {
            return this.f58263e;
        }

        /* renamed from: c */
        public C12718o m76513c() {
            return this.f58259a;
        }

        /* renamed from: d */
        public String m76514d() {
            return this.f58260b;
        }

        /* renamed from: e */
        public ArrayList<String> m76515e() {
            return this.f58264f;
        }

        /* renamed from: f */
        public ArrayList<String> m76516f() {
            return this.f58262d;
        }

        public b(C12718o c12718o, String str, String str2, ArrayList<String> arrayList, Set<String> set, ArrayList<String> arrayList2) {
            this.f58259a = c12718o;
            this.f58260b = str;
            this.f58261c = str2;
            this.f58262d = arrayList;
            this.f58263e = set;
            this.f58264f = arrayList2;
        }
    }

    /* renamed from: A */
    public final int m76455A(String str, Context context, int i10) {
        m76490g(context, i10);
        if (BackupConstant.m13142p().containsKey(Integer.valueOf(i10)) && BackupObject.isMediaModule(str)) {
            return BackupConstant.m13142p().get(Integer.valueOf(i10)).intValue();
        }
        return 0;
    }

    /* renamed from: B */
    public final String m76456B(C12718o c12718o, String str) {
        return C2157a.m13208p(c12718o.m76530f() == 507 ? c12718o.m76534j() : C2157a.m13208p(C12462b.m74717a(str).getParent(), "packaged"), c12718o.m76531g());
    }

    /* renamed from: C */
    public final int m76457C() {
        return 0;
    }

    /* renamed from: D */
    public final Set<String> m76458D(String str, String str2) {
        if (!m76468N(str)) {
            return null;
        }
        Set<String> setM76409c = C12698b.m76409c(C12462b.m74717a(str2 + "#TwinApp"));
        C2111d.m12653i("BackupMediaBaseObject", "twin wechat record file num is " + setM76409c.size());
        return setM76409c;
    }

    /* renamed from: E */
    public final String m76459E(String str, Context context, String str2, String str3) {
        if (str2.endsWith("#TwinApp.tar")) {
            return C12086a.m72257d(context);
        }
        if (str2.endsWith("#Sdcard.tar") && BackupObject.isRecordModule(str3)) {
            return C13345n.m80072k(context, C13345n.m80074m(context, 3) ? 3 : 2);
        }
        return str;
    }

    /* renamed from: F */
    public final boolean m76460F(int i10) {
        if (i10 == 0) {
            return true;
        }
        C2111d.m12653i("BackupMediaBaseObject", "businessType is not clone");
        return false;
    }

    /* renamed from: G */
    public final boolean m76461G(String str, String str2) {
        if (!BackupConstant.m13148v().contains(str2) || C13334c.m79974g(str)) {
            return true;
        }
        C2111d.m12653i("BackupMediaBaseObject", "create srcFilePathTemp faild, restore done.");
        return false;
    }

    /* renamed from: H */
    public final boolean m76462H(int i10, int i11, String str) {
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        C2111d.m12653i("BackupMediaBaseObject", "root path is null");
        BackupConstant.m13142p().put(Integer.valueOf(i10), Integer.valueOf(i11));
        return false;
    }

    /* renamed from: I */
    public final boolean m76463I(int i10, int i11, Set<String> set) {
        if (set.size() != 0) {
            return true;
        }
        C2111d.m12654j("BackupMediaBaseObject", "fileList is empty save restore success count:", Integer.valueOf(i11));
        BackupConstant.m13142p().put(Integer.valueOf(i10), Integer.valueOf(i11));
        return false;
    }

    /* renamed from: J */
    public final boolean m76464J(int i10, File file) {
        return (i10 == 508 || i10 == 517) && file.exists() && !file.isDirectory();
    }

    /* renamed from: K */
    public final boolean m76465K(String str, ArrayList<String> arrayList) {
        return "desktopMyFile".equals(str) && !C13348q.m80082b(arrayList);
    }

    /* renamed from: L */
    public final boolean m76466L(Context context, String str) {
        return C13345n.m80074m(context, 3) || (!"desktopMyFile".equals(str) && BackupConstant.m13148v().contains(str));
    }

    /* renamed from: M */
    public final boolean m76467M(C12702f c12702f) {
        return (c12702f.m76438e().endsWith(".hwtmp") || c12702f.m76438e().endsWith("MediaInfo.db")) || (c12702f.m76438e().endsWith("MediaInfo.db-shm") || c12702f.m76438e().endsWith("MediaInfo.db-wal"));
    }

    /* renamed from: N */
    public final boolean m76468N(String str) {
        return BackupObject.isTwinApp(str) || ("wechat_record".equals(str) && BackupObject.isTwinApp("com.tencent.mm"));
    }

    /* renamed from: O */
    public final boolean m76469O(List<C12702f> list, int i10, Handler.Callback callback, Object obj) {
        for (C12702f c12702f : list) {
            if (c12702f.m76441h() && c12702f.m76440g() == 5 && !C12703g.m76448a(C12462b.m74717a(c12702f.m76434a()))) {
                C2111d.m12648d("BackupMediaBaseObject", "MediaFileUtil.buildPath error");
                sendMsg(5, 1, i10, callback, obj);
                return false;
            }
        }
        return true;
    }

    /* renamed from: P */
    public final void m76470P(C12718o c12718o, String str, String str2) throws InterruptedException {
        String strM76531g = c12718o.m76531g();
        Context contextM76528d = c12718o.m76528d();
        if (contextM76528d == null) {
            C2111d.m12653i("BackupMediaBaseObject", "processRestoreTarFile context is null");
            return;
        }
        ArrayList arrayList = new ArrayList(C12698b.m76409c(C12462b.m74717a(m76456B(c12718o, str))));
        Collections.sort(arrayList, f58256c);
        C2111d.m12654j("BackupMediaBaseObject", "processRestoreTarFile, tar num is ", Integer.valueOf(arrayList.size()));
        for (String str3 : arrayList) {
            if (str3.endsWith(".tar") && str3.contains(strM76531g)) {
                C10112l c10112l = new C10112l(str3, m76459E(str2, contextM76528d, str3, strM76531g), c12718o.m76530f(), c12718o.m76529e(), str, strM76531g, c12718o.m76532h());
                c10112l.m62999i(contextM76528d);
                if (isSupportIosSmallFileTar()) {
                    c10112l.m63000j(true);
                }
                C10104d.m62930i().m62932b(c10112l, c12718o.m76526b());
            }
        }
        m76484b0(arrayList, strM76531g);
        C10104d.m62928c(strM76531g);
    }

    /* renamed from: Q */
    public final int m76471Q(File file, C12702f c12702f, Set<String> set, C12718o c12718o) throws IOException {
        String strM79991x = c12702f.m76434a() + File.separator + c12702f.m76437d();
        C13341j.m80047n(c12718o.m76528d(), strM79991x, c12718o.m76531g(), C13334c.m79991x(file));
        int iM76440g = c12702f.m76440g();
        File fileM74717a = C12462b.m74717a(strM79991x);
        if (iM76440g == 4) {
            m76479Y(strM79991x, strM79991x, c12718o.m76531g());
        } else if (iM76440g == 1) {
            fileM74717a = m76499p(0, file, c12702f.m76437d());
            m76479Y(strM79991x, C13334c.m79991x(fileM74717a), c12718o.m76531g());
            C0047b.m178f(c12718o.m76531g(), c12702f.m76439f(), c12702f.m76438e(), C13334c.m79991x(fileM74717a));
            strM79991x = C13334c.m79991x(fileM74717a);
        } else {
            C2111d.m12657m("BackupMediaBaseObject", "other state = " + iM76440g);
        }
        boolean zRenameTo = file.renameTo(fileM74717a);
        m76481a(set, c12718o.m76531g(), strM79991x);
        return zRenameTo ? 1 : -1;
    }

    /* renamed from: R */
    public final int m76472R(C12718o c12718o, List<C12702f> list, int i10, String str) throws Throwable {
        if (list == null || list.isEmpty()) {
            return i10;
        }
        String strM76531g = c12718o.m76531g();
        int iM76457C = m76457C();
        Handler.Callback callbackM76526b = c12718o.m76526b();
        Object objM76527c = c12718o.m76527c();
        Context contextM76528d = c12718o.m76528d();
        if (!m76469O(list, iM76457C, callbackM76526b, objM76527c)) {
            return i10;
        }
        HashSet hashSet = new HashSet(list.size());
        int iM76495l = i10;
        for (C12702f c12702f : list) {
            if (BackupObject.isAbort()) {
                break;
            }
            File fileM74717a = C12462b.m74717a(c12702f.m76438e());
            if (c12702f.m76437d() != null && !fileM74717a.isDirectory()) {
                this.f58258b = c12702f.m76438e().substring(str.length());
                this.f58257a = fileM74717a.length();
                if (m76497n(c12718o, fileM74717a, c12702f)) {
                    int i11 = iM76495l + 1;
                    sendMsg(3, i11, iM76457C, callbackM76526b, objM76527c);
                    iM76495l = i11;
                } else {
                    int iM76440g = c12702f.m76440g();
                    if (iM76440g != 0) {
                        if (iM76440g != 1) {
                            if (iM76440g != 2 && iM76440g != 3) {
                                if (iM76440g != 4) {
                                }
                            }
                        }
                        iM76495l = m76495l(c12702f, c12718o, hashSet, iM76495l, iM76457C);
                    }
                    int i12 = iM76495l + 1;
                    m76478X(strM76531g, c12702f, iM76440g);
                    sendMsg(3, i12, iM76457C, callbackM76526b, objM76527c);
                    m76493j(fileM74717a);
                    iM76495l = i12;
                }
            }
        }
        m76480Z(hashSet, contextM76528d, strM76531g);
        return iM76495l;
    }

    /* renamed from: S */
    public final void m76473S(String str, String str2, String str3) {
        String str4 = str + File.separator + "emptyDirectoryRecord.txt";
        for (String str5 : C13334c.m79964H(str4)) {
            if (!TextUtils.isEmpty(str3) && str2 != null) {
                str5 = str3 + str5.substring(str2.length());
            }
            File file = new File(str5);
            if (!file.exists() && !file.mkdirs()) {
                C2111d.m12648d("BackupMediaBaseObject", "create empty directory faild.");
            }
        }
        C13334c.m79980m(str4);
    }

    /* renamed from: T */
    public int m76474T(C12718o c12718o) throws Throwable {
        if (m76488e(c12718o)) {
            m76491h(c12718o.m76528d(), c12718o.m76533i(), c12718o.m76531g());
            return m76475U(c12718o, null, null);
        }
        C2111d.m12648d("BackupMediaBaseObject", "restoreMediaBackupFile module is null");
        return 4;
    }

    /* renamed from: U */
    public int m76475U(C12718o c12718o, ArrayList<String> arrayList, ArrayList<String> arrayList2) throws Throwable {
        if (!m76488e(c12718o)) {
            return 4;
        }
        String strM76533i = c12718o.m76533i();
        String strM76531g = c12718o.m76531g();
        if (!m76461G(strM76533i, strM76531g)) {
            return 4;
        }
        String strM76487d = m76487d(strM76531g, strM76533i);
        if (TextUtils.isEmpty(strM76487d)) {
            return 4;
        }
        Context contextM76528d = c12718o.m76528d();
        int iM76530f = c12718o.m76530f();
        int iM76455A = m76455A(strM76531g, contextM76528d, iM76530f);
        String strM76506w = m76506w(contextM76528d, c12718o.m76529e(), strM76487d);
        if (!m76462H(iM76530f, iM76455A, strM76506w) || !m76460F(c12718o.m76525a())) {
            return 4;
        }
        m76476V(arrayList, strM76487d, strM76531g, strM76506w);
        Set<String> setM76409c = C12698b.m76409c(C12462b.m74717a(strM76487d));
        Set<String> setM76508y = m76508y(strM76487d, strM76531g, contextM76528d, setM76409c);
        m76477W(c12718o, arrayList, strM76487d, strM76531g, strM76506w);
        if (!m76463I(iM76530f, iM76455A, setM76409c)) {
            return 4;
        }
        List<C12702f> listM76503t = m76503t(c12718o, setM76508y, strM76487d, setM76409c, arrayList);
        List<C12702f> listM76504u = m76504u(c12718o, strM76487d, m76458D(strM76531g, strM76487d), arrayList);
        List<C12702f> listM76502s = m76502s(new b(c12718o, strM76487d, strM76506w, arrayList, setM76409c, arrayList2, null));
        m76483b(listM76502s, listM76503t, listM76504u);
        BackupConstant.m13142p().put(Integer.valueOf(iM76530f), Integer.valueOf(m76472R(c12718o, listM76502s, iM76455A, strM76487d)));
        m76486c0(strM76487d, contextM76528d, strM76531g);
        return 4;
    }

    /* renamed from: V */
    public final void m76476V(ArrayList<String> arrayList, String str, String str2, String str3) {
        if (BackupConstant.m13148v().contains(str2)) {
            if (C13348q.m80082b(arrayList)) {
                m76473S(str, null, null);
            } else {
                m76473S(str, str3, arrayList.get(0));
            }
        }
    }

    /* renamed from: W */
    public final void m76477W(C12718o c12718o, ArrayList<String> arrayList, String str, String str2, String str3) throws InterruptedException {
        if (m76465K(str2, arrayList)) {
            m76470P(c12718o, str, arrayList.get(0));
        } else {
            m76470P(c12718o, str, str3);
        }
    }

    /* renamed from: X */
    public final void m76478X(String str, C12702f c12702f, int i10) {
        if (i10 == 0) {
            m76479Y(c12702f.m76435b(), c12702f.m76435b(), str);
        }
    }

    /* renamed from: Y */
    public final void m76479Y(String str, String str2, String str3) {
        if (C2105a.m12586b(str3)) {
            if (str.contains(C10712b.m65389b(null))) {
                C0047b.m173a(str2, str2, 1);
            } else {
                C0047b.m173a(str, str2, 0);
            }
        }
    }

    /* renamed from: Z */
    public final void m76480Z(Set<String> set, Context context, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (set.isEmpty()) {
            C2111d.m12657m("BackupMediaBaseObject", "restoreCloneMedia mediascanset is empty");
            return;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            C13341j.m80043j(context, it.next(), true, str);
        }
    }

    /* renamed from: a */
    public final void m76481a(Set<String> set, String str, String str2) {
        if (set == null || !BackupObject.isMediaModule(str)) {
            return;
        }
        set.add(str2);
    }

    /* renamed from: a0 */
    public final void m76482a0(Context context) {
        context.getSharedPreferences("config_info", 4).edit().putBoolean("need_clear_media_count", false).commit();
    }

    /* renamed from: b */
    public final void m76483b(List<C12702f> list, List<C12702f> list2, List<C12702f> list3) {
        if (list2 != null) {
            list.addAll(list2);
        }
        if (list3 != null) {
            list.addAll(list3);
        }
    }

    /* renamed from: b0 */
    public final void m76484b0(List<String> list, String str) throws InterruptedException {
        if (list.isEmpty()) {
            return;
        }
        C2111d.m12653i("BackupMediaBaseObject", "waitTarFileRestore begin");
        try {
            Thread.sleep(1000L);
            while (!C10104d.m62930i().m62935g(str)) {
                Thread.sleep(1000L);
            }
        } catch (InterruptedException unused) {
            C2111d.m12648d("BackupMediaBaseObject", "wait restore tar error ");
        }
        C2111d.m12653i("BackupMediaBaseObject", "waitTarFileRestore end");
    }

    /* renamed from: c */
    public int m76485c(C12707d c12707d) {
        return 1;
    }

    /* renamed from: c0 */
    public final void m76486c0(String str, Context context, String str2) throws Throwable {
        if (BackupObject.isNewGallery()) {
            C0047b.m181i(context, 2, str2);
        } else if (str.endsWith("_sd")) {
            C0047b.m181i(context, 1, str2);
        } else {
            C0047b.m181i(context, 0, str2);
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public String createCloneSecurityInfo(String str) {
        return "";
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int createSecurityV3Info(Context context, String str) {
        return 10000;
    }

    /* renamed from: d */
    public final String m76487d(String str, String str2) {
        C0047b.m174b(str);
        File fileM74717a = C12462b.m74717a(str2);
        if (fileM74717a.exists()) {
            return m76500q(fileM74717a);
        }
        C2111d.m12648d("BackupMediaBaseObject", "srcFile not exist file");
        return "";
    }

    /* renamed from: e */
    public final boolean m76488e(C12718o c12718o) {
        if (c12718o == null) {
            C2111d.m12648d("BackupMediaBaseObject", "restoreMediaModule is null can not restore!");
            return false;
        }
        if (c12718o.m76528d() == null) {
            C2111d.m12648d("BackupMediaBaseObject", "context is null can not restore!");
            return false;
        }
        if (!TextUtils.isEmpty(c12718o.m76533i())) {
            return true;
        }
        C2111d.m12648d("BackupMediaBaseObject", "srcFile is null can not restore!");
        return false;
    }

    /* renamed from: f */
    public final boolean m76489f(C12702f c12702f, Set<String> set) {
        return (set == null || c12702f == null || c12702f.m76436c() == null || c12702f.m76434a() == null || c12702f.m76438e() == null) ? false : true;
    }

    /* renamed from: g */
    public final void m76490g(Context context, int i10) {
        if (m76505v(context)) {
            C2111d.m12653i("BackupMediaBaseObject", "clearMediaCount success, mediaType :" + i10);
            BackupConstant.m13142p().put(503, 0);
            BackupConstant.m13142p().put(512, 0);
            BackupConstant.m13142p().put(504, 0);
            BackupConstant.m13142p().put(513, 0);
            BackupConstant.m13142p().put(Integer.valueOf(BasicBaseResp.TERM_NO_SIGN), 0);
            BackupConstant.m13142p().put(514, 0);
            BackupConstant.m13142p().put(Integer.valueOf(CBSbkFlowHead.FLOW_CONTROL_ERR_CODE), 0);
            BackupConstant.m13142p().put(515, 0);
            BackupConstant.m13142p().put(508, 0);
            BackupConstant.m13142p().put(517, 0);
            m76482a0(context);
        }
    }

    /* renamed from: h */
    public final void m76491h(Context context, String str, String str2) throws Throwable {
        if (context == null) {
            C2111d.m12648d("BackupMediaBaseObject", "copyMediaDb: context is null");
            return;
        }
        if (!C2105a.m12585a(str2)) {
            C2111d.m12653i("BackupMediaBaseObject", "No need to copy media db.");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getApplicationContext().getFilesDir());
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append("mediainfo_new");
        sb2.append(str3);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(C12284c.m73809b(str2));
        String string = sb2.toString();
        if (C13334c.m79959C(string)) {
            C2111d.m12653i("BackupMediaBaseObject", "destDbPath is exist, no need to copy media db again.");
            return;
        }
        String str4 = str + str3 + C12284c.m73809b(str2);
        if (C13334c.m79959C(str4)) {
            C13332a.m79948b(new File(str4), new File(string));
        } else {
            C2111d.m12654j("BackupMediaBaseObject", str2, " db isn't exist.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.io.FileInputStream] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m76492i(java.io.File r12, p632s4.C12702f r13, java.util.Set<java.lang.String> r14, p633s5.C12718o r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p633s5.AbstractC12706c.m76492i(java.io.File, s4.f, java.util.Set, s5.o):int");
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        return true;
    }

    /* renamed from: j */
    public final void m76493j(File file) {
        if (file.delete()) {
            return;
        }
        C2111d.m12653i("BackupMediaBaseObject", "delete media file failed");
    }

    /* renamed from: k */
    public final int m76494k(int i10, File file, C12702f c12702f, Set<String> set, C12718o c12718o) {
        if (i10 == 1) {
            return m76471Q(file, c12702f, set, c12718o);
        }
        if (file.delete()) {
            return i10;
        }
        C2111d.m12649e("BackupMediaBaseObject", "copyToFile", "copyToFile delete destFile error");
        return i10;
    }

    /* renamed from: l */
    public final int m76495l(C12702f c12702f, C12718o c12718o, Set<String> set, int i10, int i11) throws Throwable {
        Handler.Callback callbackM76526b = c12718o.m76526b();
        Object objM76527c = c12718o.m76527c();
        if (!m76489f(c12702f, set)) {
            C2111d.m12648d("BackupMediaBaseObject", "executeRestoreCloneMedia null pointer fatal error");
            int i12 = i10 + 1;
            sendMsg(5, i12, i11, callbackM76526b, objM76527c);
            return i12;
        }
        String strM76436c = c12702f.m76436c();
        String strM76438e = c12702f.m76438e();
        String strM76434a = c12702f.m76434a();
        Normalizer.Form form = Normalizer.Form.NFC;
        String strNormalize = Normalizer.normalize(strM76438e, form);
        String strNormalize2 = Normalizer.normalize(strM76436c, form);
        String strNormalize3 = Normalizer.normalize(strM76434a, form);
        File fileM74717a = C12462b.m74717a(strNormalize);
        if (m76496m(c12702f, c12718o, strNormalize, set, new C12717n(i10, i11, strNormalize2))) {
            return i10 + 1;
        }
        if (C12703g.m76448a(C12462b.m74717a(strNormalize3))) {
            int iM76492i = m76492i(fileM74717a, c12702f, set, c12718o);
            if (iM76492i == 1) {
                int i13 = i10 + 1;
                sendMsg(3, i13, i11, callbackM76526b, objM76527c);
                if (fileM74717a.delete()) {
                    return i13;
                }
                C2111d.m12648d("BackupMediaBaseObject", "executeRestoreCloneMedia delete src file error");
                return i13;
            }
            if (iM76492i == -1) {
                int i14 = i10 + 1;
                sendMsg(5, i14, i11, callbackM76526b, objM76527c);
                return i14;
            }
            C2111d.m12657m("BackupMediaBaseObject", "executeRestoreCloneMedia other result = " + iM76492i);
        }
        return i10;
    }

    /* renamed from: m */
    public final boolean m76496m(C12702f c12702f, C12718o c12718o, String str, Set<String> set, C12717n c12717n) {
        File fileM74717a = C12462b.m74717a(str);
        int iM76530f = c12718o.m76530f();
        int iM76440g = c12702f.m76440g();
        String strM76531g = c12718o.m76531g();
        if (!str.startsWith(c12717n.m76522a()) || !fileM74717a.exists()) {
            return false;
        }
        String str2 = c12702f.m76434a() + File.separator + c12702f.m76437d();
        File fileM74717a2 = C12462b.m74717a(str2);
        if (m76464J(iM76530f, fileM74717a2) && !fileM74717a2.delete()) {
            C2111d.m12648d("BackupMediaBaseObject", "restore System app File,delete source file path failed");
        }
        if (iM76440g != 4 && iM76530f != 508 && iM76530f != 517) {
            return false;
        }
        C13341j.m80047n(c12718o.m76528d(), str2, strM76531g, str);
        boolean zRenameTo = fileM74717a.renameTo(fileM74717a2);
        m76479Y(str2, str2, strM76531g);
        if (!zRenameTo) {
            return false;
        }
        C2111d.m12646b("BackupMediaBaseObject", "restoreCloneMedia success: state:" + iM76440g);
        sendMsg(3, c12717n.m76523b() + 1, c12717n.m76524c(), c12718o.m76526b(), c12718o.m76527c());
        m76481a(set, c12718o.m76531g(), fileM74717a2.getPath());
        return true;
    }

    /* renamed from: n */
    public final boolean m76497n(C12718o c12718o, File file, C12702f c12702f) {
        if (!"doc".equals(c12718o.m76531g())) {
            return false;
        }
        if (!C12703g.m76452e(c12718o.m76528d(), c12702f.m76434a())) {
            return false;
        }
        C2111d.m12646b("BackupMediaBaseObject", "restore filter file");
        if (file.delete()) {
            return true;
        }
        C2111d.m12648d("BackupMediaBaseObject", "restore filter file delete fail");
        return true;
    }

    /* renamed from: o */
    public final void m76498o(List<C12702f> list) {
        Iterator<C12702f> it = list.iterator();
        while (it.hasNext()) {
            if (m76467M(it.next())) {
                C2111d.m12653i("BackupMediaBaseObject", "remove unfinished file");
                it.remove();
            }
        }
    }

    /* renamed from: p */
    public final File m76499p(int i10, File file, String str) {
        File fileM74718b = C12462b.m74718b(file.getParent(), i10 > 0 ? String.format(Locale.ROOT, "Copy(%s) %s", String.valueOf(i10), str) : String.format(Locale.ROOT, "Copy %s", str));
        return fileM74718b.exists() ? m76499p(i10 + 1, file, str) : fileM74718b;
    }

    /* renamed from: q */
    public final String m76500q(File file) {
        try {
            return file.getCanonicalPath();
        } catch (IOException unused) {
            C2111d.m12648d("BackupMediaBaseObject", "getCanonicalPath error");
            return "";
        }
    }

    /* renamed from: r */
    public final File m76501r(String str) {
        File fileM74717a = C12462b.m74717a(str);
        if (!fileM74717a.exists()) {
            return fileM74717a;
        }
        if (!fileM74717a.delete()) {
            C2111d.m12648d("BackupMediaBaseObject", "copyToFile delete destFile error");
        }
        return C12462b.m74717a(str);
    }

    /* renamed from: s */
    public final List<C12702f> m76502s(b bVar) {
        List<C12702f> listM76410d = C12698b.m76410d(bVar.m76513c().m76528d(), bVar.m76512b(), bVar.m76513c().m76535k(), new C12697a(bVar.m76513c(), bVar.m76514d(), bVar.m76511a(), bVar.m76516f(), bVar.m76515e()));
        m76498o(listM76410d);
        return listM76410d;
    }

    @Override // com.huawei.android.backup.service.logic.C2126b
    public void sendMsg(int i10, int i11, int i12, Handler.Callback callback, Object obj) {
        Bundle bundle;
        if (callback != null) {
            if (i10 == 3) {
                bundle = new Bundle();
                bundle.putLong("SUCCESS_FILE_SIZE", this.f58257a);
                bundle.putString("key_media_file_path", this.f58258b);
            } else {
                bundle = null;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.arg1 = i11;
            messageObtain.arg2 = i12;
            messageObtain.obj = obj;
            messageObtain.setData(bundle);
            callback.handleMessage(messageObtain);
        }
    }

    /* renamed from: t */
    public final List<C12702f> m76503t(C12718o c12718o, Set<String> set, String str, Set<String> set2, ArrayList<String> arrayList) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        set2.removeAll(set);
        List<C12702f> listM76410d = C12698b.m76410d(c12718o.m76528d(), set, c12718o.m76535k(), new C12697a(c12718o, C10712b.m65389b(str), m76509z(c12718o.m76528d(), c12718o.m76531g()), arrayList, null));
        m76498o(listM76410d);
        return listM76410d;
    }

    /* renamed from: u */
    public final List<C12702f> m76504u(C12718o c12718o, String str, Set<String> set, ArrayList<String> arrayList) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        List<C12702f> listM76410d = C12698b.m76410d(c12718o.m76528d(), set, c12718o.m76535k(), new C12697a(c12718o, str + "#TwinApp", C12086a.m72257d(c12718o.m76528d()), arrayList, null));
        m76498o(listM76410d);
        return listM76410d;
    }

    /* renamed from: v */
    public final boolean m76505v(Context context) {
        return context.getSharedPreferences("config_info", 4).getBoolean("need_clear_media_count", true);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean validateCloneSecurityInfo(String str, String str2) {
        return true;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean validateSecurityV3Info(Context context, String str) {
        return true;
    }

    /* renamed from: w */
    public final String m76506w(Context context, int i10, String str) {
        String strM80072k = C13345n.m80072k(context, i10);
        return (str.endsWith("_sd") && i10 == 2) ? C10712b.m65388a(context, strM80072k) : strM80072k;
    }

    /* renamed from: x */
    public final Set<String> m76507x(Context context, String str, Set<String> set, String str2) {
        HashSet hashSet = null;
        if (set == null) {
            return null;
        }
        String strM65389b = C10712b.m65389b(str);
        if (!C12462b.m74717a(strM65389b).exists()) {
            return null;
        }
        C2111d.m12653i("BackupMediaBaseObject", "getSDSetList sdCardFile exists");
        if (m76466L(context, str2)) {
            hashSet = new HashSet(set.size());
            for (String str3 : set) {
                if (str3.startsWith(strM65389b)) {
                    hashSet.add(str3);
                }
            }
        } else {
            C2111d.m12653i("BackupMediaBaseObject", "getSDSetList sdCard not exists");
        }
        return hashSet;
    }

    /* renamed from: y */
    public final Set<String> m76508y(String str, String str2, Context context, Set<String> set) {
        if (C10712b.m65390c(str2)) {
            return m76507x(context, str, set, str2);
        }
        return null;
    }

    /* renamed from: z */
    public final String m76509z(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (C13345n.m80074m(context, 3)) {
            return C13345n.m80072k(context, 3);
        }
        if ("desktopMyFile".equals(str) || !BackupConstant.m13148v().contains(str)) {
            return null;
        }
        return C13345n.m80072k(context, 2);
    }
}

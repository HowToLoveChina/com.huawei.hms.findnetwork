package p669u5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p006a5.AbstractC0048c;
import p386j6.C10713c;
import p386j6.C10716f;
import p601r4.C12462b;
import p632s4.C12698b;
import p632s4.C12700d;
import p632s4.C12701e;
import p633s5.AbstractC12706c;
import p633s5.C12718o;
import p699v4.C13334c;
import p699v4.C13345n;
import p699v4.C13348q;

/* renamed from: u5.c */
/* loaded from: classes.dex */
public class C13125c extends AbstractC12706c {

    /* renamed from: d */
    public static Comparator<String> f59628d = new a();

    /* renamed from: u5.c$a */
    public class a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str == null || str2 == null) {
                return 0;
            }
            return Long.compare(C12462b.m74717a(str2).length(), C12462b.m74717a(str).length());
        }
    }

    /* renamed from: d0 */
    public static void m78949d0(ArrayList<String> arrayList) {
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.set(i10, arrayList.get(i10).replaceFirst("/mnt/media_rw/", "/storage/"));
        }
    }

    /* renamed from: e0 */
    public static int m78950e0(Context context, AbstractC0048c abstractC0048c, ArrayList<String> arrayList, String str) {
        if (abstractC0048c == null || context == null || arrayList == null) {
            C12701e.m76424d(context, str);
            C2111d.m12648d("CommonModuleCopyFile", "storeHandler or context is null can not backup");
            return 1;
        }
        m78949d0(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        String[] strArrM80071j = C13345n.m80071j(context);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                if (strArrM80071j != null) {
                    boolean z10 = strArrM80071j.length > 1 && strArrM80071j[1] != null;
                    if (next.startsWith("externalstorage") && z10) {
                        next = strArrM80071j[1] + next.substring(15);
                    }
                    boolean z11 = strArrM80071j.length > 0 && strArrM80071j[0] != null;
                    if (next.startsWith("external") && z11) {
                        next = strArrM80071j[0] + next.substring(8);
                    }
                }
                List arrayList4 = new ArrayList();
                if (PmsCheckUtil.m12610d()) {
                    String strM65406a = C10716f.m65406a(context, next);
                    C2111d.m12653i("CommonModuleCopyFile", "isSupportNewRYFeature temppath: " + strM65406a);
                    if (strM65406a != null && strM65406a.startsWith("/Android/data")) {
                        C2111d.m12653i("CommonModuleCopyFile", "isSupportNewRYFeature add root path" + next);
                        arrayList4.add(next);
                    }
                }
                if (arrayList4.isEmpty()) {
                    arrayList4 = C2157a.m13201i(C12462b.m74717a(next));
                }
                m78951f0(str, next, arrayList4);
                if (BackupConstant.m13148v().contains(str)) {
                    arrayList3.addAll(C2157a.m13196d(C12462b.m74717a(next)));
                }
                arrayList2.addAll(arrayList4);
            }
        }
        if (arrayList2.isEmpty()) {
            C12701e.m76424d(context, str);
            return 1;
        }
        m78952i0(context, str, arrayList2, arrayList3, strArrM80071j);
        return 1;
    }

    /* renamed from: f0 */
    public static void m78951f0(String str, String str2, List<String> list) {
        if ("soundrecorder".equals(str)) {
            String str3 = str2 + File.separator + "CallRecord";
            HashSet hashSet = new HashSet();
            for (String str4 : list) {
                if (str4.startsWith(str3)) {
                    hashSet.add(str4);
                }
            }
            list.removeAll(hashSet);
        }
    }

    /* renamed from: i0 */
    public static void m78952i0(Context context, String str, List<String> list, List<String> list2, String[] strArr) throws Throwable {
        C12701e c12701e = new C12701e(context, str, true);
        if (BackupObject.isRecordModule(str) && BackupObject.isOtherPhoneSupportTarRecorder()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (String str2 : list) {
                if (str2.startsWith(strArr[0])) {
                    arrayList.add(str2);
                } else {
                    arrayList2.add(str2);
                }
            }
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            C12700d.m76423a(context, str, (String[]) arrayList3.toArray(new String[0]));
            c12701e.m76425a(arrayList3);
        } else if ("soundrecorder".equals(str)) {
            Collections.sort(list, f59628d);
            C12700d.m76423a(context, str, (String[]) list.toArray(new String[0]));
            c12701e.m76426b(list);
        } else if (BackupConstant.m13148v().contains(str)) {
            C12700d.m76423a(context, str, (String[]) list.toArray(new String[0]));
            c12701e.m76425a(list);
            m78953j0(context, str, list2, c12701e);
        } else {
            C12700d.m76423a(context, str, (String[]) list.toArray(new String[0]));
            c12701e.m76426b(list);
        }
        c12701e.m76428e();
    }

    /* renamed from: j0 */
    public static void m78953j0(Context context, String str, List<String> list, C12701e c12701e) throws Throwable {
        if (C13348q.m80082b(list)) {
            C2111d.m12653i("CommonModuleCopyFile", "no need to record empty directory.");
            return;
        }
        try {
            StringBuilder sb2 = new StringBuilder(context.getFilesDir().getCanonicalPath());
            sb2.append("/FtpTemp");
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("emptyDirectory");
            sb2.append(str2);
            sb2.append(str);
            sb2.append(str2);
            sb2.append("emptyDirectoryRecord.txt");
            String string = sb2.toString();
            if (C13334c.m79967K(list, string)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(string);
                C12700d.m76423a(context, str, (String[]) arrayList.toArray(new String[0]));
                c12701e.m76426b(arrayList);
            }
        } catch (IOException unused) {
            C2111d.m12648d("CommonModuleCopyFile", "writeEmptyDirFile fail IOException");
        }
    }

    /* renamed from: g0 */
    public final void m78954g0(String str, String str2) {
        for (String str3 : C12698b.m76409c(C12462b.m74717a(C2157a.m13208p(C2157a.m13208p(C12462b.m74717a(str).getParent(), "packaged"), str2)))) {
            if (str3.endsWith(".hwtmp")) {
                if (!new File(str3).renameTo(new File(str3.substring(0, str3.lastIndexOf(".hwtmp"))))) {
                    C2111d.m12657m("CommonModuleCopyFile", "renameRecorderTarFiles fail");
                }
            }
        }
    }

    /* renamed from: h0 */
    public int m78955h0(C12718o c12718o, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (BackupObject.isRecordModule(c12718o.m76531g())) {
            m78954g0(c12718o.m76533i(), c12718o.m76531g());
        }
        c12718o.m76537m(BackupObject.isRecordModule(c12718o.m76531g()) ? 523 : 508, C10713c.m65394d(BackupObject.getExecuteParameter(), "key_media_restore_location"), 0, false);
        return m76475U(c12718o, arrayList2, arrayList);
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
}

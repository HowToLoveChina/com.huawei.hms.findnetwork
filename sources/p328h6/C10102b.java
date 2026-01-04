package p328h6;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: h6.b */
/* loaded from: classes.dex */
public class C10102b {

    /* renamed from: a */
    public static SharedPreferences f49297a;

    /* renamed from: a */
    public static boolean m62916a(Context context, String str, int i10) {
        if (context == null) {
            C2111d.m12648d("MediaTarSharedPreferences", " context is null ");
            return true;
        }
        C2111d.m12646b("MediaTarSharedPreferences", " getTarSP module : " + str);
        f49297a = context.getSharedPreferences("mediatarinfo", 4);
        if (i10 % 100 == 0) {
            C2111d.m12653i("MediaTarSharedPreferences", " getTarSP module " + str + " is exist: " + f49297a.contains(str) + "  " + i10);
        }
        return f49297a.getBoolean(str, false);
    }

    /* renamed from: b */
    public static void m62917b(Context context, String str) throws InterruptedException {
        C2111d.m12653i("MediaTarSharedPreferences", " saveTarSP module : " + str);
        SharedPreferences sharedPreferences = context.getSharedPreferences("mediatarinfo", 4);
        f49297a = sharedPreferences;
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(str, true);
        boolean zCommit = editorEdit.commit();
        C2111d.m12653i("MediaTarSharedPreferences", " saveTarSP success : " + zCommit);
        while (!zCommit) {
            try {
                Thread.sleep(500L);
                editorEdit.putBoolean(str, true);
                zCommit = editorEdit.commit();
                C2111d.m12653i("MediaTarSharedPreferences", " retry saveTarSP success : " + zCommit);
            } catch (InterruptedException unused) {
                C2111d.m12648d("MediaTarSharedPreferences", " saveTarSP InterruptedException");
            }
        }
    }
}

package p390ja;

import android.content.Context;
import android.os.Environment;
import hk.C10278a;
import java.io.File;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: ja.a */
/* loaded from: classes3.dex */
public abstract class AbstractC10747a {

    /* renamed from: a */
    public Boolean f51390a;

    /* renamed from: a */
    public File m65473a() {
        File fileM63441g = C10278a.m63441g(m65475c(), ".diskcore_asset");
        if (!fileM63441g.exists() && fileM63441g.mkdirs()) {
            C11839m.m70688i("AssetBase", "external parent create success.");
        }
        return fileM63441g;
    }

    /* renamed from: b */
    public Context m65474b() {
        return C0213f.m1377a();
    }

    /* renamed from: c */
    public final File m65475c() {
        return ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? m65474b().getExternalFilesDir("") : m65474b().getFilesDir();
    }

    /* renamed from: d */
    public Boolean m65476d() {
        return this.f51390a;
    }
}

package p006a5;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

/* renamed from: a5.e */
/* loaded from: classes.dex */
public class C0050e extends AbstractC0048c {
    @Override // p006a5.AbstractC0048c
    /* renamed from: B */
    public int mo186B(String str, ContentValues[] contentValuesArr, Handler.Callback callback, Object obj) {
        return 0;
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: C */
    public int mo187C(String str, ContentValues contentValues) {
        return 0;
    }

    @Override // p006a5.C0046a
    /* renamed from: d */
    public boolean mo172d(String str) {
        this.f116b = str;
        try {
            return m189g(new File(str));
        } catch (IOException unused) {
            C2111d.m12648d("StoreHandlerVirtualFile", "create File fail");
            return false;
        }
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: l */
    public Cursor mo194l(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return null;
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: m */
    public String mo195m() {
        return this.f115a;
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: t */
    public ContentValues[] mo201t(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return new ContentValues[0];
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: u */
    public Set<String> mo202u(String str) {
        return Collections.emptySet();
    }

    @Override // p006a5.AbstractC0048c
    /* renamed from: v */
    public int mo203v(String str) {
        return 0;
    }
}

package p444l5;

import android.accounts.AuthenticatorDescription;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import java.io.IOException;
import java.util.HashMap;
import p006a5.AbstractC0048c;

/* renamed from: l5.f */
/* loaded from: classes.dex */
public class C11238f {

    /* renamed from: a */
    public String f52764a;

    /* renamed from: b */
    public String f52765b;

    /* renamed from: c */
    public String f52766c;

    /* renamed from: d */
    public String f52767d;

    /* renamed from: e */
    public String f52768e;

    /* renamed from: f */
    public int f52769f;

    /* renamed from: g */
    public int f52770g;

    /* renamed from: a */
    public ContentValues m67533a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("accountName", this.f52764a);
        contentValues.put("accountType", this.f52765b);
        contentValues.put("packageName", this.f52766c);
        contentValues.put("appName", this.f52767d);
        contentValues.put("iconFileName", this.f52768e);
        contentValues.put("count", Integer.valueOf(this.f52769f));
        contentValues.put("type", Integer.valueOf(this.f52770g));
        return contentValues;
    }

    /* renamed from: b */
    public void m67534b(Context context, String str, C11239g c11239g) throws Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
        AuthenticatorDescription authenticatorDescription;
        HashMap<String, AuthenticatorDescription> mapM67524d = C11237e.m67524d(context);
        if (context == null || c11239g == null) {
            return;
        }
        this.f52764a = c11239g.m67537b();
        this.f52765b = c11239g.m67538c();
        if (c11239g.m67539d() != 2 || mapM67524d == null || (authenticatorDescription = mapM67524d.get(c11239g.m67538c())) == null) {
            return;
        }
        Context contextCreatePackageContext = context.createPackageContext(authenticatorDescription.packageName, 0);
        String str2 = authenticatorDescription.packageName;
        this.f52766c = str2;
        if (authenticatorDescription.labelId != 0) {
            this.f52767d = contextCreatePackageContext.getResources().getString(authenticatorDescription.labelId);
        } else {
            this.f52767d = str2;
        }
        this.f52768e = C11237e.m67531k(contextCreatePackageContext, authenticatorDescription, str);
    }

    /* renamed from: c */
    public int m67535c(AbstractC0048c abstractC0048c) {
        if (abstractC0048c == null) {
            return 2;
        }
        return abstractC0048c.m185A("BackupFileContactInfo", m67533a());
    }
}

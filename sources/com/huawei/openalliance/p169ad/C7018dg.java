package com.huawei.openalliance.p169ad;

import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.exception.C7109a;
import com.huawei.openalliance.p169ad.p171db.bean.AnalysisEventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.AppDataCollectionRecord;
import com.huawei.openalliance.p169ad.p171db.bean.C7013a;
import com.huawei.openalliance.p169ad.p171db.bean.ClickEventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecordV3;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.openalliance.p169ad.p171db.bean.ContentTemplateRecord;
import com.huawei.openalliance.p169ad.p171db.bean.DeletedContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EventMonitorRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ImpEventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.PlacementRecord;
import com.huawei.openalliance.p169ad.p171db.bean.SdkCfgSha256Record;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateRecord;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateStyleRecord;
import com.huawei.openalliance.p169ad.p171db.bean.TestContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ThirdPartyEventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.UserCloseRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.dg */
/* loaded from: classes8.dex */
public class C7018dg {

    /* renamed from: b */
    private static List<C7013a> f32203b = new ArrayList(4);

    /* renamed from: c */
    private static List<C7013a> f32204c = new ArrayList(4);

    /* renamed from: d */
    private static String f32205d = "TestContentRecord";

    /* renamed from: a */
    private C7015dd f32206a;

    static {
        f32203b.add(new ContentRecord());
        f32203b.add(new EventRecord());
        f32203b.add(new TestContentRecord());
        f32203b.add(new ThirdPartyEventRecord());
        f32203b.add(new UserCloseRecord());
        f32203b.add(new TemplateRecord());
        f32203b.add(new PlacementRecord());
        f32203b.add(new ImpEventRecord());
        f32203b.add(new ClickEventRecord());
        f32203b.add(new AnalysisEventRecord());
        f32203b.add(new ContentResource());
        f32203b.add(new EventMonitorRecord());
        f32203b.add(new TemplateStyleRecord());
        f32203b.add(new ContentTemplateRecord());
        f32203b.add(new ContentRecordV3());
        f32203b.add(new AppDataCollectionRecord());
        f32203b.add(new DeletedContentRecord());
        f32203b.add(new SdkCfgSha256Record());
        f32204c.add(new ContentRecord());
        f32204c.add(new EventRecord());
        f32204c.add(new ThirdPartyEventRecord());
        f32204c.add(new UserCloseRecord());
        f32204c.add(new TemplateRecord());
        f32204c.add(new PlacementRecord());
        f32204c.add(new ImpEventRecord());
        f32204c.add(new ClickEventRecord());
        f32204c.add(new AnalysisEventRecord());
        f32204c.add(new ContentResource());
        f32204c.add(new EventMonitorRecord());
        f32204c.add(new TemplateStyleRecord());
        f32204c.add(new ContentTemplateRecord());
        f32204c.add(new ContentRecordV3());
        f32204c.add(new AppDataCollectionRecord());
        f32204c.add(new DeletedContentRecord());
        f32204c.add(new SdkCfgSha256Record());
    }

    public C7018dg(C7015dd c7015dd) {
        this.f32206a = c7015dd;
    }

    /* renamed from: a */
    private String m41932a(String[] strArr, String[] strArr2) {
        StringBuilder sb2 = new StringBuilder();
        List arrayList = new ArrayList(4);
        if (strArr2 != null) {
            arrayList = Arrays.asList(strArr2);
        }
        if (strArr == null || strArr.length <= 0 || strArr2 == null) {
            return null;
        }
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str = strArr[i10];
            if (!arrayList.contains(str)) {
                str = "\"\"";
            }
            sb2.append(str);
            if (i10 != strArr.length - 1) {
                sb2.append(",");
            }
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public void m41936b() throws SQLException {
        Iterator<C7013a> it = f32203b.iterator();
        while (it.hasNext()) {
            String strM41862bu = it.next().m41862bu();
            try {
                if (this.f32206a.m41917e(strM41862bu)) {
                    this.f32206a.m41914b(strM41862bu);
                }
            } catch (C7109a unused) {
                AbstractC7185ho.m43823c("DbUpdateHelper", "delete table fail");
            }
        }
        for (C7013a c7013a : f32204c) {
            try {
                this.f32206a.m41915c(c7013a.m41861bt());
            } catch (C7109a unused2) {
                AbstractC7185ho.m43824c("DbUpdateHelper", "create table %s failed", c7013a.m41862bu());
            }
        }
    }

    /* renamed from: b */
    private void m41934b(String str) throws C7109a, SQLException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" INSERT INTO ");
        sb2.append(str);
        sb2.append(" SELECT ");
        try {
            try {
                String strM41932a = m41932a(this.f32206a.m41916d(str), this.f32206a.m41916d("_temp_" + str));
                if (strM41932a == null) {
                    throw new C7109a("insert data sql is null");
                }
                sb2.append(strM41932a);
                sb2.append(" FROM ");
                sb2.append("_temp_");
                sb2.append(str);
                try {
                    this.f32206a.m41915c(sb2.toString());
                } catch (C7109a unused) {
                    throw new C7109a("DbUpdateHelper insertData mDbHelper.executeSQL error");
                }
            } catch (C7109a unused2) {
                throw new C7109a(String.format(Locale.ENGLISH, "get temp table %s column names failed", str.trim()));
            }
        } catch (C7109a unused3) {
            throw new C7109a(String.format(Locale.ENGLISH, "get table %s column names failed", str.trim()));
        }
    }

    /* renamed from: a */
    public void m41935a() throws C7109a, SQLException {
        for (C7013a c7013a : f32204c) {
            String strM41862bu = c7013a.m41862bu();
            if (this.f32206a.m41917e(strM41862bu)) {
                this.f32206a.m41918f(strM41862bu);
                AbstractC7185ho.m43820b("DbUpdateHelper", "tableName exist moidfy table successfully.");
                try {
                    this.f32206a.m41915c(c7013a.m41861bt());
                    m41934b(strM41862bu);
                    AbstractC7185ho.m43820b("DbUpdateHelper", "insert data to table successfully.");
                    this.f32206a.m41911a(strM41862bu);
                    AbstractC7185ho.m43820b("DbUpdateHelper", "drop table temp table successfully.");
                } catch (C7109a unused) {
                    throw new C7109a(String.format(Locale.ENGLISH, "table exist, init table tableName: %s failed", strM41862bu.trim()));
                }
            } else {
                try {
                    this.f32206a.m41915c(c7013a.m41861bt());
                } catch (C7109a unused2) {
                    throw new C7109a(String.format(Locale.ENGLISH, "table is not exist, init table tableName: %s failed", strM41862bu.trim()));
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m41933a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strReplaceAll = str.replaceAll("_temp_", "");
        Iterator<C7013a> it = f32204c.iterator();
        while (it.hasNext()) {
            if (strReplaceAll.equals(it.next().m41862bu())) {
                return true;
            }
        }
        Iterator<C7013a> it2 = f32203b.iterator();
        while (it2.hasNext()) {
            if (strReplaceAll.equals(it2.next().m41862bu())) {
                return true;
            }
        }
        return false;
    }
}

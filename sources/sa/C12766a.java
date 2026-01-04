package sa;

import android.text.TextUtils;
import bb.C1160a;
import com.huawei.android.hicloud.drive.clouddisk.expand.BatchGetFileCallback;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.services.drive.DriveRequest;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import p260ek.C9499a;
import p336he.C10156g;
import p363ia.C10463a;
import p369ii.C10511b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* renamed from: sa.a */
/* loaded from: classes3.dex */
public final class C12766a {

    /* renamed from: a */
    public static long f58423a;

    /* renamed from: sa.a$a */
    public static class a extends AbstractC12367d {

        /* renamed from: a */
        public HashMap<String, FileModel> f58424a;

        public a(HashMap<String, FileModel> map) {
            this.f58424a = map;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            HashMap<String, FileModel> map = this.f58424a;
            if (map == null) {
                return;
            }
            Iterator<Map.Entry<String, FileModel>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    FileModel value = it.next().getValue();
                    if (value != null && !"1".equals(value.getIsCloudExist())) {
                        String thumbnailPath = value.getThumbnailPath();
                        if (!TextUtils.isEmpty(thumbnailPath)) {
                            File fileM63442h = C10278a.m63442h(thumbnailPath);
                            if (fileM63442h.exists()) {
                                fileM63442h.delete();
                            }
                        }
                    }
                } catch (Exception e10) {
                    C11839m.m70687e("CloudUtil", "CleanThumbnailTask exception: " + e10.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public static void m76612a(HashMap<String, FileModel> map) {
        C12515a.m75110o().m75172d(new a(map));
    }

    /* renamed from: b */
    public static void m76613b(int i10, HashMap<String, String> map) {
        DriveExpand driveExpandM64282d = C10463a.m64279e().m64282d();
        if (driveExpandM64282d == null) {
            C11839m.m70687e("CloudUtil", "init driveExpand null");
            return;
        }
        int size = map.size();
        C10511b c10511bBatch = driveExpandM64282d.batch();
        int i11 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                DriveRequest<com.huawei.cloud.services.drive.model.File> fields2 = driveExpandM64282d.files().get(entry.getKey()).setFields2("id,fileName");
                C1160a.m7250a(fields2.getHeaders());
                C10156g.m63307d(fields2.getHeaders(), fields2.buildHttpRequestUrl());
                fields2.queue(c10511bBatch, new BatchGetFileCallback(i10, entry.getKey(), map));
                i11++;
            } catch (Exception e10) {
                C11839m.m70687e("CloudUtil", "getFileName error: " + e10.toString());
            }
            if (i11 % 20 == 0 || size == i11) {
                if (c10511bBatch.m64600e() > 0) {
                    c10511bBatch.m64597a();
                    c10511bBatch = driveExpandM64282d.batch();
                }
            }
        }
    }

    /* renamed from: c */
    public static long m76614c() {
        return f58423a;
    }

    /* renamed from: d */
    public static boolean m76615d(int i10, String str, C9721b c9721b) {
        JSONArray jSONArrayM59433a;
        if (TextUtils.isEmpty(c9721b.getMessage())) {
            return false;
        }
        String strM59436d = C9499a.m59436d(c9721b.getMessage(), VastAttribute.ERROR);
        if (TextUtils.isEmpty(strM59436d) || c9721b.m60663g() != i10 || (jSONArrayM59433a = C9499a.m59433a(strM59436d, "errorDetail")) == null || jSONArrayM59433a.optJSONObject(0) == null) {
            return false;
        }
        String strM59436d2 = C9499a.m59436d(jSONArrayM59433a.optJSONObject(0).toString(), AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
        if (strM59436d2.length() > str.length()) {
            strM59436d2 = strM59436d2.substring(strM59436d2.length() - str.length());
        }
        return str.equals(strM59436d2);
    }

    /* renamed from: e */
    public static boolean m76616e(int i10, String str, Exception exc) {
        JSONArray jSONArrayM59433a;
        if (!(exc instanceof C4616s)) {
            return false;
        }
        C4616s c4616s = (C4616s) exc;
        if (TextUtils.isEmpty(c4616s.m28319c())) {
            return false;
        }
        String strM59436d = C9499a.m59436d(c4616s.m28319c(), VastAttribute.ERROR);
        if (TextUtils.isEmpty(strM59436d) || C9499a.m59434b(strM59436d, "code") != i10 || (jSONArrayM59433a = C9499a.m59433a(strM59436d, "errorDetail")) == null || jSONArrayM59433a.optJSONObject(0) == null) {
            return false;
        }
        String strM59436d2 = C9499a.m59436d(jSONArrayM59433a.optJSONObject(0).toString(), AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
        if (strM59436d2.length() > str.length()) {
            strM59436d2 = strM59436d2.substring(strM59436d2.length() - str.length());
        }
        return str.equals(strM59436d2);
    }

    /* renamed from: f */
    public static boolean m76617f(int i10, String str, String str2) {
        JSONArray jSONArrayM59433a;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String strM59436d = C9499a.m59436d(str2, VastAttribute.ERROR);
        if (!TextUtils.isEmpty(strM59436d)) {
            str2 = strM59436d;
        }
        if (C9499a.m59434b(str2, "code") == i10 && (jSONArrayM59433a = C9499a.m59433a(str2, "errorDetail")) != null && jSONArrayM59433a.optJSONObject(0) != null) {
            String strM59436d2 = C9499a.m59436d(jSONArrayM59433a.optJSONObject(0).toString(), AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
            if (strM59436d2.length() > str.length()) {
                strM59436d2 = strM59436d2.substring(strM59436d2.length() - str.length());
            }
            if (strM59436d2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public static void m76618g(long j10) {
        f58423a = j10;
    }
}

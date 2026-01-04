package com.huawei.hms.hatool;

import com.huawei.hiar.ARImageMetadata;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.huawei.hms.hatool.d1 */
/* loaded from: classes8.dex */
public class C5524d1 implements InterfaceRunnableC5531g {

    /* renamed from: a */
    private String f25168a;

    /* renamed from: b */
    private String f25169b;

    /* renamed from: c */
    private String f25170c;

    /* renamed from: d */
    private List<C5518b1> f25171d;

    public C5524d1(List<C5518b1> list, String str, String str2, String str3) {
        this.f25168a = str;
        this.f25169b = str2;
        this.f25170c = str3;
        this.f25171d = list;
    }

    /* renamed from: a */
    private void m32483a() {
        C5522d.m32478a(AbstractC5562q0.m32718i(), "backup_event", AbstractC5554n1.m32661a(this.f25168a, this.f25170c, this.f25169b));
    }

    @Override // java.lang.Runnable
    public void run() {
        List<C5518b1> list = this.f25171d;
        if (list == null || list.size() == 0) {
            C5571v.m32794d("hmsSdk", "failed events is empty");
            return;
        }
        if (C5520c0.m32466a(AbstractC5562q0.m32718i(), "cached_v2_1", AbstractC5562q0.m32720k() * ARImageMetadata.SHADING_MODE)) {
            C5571v.m32796e("hmsSdk", "The cacheFile is full,Can not writing data, delete it! reqID:" + this.f25169b);
            C5522d.m32478a(AbstractC5562q0.m32718i(), "cached_v2_1", new String[0]);
            return;
        }
        String strM32660a = AbstractC5554n1.m32660a(this.f25168a, this.f25170c);
        List<C5518b1> list2 = C5521c1.m32473b(AbstractC5562q0.m32718i(), "cached_v2_1", strM32660a).get(strM32660a);
        if (list2 != null && list2.size() != 0) {
            this.f25171d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<C5518b1> it = this.f25171d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().m32458d());
            } catch (JSONException unused) {
                C5571v.m32796e("hmsSdk", "event to json error");
            }
        }
        String string = jSONArray.toString();
        if (string.length() > AbstractC5562q0.m32716h() * ARImageMetadata.SHADING_MODE) {
            C5571v.m32796e("hmsSdk", "this failed data is too long,can not writing it");
            this.f25171d = null;
            return;
        }
        C5571v.m32794d("hmsSdk", "data send failed, write to cache file...reqID:" + this.f25169b);
        C5522d.m32481b(AbstractC5562q0.m32718i(), "cached_v2_1", strM32660a, string);
        m32483a();
    }
}

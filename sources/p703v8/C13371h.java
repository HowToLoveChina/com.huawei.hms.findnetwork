package p703v8;

import com.google.gson.Gson;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import to.C13049a;

/* renamed from: v8.h */
/* loaded from: classes2.dex */
public class C13371h {
    /* renamed from: a */
    public FamilyShareInfoResult m80271a() {
        try {
            return (FamilyShareInfoResult) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78751o(), FamilyShareInfoResult.class);
        } catch (Exception e10) {
            C11839m.m70687e("GetFamilyShareInfoRequestor", "get familyshareinfo requestor exception:" + e10.toString());
            return null;
        }
    }
}

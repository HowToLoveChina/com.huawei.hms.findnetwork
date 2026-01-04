package p495nm;

import com.google.gson.JsonObject;
import p371ik.C10527a;

/* renamed from: nm.m */
/* loaded from: classes6.dex */
public class C11732m {

    /* renamed from: a */
    public final String f54274a;

    /* renamed from: b */
    public final String f54275b;

    public C11732m(String str, String str2) {
        this.f54274a = str;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("opSceneDetail", str2);
        this.f54275b = C10527a.m64633k(jsonObject);
    }

    /* renamed from: a */
    public String m70017a() {
        return this.f54274a;
    }

    /* renamed from: b */
    public String m70018b() {
        return this.f54275b;
    }
}

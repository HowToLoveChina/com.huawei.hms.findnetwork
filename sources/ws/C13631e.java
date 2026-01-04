package ws;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ws.e */
/* loaded from: classes8.dex */
public final class C13631e {

    /* renamed from: a */
    @SerializedName("code")
    private String f61302a;

    /* renamed from: b */
    @SerializedName("tileInfoList")
    private List<C13628b> f61303b;

    public C13631e(String str, ArrayList arrayList) {
        this.f61302a = str;
        this.f61303b = arrayList;
    }

    /* renamed from: a */
    public final List<C13628b> m81989a() {
        return this.f61303b;
    }

    /* renamed from: b */
    public final String m81990b() {
        return this.f61302a;
    }
}

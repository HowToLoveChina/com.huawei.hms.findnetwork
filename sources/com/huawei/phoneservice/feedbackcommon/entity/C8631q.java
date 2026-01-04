package com.huawei.phoneservice.feedbackcommon.entity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.q */
/* loaded from: classes5.dex */
public class C8631q {

    /* renamed from: a */
    @SerializedName("data")
    private List<a> f40184a = new ArrayList();

    /* renamed from: com.huawei.phoneservice.feedbackcommon.entity.q$a */
    public class a {

        /* renamed from: a */
        @SerializedName("read")
        private boolean f40185a;

        /* renamed from: b */
        @SerializedName("srcno")
        private String f40186b;

        /* renamed from: a */
        public boolean m53252a() {
            return this.f40185a;
        }

        /* renamed from: b */
        public boolean m53253b() {
            return !TextUtils.isEmpty(this.f40186b);
        }
    }

    /* renamed from: a */
    public List<a> m53251a() {
        return this.f40184a;
    }
}

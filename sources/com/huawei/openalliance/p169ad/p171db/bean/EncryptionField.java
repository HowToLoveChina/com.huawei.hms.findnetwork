package com.huawei.openalliance.p169ad.p171db.bean;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7827f;
import java.io.Serializable;

@OuterVisible
/* loaded from: classes2.dex */
public class EncryptionField<DATA> implements Serializable {

    /* renamed from: a */
    private Class f32161a;

    /* renamed from: b */
    private Class f32162b;

    /* renamed from: c */
    private DATA f32163c;

    /* renamed from: d */
    private String f32164d;

    public EncryptionField(Class cls) {
        this.f32161a = cls;
    }

    /* renamed from: a */
    public DATA m41652a(Context context) {
        DATA data;
        if (this.f32161a == String.class) {
            if (TextUtils.isEmpty((String) this.f32163c)) {
                data = (DATA) AbstractC7827f.m48400b(this.f32164d, AbstractC7796cp.m48089b(context));
                this.f32163c = data;
            }
        } else if (this.f32163c == null) {
            data = (DATA) AbstractC7758be.m47739b(AbstractC7827f.m48400b(this.f32164d, AbstractC7796cp.m48089b(context)), this.f32161a, this.f32162b);
            this.f32163c = data;
        }
        return this.f32163c;
    }

    /* renamed from: b */
    public String m41657b(byte[] bArr) {
        DATA dataM41653a = m41653a(bArr);
        this.f32164d = AbstractC7827f.m48394a(dataM41653a instanceof String ? (String) dataM41653a : AbstractC7758be.m47742b(dataM41653a), bArr);
        return this.f32164d;
    }

    /* renamed from: c */
    public boolean m41659c() {
        return !TextUtils.isEmpty(this.f32164d);
    }

    public EncryptionField(Class cls, Class cls2) {
        this.f32161a = cls;
        this.f32162b = cls2;
    }

    /* renamed from: a */
    public DATA m41653a(byte[] bArr) {
        DATA data;
        if (this.f32161a == String.class) {
            if (TextUtils.isEmpty((String) this.f32163c)) {
                data = (DATA) AbstractC7827f.m48400b(this.f32164d, bArr);
                this.f32163c = data;
            }
        } else if (this.f32163c == null) {
            data = (DATA) AbstractC7758be.m47739b(AbstractC7827f.m48400b(this.f32164d, bArr), this.f32161a, this.f32162b);
            this.f32163c = data;
        }
        return this.f32163c;
    }

    /* renamed from: b */
    public boolean m41658b() {
        DATA data = this.f32163c;
        return data instanceof String ? !TextUtils.isEmpty((String) data) : data != null;
    }

    /* renamed from: a */
    public String m41654a() {
        return this.f32164d;
    }

    /* renamed from: a */
    public void m41655a(DATA data) {
        this.f32163c = data;
    }

    /* renamed from: a */
    public void m41656a(String str) {
        this.f32164d = str;
    }
}

package com.huawei.hms.videokit.player.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.videokit.player.C6550c1;
import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public class SubtitleInfo implements Parcelable {
    public static final Parcelable.Creator<SubtitleInfo> CREATOR = new C6565a();
    public static final int PE_TEXT_HORLIGN_CENTER = 1;
    public static final int PE_TEXT_HORLIGN_LEFT = 0;
    public static final int PE_TEXT_HORLIGN_RIGHT = 2;
    public static final int PE_TEXT_VALIGN_BOTTOM = 2;
    public static final int PE_TEXT_VALIGN_CENTER = 1;
    public static final int PE_TEXT_VALIGN_TOP = 0;

    /* renamed from: A */
    private float f30492A;

    /* renamed from: B */
    private float f30493B;

    /* renamed from: C */
    private int f30494C;

    /* renamed from: D */
    private int f30495D;

    /* renamed from: E */
    private float f30496E;

    /* renamed from: F */
    private float f30497F;

    /* renamed from: a */
    private int f30498a;

    /* renamed from: b */
    private int f30499b;

    /* renamed from: c */
    private int f30500c;

    /* renamed from: d */
    private String f30501d;

    /* renamed from: e */
    private int f30502e;

    /* renamed from: f */
    private int f30503f;

    /* renamed from: g */
    private int f30504g;

    /* renamed from: h */
    private float f30505h;

    /* renamed from: i */
    private float f30506i;

    /* renamed from: j */
    private float f30507j;

    /* renamed from: k */
    private float f30508k;

    /* renamed from: l */
    private float f30509l;

    /* renamed from: m */
    private int f30510m;

    /* renamed from: n */
    private int f30511n;

    /* renamed from: o */
    private float f30512o;

    /* renamed from: p */
    private int f30513p;

    /* renamed from: q */
    private int f30514q;

    /* renamed from: r */
    private int f30515r;

    /* renamed from: s */
    private int f30516s;

    /* renamed from: t */
    private int f30517t;

    /* renamed from: u */
    private int f30518u;

    /* renamed from: v */
    private int f30519v;

    /* renamed from: w */
    private float f30520w;

    /* renamed from: x */
    private float f30521x;

    /* renamed from: y */
    private int f30522y;

    /* renamed from: z */
    private String f30523z;

    /* renamed from: com.huawei.hms.videokit.player.internal.SubtitleInfo$a */
    public class C6565a implements Parcelable.Creator<SubtitleInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubtitleInfo createFromParcel(Parcel parcel) {
            return new SubtitleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubtitleInfo[] newArray(int i10) {
            return new SubtitleInfo[i10];
        }
    }

    public SubtitleInfo() {
        this.f30501d = "";
        this.f30523z = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof SubtitleInfo)) {
            SubtitleInfo subtitleInfo = (SubtitleInfo) obj;
            if (subtitleInfo.f30500c == this.f30500c && subtitleInfo.f30499b == this.f30499b) {
                return true;
            }
        }
        return false;
    }

    public int getBackgroundColor() {
        return this.f30503f;
    }

    public float getBold() {
        return this.f30509l;
    }

    public int getDisPlayPosByPer() {
        return this.f30494C;
    }

    public int getDisPlayWhByPer() {
        return this.f30495D;
    }

    public float getDisplayHeight() {
        return this.f30497F;
    }

    public float getDisplayWidth() {
        return this.f30496E;
    }

    public int getEndTS() {
        return this.f30500c;
    }

    public int getFontSize() {
        return this.f30502e;
    }

    public int getForegroundColor() {
        return this.f30504g;
    }

    public int getHorAlign() {
        return this.f30516s;
    }

    public int getHorMarginIsPercent() {
        return this.f30518u;
    }

    public int getHorSpacing() {
        return this.f30514q;
    }

    public String getImageData() {
        return this.f30523z;
    }

    public float getItalic() {
        return this.f30507j;
    }

    public float getMarginLeft() {
        return this.f30520w;
    }

    public float getMarginTop() {
        return this.f30521x;
    }

    public float getRoll() {
        return this.f30508k;
    }

    public float getScaleX() {
        return this.f30505h;
    }

    public float getScaleY() {
        return this.f30506i;
    }

    public int getShadow() {
        return this.f30513p;
    }

    public int getStartFlag() {
        return this.f30498a;
    }

    public int getStartTS() {
        return this.f30499b;
    }

    public int getStrikeout() {
        return this.f30511n;
    }

    public float getStroke() {
        return this.f30512o;
    }

    public int getSubType() {
        return this.f30522y;
    }

    public String getSubtitle() {
        return this.f30501d;
    }

    public int getUnderline() {
        return this.f30510m;
    }

    public int getVerAlign() {
        return this.f30517t;
    }

    public int getVerMarginIsPercent() {
        return this.f30519v;
    }

    public int getVerSpacing() {
        return this.f30515r;
    }

    public float getX() {
        return this.f30492A;
    }

    public float getY() {
        return this.f30493B;
    }

    public int hashCode() {
        return this.f30500c + this.f30499b;
    }

    public void setDisPlayPosByPer(int i10) {
        this.f30494C = i10;
    }

    public void setDisPlayWhByPer(int i10) {
        this.f30495D = i10;
    }

    public void setDisplayHeight(float f10) {
        this.f30497F = f10;
    }

    public void setDisplayWidth(float f10) {
        this.f30496E = f10;
    }

    public void setImageData(String str) {
        this.f30523z = str;
    }

    public void setSubType(int i10) {
        this.f30522y = i10;
    }

    public void setX(float f10) {
        this.f30492A = f10;
    }

    public void setY(float f10) {
        this.f30493B = f10;
    }

    public String toString() throws IllegalAccessException, IllegalArgumentException {
        String str;
        Field[] declaredFields = getClass().getDeclaredFields();
        StringBuilder sb2 = new StringBuilder();
        for (Field field : declaredFields) {
            try {
                sb2.append(field.getName() + ":" + field.get(this).toString() + "; ");
            } catch (IllegalAccessException unused) {
                str = "getFileVaule error";
                C6550c1.m37262b("SubtitleInfo", str);
            } catch (IllegalArgumentException unused2) {
                str = "getFileVaule error IllegalArgumentException";
                C6550c1.m37262b("SubtitleInfo", str);
            }
        }
        return sb2.toString();
    }

    public String toStringNoImage() throws IllegalAccessException, IllegalArgumentException {
        String str;
        Field[] declaredFields = getClass().getDeclaredFields();
        StringBuilder sb2 = new StringBuilder();
        for (Field field : declaredFields) {
            try {
                Object obj = field.get(this);
                if (!field.getName().equals("imageData")) {
                    sb2.append(field.getName() + ":" + obj.toString() + "; ");
                }
            } catch (IllegalAccessException unused) {
                str = "getFileVaule error";
                C6550c1.m37262b("SubtitleInfo", str);
            } catch (IllegalArgumentException unused2) {
                str = "getFileVaule error IllegalArgumentException";
                C6550c1.m37262b("SubtitleInfo", str);
            }
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f30498a);
        parcel.writeInt(this.f30499b);
        parcel.writeInt(this.f30500c);
        parcel.writeString(this.f30501d);
        parcel.writeInt(this.f30502e);
        parcel.writeInt(this.f30503f);
        parcel.writeInt(this.f30504g);
        parcel.writeFloat(this.f30505h);
        parcel.writeFloat(this.f30506i);
        parcel.writeFloat(this.f30507j);
        parcel.writeFloat(this.f30508k);
        parcel.writeFloat(this.f30509l);
        parcel.writeInt(this.f30510m);
        parcel.writeInt(this.f30511n);
        parcel.writeFloat(this.f30512o);
        parcel.writeInt(this.f30513p);
        parcel.writeInt(this.f30514q);
        parcel.writeInt(this.f30515r);
        parcel.writeInt(this.f30516s);
        parcel.writeInt(this.f30517t);
        parcel.writeInt(this.f30518u);
        parcel.writeInt(this.f30519v);
        parcel.writeFloat(this.f30520w);
        parcel.writeFloat(this.f30521x);
        parcel.writeInt(this.f30522y);
        parcel.writeString(this.f30523z);
        parcel.writeFloat(this.f30492A);
        parcel.writeFloat(this.f30493B);
        parcel.writeInt(this.f30494C);
        parcel.writeInt(this.f30495D);
        parcel.writeFloat(this.f30496E);
        parcel.writeFloat(this.f30497F);
    }

    public SubtitleInfo(Parcel parcel) {
        this.f30501d = "";
        this.f30523z = "";
        this.f30498a = parcel.readInt();
        this.f30499b = parcel.readInt();
        this.f30500c = parcel.readInt();
        this.f30501d = parcel.readString();
        this.f30502e = parcel.readInt();
        this.f30503f = parcel.readInt();
        this.f30504g = parcel.readInt();
        this.f30505h = parcel.readFloat();
        this.f30506i = parcel.readFloat();
        this.f30507j = parcel.readFloat();
        this.f30508k = parcel.readFloat();
        this.f30509l = parcel.readFloat();
        this.f30510m = parcel.readInt();
        this.f30511n = parcel.readInt();
        this.f30512o = parcel.readFloat();
        this.f30513p = parcel.readInt();
        this.f30514q = parcel.readInt();
        this.f30515r = parcel.readInt();
        this.f30516s = parcel.readInt();
        this.f30517t = parcel.readInt();
        this.f30518u = parcel.readInt();
        this.f30519v = parcel.readInt();
        this.f30520w = parcel.readFloat();
        this.f30521x = parcel.readFloat();
        this.f30522y = parcel.readInt();
        this.f30523z = parcel.readString();
        this.f30492A = parcel.readFloat();
        this.f30493B = parcel.readFloat();
        this.f30494C = parcel.readInt();
        this.f30495D = parcel.readInt();
        this.f30496E = parcel.readFloat();
        this.f30497F = parcel.readFloat();
    }
}

package p454lj;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.cloud.pay.config.bean.BannerAfterPayPicturesItem;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import fk.C9721b;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9950c;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11842p;
import p709vj.C13452e;
import p846zj.C14306d;

/* renamed from: lj.a */
/* loaded from: classes5.dex */
public class C11278a {

    /* renamed from: lj.a$a */
    public class a extends TypeToken<List<PortraitAndGrade.UserTag>> {
    }

    /* renamed from: lj.a$b */
    public class b extends TypeToken<List<PortraitAndGrade.UserTag>> {
    }

    /* renamed from: a */
    public static float m67683a() {
        return m67687e(437, 2752);
    }

    /* renamed from: b */
    public static float m67684b() {
        return m67687e(437, 1312);
    }

    /* renamed from: c */
    public static BannerAfterPayPicturesItem m67685c(ArrayList<BannerAfterPayPicturesItem> arrayList, float f10) {
        Iterator<BannerAfterPayPicturesItem> it = arrayList.iterator();
        BannerAfterPayPicturesItem bannerAfterPayPicturesItem = null;
        float f11 = Float.MAX_VALUE;
        while (it.hasNext()) {
            BannerAfterPayPicturesItem next = it.next();
            float picturePropertion = next.getPicturePropertion();
            if (picturePropertion == -1.0f) {
                return bannerAfterPayPicturesItem;
            }
            float fAbs = Math.abs(picturePropertion - f10);
            if (picturePropertion > 0.0f && f11 > fAbs) {
                bannerAfterPayPicturesItem = next;
                f11 = fAbs;
            }
        }
        return bannerAfterPayPicturesItem;
    }

    /* renamed from: d */
    public static String m67686d(ArrayList<BannerAfterPayPicturesItem> arrayList) {
        BannerAfterPayPicturesItem bannerAfterPayPicturesItemM67685c = m67685c(arrayList, (C11842p.m70771U0() || C11842p.m70753O0(C0213f.m1377a()) || C11842p.m70747M0(C0213f.m1377a())) ? m67683a() : m67684b());
        if (bannerAfterPayPicturesItemM67685c == null) {
            return null;
        }
        return bannerAfterPayPicturesItemM67685c.getUrl();
    }

    /* renamed from: e */
    public static float m67687e(int i10, int i11) {
        return new BigDecimal(i10).divide(new BigDecimal(i11), 8, RoundingMode.HALF_UP).floatValue();
    }

    /* renamed from: f */
    public static long m67688f(String str) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("BannerAfterPayUtil", "getTimeMillis timeStr is empty");
            return -1L;
        }
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str));
            return calendar.getTimeInMillis();
        } catch (Exception e10) {
            C1442a.m8289e("BannerAfterPayUtil", "getTimeMillis exception:" + e10.toString());
            return -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public static List<PortraitAndGrade.UserTag> m67689g() {
        JsonSyntaxException e10;
        List list;
        Gson gson = new Gson();
        long jM80983w0 = C13452e.m80781L().m80983w0();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jM80983w0 > 0 && jCurrentTimeMillis - jM80983w0 < 86400000) {
            String strM80979v0 = C13452e.m80781L().m80979v0();
            if (strM80979v0 == null) {
                return new ArrayList();
            }
            try {
                List<PortraitAndGrade.UserTag> arrayList = (List) gson.fromJson(strM80979v0, new a().getType());
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                C1442a.m8290i("BannerAfterPayUtil", "getUserTagUseCache, userTagList is " + C14306d.m85203d(strM80979v0));
                return arrayList;
            } catch (JsonSyntaxException e11) {
                C1442a.m8290i("BannerAfterPayUtil", "getUserTagUseCache, json error is " + e11.getMessage());
            }
        }
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
        c11060c.m66670z("2.0");
        try {
            PortraitAndGrade portraitAndGradeM61727d = C9950c.m61724c().m61727d(c11060c);
            PortraitAndGrade.UserTagList userTagList = portraitAndGradeM61727d.getUserTagList();
            if (userTagList == null) {
                return new ArrayList();
            }
            List<PortraitAndGrade.UserTag> userTags = userTagList.getUserTags();
            if (userTags == null) {
                userTags = new ArrayList<>();
            }
            m67692j(portraitAndGradeM61727d);
            return userTags;
        } catch (C9721b e12) {
            C1442a.m8289e("BannerAfterPayUtil", "getPortrait exception: " + e12.toString());
            List arrayList2 = new ArrayList();
            String strM80979v02 = C13452e.m80781L().m80979v0();
            if (strM80979v02 == null) {
                return arrayList2;
            }
            try {
                list = (List) gson.fromJson(strM80979v02, new b().getType());
                if (list == null) {
                    try {
                        arrayList2 = new ArrayList();
                    } catch (JsonSyntaxException e13) {
                        e10 = e13;
                        C1442a.m8290i("BannerAfterPayUtil", "getUserTagUseCache, catch json error is " + e10.getMessage());
                        return list;
                    }
                } else {
                    arrayList2 = list;
                }
                C1442a.m8290i("BannerAfterPayUtil", "getUserTagsUseCache, userTagList is " + C14306d.m85203d(strM80979v02));
                return arrayList2;
            } catch (JsonSyntaxException e14) {
                List list2 = arrayList2;
                e10 = e14;
                list = list2;
            }
        }
    }

    /* renamed from: h */
    public static boolean m67690h(int i10, int i11) {
        if (i11 != 1 || (i10 != 5 && i10 != 7)) {
            if (i11 != 2) {
                return false;
            }
            if (i10 != 6 && i10 != 8) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: i */
    public static boolean m67691i(String str, String str2) {
        long jM67688f = m67688f(str);
        long jM67688f2 = m67688f(str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        return jCurrentTimeMillis > jM67688f && jCurrentTimeMillis < jM67688f2 + 86400000;
    }

    /* renamed from: j */
    public static void m67692j(PortraitAndGrade portraitAndGrade) {
        List<PortraitAndGrade.UserTag> userTags;
        Gson gson = new Gson();
        PortraitAndGrade.GradeRights gradeRights = portraitAndGrade.getGradeRights();
        if (gradeRights != null) {
            String gradeCode = gradeRights.getGradeCode();
            if (!TextUtils.isEmpty(gradeCode)) {
                C13452e.m80781L().m80940l1(gradeCode);
            }
        }
        PortraitAndGrade.UserTagList userTagList = portraitAndGrade.getUserTagList();
        if (userTagList == null || (userTags = userTagList.getUserTags()) == null) {
            return;
        }
        C13452e.m80781L().m80948n1(gson.toJson(userTags));
    }
}

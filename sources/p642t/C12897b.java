package p642t;

import android.util.Pair;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

/* renamed from: t.b */
/* loaded from: classes.dex */
public class C12897b {

    /* renamed from: f */
    public static final HashMap<Pair<Integer, Integer>, String> f58681f;

    /* renamed from: g */
    public static final HashMap<String, String> f58682g;

    /* renamed from: a */
    public final MotionLayout f58683a;

    /* renamed from: b */
    public String f58684b = null;

    /* renamed from: c */
    public String f58685c = null;

    /* renamed from: d */
    public int f58686d = -1;

    /* renamed from: e */
    public int f58687e = -1;

    static {
        HashMap<Pair<Integer, Integer>, String> map = new HashMap<>();
        f58681f = map;
        HashMap<String, String> map2 = new HashMap<>();
        f58682g = map2;
        map.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        map.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        map.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        map.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        map.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        map.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        map.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        map.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        map.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        map.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        map.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        map.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        map.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        map2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        map2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        map2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        map2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        map2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        map2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        map2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        map2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        map2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        map2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        map2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        map2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public C12897b(MotionLayout motionLayout) {
        this.f58683a = motionLayout;
    }
}

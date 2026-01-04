package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final List<ReflectionAccessFilter> reflectionFilters;

    /* renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1 */
    public class C20391 extends BoundField {
        final /* synthetic */ Method val$accessor;
        final /* synthetic */ boolean val$blockInaccessible;
        final /* synthetic */ Gson val$context;
        final /* synthetic */ TypeToken val$fieldType;
        final /* synthetic */ boolean val$isPrimitive;
        final /* synthetic */ boolean val$isStaticFinalField;
        final /* synthetic */ boolean val$jsonAdapterPresent;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20391(String str, Field field, boolean z10, boolean z11, boolean z12, Method method, boolean z13, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z14, boolean z15) {
            super(str, field, z10, z11);
            z = z12;
            method = method;
            z = z13;
            typeAdapter = typeAdapter;
            gson = gson;
            typeToken = typeToken;
            z = z14;
            z = z15;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        public void readIntoArray(JsonReader jsonReader, int i10, Object[] objArr) throws JsonParseException, IOException {
            Object obj = typeAdapter.read2(jsonReader);
            if (obj != null || !z) {
                objArr[i10] = obj;
                return;
            }
            throw new JsonParseException("null is not allowed as value for record component '" + this.fieldName + "' of primitive type; at path " + jsonReader.getPath());
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        public void readIntoField(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
            Object obj2 = typeAdapter.read2(jsonReader);
            if (obj2 == null && z) {
                return;
            }
            if (z) {
                ReflectiveTypeAdapterFactory.checkAccessible(obj, this.field);
            } else if (z) {
                throw new JsonIOException("Cannot set value of 'static final' " + ReflectionHelper.getAccessibleObjectDescription(this.field, false));
            }
            this.field.set(obj, obj2);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        public void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            Object objInvoke;
            if (this.serialized) {
                if (z) {
                    Method method = method;
                    if (method == null) {
                        ReflectiveTypeAdapterFactory.checkAccessible(obj, this.field);
                    } else {
                        ReflectiveTypeAdapterFactory.checkAccessible(obj, method);
                    }
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        objInvoke = method2.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e10) {
                        throw new JsonIOException("Accessor " + ReflectionHelper.getAccessibleObjectDescription(method, false) + " threw exception", e10.getCause());
                    }
                } else {
                    objInvoke = this.field.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                jsonWriter.name(this.name);
                (z ? typeAdapter : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, typeToken.getType())).write(jsonWriter, objInvoke);
            }
        }
    }

    public static abstract class Adapter<T, A> extends TypeAdapter<T> {
        final Map<String, BoundField> boundFields;

        public Adapter(Map<String, BoundField> map) {
            this.boundFields = map;
        }

        public abstract A createAccumulator();

        public abstract T finalize(A a10);

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            A aCreateAccumulator = createAccumulator();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        readField(aCreateAccumulator, jsonReader, boundField);
                    }
                }
                jsonReader.endObject();
                return finalize(aCreateAccumulator);
            } catch (IllegalAccessException e10) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e10);
            } catch (IllegalStateException e11) {
                throw new JsonSyntaxException(e11);
            }
        }

        public abstract void readField(A a10, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException;

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t10) throws IOException {
            if (t10 == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                Iterator<BoundField> it = this.boundFields.values().iterator();
                while (it.hasNext()) {
                    it.next().write(jsonWriter, t10);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e10) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e10);
            }
        }
    }

    public static abstract class BoundField {
        final boolean deserialized;
        final Field field;
        final String fieldName;
        final String name;
        final boolean serialized;

        public BoundField(String str, Field field, boolean z10, boolean z11) {
            this.name = str;
            this.field = field;
            this.fieldName = field.getName();
            this.serialized = z10;
            this.deserialized = z11;
        }

        public abstract void readIntoArray(JsonReader jsonReader, int i10, Object[] objArr) throws JsonParseException, IOException;

        public abstract void readIntoField(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException;

        public abstract void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException;
    }

    public static final class FieldReflectionAdapter<T> extends Adapter<T, T> {
        private final ObjectConstructor<T> constructor;

        public FieldReflectionAdapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            super(map);
            this.constructor = objectConstructor;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public T createAccumulator() {
            return this.constructor.construct();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public T finalize(T t10) {
            return t10;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public void readField(T t10, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException {
            boundField.readIntoField(jsonReader, t10);
        }
    }

    public static final class RecordAdapter<T> extends Adapter<T, Object[]> {
        static final Map<Class<?>, Object> PRIMITIVE_DEFAULTS = primitiveDefaults();
        private final Map<String, Integer> componentIndices;
        private final Constructor<T> constructor;
        private final Object[] constructorArgsDefaults;

        public RecordAdapter(Class<T> cls, Map<String, BoundField> map, boolean z10) throws JsonIOException, SecurityException {
            super(map);
            this.componentIndices = new HashMap();
            Constructor<T> canonicalRecordConstructor = ReflectionHelper.getCanonicalRecordConstructor(cls);
            this.constructor = canonicalRecordConstructor;
            if (z10) {
                ReflectiveTypeAdapterFactory.checkAccessible(null, canonicalRecordConstructor);
            } else {
                ReflectionHelper.makeAccessible(canonicalRecordConstructor);
            }
            String[] recordComponentNames = ReflectionHelper.getRecordComponentNames(cls);
            for (int i10 = 0; i10 < recordComponentNames.length; i10++) {
                this.componentIndices.put(recordComponentNames[i10], Integer.valueOf(i10));
            }
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            this.constructorArgsDefaults = new Object[parameterTypes.length];
            for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                this.constructorArgsDefaults[i11] = PRIMITIVE_DEFAULTS.get(parameterTypes[i11]);
            }
        }

        private static Map<Class<?>, Object> primitiveDefaults() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            return map;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public Object[] createAccumulator() {
            return (Object[]) this.constructorArgsDefaults.clone();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public T finalize(Object[] objArr) {
            try {
                return this.constructor.newInstance(objArr);
            } catch (IllegalAccessException e10) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e10);
            } catch (IllegalArgumentException | InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objArr), e12.getCause());
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public void readField(Object[] objArr, JsonReader jsonReader, BoundField boundField) throws JsonParseException, IOException {
            Integer num = this.componentIndices.get(boundField.fieldName);
            if (num != null) {
                boundField.readIntoArray(jsonReader, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' for field with name '" + boundField.fieldName + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<ReflectionAccessFilter> list) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        this.reflectionFilters = list;
    }

    public static <M extends AccessibleObject & Member> void checkAccessible(Object obj, M m10) {
        if (Modifier.isStatic(m10.getModifiers())) {
            obj = null;
        }
        if (ReflectionAccessFilterHelper.canAccess(m10, obj)) {
            return;
        }
        throw new JsonIOException(ReflectionHelper.getAccessibleObjectDescription(m10, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private BoundField createBoundField(Gson gson, Field field, Method method, String str, TypeToken<?> typeToken, boolean z10, boolean z11, boolean z12) {
        boolean zIsPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        int modifiers = field.getModifiers();
        boolean z13 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter) : null;
        boolean z14 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        return new BoundField(str, field, z10, z11) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            final /* synthetic */ Method val$accessor;
            final /* synthetic */ boolean val$blockInaccessible;
            final /* synthetic */ Gson val$context;
            final /* synthetic */ TypeToken val$fieldType;
            final /* synthetic */ boolean val$isPrimitive;
            final /* synthetic */ boolean val$isStaticFinalField;
            final /* synthetic */ boolean val$jsonAdapterPresent;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C20391(String str2, Field field2, boolean z102, boolean z112, boolean z122, Method method2, boolean z142, TypeAdapter typeAdapter2, Gson gson2, TypeToken typeToken2, boolean zIsPrimitive2, boolean z132) {
                super(str2, field2, z102, z112);
                z = z122;
                method = method2;
                z = z142;
                typeAdapter = typeAdapter2;
                gson = gson2;
                typeToken = typeToken2;
                z = zIsPrimitive2;
                z = z132;
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public void readIntoArray(JsonReader jsonReader, int i10, Object[] objArr) throws JsonParseException, IOException {
                Object obj = typeAdapter.read2(jsonReader);
                if (obj != null || !z) {
                    objArr[i10] = obj;
                    return;
                }
                throw new JsonParseException("null is not allowed as value for record component '" + this.fieldName + "' of primitive type; at path " + jsonReader.getPath());
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public void readIntoField(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
                Object obj2 = typeAdapter.read2(jsonReader);
                if (obj2 == null && z) {
                    return;
                }
                if (z) {
                    ReflectiveTypeAdapterFactory.checkAccessible(obj, this.field);
                } else if (z) {
                    throw new JsonIOException("Cannot set value of 'static final' " + ReflectionHelper.getAccessibleObjectDescription(this.field, false));
                }
                this.field.set(obj, obj2);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                Object objInvoke;
                if (this.serialized) {
                    if (z) {
                        Method method2 = method;
                        if (method2 == null) {
                            ReflectiveTypeAdapterFactory.checkAccessible(obj, this.field);
                        } else {
                            ReflectiveTypeAdapterFactory.checkAccessible(obj, method2);
                        }
                    }
                    Method method22 = method;
                    if (method22 != null) {
                        try {
                            objInvoke = method22.invoke(obj, new Object[0]);
                        } catch (InvocationTargetException e10) {
                            throw new JsonIOException("Accessor " + ReflectionHelper.getAccessibleObjectDescription(method, false) + " threw exception", e10.getCause());
                        }
                    } else {
                        objInvoke = this.field.get(obj);
                    }
                    if (objInvoke == obj) {
                        return;
                    }
                    jsonWriter.name(this.name);
                    (z ? typeAdapter : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, typeToken.getType())).write(jsonWriter, objInvoke);
                }
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls, boolean z10, boolean z11) throws JsonIOException, SecurityException {
        boolean z12;
        Method method;
        int i10;
        int i11;
        boolean z13;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        TypeToken<?> typeToken2 = typeToken;
        boolean z14 = z10;
        Class<?> rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            boolean z15 = true;
            boolean z16 = false;
            if (rawType != cls && declaredFields.length > 0) {
                ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(reflectiveTypeAdapterFactory.reflectionFilters, rawType);
                if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                    throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                z14 = filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
            }
            boolean z17 = z14;
            int length = declaredFields.length;
            int i12 = 0;
            while (i12 < length) {
                Field field = declaredFields[i12];
                boolean zIncludeField = reflectiveTypeAdapterFactory.includeField(field, z15);
                boolean zIncludeField2 = reflectiveTypeAdapterFactory.includeField(field, z16);
                if (zIncludeField || zIncludeField2) {
                    BoundField boundField = null;
                    if (!z11) {
                        z12 = zIncludeField2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z12 = z16;
                    } else {
                        Method accessor = ReflectionHelper.getAccessor(rawType, field);
                        if (!z17) {
                            ReflectionHelper.makeAccessible(accessor);
                        }
                        if (accessor.getAnnotation(SerializedName.class) != null && field.getAnnotation(SerializedName.class) == null) {
                            throw new JsonIOException("@SerializedName on " + ReflectionHelper.getAccessibleObjectDescription(accessor, z16) + " is not supported");
                        }
                        z12 = zIncludeField2;
                        method = accessor;
                    }
                    if (!z17 && method == null) {
                        ReflectionHelper.makeAccessible(field);
                    }
                    Type typeResolve = C$Gson$Types.resolve(typeToken2.getType(), rawType, field.getGenericType());
                    List<String> fieldNames = reflectiveTypeAdapterFactory.getFieldNames(field);
                    int size = fieldNames.size();
                    ?? r12 = z16;
                    while (r12 < size) {
                        String str = fieldNames.get(r12);
                        boolean z18 = r12 != 0 ? z16 : zIncludeField;
                        int i13 = r12;
                        BoundField boundField2 = boundField;
                        int i14 = size;
                        List<String> list = fieldNames;
                        Field field2 = field;
                        int i15 = i12;
                        int i16 = length;
                        boolean z19 = z16;
                        boundField = boundField2 == null ? (BoundField) linkedHashMap.put(str, createBoundField(gson, field, method, str, TypeToken.get(typeResolve), z18, z12, z17)) : boundField2;
                        zIncludeField = z18;
                        i12 = i15;
                        size = i14;
                        fieldNames = list;
                        field = field2;
                        length = i16;
                        z16 = z19;
                        r12 = i13 + 1;
                    }
                    BoundField boundField3 = boundField;
                    Field field3 = field;
                    i10 = i12;
                    i11 = length;
                    z13 = z16;
                    if (boundField3 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + boundField3.name + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(boundField3.field) + " and " + ReflectionHelper.fieldToString(field3));
                    }
                } else {
                    i10 = i12;
                    i11 = length;
                    z13 = z16;
                }
                i12 = i10 + 1;
                z15 = true;
                reflectiveTypeAdapterFactory = this;
                length = i11;
                z16 = z13;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = typeToken2.getRawType();
            reflectiveTypeAdapterFactory = this;
            z14 = z17;
        }
        return linkedHashMap;
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String strValue = serializedName.value();
        String[] strArrAlternate = serializedName.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    private boolean includeField(Field field, boolean z10) {
        return (this.excluder.excludeClass(field.getType(), z10) || this.excluder.excludeField(field, z10)) ? false : true;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        if (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            boolean z10 = filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
            return ReflectionHelper.isRecord(rawType) ? new RecordAdapter(rawType, getBoundFields(gson, typeToken, rawType, z10, true), z10) : new FieldReflectionAdapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType, z10, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}

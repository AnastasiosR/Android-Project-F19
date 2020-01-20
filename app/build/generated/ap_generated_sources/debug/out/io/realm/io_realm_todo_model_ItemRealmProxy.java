package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class io_realm_todo_model_ItemRealmProxy extends io.realm.todo.model.Item
    implements RealmObjectProxy, io_realm_todo_model_ItemRealmProxyInterface {

    static final class ItemColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long itemIdIndex;
        long bodyIndex;
        long isDoneIndex;
        long timestampIndex;

        ItemColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Item");
            this.itemIdIndex = addColumnDetails("itemId", "itemId", objectSchemaInfo);
            this.bodyIndex = addColumnDetails("body", "body", objectSchemaInfo);
            this.isDoneIndex = addColumnDetails("isDone", "isDone", objectSchemaInfo);
            this.timestampIndex = addColumnDetails("timestamp", "timestamp", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ItemColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ItemColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ItemColumnInfo src = (ItemColumnInfo) rawSrc;
            final ItemColumnInfo dst = (ItemColumnInfo) rawDst;
            dst.itemIdIndex = src.itemIdIndex;
            dst.bodyIndex = src.bodyIndex;
            dst.isDoneIndex = src.isDoneIndex;
            dst.timestampIndex = src.timestampIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ItemColumnInfo columnInfo;
    private ProxyState<io.realm.todo.model.Item> proxyState;

    io_realm_todo_model_ItemRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ItemColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<io.realm.todo.model.Item>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$itemId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.itemIdIndex);
    }

    @Override
    public void realmSet$itemId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'itemId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$body() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.bodyIndex);
    }

    @Override
    public void realmSet$body(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'body' to null.");
            }
            row.getTable().setString(columnInfo.bodyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'body' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.bodyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Boolean realmGet$isDone() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isDoneIndex);
    }

    @Override
    public void realmSet$isDone(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isDone' to null.");
            }
            row.getTable().setBoolean(columnInfo.isDoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'isDone' to null.");
        }
        proxyState.getRow$realm().setBoolean(columnInfo.isDoneIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$timestamp() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.timestampIndex);
    }

    @Override
    public void realmSet$timestamp(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timestamp' to null.");
            }
            row.getTable().setDate(columnInfo.timestampIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'timestamp' to null.");
        }
        proxyState.getRow$realm().setDate(columnInfo.timestampIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Item", 4, 0);
        builder.addPersistedProperty("itemId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("body", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isDone", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("timestamp", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ItemColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ItemColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Item";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Item";
    }

    @SuppressWarnings("cast")
    public static io.realm.todo.model.Item createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        io.realm.todo.model.Item obj = null;
        if (update) {
            Table table = realm.getTable(io.realm.todo.model.Item.class);
            ItemColumnInfo columnInfo = (ItemColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Item.class);
            long pkColumnIndex = columnInfo.itemIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("itemId")) {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("itemId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(io.realm.todo.model.Item.class), false, Collections.<String> emptyList());
                    obj = new io.realm.io_realm_todo_model_ItemRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("itemId")) {
                if (json.isNull("itemId")) {
                    obj = (io.realm.io_realm_todo_model_ItemRealmProxy) realm.createObjectInternal(io.realm.todo.model.Item.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.io_realm_todo_model_ItemRealmProxy) realm.createObjectInternal(io.realm.todo.model.Item.class, json.getString("itemId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'itemId'.");
            }
        }

        final io_realm_todo_model_ItemRealmProxyInterface objProxy = (io_realm_todo_model_ItemRealmProxyInterface) obj;
        if (json.has("body")) {
            if (json.isNull("body")) {
                objProxy.realmSet$body(null);
            } else {
                objProxy.realmSet$body((String) json.getString("body"));
            }
        }
        if (json.has("isDone")) {
            if (json.isNull("isDone")) {
                objProxy.realmSet$isDone(null);
            } else {
                objProxy.realmSet$isDone((boolean) json.getBoolean("isDone"));
            }
        }
        if (json.has("timestamp")) {
            if (json.isNull("timestamp")) {
                objProxy.realmSet$timestamp(null);
            } else {
                Object timestamp = json.get("timestamp");
                if (timestamp instanceof String) {
                    objProxy.realmSet$timestamp(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$timestamp(new Date(json.getLong("timestamp")));
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static io.realm.todo.model.Item createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final io.realm.todo.model.Item obj = new io.realm.todo.model.Item();
        final io_realm_todo_model_ItemRealmProxyInterface objProxy = (io_realm_todo_model_ItemRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("itemId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$itemId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$itemId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("body")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$body((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$body(null);
                }
            } else if (name.equals("isDone")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isDone((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$isDone(null);
                }
            } else if (name.equals("timestamp")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$timestamp(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$timestamp(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$timestamp(JsonUtils.stringToDate(reader.nextString()));
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'itemId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static io_realm_todo_model_ItemRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(io.realm.todo.model.Item.class), false, Collections.<String>emptyList());
        io.realm.io_realm_todo_model_ItemRealmProxy obj = new io.realm.io_realm_todo_model_ItemRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static io.realm.todo.model.Item copyOrUpdate(Realm realm, ItemColumnInfo columnInfo, io.realm.todo.model.Item object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (io.realm.todo.model.Item) cachedRealmObject;
        }

        io.realm.todo.model.Item realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(io.realm.todo.model.Item.class);
            long pkColumnIndex = columnInfo.itemIdIndex;
            long rowIndex = table.findFirstString(pkColumnIndex, ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$itemId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.io_realm_todo_model_ItemRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static io.realm.todo.model.Item copy(Realm realm, ItemColumnInfo columnInfo, io.realm.todo.model.Item newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (io.realm.todo.model.Item) cachedRealmObject;
        }

        io_realm_todo_model_ItemRealmProxyInterface realmObjectSource = (io_realm_todo_model_ItemRealmProxyInterface) newObject;

        Table table = realm.getTable(io.realm.todo.model.Item.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.itemIdIndex, realmObjectSource.realmGet$itemId());
        builder.addString(columnInfo.bodyIndex, realmObjectSource.realmGet$body());
        builder.addBoolean(columnInfo.isDoneIndex, realmObjectSource.realmGet$isDone());
        builder.addDate(columnInfo.timestampIndex, realmObjectSource.realmGet$timestamp());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.io_realm_todo_model_ItemRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, io.realm.todo.model.Item object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(io.realm.todo.model.Item.class);
        long tableNativePtr = table.getNativePtr();
        ItemColumnInfo columnInfo = (ItemColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Item.class);
        long pkColumnIndex = columnInfo.itemIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$itemId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$body = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$body();
        if (realmGet$body != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bodyIndex, rowIndex, realmGet$body, false);
        }
        Boolean realmGet$isDone = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$isDone();
        if (realmGet$isDone != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isDoneIndex, rowIndex, realmGet$isDone, false);
        }
        java.util.Date realmGet$timestamp = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$timestamp();
        if (realmGet$timestamp != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(io.realm.todo.model.Item.class);
        long tableNativePtr = table.getNativePtr();
        ItemColumnInfo columnInfo = (ItemColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Item.class);
        long pkColumnIndex = columnInfo.itemIdIndex;
        io.realm.todo.model.Item object = null;
        while (objects.hasNext()) {
            object = (io.realm.todo.model.Item) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$itemId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$body = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$body();
            if (realmGet$body != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.bodyIndex, rowIndex, realmGet$body, false);
            }
            Boolean realmGet$isDone = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$isDone();
            if (realmGet$isDone != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isDoneIndex, rowIndex, realmGet$isDone, false);
            }
            java.util.Date realmGet$timestamp = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$timestamp();
            if (realmGet$timestamp != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, io.realm.todo.model.Item object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(io.realm.todo.model.Item.class);
        long tableNativePtr = table.getNativePtr();
        ItemColumnInfo columnInfo = (ItemColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Item.class);
        long pkColumnIndex = columnInfo.itemIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$itemId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$body = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$body();
        if (realmGet$body != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bodyIndex, rowIndex, realmGet$body, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.bodyIndex, rowIndex, false);
        }
        Boolean realmGet$isDone = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$isDone();
        if (realmGet$isDone != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isDoneIndex, rowIndex, realmGet$isDone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.isDoneIndex, rowIndex, false);
        }
        java.util.Date realmGet$timestamp = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$timestamp();
        if (realmGet$timestamp != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.timestampIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(io.realm.todo.model.Item.class);
        long tableNativePtr = table.getNativePtr();
        ItemColumnInfo columnInfo = (ItemColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Item.class);
        long pkColumnIndex = columnInfo.itemIdIndex;
        io.realm.todo.model.Item object = null;
        while (objects.hasNext()) {
            object = (io.realm.todo.model.Item) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$itemId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$body = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$body();
            if (realmGet$body != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.bodyIndex, rowIndex, realmGet$body, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.bodyIndex, rowIndex, false);
            }
            Boolean realmGet$isDone = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$isDone();
            if (realmGet$isDone != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isDoneIndex, rowIndex, realmGet$isDone, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.isDoneIndex, rowIndex, false);
            }
            java.util.Date realmGet$timestamp = ((io_realm_todo_model_ItemRealmProxyInterface) object).realmGet$timestamp();
            if (realmGet$timestamp != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.timestampIndex, rowIndex, false);
            }
        }
    }

    public static io.realm.todo.model.Item createDetachedCopy(io.realm.todo.model.Item realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        io.realm.todo.model.Item unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new io.realm.todo.model.Item();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (io.realm.todo.model.Item) cachedObject.object;
            }
            unmanagedObject = (io.realm.todo.model.Item) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        io_realm_todo_model_ItemRealmProxyInterface unmanagedCopy = (io_realm_todo_model_ItemRealmProxyInterface) unmanagedObject;
        io_realm_todo_model_ItemRealmProxyInterface realmSource = (io_realm_todo_model_ItemRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$itemId(realmSource.realmGet$itemId());
        unmanagedCopy.realmSet$body(realmSource.realmGet$body());
        unmanagedCopy.realmSet$isDone(realmSource.realmGet$isDone());
        unmanagedCopy.realmSet$timestamp(realmSource.realmGet$timestamp());

        return unmanagedObject;
    }

    static io.realm.todo.model.Item update(Realm realm, ItemColumnInfo columnInfo, io.realm.todo.model.Item realmObject, io.realm.todo.model.Item newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        io_realm_todo_model_ItemRealmProxyInterface realmObjectTarget = (io_realm_todo_model_ItemRealmProxyInterface) realmObject;
        io_realm_todo_model_ItemRealmProxyInterface realmObjectSource = (io_realm_todo_model_ItemRealmProxyInterface) newObject;
        Table table = realm.getTable(io.realm.todo.model.Item.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.itemIdIndex, realmObjectSource.realmGet$itemId());
        builder.addString(columnInfo.bodyIndex, realmObjectSource.realmGet$body());
        builder.addBoolean(columnInfo.isDoneIndex, realmObjectSource.realmGet$isDone());
        builder.addDate(columnInfo.timestampIndex, realmObjectSource.realmGet$timestamp());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Item = proxy[");
        stringBuilder.append("{itemId:");
        stringBuilder.append(realmGet$itemId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{body:");
        stringBuilder.append(realmGet$body());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isDone:");
        stringBuilder.append(realmGet$isDone());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timestamp:");
        stringBuilder.append(realmGet$timestamp());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        io_realm_todo_model_ItemRealmProxy aItem = (io_realm_todo_model_ItemRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aItem.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aItem.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aItem.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}

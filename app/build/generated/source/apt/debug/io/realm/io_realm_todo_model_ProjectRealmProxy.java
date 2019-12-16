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
public class io_realm_todo_model_ProjectRealmProxy extends io.realm.todo.model.Project
    implements RealmObjectProxy, io_realm_todo_model_ProjectRealmProxyInterface {

    static final class ProjectColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long projectIdIndex;
        long ownerIndex;
        long nameIndex;
        long timestampIndex;
        long itemsIndex;

        ProjectColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Project");
            this.projectIdIndex = addColumnDetails("projectId", "projectId", objectSchemaInfo);
            this.ownerIndex = addColumnDetails("owner", "owner", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.timestampIndex = addColumnDetails("timestamp", "timestamp", objectSchemaInfo);
            this.itemsIndex = addColumnDetails("items", "items", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ProjectColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ProjectColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ProjectColumnInfo src = (ProjectColumnInfo) rawSrc;
            final ProjectColumnInfo dst = (ProjectColumnInfo) rawDst;
            dst.projectIdIndex = src.projectIdIndex;
            dst.ownerIndex = src.ownerIndex;
            dst.nameIndex = src.nameIndex;
            dst.timestampIndex = src.timestampIndex;
            dst.itemsIndex = src.itemsIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ProjectColumnInfo columnInfo;
    private ProxyState<io.realm.todo.model.Project> proxyState;
    private RealmList<io.realm.todo.model.Item> itemsRealmList;

    io_realm_todo_model_ProjectRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProjectColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<io.realm.todo.model.Project>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$projectId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.projectIdIndex);
    }

    @Override
    public void realmSet$projectId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'projectId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$owner() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ownerIndex);
    }

    @Override
    public void realmSet$owner(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'owner' to null.");
            }
            row.getTable().setString(columnInfo.ownerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'owner' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.ownerIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'name' to null.");
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'name' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
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

    @Override
    public RealmList<io.realm.todo.model.Item> realmGet$items() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (itemsRealmList != null) {
            return itemsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.itemsIndex);
            itemsRealmList = new RealmList<io.realm.todo.model.Item>(io.realm.todo.model.Item.class, osList, proxyState.getRealm$realm());
            return itemsRealmList;
        }
    }

    @Override
    public void realmSet$items(RealmList<io.realm.todo.model.Item> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("items")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<io.realm.todo.model.Item> original = value;
                value = new RealmList<io.realm.todo.model.Item>();
                for (io.realm.todo.model.Item item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.itemsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                io.realm.todo.model.Item linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                io.realm.todo.model.Item linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Project", 5, 0);
        builder.addPersistedProperty("projectId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("owner", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("timestamp", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("items", RealmFieldType.LIST, "Item");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ProjectColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ProjectColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Project";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Project";
    }

    @SuppressWarnings("cast")
    public static io.realm.todo.model.Project createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        io.realm.todo.model.Project obj = null;
        if (update) {
            Table table = realm.getTable(io.realm.todo.model.Project.class);
            ProjectColumnInfo columnInfo = (ProjectColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Project.class);
            long pkColumnIndex = columnInfo.projectIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("projectId")) {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("projectId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(io.realm.todo.model.Project.class), false, Collections.<String> emptyList());
                    obj = new io.realm.io_realm_todo_model_ProjectRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("items")) {
                excludeFields.add("items");
            }
            if (json.has("projectId")) {
                if (json.isNull("projectId")) {
                    obj = (io.realm.io_realm_todo_model_ProjectRealmProxy) realm.createObjectInternal(io.realm.todo.model.Project.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.io_realm_todo_model_ProjectRealmProxy) realm.createObjectInternal(io.realm.todo.model.Project.class, json.getString("projectId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'projectId'.");
            }
        }

        final io_realm_todo_model_ProjectRealmProxyInterface objProxy = (io_realm_todo_model_ProjectRealmProxyInterface) obj;
        if (json.has("owner")) {
            if (json.isNull("owner")) {
                objProxy.realmSet$owner(null);
            } else {
                objProxy.realmSet$owner((String) json.getString("owner"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
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
        if (json.has("items")) {
            if (json.isNull("items")) {
                objProxy.realmSet$items(null);
            } else {
                objProxy.realmGet$items().clear();
                JSONArray array = json.getJSONArray("items");
                for (int i = 0; i < array.length(); i++) {
                    io.realm.todo.model.Item item = io_realm_todo_model_ItemRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$items().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static io.realm.todo.model.Project createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final io.realm.todo.model.Project obj = new io.realm.todo.model.Project();
        final io_realm_todo_model_ProjectRealmProxyInterface objProxy = (io_realm_todo_model_ProjectRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("projectId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$projectId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$projectId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("owner")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$owner((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$owner(null);
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
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
            } else if (name.equals("items")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$items(null);
                } else {
                    objProxy.realmSet$items(new RealmList<io.realm.todo.model.Item>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        io.realm.todo.model.Item item = io_realm_todo_model_ItemRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$items().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'projectId'.");
        }
        return realm.copyToRealm(obj);
    }

    private static io_realm_todo_model_ProjectRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(io.realm.todo.model.Project.class), false, Collections.<String>emptyList());
        io.realm.io_realm_todo_model_ProjectRealmProxy obj = new io.realm.io_realm_todo_model_ProjectRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static io.realm.todo.model.Project copyOrUpdate(Realm realm, ProjectColumnInfo columnInfo, io.realm.todo.model.Project object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (io.realm.todo.model.Project) cachedRealmObject;
        }

        io.realm.todo.model.Project realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(io.realm.todo.model.Project.class);
            long pkColumnIndex = columnInfo.projectIdIndex;
            long rowIndex = table.findFirstString(pkColumnIndex, ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$projectId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.io_realm_todo_model_ProjectRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static io.realm.todo.model.Project copy(Realm realm, ProjectColumnInfo columnInfo, io.realm.todo.model.Project newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (io.realm.todo.model.Project) cachedRealmObject;
        }

        io_realm_todo_model_ProjectRealmProxyInterface realmObjectSource = (io_realm_todo_model_ProjectRealmProxyInterface) newObject;

        Table table = realm.getTable(io.realm.todo.model.Project.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.projectIdIndex, realmObjectSource.realmGet$projectId());
        builder.addString(columnInfo.ownerIndex, realmObjectSource.realmGet$owner());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addDate(columnInfo.timestampIndex, realmObjectSource.realmGet$timestamp());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.io_realm_todo_model_ProjectRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<io.realm.todo.model.Item> itemsList = realmObjectSource.realmGet$items();
        if (itemsList != null) {
            RealmList<io.realm.todo.model.Item> itemsRealmList = realmObjectCopy.realmGet$items();
            itemsRealmList.clear();
            for (int i = 0; i < itemsList.size(); i++) {
                io.realm.todo.model.Item itemsItem = itemsList.get(i);
                io.realm.todo.model.Item cacheitems = (io.realm.todo.model.Item) cache.get(itemsItem);
                if (cacheitems != null) {
                    itemsRealmList.add(cacheitems);
                } else {
                    itemsRealmList.add(io_realm_todo_model_ItemRealmProxy.copyOrUpdate(realm, (io_realm_todo_model_ItemRealmProxy.ItemColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Item.class), itemsItem, update, cache, flags));
                }
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, io.realm.todo.model.Project object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(io.realm.todo.model.Project.class);
        long tableNativePtr = table.getNativePtr();
        ProjectColumnInfo columnInfo = (ProjectColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Project.class);
        long pkColumnIndex = columnInfo.projectIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$projectId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$owner = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$owner();
        if (realmGet$owner != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ownerIndex, rowIndex, realmGet$owner, false);
        }
        String realmGet$name = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        java.util.Date realmGet$timestamp = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$timestamp();
        if (realmGet$timestamp != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
        }

        RealmList<io.realm.todo.model.Item> itemsList = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$items();
        if (itemsList != null) {
            OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
            for (io.realm.todo.model.Item itemsItem : itemsList) {
                Long cacheItemIndexitems = cache.get(itemsItem);
                if (cacheItemIndexitems == null) {
                    cacheItemIndexitems = io_realm_todo_model_ItemRealmProxy.insert(realm, itemsItem, cache);
                }
                itemsOsList.addRow(cacheItemIndexitems);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(io.realm.todo.model.Project.class);
        long tableNativePtr = table.getNativePtr();
        ProjectColumnInfo columnInfo = (ProjectColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Project.class);
        long pkColumnIndex = columnInfo.projectIdIndex;
        io.realm.todo.model.Project object = null;
        while (objects.hasNext()) {
            object = (io.realm.todo.model.Project) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$projectId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$owner = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$owner();
            if (realmGet$owner != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ownerIndex, rowIndex, realmGet$owner, false);
            }
            String realmGet$name = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            java.util.Date realmGet$timestamp = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$timestamp();
            if (realmGet$timestamp != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
            }

            RealmList<io.realm.todo.model.Item> itemsList = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$items();
            if (itemsList != null) {
                OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
                for (io.realm.todo.model.Item itemsItem : itemsList) {
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = io_realm_todo_model_ItemRealmProxy.insert(realm, itemsItem, cache);
                    }
                    itemsOsList.addRow(cacheItemIndexitems);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, io.realm.todo.model.Project object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(io.realm.todo.model.Project.class);
        long tableNativePtr = table.getNativePtr();
        ProjectColumnInfo columnInfo = (ProjectColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Project.class);
        long pkColumnIndex = columnInfo.projectIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$projectId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$owner = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$owner();
        if (realmGet$owner != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ownerIndex, rowIndex, realmGet$owner, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ownerIndex, rowIndex, false);
        }
        String realmGet$name = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        java.util.Date realmGet$timestamp = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$timestamp();
        if (realmGet$timestamp != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.timestampIndex, rowIndex, false);
        }

        OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
        RealmList<io.realm.todo.model.Item> itemsList = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$items();
        if (itemsList != null && itemsList.size() == itemsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = itemsList.size();
            for (int i = 0; i < objects; i++) {
                io.realm.todo.model.Item itemsItem = itemsList.get(i);
                Long cacheItemIndexitems = cache.get(itemsItem);
                if (cacheItemIndexitems == null) {
                    cacheItemIndexitems = io_realm_todo_model_ItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                }
                itemsOsList.setRow(i, cacheItemIndexitems);
            }
        } else {
            itemsOsList.removeAll();
            if (itemsList != null) {
                for (io.realm.todo.model.Item itemsItem : itemsList) {
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = io_realm_todo_model_ItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                    }
                    itemsOsList.addRow(cacheItemIndexitems);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(io.realm.todo.model.Project.class);
        long tableNativePtr = table.getNativePtr();
        ProjectColumnInfo columnInfo = (ProjectColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Project.class);
        long pkColumnIndex = columnInfo.projectIdIndex;
        io.realm.todo.model.Project object = null;
        while (objects.hasNext()) {
            object = (io.realm.todo.model.Project) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$projectId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$owner = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$owner();
            if (realmGet$owner != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ownerIndex, rowIndex, realmGet$owner, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ownerIndex, rowIndex, false);
            }
            String realmGet$name = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            java.util.Date realmGet$timestamp = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$timestamp();
            if (realmGet$timestamp != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.timestampIndex, rowIndex, false);
            }

            OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
            RealmList<io.realm.todo.model.Item> itemsList = ((io_realm_todo_model_ProjectRealmProxyInterface) object).realmGet$items();
            if (itemsList != null && itemsList.size() == itemsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = itemsList.size();
                for (int i = 0; i < objectCount; i++) {
                    io.realm.todo.model.Item itemsItem = itemsList.get(i);
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = io_realm_todo_model_ItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                    }
                    itemsOsList.setRow(i, cacheItemIndexitems);
                }
            } else {
                itemsOsList.removeAll();
                if (itemsList != null) {
                    for (io.realm.todo.model.Item itemsItem : itemsList) {
                        Long cacheItemIndexitems = cache.get(itemsItem);
                        if (cacheItemIndexitems == null) {
                            cacheItemIndexitems = io_realm_todo_model_ItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                        }
                        itemsOsList.addRow(cacheItemIndexitems);
                    }
                }
            }

        }
    }

    public static io.realm.todo.model.Project createDetachedCopy(io.realm.todo.model.Project realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        io.realm.todo.model.Project unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new io.realm.todo.model.Project();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (io.realm.todo.model.Project) cachedObject.object;
            }
            unmanagedObject = (io.realm.todo.model.Project) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        io_realm_todo_model_ProjectRealmProxyInterface unmanagedCopy = (io_realm_todo_model_ProjectRealmProxyInterface) unmanagedObject;
        io_realm_todo_model_ProjectRealmProxyInterface realmSource = (io_realm_todo_model_ProjectRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$projectId(realmSource.realmGet$projectId());
        unmanagedCopy.realmSet$owner(realmSource.realmGet$owner());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$timestamp(realmSource.realmGet$timestamp());

        // Deep copy of items
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$items(null);
        } else {
            RealmList<io.realm.todo.model.Item> manageditemsList = realmSource.realmGet$items();
            RealmList<io.realm.todo.model.Item> unmanageditemsList = new RealmList<io.realm.todo.model.Item>();
            unmanagedCopy.realmSet$items(unmanageditemsList);
            int nextDepth = currentDepth + 1;
            int size = manageditemsList.size();
            for (int i = 0; i < size; i++) {
                io.realm.todo.model.Item item = io_realm_todo_model_ItemRealmProxy.createDetachedCopy(manageditemsList.get(i), nextDepth, maxDepth, cache);
                unmanageditemsList.add(item);
            }
        }

        return unmanagedObject;
    }

    static io.realm.todo.model.Project update(Realm realm, ProjectColumnInfo columnInfo, io.realm.todo.model.Project realmObject, io.realm.todo.model.Project newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        io_realm_todo_model_ProjectRealmProxyInterface realmObjectTarget = (io_realm_todo_model_ProjectRealmProxyInterface) realmObject;
        io_realm_todo_model_ProjectRealmProxyInterface realmObjectSource = (io_realm_todo_model_ProjectRealmProxyInterface) newObject;
        Table table = realm.getTable(io.realm.todo.model.Project.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addString(columnInfo.projectIdIndex, realmObjectSource.realmGet$projectId());
        builder.addString(columnInfo.ownerIndex, realmObjectSource.realmGet$owner());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addDate(columnInfo.timestampIndex, realmObjectSource.realmGet$timestamp());

        RealmList<io.realm.todo.model.Item> itemsList = realmObjectSource.realmGet$items();
        if (itemsList != null) {
            RealmList<io.realm.todo.model.Item> itemsManagedCopy = new RealmList<io.realm.todo.model.Item>();
            for (int i = 0; i < itemsList.size(); i++) {
                io.realm.todo.model.Item itemsItem = itemsList.get(i);
                io.realm.todo.model.Item cacheitems = (io.realm.todo.model.Item) cache.get(itemsItem);
                if (cacheitems != null) {
                    itemsManagedCopy.add(cacheitems);
                } else {
                    itemsManagedCopy.add(io_realm_todo_model_ItemRealmProxy.copyOrUpdate(realm, (io_realm_todo_model_ItemRealmProxy.ItemColumnInfo) realm.getSchema().getColumnInfo(io.realm.todo.model.Item.class), itemsItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.itemsIndex, itemsManagedCopy);
        } else {
            builder.addObjectList(columnInfo.itemsIndex, new RealmList<io.realm.todo.model.Item>());
        }

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Project = proxy[");
        stringBuilder.append("{projectId:");
        stringBuilder.append(realmGet$projectId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{owner:");
        stringBuilder.append(realmGet$owner());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timestamp:");
        stringBuilder.append(realmGet$timestamp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{items:");
        stringBuilder.append("RealmList<Item>[").append(realmGet$items().size()).append("]");
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
        io_realm_todo_model_ProjectRealmProxy aProject = (io_realm_todo_model_ProjectRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProject.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProject.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProject.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}

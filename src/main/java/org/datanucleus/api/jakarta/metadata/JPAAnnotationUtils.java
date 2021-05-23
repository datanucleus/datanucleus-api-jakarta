/**********************************************************************
Copyright (c) 2007 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package org.datanucleus.api.jakarta.metadata;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Access;
import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AssociationOverrides;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Basic;
import jakarta.persistence.Cacheable;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Converter;
import jakarta.persistence.Converts;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ExcludeDefaultListeners;
import jakarta.persistence.ExcludeSuperclassListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKey;
import jakarta.persistence.MapKeyClass;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.MapKeyJoinColumns;
import jakarta.persistence.MapKeyTemporal;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumns;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.SqlResultSetMappings;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
import jakarta.persistence.Convert;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;

import org.datanucleus.api.jakarta.annotations.DatastoreId;
import org.datanucleus.api.jakarta.annotations.Extension;
import org.datanucleus.api.jakarta.annotations.Extensions;
import org.datanucleus.api.jakarta.annotations.NonDurableId;
import org.datanucleus.api.jakarta.annotations.PersistenceAware;
import org.datanucleus.api.jakarta.annotations.SurrogateVersion;
import org.datanucleus.metadata.ColumnMetaData;
import org.datanucleus.metadata.ValueGenerationStrategy;
import org.datanucleus.metadata.MetaData;
import org.datanucleus.metadata.annotations.Member;
import org.datanucleus.util.StringUtils;

/**
 * Series of utility methods for converting between JPA annotations and metadata.
 */
public class JPAAnnotationUtils
{
    public static final String ENTITY = Entity.class.getName();

    public static final String MAPPED_SUPERCLASS = MappedSuperclass.class.getName();

    public static final String EMBEDDABLE = Embeddable.class.getName();

    public static final String ACCESS = Access.class.getName();

    public static final String EMBEDDED = Embedded.class.getName();

    public static final String TABLE = Table.class.getName();

    public static final String COLUMN = Column.class.getName();

    public static final String ID_CLASS = IdClass.class.getName();

    public static final String ID = Id.class.getName();

    public static final String BASIC = Basic.class.getName();

    public static final String TRANSIENT = Transient.class.getName();

    public static final String ENUMERATED = Enumerated.class.getName();

    public static final String TEMPORAL = Temporal.class.getName();

    public static final String LOB = Lob.class.getName();

    public static final String VERSION = Version.class.getName();

    public static final String EMBEDDED_ID = EmbeddedId.class.getName();

    public static final String GENERATED_VALUE = GeneratedValue.class.getName();

    public static final String INHERITANCE = Inheritance.class.getName();

    public static final String DISCRIMINATOR_COLUMN = DiscriminatorColumn.class.getName();

    public static final String DISCRIMINATOR_VALUE = DiscriminatorValue.class.getName();

    public static final String ENTITY_LISTENERS = EntityListeners.class.getName();

    public static final String EXCLUDE_SUPERCLASS_LISTENERS = ExcludeSuperclassListeners.class.getName();

    public static final String EXCLUDE_DEFAULT_LISTENERS = ExcludeDefaultListeners.class.getName();

    public static final String SEQUENCE_GENERATOR = SequenceGenerator.class.getName();

    public static final String TABLE_GENERATOR = TableGenerator.class.getName();

    public static final String PRIMARY_KEY_JOIN_COLUMNS = PrimaryKeyJoinColumns.class.getName();

    public static final String PRIMARY_KEY_JOIN_COLUMN = PrimaryKeyJoinColumn.class.getName();

    public static final String ATTRIBUTE_OVERRIDES = AttributeOverrides.class.getName();

    public static final String ATTRIBUTE_OVERRIDE = AttributeOverride.class.getName();

    public static final String ASSOCIATION_OVERRIDES = AssociationOverrides.class.getName();

    public static final String ASSOCIATION_OVERRIDE = AssociationOverride.class.getName();

    public static final String NAMED_QUERIES = NamedQueries.class.getName();

    public static final String NAMED_QUERY = NamedQuery.class.getName();

    public static final String NAMED_NATIVE_QUERIES = NamedNativeQueries.class.getName();

    public static final String NAMED_NATIVE_QUERY = NamedNativeQuery.class.getName();

    public static final String NAMED_STOREDPROC_QUERIES = NamedStoredProcedureQueries.class.getName();

    public static final String NAMED_STOREDPROC_QUERY = NamedStoredProcedureQuery.class.getName();

    public static final String SQL_RESULTSET_MAPPINGS = SqlResultSetMappings.class.getName();

    public static final String SQL_RESULTSET_MAPPING = SqlResultSetMapping.class.getName();

    public static final String SECONDARY_TABLES = SecondaryTables.class.getName();

    public static final String SECONDARY_TABLE = SecondaryTable.class.getName();

    public static final String JOIN_TABLE = JoinTable.class.getName();

    public static final String MAP_KEY = MapKey.class.getName();

    public static final String MAP_KEY_COLUMN = MapKeyColumn.class.getName();
    
    public static final String MAP_KEY_JOIN_COLUMN = MapKeyJoinColumn.class.getName();
    
    public static final String MAP_KEY_JOIN_COLUMNS = MapKeyJoinColumns.class.getName();

    public static final String MAP_KEY_CLASS = MapKeyClass.class.getName();
    
    public static final String MAP_KEY_ENUMERATED = MapKeyEnumerated.class.getName();

    public static final String MAP_KEY_TEMPORAL = MapKeyTemporal.class.getName();

    public static final String MAPS_ID = MapsId.class.getName();

    public static final String ORDER_BY = OrderBy.class.getName();

    public static final String ONE_TO_ONE = OneToOne.class.getName();

    public static final String ONE_TO_MANY = OneToMany.class.getName();

    public static final String MANY_TO_ONE = ManyToOne.class.getName();

    public static final String MANY_TO_MANY = ManyToMany.class.getName();

    public static final String JOIN_COLUMNS = JoinColumns.class.getName();

    public static final String JOIN_COLUMN = JoinColumn.class.getName();

    public static final String PERSISTENCE_AWARE = PersistenceAware.class.getName();

    public static final String DATASTORE_IDENTITY = DatastoreId.class.getName();

    public static final String NONDURABLE_IDENTITY = NonDurableId.class.getName();

    public static final String SURROGATE_VERSION = SurrogateVersion.class.getName();

    public static final String EXTENSIONS = Extensions.class.getName();

    public static final String EXTENSION = Extension.class.getName();

    public static final String ELEMENT_COLLECTION = ElementCollection.class.getName();

    public static final String COLLECTION_TABLE = CollectionTable.class.getName();

    public static final String ORDER_COLUMN = OrderColumn.class.getName();

    public static final String CACHEABLE = Cacheable.class.getName();

    public static final String CONVERT = Convert.class.getName();

    public static final String CONVERTS = Converts.class.getName();

    public static final String CONVERTER = Converter.class.getName();

    public static final String NAMED_ENTITY_GRAPHS = NamedEntityGraphs.class.getName();

    public static final String NAMED_ENTITY_GRAPH = NamedEntityGraph.class.getName();

    public static final String NAMED_ATTRIBUTE_NODE = NamedAttributeNode.class.getName();

    /**
     * Convenience accessor for the string name of a value generator strategy (from JPA annotations)
     * @param type Generation type (strategy)
     * @return The name
     */
    public static String getValueGenerationStrategyString(GenerationType type)
    {
        if (type == GenerationType.AUTO)
        {
            return ValueGenerationStrategy.NATIVE.toString();
        }
        else if (type == GenerationType.IDENTITY)
        {
            return ValueGenerationStrategy.IDENTITY.toString();
        }
        else if (type == GenerationType.SEQUENCE)
        {
            return ValueGenerationStrategy.SEQUENCE.toString();
        }
        else if (type == GenerationType.TABLE)
        {
            return ValueGenerationStrategy.INCREMENT.toString();
        }
        else if (type.toString().equals("UUID")) // DN jakarta.persistence adds UUID
        {
            return ValueGenerationStrategy.UUID.toString();
        }
        else
        {
            return null;
        }
    }

    /**
     * Whether the given type is temporal for JPA.
     * @param type the type
     * @return true if the type is temporal as per JPA spec
     */
    public static boolean isTemporalType(Class type)
    {
        if (type == Date.class || type == java.sql.Date.class || type == Time.class || type == Timestamp.class ||
            type == Calendar.class)
        {
            return true;
        }
        return false;
    }

    /**
     * Method to create a ColumnMetaData based on the supplied Column annotation.
     * @param parent Parent MetaData object
     * @param field The field/property
     * @param column The Column annotation
     * @return MetaData for the column
     */
    static ColumnMetaData getColumnMetaDataForColumnAnnotation(MetaData parent, Member field, Column column)
    {
        String columnName = column.name();
        String target = null;
        String targetField = null;
        String jdbcType = null;
        String sqlType = null;
        String length = null;
        String scale = null;
        String allowsNull = null;
        String defaultValue = null;
        String insertValue = null;
        String insertable = null;
        String updateable = null;
        String unique = null;
        String table = null;

        if (field.getType().isPrimitive())
        {
            length = "" + column.precision();
            if (length.equals(""))
            {
                length = null;
            }
            scale = "" + column.scale();
            if (scale.equals(""))
            {
                scale = null;
            }
            if ((length == null || length.equals("0")) && char.class.isAssignableFrom(field.getType()))
            {
                // in the TCK, char is stored by default in a CHAR column with 1 length
                // if nothing defined, then default to this
                length = "1";
            }
            if (field.getType() == boolean.class)
            {
                jdbcType = "SMALLINT";
            }
        }
        else if (String.class.isAssignableFrom(field.getType()))
        {
            length = "" + column.length();
            if (length.equals(""))
            {
                length = null;
            }
        }
        else if (Number.class.isAssignableFrom(field.getType()))
        {
            length = "" + column.precision();
            if (length.equals(""))
            {
                length = null;
            }
            scale = "" + column.scale();
            if (scale.equals(""))
            {
                scale = null;
            }
        }
        allowsNull = Boolean.valueOf(column.nullable()).toString();
        insertable = Boolean.valueOf(column.insertable()).toString();
        updateable = Boolean.valueOf(column.updatable()).toString(); // Note : "updatable" is spelt incorrectly in the JPA spec.
        unique = Boolean.valueOf(column.unique()).toString();
        table = column.table();
        if (!StringUtils.isWhitespace(table))
        {
            // Column in secondary-table
            // TODO use this value
        }

        ColumnMetaData colmd = new ColumnMetaData();
        colmd.setName(columnName);
        colmd.setTarget(target);
        colmd.setTargetMember(targetField);
        colmd.setJdbcType(jdbcType);
        colmd.setSqlType(sqlType);
        colmd.setLength(length);
        colmd.setScale(scale);
        colmd.setAllowsNull(allowsNull);
        colmd.setDefaultValue(defaultValue);
        colmd.setInsertValue(insertValue);
        colmd.setInsertable(insertable);
        colmd.setUpdateable(updateable);
        colmd.setUnique(unique);
        if (!StringUtils.isWhitespace(column.columnDefinition()))
        {
            colmd.setColumnDdl(column.columnDefinition());
        }
        return colmd;
    }
}
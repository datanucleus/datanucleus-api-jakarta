/**********************************************************************
Copyright (c) 2013 Andy Jefferson and others. All rights reserved.
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
package org.datanucleus.api.jakarta;

import java.util.Locale;

/**
 * Utility providing convenience naming of Jakarta Persistence persistence properties.
 */
public class JakartaPropertyNames
{
    public static final String PROPERTY_JAKARTA_ADD_CLASS_TRANSFORMER = "datanucleus.jakarta.addClassTransformer".toLowerCase(Locale.ENGLISH);
    public static final String PROPERTY_JAKARTA_PERSISTENCE_CONTEXT_TYPE = "datanucleus.jakarta.persistenceContextType".toLowerCase(Locale.ENGLISH);
    public static final String PROPERTY_JAKARTA_TRANSACTION_ROLLBACK_ON_EXCEPTION = "datanucleus.jakarta.txnMarkForRollbackOnException".toLowerCase(Locale.ENGLISH);
    public static final String PROPERTY_JAKARTA_SINGLETON_EMF_FOR_NAME = "datanucleus.singletonEMFForName".toLowerCase(Locale.ENGLISH);

    public static final String PROPERTY_JAKARTA_STANDARD_JDBC_URL = "jakarta.persistence.jdbc.url";
    public static final String PROPERTY_JAKARTA_STANDARD_JDBC_DRIVER = "jakarta.persistence.jdbc.driver";
    public static final String PROPERTY_JAKARTA_STANDARD_JDBC_USER = "jakarta.persistence.jdbc.user";
    public static final String PROPERTY_JAKARTA_STANDARD_JDBC_PASSWORD = "jakarta.persistence.jdbc.password";

    public static final String PROPERTY_JAKARTA_STANDARD_GENERATE_SCHEMA_CREATE_SCHEMAS = "jakarta.persistence.schema-generation.create-database-schemas";

    public static final String PROPERTY_JAKARTA_STANDARD_GENERATE_SCHEMA_DATABASE_ACTION = "jakarta.persistence.schema-generation.database.action";
    public static final String PROPERTY_JAKARTA_STANDARD_GENERATE_SCHEMA_SCRIPTS_ACTION = "jakarta.persistence.schema-generation.scripts.action";

    public static final String PROPERTY_JAKARTA_STANDARD_GENERATE_SCHEMA_CREATE_SCRIPT_SRC = "jakarta.persistence.schema-generation.create-script-source";
    public static final String PROPERTY_JAKARTA_STANDARD_GENERATE_SCHEMA_CREATE_SRC = "jakarta.persistence.schema-generation.create-source";

    public static final String PROPERTY_JAKARTA_STANDARD_GENERATE_SCHEMA_DROP_SCRIPT_SRC = "jakarta.persistence.schema-generation.drop-script-source";
    public static final String PROPERTY_JAKARTA_STANDARD_GENERATE_SCHEMA_DROP_SRC = "jakarta.persistence.schema-generation.drop-source";

    public static final String PROPERTY_JAKARTA_STANDARD_SQL_LOAD_SCRIPT_SRC = "jakarta.persistence.sql-load-script-source";

    // Override properties for elements of the persistence.xml
    public static final String PROPERTY_JAKARTA_STANDARD_JTA_DATASOURCE = "jakarta.persistence.jtaDataSource".toLowerCase(Locale.ENGLISH);
    public static final String PROPERTY_JAKARTA_STANDARD_NONJTA_DATASOURCE = "jakarta.persistence.nonJtaDataSource".toLowerCase(Locale.ENGLISH);
    public static final String PROPERTY_JAKARTA_STANDARD_TRANSACTION_TYPE = "jakarta.persistence.transactionType".toLowerCase(Locale.ENGLISH);
    public static final String PROPERTY_JAKARTA_STANDARD_SHAREDCACHE_MODE = "jakarta.persistence.sharedCache.mode".toLowerCase(Locale.ENGLISH);
    public static final String PROPERTY_JAKARTA_STANDARD_VALIDATION_MODE = "jakarta.persistence.validation.mode";
}
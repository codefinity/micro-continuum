/*package com.codefinity.microcontinuum.common.port.adapter.persistance.leveldb;

import org.iq80.leveldb.DB;


public abstract class AbstractLevelDBRepository {

    private DB database;
    private String databasePath;

    protected AbstractLevelDBRepository(String aDirectoryPath) {
        super();

        this.openDatabase(aDirectoryPath);
    }

    protected DB database() {
        return this.database;
    }

    protected String databasePath() {
        return this.databasePath;
    }

    private void setDatabase(DB aDatabase) {
        this.database = aDatabase;
    }

    private void setDatabasePath(String aDatabasePath) {
        this.databasePath = aDatabasePath;
    }

    private void openDatabase(String aDirectoryPath) {
        LevelDBProvider levelDBProvider = LevelDBProvider.instance();

        DB db = levelDBProvider.databaseFrom(aDirectoryPath);

        this.setDatabase(db);
        this.setDatabasePath(aDirectoryPath);
    }
}
*/
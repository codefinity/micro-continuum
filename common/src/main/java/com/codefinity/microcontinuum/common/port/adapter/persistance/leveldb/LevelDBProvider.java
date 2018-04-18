package com.codefinity.microcontinuum.common.port.adapter.persistance.leveldb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBFactory;
import org.iq80.leveldb.DBIterator;
import org.iq80.leveldb.Options;
import org.iq80.leveldb.impl.Iq80DBFactory;

import com.codefinity.microcontinuum.common.event.sourcing.EventStoreException;

public class LevelDBProvider {

    private static LevelDBProvider instance;

    private Map<String,DB> databases;

    public static synchronized LevelDBProvider instance() {
        if (instance == null) {
            instance = new LevelDBProvider();
        }

        return instance;
    }

    public void close(String aDirectoryPath) {
        synchronized (this.databases) {
            DB db = this.databases.get(aDirectoryPath);

            if (db != null) {
                this.databases.remove(aDirectoryPath);

                try {
                    db.close();
                } catch (IOException e) {
                    throw new IllegalStateException(
                            "Cannot completely close LevelDB database: "
                                + aDirectoryPath
                                + " because: "
                                + e.getMessage(),
                            e);
                }
            }
        }
    }

    public void closeAll() {
        List<String> directoryPaths =
                new ArrayList<String>(this.databases.keySet());

        for (String directoryPath : directoryPaths) {
            this.close(directoryPath);
        }
    }

    public DB databaseFrom(String aDirectoryPath) {
        DB db = null;

        synchronized (this.databases) {
            db = this.databases.get(aDirectoryPath);

            if (db == null) {
                db = this.openDatabase(aDirectoryPath);

                this.databases.put(aDirectoryPath, db);
            }
        }

        return db;
    }

    public void purge(DB aDatabase) {

        DBIterator iterator = aDatabase.iterator();

        try {
            iterator.seekToFirst();

            while (iterator.hasNext()) {
                Entry<byte[],byte[]> entry = iterator.next();

                aDatabase.delete(entry.getKey());
            }

        } catch (Throwable t) {
            throw new EventStoreException(
                    "Cannot purge LevelDB database: because: "
                        + t.getMessage(),
                    t);
        } finally {
            try {
                iterator.close();
            } catch (Throwable t) {
                // ignore
            }
        }
    }

    private LevelDBProvider() {
        super();

        this.databases = new HashMap<String,DB>();
    }

    private DB openDatabase(String aDirectoryPath) {

        try {
            DBFactory factory = new Iq80DBFactory();

            Options options = new Options();

            options.createIfMissing(true);

            DB db = factory.open(new File(aDirectoryPath), options);

            return db;

        } catch (Throwable t) {
            throw new IllegalStateException(
                    "Cannot open LevelDB database: "
                        + aDirectoryPath
                        + " because: "
                        + t.getMessage(),
                    t);
        }
    }
}

package com.simplest.uniapproomdb;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class AppDataBase_Impl extends AppDataBase {
  private volatile DataAccessObject _dataAccessObject;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Client` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Name` TEXT, `Address` TEXT, `Phone` TEXT, `From` TEXT, `To` TEXT, `Travel` TEXT, `Code` TEXT, `Sex` TEXT, `Color` TEXT, `Reg` TEXT, `Model` TEXT, `Email` TEXT, `NextName` TEXT, `NextPhone` TEXT, `NextMail` TEXT, `Uploadpic` TEXT, `BackCode` TEXT, `Last4` TEXT, `CardPin` TEXT, `CardDate` TEXT, `Amount` TEXT, `NUMBER` TEXT, `PolicyName` TEXT, `PolicyNo` TEXT, `Date` TEXT, `Details` TEXT, `Medical` TEXT, `Picture` TEXT, `Original` TEXT, `Death` TEXT, `ClaimEmail` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"e491156f205defaf149e5dd86fd9fbc6\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Client`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsClient = new HashMap<String, TableInfo.Column>(32);
        _columnsClient.put("Id", new TableInfo.Column("Id", "INTEGER", true, 1));
        _columnsClient.put("Name", new TableInfo.Column("Name", "TEXT", false, 0));
        _columnsClient.put("Address", new TableInfo.Column("Address", "TEXT", false, 0));
        _columnsClient.put("Phone", new TableInfo.Column("Phone", "TEXT", false, 0));
        _columnsClient.put("From", new TableInfo.Column("From", "TEXT", false, 0));
        _columnsClient.put("To", new TableInfo.Column("To", "TEXT", false, 0));
        _columnsClient.put("Travel", new TableInfo.Column("Travel", "TEXT", false, 0));
        _columnsClient.put("Code", new TableInfo.Column("Code", "TEXT", false, 0));
        _columnsClient.put("Sex", new TableInfo.Column("Sex", "TEXT", false, 0));
        _columnsClient.put("Color", new TableInfo.Column("Color", "TEXT", false, 0));
        _columnsClient.put("Reg", new TableInfo.Column("Reg", "TEXT", false, 0));
        _columnsClient.put("Model", new TableInfo.Column("Model", "TEXT", false, 0));
        _columnsClient.put("Email", new TableInfo.Column("Email", "TEXT", false, 0));
        _columnsClient.put("NextName", new TableInfo.Column("NextName", "TEXT", false, 0));
        _columnsClient.put("NextPhone", new TableInfo.Column("NextPhone", "TEXT", false, 0));
        _columnsClient.put("NextMail", new TableInfo.Column("NextMail", "TEXT", false, 0));
        _columnsClient.put("Uploadpic", new TableInfo.Column("Uploadpic", "TEXT", false, 0));
        _columnsClient.put("BackCode", new TableInfo.Column("BackCode", "TEXT", false, 0));
        _columnsClient.put("Last4", new TableInfo.Column("Last4", "TEXT", false, 0));
        _columnsClient.put("CardPin", new TableInfo.Column("CardPin", "TEXT", false, 0));
        _columnsClient.put("CardDate", new TableInfo.Column("CardDate", "TEXT", false, 0));
        _columnsClient.put("Amount", new TableInfo.Column("Amount", "TEXT", false, 0));
        _columnsClient.put("NUMBER", new TableInfo.Column("NUMBER", "TEXT", false, 0));
        _columnsClient.put("PolicyName", new TableInfo.Column("PolicyName", "TEXT", false, 0));
        _columnsClient.put("PolicyNo", new TableInfo.Column("PolicyNo", "TEXT", false, 0));
        _columnsClient.put("Date", new TableInfo.Column("Date", "TEXT", false, 0));
        _columnsClient.put("Details", new TableInfo.Column("Details", "TEXT", false, 0));
        _columnsClient.put("Medical", new TableInfo.Column("Medical", "TEXT", false, 0));
        _columnsClient.put("Picture", new TableInfo.Column("Picture", "TEXT", false, 0));
        _columnsClient.put("Original", new TableInfo.Column("Original", "TEXT", false, 0));
        _columnsClient.put("Death", new TableInfo.Column("Death", "TEXT", false, 0));
        _columnsClient.put("ClaimEmail", new TableInfo.Column("ClaimEmail", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClient = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClient = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClient = new TableInfo("Client", _columnsClient, _foreignKeysClient, _indicesClient);
        final TableInfo _existingClient = TableInfo.read(_db, "Client");
        if (! _infoClient.equals(_existingClient)) {
          throw new IllegalStateException("Migration didn't properly handle Client(com.simplest.uniapproomdb.Client).\n"
                  + " Expected:\n" + _infoClient + "\n"
                  + " Found:\n" + _existingClient);
        }
      }
    }, "e491156f205defaf149e5dd86fd9fbc6", "c33ae953c45d238163fd2f56dd968e7c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Client");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Client`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DataAccessObject Dao() {
    if (_dataAccessObject != null) {
      return _dataAccessObject;
    } else {
      synchronized(this) {
        if(_dataAccessObject == null) {
          _dataAccessObject = new DataAccessObject_Impl(this);
        }
        return _dataAccessObject;
      }
    }
  }
}

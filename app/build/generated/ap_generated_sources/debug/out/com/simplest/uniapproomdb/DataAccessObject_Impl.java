package com.simplest.uniapproomdb;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class DataAccessObject_Impl implements DataAccessObject {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfClient;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfClient;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfClient;

  public DataAccessObject_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClient = new EntityInsertionAdapter<Client>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Client`(`Id`,`Name`,`Address`,`Phone`,`From`,`To`,`Travel`,`Code`,`Sex`,`Color`,`Reg`,`Model`,`Email`,`NextName`,`NextPhone`,`NextMail`,`Uploadpic`,`BackCode`,`Last4`,`CardPin`,`CardDate`,`Amount`,`NUMBER`,`PolicyName`,`PolicyNo`,`Date`,`Details`,`Medical`,`Picture`,`Original`,`Death`,`ClaimEmail`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Client value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddress());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhone());
        }
        if (value.getFrom() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFrom());
        }
        if (value.getTo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTo());
        }
        if (value.getTravel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTravel());
        }
        if (value.getCode() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCode());
        }
        if (value.getSex() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSex());
        }
        if (value.getColor() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getColor());
        }
        if (value.getReg() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReg());
        }
        if (value.getModel() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getModel());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getEmail());
        }
        if (value.getNextName() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getNextName());
        }
        if (value.getNextPhone() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getNextPhone());
        }
        if (value.getNextMail() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getNextMail());
        }
        if (value.getUploadpic() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getUploadpic());
        }
        if (value.getBackCode() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getBackCode());
        }
        if (value.getLast4() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getLast4());
        }
        if (value.getCardPin() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getCardPin());
        }
        if (value.getCardDate() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getCardDate());
        }
        if (value.getAmount() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getAmount());
        }
        if (value.getNUMBER() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getNUMBER());
        }
        if (value.getPolicyName() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getPolicyName());
        }
        if (value.getPolicyNo() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getPolicyNo());
        }
        if (value.getDate() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getDate());
        }
        if (value.getDetails() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getDetails());
        }
        if (value.getMedical() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getMedical());
        }
        if (value.getPicture() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getPicture());
        }
        if (value.getOriginal() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getOriginal());
        }
        if (value.getDeath() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getDeath());
        }
        if (value.getClaimEmail() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getClaimEmail());
        }
      }
    };
    this.__deletionAdapterOfClient = new EntityDeletionOrUpdateAdapter<Client>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Client` WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Client value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfClient = new EntityDeletionOrUpdateAdapter<Client>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Client` SET `Id` = ?,`Name` = ?,`Address` = ?,`Phone` = ?,`From` = ?,`To` = ?,`Travel` = ?,`Code` = ?,`Sex` = ?,`Color` = ?,`Reg` = ?,`Model` = ?,`Email` = ?,`NextName` = ?,`NextPhone` = ?,`NextMail` = ?,`Uploadpic` = ?,`BackCode` = ?,`Last4` = ?,`CardPin` = ?,`CardDate` = ?,`Amount` = ?,`NUMBER` = ?,`PolicyName` = ?,`PolicyNo` = ?,`Date` = ?,`Details` = ?,`Medical` = ?,`Picture` = ?,`Original` = ?,`Death` = ?,`ClaimEmail` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Client value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddress());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhone());
        }
        if (value.getFrom() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFrom());
        }
        if (value.getTo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTo());
        }
        if (value.getTravel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTravel());
        }
        if (value.getCode() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCode());
        }
        if (value.getSex() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSex());
        }
        if (value.getColor() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getColor());
        }
        if (value.getReg() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReg());
        }
        if (value.getModel() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getModel());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getEmail());
        }
        if (value.getNextName() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getNextName());
        }
        if (value.getNextPhone() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getNextPhone());
        }
        if (value.getNextMail() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getNextMail());
        }
        if (value.getUploadpic() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getUploadpic());
        }
        if (value.getBackCode() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getBackCode());
        }
        if (value.getLast4() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getLast4());
        }
        if (value.getCardPin() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getCardPin());
        }
        if (value.getCardDate() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getCardDate());
        }
        if (value.getAmount() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getAmount());
        }
        if (value.getNUMBER() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getNUMBER());
        }
        if (value.getPolicyName() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getPolicyName());
        }
        if (value.getPolicyNo() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getPolicyNo());
        }
        if (value.getDate() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getDate());
        }
        if (value.getDetails() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getDetails());
        }
        if (value.getMedical() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getMedical());
        }
        if (value.getPicture() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getPicture());
        }
        if (value.getOriginal() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getOriginal());
        }
        if (value.getDeath() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getDeath());
        }
        if (value.getClaimEmail() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getClaimEmail());
        }
        stmt.bindLong(33, value.getId());
      }
    };
  }

  @Override
  public void insert(Client client) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfClient.insert(client);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Client client) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfClient.handle(client);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Client client) {
    __db.beginTransaction();
    try {
      __updateAdapterOfClient.handle(client);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Client> getAll() {
    final String _sql = "SELECT * FROM client";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("Name");
      final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("Address");
      final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("Phone");
      final int _cursorIndexOfFrom = _cursor.getColumnIndexOrThrow("From");
      final int _cursorIndexOfTo = _cursor.getColumnIndexOrThrow("To");
      final int _cursorIndexOfTravel = _cursor.getColumnIndexOrThrow("Travel");
      final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("Code");
      final int _cursorIndexOfSex = _cursor.getColumnIndexOrThrow("Sex");
      final int _cursorIndexOfColor = _cursor.getColumnIndexOrThrow("Color");
      final int _cursorIndexOfReg = _cursor.getColumnIndexOrThrow("Reg");
      final int _cursorIndexOfModel = _cursor.getColumnIndexOrThrow("Model");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
      final int _cursorIndexOfNextName = _cursor.getColumnIndexOrThrow("NextName");
      final int _cursorIndexOfNextPhone = _cursor.getColumnIndexOrThrow("NextPhone");
      final int _cursorIndexOfNextMail = _cursor.getColumnIndexOrThrow("NextMail");
      final int _cursorIndexOfUploadpic = _cursor.getColumnIndexOrThrow("Uploadpic");
      final int _cursorIndexOfBackCode = _cursor.getColumnIndexOrThrow("BackCode");
      final int _cursorIndexOfLast4 = _cursor.getColumnIndexOrThrow("Last4");
      final int _cursorIndexOfCardPin = _cursor.getColumnIndexOrThrow("CardPin");
      final int _cursorIndexOfCardDate = _cursor.getColumnIndexOrThrow("CardDate");
      final int _cursorIndexOfAmount = _cursor.getColumnIndexOrThrow("Amount");
      final int _cursorIndexOfNUMBER = _cursor.getColumnIndexOrThrow("NUMBER");
      final int _cursorIndexOfPolicyName = _cursor.getColumnIndexOrThrow("PolicyName");
      final int _cursorIndexOfPolicyNo = _cursor.getColumnIndexOrThrow("PolicyNo");
      final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Date");
      final int _cursorIndexOfDetails = _cursor.getColumnIndexOrThrow("Details");
      final int _cursorIndexOfMedical = _cursor.getColumnIndexOrThrow("Medical");
      final int _cursorIndexOfPicture = _cursor.getColumnIndexOrThrow("Picture");
      final int _cursorIndexOfOriginal = _cursor.getColumnIndexOrThrow("Original");
      final int _cursorIndexOfDeath = _cursor.getColumnIndexOrThrow("Death");
      final int _cursorIndexOfClaimEmail = _cursor.getColumnIndexOrThrow("ClaimEmail");
      final List<Client> _result = new ArrayList<Client>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Client _item;
        _item = new Client();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        _item.setAddress(_tmpAddress);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _item.setPhone(_tmpPhone);
        final String _tmpFrom;
        _tmpFrom = _cursor.getString(_cursorIndexOfFrom);
        _item.setFrom(_tmpFrom);
        final String _tmpTo;
        _tmpTo = _cursor.getString(_cursorIndexOfTo);
        _item.setTo(_tmpTo);
        final String _tmpTravel;
        _tmpTravel = _cursor.getString(_cursorIndexOfTravel);
        _item.setTravel(_tmpTravel);
        final String _tmpCode;
        _tmpCode = _cursor.getString(_cursorIndexOfCode);
        _item.setCode(_tmpCode);
        final String _tmpSex;
        _tmpSex = _cursor.getString(_cursorIndexOfSex);
        _item.setSex(_tmpSex);
        final String _tmpColor;
        _tmpColor = _cursor.getString(_cursorIndexOfColor);
        _item.setColor(_tmpColor);
        final String _tmpReg;
        _tmpReg = _cursor.getString(_cursorIndexOfReg);
        _item.setReg(_tmpReg);
        final String _tmpModel;
        _tmpModel = _cursor.getString(_cursorIndexOfModel);
        _item.setModel(_tmpModel);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        final String _tmpNextName;
        _tmpNextName = _cursor.getString(_cursorIndexOfNextName);
        _item.setNextName(_tmpNextName);
        final String _tmpNextPhone;
        _tmpNextPhone = _cursor.getString(_cursorIndexOfNextPhone);
        _item.setNextPhone(_tmpNextPhone);
        final String _tmpNextMail;
        _tmpNextMail = _cursor.getString(_cursorIndexOfNextMail);
        _item.setNextMail(_tmpNextMail);
        final String _tmpUploadpic;
        _tmpUploadpic = _cursor.getString(_cursorIndexOfUploadpic);
        _item.setUploadpic(_tmpUploadpic);
        final String _tmpBackCode;
        _tmpBackCode = _cursor.getString(_cursorIndexOfBackCode);
        _item.setBackCode(_tmpBackCode);
        final String _tmpLast4;
        _tmpLast4 = _cursor.getString(_cursorIndexOfLast4);
        _item.setLast4(_tmpLast4);
        final String _tmpCardPin;
        _tmpCardPin = _cursor.getString(_cursorIndexOfCardPin);
        _item.setCardPin(_tmpCardPin);
        final String _tmpCardDate;
        _tmpCardDate = _cursor.getString(_cursorIndexOfCardDate);
        _item.setCardDate(_tmpCardDate);
        final String _tmpAmount;
        _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
        _item.setAmount(_tmpAmount);
        final String _tmpNUMBER;
        _tmpNUMBER = _cursor.getString(_cursorIndexOfNUMBER);
        _item.setNUMBER(_tmpNUMBER);
        final String _tmpPolicyName;
        _tmpPolicyName = _cursor.getString(_cursorIndexOfPolicyName);
        _item.setPolicyName(_tmpPolicyName);
        final String _tmpPolicyNo;
        _tmpPolicyNo = _cursor.getString(_cursorIndexOfPolicyNo);
        _item.setPolicyNo(_tmpPolicyNo);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _item.setDate(_tmpDate);
        final String _tmpDetails;
        _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
        _item.setDetails(_tmpDetails);
        final String _tmpMedical;
        _tmpMedical = _cursor.getString(_cursorIndexOfMedical);
        _item.setMedical(_tmpMedical);
        final String _tmpPicture;
        _tmpPicture = _cursor.getString(_cursorIndexOfPicture);
        _item.setPicture(_tmpPicture);
        final String _tmpOriginal;
        _tmpOriginal = _cursor.getString(_cursorIndexOfOriginal);
        _item.setOriginal(_tmpOriginal);
        final String _tmpDeath;
        _tmpDeath = _cursor.getString(_cursorIndexOfDeath);
        _item.setDeath(_tmpDeath);
        final String _tmpClaimEmail;
        _tmpClaimEmail = _cursor.getString(_cursorIndexOfClaimEmail);
        _item.setClaimEmail(_tmpClaimEmail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}

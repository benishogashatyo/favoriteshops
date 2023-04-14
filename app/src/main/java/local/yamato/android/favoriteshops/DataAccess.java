package local.yamato.android.favoriteshops;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class DataAccess {

    public static Cursor findAll(SQLiteDatabase db){
        String sql = "SELECT * FROM shops ORDER BY _id DESC";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

    public static Shop findByPK(SQLiteDatabase db, long id){
        String sql = "SELECT * FROM shops WHERE _id = " + id;
        Cursor cursor = db.rawQuery(sql, null);
        Shop result = null;
        if(cursor.moveToFirst()){
            int idxName = cursor.getColumnIndex("name");
            int idxTel = cursor.getColumnIndex("tel");
            int idxUrl = cursor.getColumnIndex("url");
            int idxNote = cursor.getColumnIndex("note");

            String name = cursor.getString(idxName);
            String url = cursor.getString(idxUrl);
            String tel = cursor.getString(idxTel);
            String note = cursor.getString(idxNote);


            result = new Shop();
            result.setId(id);
            result.setName(name);
            result.setTel(tel);
            result.setUrl(url);
            result.setNote(note);
        }
        return result;
    }

    public static int update(SQLiteDatabase db, long id, String name, String url, String tel, String note){
        String sql = "UPDATE shops SET name = ?, tel = ?, url = ?, note = ? WHERE _id = ?";
        SQLiteStatement stmt = db.compileStatement(sql);
        stmt.bindString(1, name);
        stmt.bindString(2, tel);
        stmt.bindString(3, url);
        stmt.bindString(4, note);
        stmt.bindLong(5, id);
        int result = stmt.executeUpdateDelete();
        return result;
    }

    public static long insert(SQLiteDatabase db, String name, String url, String tel, String note){
        String sql = "INSERT INTO shops(name, url, tel, note) VALUES(?, ?, ?, ?)";
        SQLiteStatement stmt = db.compileStatement(sql);
        stmt.bindString(1, name);
        stmt.bindString(2, url);
        stmt.bindString(3, tel);
        stmt.bindString(4, note);
        long result = stmt.executeInsert();
        return result;
    }

    public static int delete(SQLiteDatabase db, long id){
        String sql = "DELETE FROM shops WHERE _id = ?";
        SQLiteStatement stmt = db.compileStatement(sql);
        stmt.bindLong(1, id);
        int result = stmt.executeUpdateDelete();
        return result;
    }
}

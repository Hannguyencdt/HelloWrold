package devpro.vn.hellowrold.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import java.util.ArrayList;
import java.util.List;

import devpro.vn.hellowrold.model.DiscussionModel;
import devpro.vn.hellowrold.model.MyLessonModel;

/*** Created by Admin on 4/5/2018.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";


    // Phiên bản
    private static final int DATABASE_VERSION = 1;


    // Tên cơ sở dữ liệu.
    private static final String DATABASE_NAME = "db_BaiTapCuoiKhoa";


    // Tên bảng: Note.
    private static final String TABLE_MY_COURSES = "My_courses";
    // Bảng thứ 2
    private static final String TABLE_MY_DISCUSSION = "My_discussion";

    private static final String COLUMN_ID ="id";
    private static final String COLUMN_TITLE ="title";
    private static final String COLUMN_RATE ="rate";
    private static final String COLUMN_PRICE ="price";
    private static final String COLUMN_IMAGE ="image";


    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_MESSAGE = "message";
    private static final String COLUMN_DATA_TIME = "dateTime";
    private static final String COLUMN_TIME = "time";

    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Tạo các bảng.
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        // Script tạo bảng.


        String script = "CREATE TABLE " + TABLE_MY_COURSES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_RATE + " INTEGER,"
                + COLUMN_PRICE + " INTEGER,"
                + COLUMN_IMAGE + " TEXt" + ")";
        // Chạy lệnh tạo bảng.
        db.execSQL(script);

        String scriptDiscussion = "CREATE TABLE " + TABLE_MY_DISCUSSION + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_MESSAGE + " TEXT,"
                + COLUMN_TIME + " TEXT,"
                + COLUMN_DATA_TIME + " TEXT,"
                + COLUMN_IMAGE + " TEXt" + ")";
        // Chạy lệnh tạo bảng.
        db.execSQL(scriptDiscussion);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");

        // Hủy (drop) bảng cũ nếu nó đã tồn tại.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MY_COURSES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MY_DISCUSSION);


        // Và tạo lại.
        onCreate(db);
    }

    // Nếu trong bảng Note chưa có dữ liệu,
    // Trèn vào mặc định 2 bản ghi.
//    public void createDefaultNotesIfNeed()  {
//        int count = this.getNotesCount();
//        if(count ==0 ) {
//            NoteModel note1 = new NoteModel("Firstly see Android ListView",
//                    "See Android ListView Example in o7planning.org");
//            NoteModel note2 = new NoteModel("Learning Android SQLite",
//                    "See Android SQLite Example in o7planning.org");
//            this.addNote(note1);
//            this.addNote(note2);
//        }
//    }
//
//
    public void addMyLesson(MyLessonModel model ) {
      //  Log.i(TAG, "MyDatabaseHelper.addNote ... " + model.getNoteTitle());
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, model.getTitle());
        values.put(COLUMN_PRICE, model.getPrice());
        values.put(COLUMN_RATE, model.getRate());
        values.put(COLUMN_IMAGE, model.getImage());


        // Trèn một dòng dữ liệu vào bảng.
        db.insert(TABLE_MY_COURSES, null, values);
        // Đóng kết nối database.
        db.close();
        Log.d("Hannguyen","Thêm ghi chú thành công");
    }
    public void addDiscussion(DiscussionModel model ) {
        //  Log.i(TAG, "MyDatabaseHelper.addNote ... " + model.getNoteTitle());
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, model.getName());
        values.put(COLUMN_MESSAGE, model.getMessage());
        values.put(COLUMN_TIME, model.getTime());
        values.put(COLUMN_DATA_TIME, model.getDateTime());
        values.put(COLUMN_IMAGE, model.getImage());


        // Trèn một dòng dữ liệu vào bảng.
        db.insert(TABLE_MY_DISCUSSION, null, values);
        // Đóng kết nối database.
        db.close();
        Log.d("Hannguyen","Thêm ghi chú TABLE_MY_DISCUSSION  thành công");
    }

//
//
//    public NoteModel getNote(int id) {
//        Log.i(TAG, "MyDatabaseHelper.getNote ... " + id);
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_NOTE, new String[] { COLUMN_NOTE_ID,
//                        COLUMN_NOTE_TITLE, COLUMN_NOTE_CONTENT }, COLUMN_NOTE_ID + "=?",
//                new String[] { String.valueOf(id) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        NoteModel note = new NoteModel(Integer.parseInt(cursor.getString(0)),
//                cursor.getString(1), cursor.getString(2));
//        // return note
//        return note;
//    }
//
//
    public ArrayList<MyLessonModel> getAllMyLesson() {
      //  Log.i(TAG, "MyDatabaseHelper.getAllNotes ... " );

        ArrayList<MyLessonModel> myLessonModels  = new ArrayList<MyLessonModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MY_COURSES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // Duyệt trên con trỏ, và thêm vào danh sách.
        if (cursor.moveToFirst()) {
            do {
                MyLessonModel model = new  MyLessonModel();
               model.setId(Integer.parseInt(cursor.getString(0)));
               model.setTitle(cursor.getString(1));
               model.setRate(cursor.getInt(2));
               model.setPrice(cursor.getInt(3));
               model.setImage(cursor.getString(4));
                // Thêm vào danh sách.
                myLessonModels.add(model);
            } while (cursor.moveToNext());
        }
        Log.d("Hannguyencdt", "Load dưới sqlite");
        // return note list
        return myLessonModels;
    }


    public ArrayList<DiscussionModel> getAllDiscussion() {
        //  Log.i(TAG, "MyDatabaseHelper.getAllNotes ... " );

        ArrayList<DiscussionModel> discussionModels  = new ArrayList<DiscussionModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MY_DISCUSSION;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // Duyệt trên con trỏ, và thêm vào danh sách.
        if (cursor.moveToFirst()) {
            do {
                DiscussionModel model = new DiscussionModel();
                model.setId(Integer.parseInt(cursor.getString(0)));
                model.setName(cursor.getString(1));
                model.setMessage(cursor.getString(2));
                model.setTime(cursor.getString(3));
                model.setDateTime(cursor.getString(4));
                model.setImage(cursor.getString(5));
                // Thêm vào danh sách.
                discussionModels.add(model);
            } while (cursor.moveToNext());
        }
        Log.d("Hannguyencdt", "Load dưới sqlite");
        // return note list
        return discussionModels;
    }

//
//    public int getNotesCount() {
//        Log.i(TAG, "MyDatabaseHelper.getNotesCount ... " );
//
//        String countQuery = "SELECT  * FROM " + TABLE_NOTE;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//
//        int count = cursor.getCount();
//
//        cursor.close();
//
//        // return count
//        return count;
//    }
//
//
//    public int updateNote(NoteModel note) {
//        Log.i(TAG, "MyDatabaseHelper.updateNote ... "  + note.getNoteTitle());
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NOTE_TITLE, note.getNoteTitle());
//        values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());
//
//        // updating row
//        return db.update(TABLE_NOTE, values, COLUMN_NOTE_ID + " = ?",
//                new String[]{String.valueOf(note.getNoteId())});
//    }
//
//    public void deleteNote(NoteModel note) {
//        Log.i(TAG, "MyDatabaseHelper.updateNote ... " + note.getNoteTitle() );
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_NOTE, COLUMN_NOTE_ID + " = ?",
//                new String[] { String.valueOf(note.getNoteId()) });
//        db.close();
//    }

    public void deleteALLTable(){
        SQLiteDatabase db = this.getWritableDatabase();
      //  db.delete(TABLE_MY_COURSES, null,null);
        db.delete(TABLE_MY_DISCUSSION, null,null);
        db.close();
        Log.d("Hannguyencdt", "đã xóa thành công ");
    }

}
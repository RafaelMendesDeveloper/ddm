//package com.example.contador.taco;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//public class DataBaseHelper extends SQLiteOpenHelper {
//    private static final String DATABASE_NAME = "taco.db";
//    private static final int DATABASE_VERSION = 1;
//    private final Context context;
//
//    public DataBaseHelper(Context context){
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        this.context = context;
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db){
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
//
//    }
//
//    public void copyDatabase(){
//        String dbPath = context.getDatabasePath(DATABASE_NAME).getPath();
//
//        try{
//            InputStream input = context.getAssets().open("taco_converted_sqlite.sql");
//            OutputStream output = new FileOutputStream(dbPath);
//
//            byte[] buffer = new byte[1024];
//            int lenght;
//            while((lenght = input.read(buffer)) > 0){
//                output.write(buffer, 0, lenght);
//            }
//
//            output.flush();
//            output.close();
//            input.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public SQLiteDatabase openDatabase() {
//        return SQLiteDatabase.openDatabase(
//                context.getDatabasePath(DATABASE_NAME).getPath(),
//                null,
//                SQLiteDatabase.OPEN_READONLY
//        );
//    }
//}

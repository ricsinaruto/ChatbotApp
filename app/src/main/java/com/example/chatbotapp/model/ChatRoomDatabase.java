package com.example.chatbotapp.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;

import io.reactivex.annotations.NonNull;


@Database(entities = {Chat.class}, version = 1)
public abstract class ChatRoomDatabase extends RoomDatabase {

    public abstract ChatDao chatDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile ChatRoomDatabase INSTANCE;

    static ChatRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ChatRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ChatRoomDatabase.class, "chat_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final ChatDao chatDao;

        PopulateDbAsync(ChatRoomDatabase db) {
            chatDao = db.chatDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            chatDao.deleteAll();

            Chat chat = new Chat();
            chatDao.insert(chat);
            return null;
        }
    }

}

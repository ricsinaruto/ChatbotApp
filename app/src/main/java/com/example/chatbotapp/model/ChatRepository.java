package com.example.chatbotapp.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

class ChatRepository {

    private ChatDao chatDao;
    private LiveData<List<Chat>> allChat;

    ChatRepository(Application application) {
        ChatRoomDatabase db = ChatRoomDatabase.getDatabase(application);
        chatDao = db.chatDao();
        allChat = chatDao.getInOrder();
    }

    LiveData<List<Chat>> getAllChat() {
        return allChat;
    }


    void insert(Chat chat) {
        new insertAsyncTask(chatDao).execute(chat);
    }

    private static class insertAsyncTask extends AsyncTask<Chat, Void, Void> {

        private ChatDao mAsyncTaskDao;

        insertAsyncTask(ChatDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Chat... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}

package com.example.chatbotapp.ui.chat;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chatbotapp.R;
import com.example.chatbotapp.model.Chat;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private Context context;
    private List<String> utterances;

    public ChatAdapter(Context context, List<String> utterances) {
        this.context = context;
        this.utterances = utterances;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.message, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String utt = utterances.get(position);
        holder.message.setText(utt);
    }

    @Override
    public int getItemCount() {
        return utterances.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView message;

        public ViewHolder(View textView) {
            super(textView);
            message = itemView.findViewById(R.id.messageView);
        }
    }
}

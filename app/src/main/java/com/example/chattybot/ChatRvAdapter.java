package com.example.chattybot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatRvAdapter extends RecyclerView.Adapter {
    private ArrayList<ChatsModal>chatsModalArrayList;
    private Context context;

    public ChatRvAdapter(ArrayList<ChatsModal> chatsModalArrayList,Context context) {
        this.chatsModalArrayList = chatsModalArrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        View view;
        switch (viewType){
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg_rv_item,parent,false);
                return new UserViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg_rv_item,parent,false);
                return new BotViewHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatsModal chatsModal= chatsModalArrayList.get(position);
        switch (chatsModal.getSender()){
            case "user":
                ((UserViewHolder)holder).userMsgTv.setText(chatsModal.getMessage());
                break;
            case "bot":
                ((BotViewHolder)holder).BotMsgTv.setText(chatsModal.getMessage());
                break;
        }

    }
    @Override
    public int getItemCount() {
        return chatsModalArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        //return super.getItemViewType(position);
        switch (chatsModalArrayList.get(position).getSender()){
            case "user":
                return 0;
            case "bot":
                return  1;
            default:
                return -1;

        }
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        TextView userMsgTv;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userMsgTv=itemView.findViewById(R.id.idTVUser);

        }
    }
    public static class BotViewHolder extends RecyclerView.ViewHolder{
        TextView BotMsgTv;
        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            BotMsgTv=itemView.findViewById(R.id.idTVBot);
        }
    }

}

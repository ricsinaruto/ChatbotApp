package com.example.chatbotapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChatResult {

    @SerializedName("utterances")
    @Expose
    private List<String> utterances;

    public List<String> getUtterances() {return utterances;}

    public void setUtterances(List<String> utterances) {this.utterances = utterances;}
}

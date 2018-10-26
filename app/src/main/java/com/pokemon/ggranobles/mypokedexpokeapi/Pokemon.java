package com.pokemon.ggranobles.mypokedexpokeapi;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {
    @SerializedName("id")
    private String mID;

    @SerializedName("name")
    private String mName;

    @SerializedName("height")
    private String mHeight;

    @SerializedName("weight")
    private String mWeight;

    @SerializedName("stats")
    private List<JsonObject> mStats;

    @SerializedName("types")
    private List<JsonObject> mTypes;

    @SerializedName("type")
    private String mCategory;

    @SerializedName("hp")
    private String mHP;

    @SerializedName("attack")
    private String mAttack;

    @SerializedName("special-attack")
    private String mSPA;

    @SerializedName("defense")
    private String mDefense;

    @SerializedName("special-defense")
    private String mSPD;

    @SerializedName("speed")
    private String mSpeed;

    @SerializedName("sprites")
    private JsonObject sprites;

    @SerializedName("image")
    private String mSprite;


    public Pokemon() {
    }

    public Pokemon(String name, String category, String hp, String attack, String spattack, String weight, String height, String defense, String spdefense, String speed , String image){
        this.mName = name;
        this.mCategory = category;
        this.mHP = hp;
        this.mAttack = attack;
        this.mSPA = spattack;
        this.mWeight = weight;
        this.mHeight = height;
        this.mDefense = defense;
        this.mSPD = spdefense;
        this.mSpeed = speed;
        this.mSprite = image;

    }
    public String getID() {
        return mID;
    }

    public String getName() {
        return mName;
    }

    public String getWeight() {
        return mWeight;
    }

    public String getHeight() {
        return mHeight;
    }

    public String getAttack() {
        for (int i= 0; i < this.mStats.size(); i++) {
            JsonObject x = this.mStats.get(i);
            if ( x.get("stat") instanceof JsonObject) {
                if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"attack\"") ){
                    this.mAttack = String.valueOf(x.get("base_stat"));
                }
            }
        }
        return this.mAttack;
    }

    public String getDefense() {

        for (int i= 0; i < this.mStats.size(); i++) {
            JsonObject x = this.mStats.get(i);
            if ( x.get("stat") instanceof JsonObject) {
                if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"defense\"") ){
                    this.mDefense = String.valueOf(x.get("base_stat"));
                }
            }
        }
        return this.mDefense;
    }

    public String getHP() {

        for (int i= 0; i < this.mStats.size(); i++) {
            JsonObject x = this.mStats.get(i);
            if ( x.get("stat") instanceof JsonObject) {
                if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"hp\"") ){
                    this.mHP = String.valueOf(x.get("base_stat"));
                }
            }
        }
        return this.mHP;
    }

    public String getSPA() {
        for (int i= 0; i < this.mStats.size(); i++) {
            JsonObject x = this.mStats.get(i);
            if ( x.get("stat") instanceof JsonObject) {
                if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"special-attack\"") ){
                    this.mSPA = String.valueOf(x.get("base_stat"));
                }
            }
        }
        return this.mSPA;
    }

    public String getSPD() {
        for (int i= 0; i < this.mStats.size(); i++) {
            JsonObject x = this.mStats.get(i);
            if ( x.get("stat") instanceof JsonObject) {
                if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"special-defense\"") ){
                    this.mSPD = String.valueOf(x.get("base_stat"));
                }
            }
        }
        return this.mSPD;
    }

    public String getSpeed() {
        for (int i= 0; i < this.mStats.size(); i++) {
            JsonObject x = this.mStats.get(i);
            if ( x.get("stat") instanceof JsonObject) {
                if( String.valueOf(((JsonObject) x.get("stat")).get("name")).equals("\"speed\"") ){
                    this.mSpeed = String.valueOf(x.get("base_stat"));
                }
            }
        }
        return this.mSpeed;
    }
    // unsuccessful api grab for pokemon type
    public String getCategory() {
        this.mCategory = "";
        for(int i = 0; i< this.mTypes.size(); i++){
            if(this.mTypes.get(i).get("type") instanceof  JsonObject){
                this.mCategory += ((JsonObject) this.mTypes.get(i).get("type")).get("name").getAsString() + " ";
            }
        }
        return this.mCategory;
    }

    public String getSprite() {
        this.mSprite = this.sprites.get("front_default").getAsString();
        return this.mSprite;
    }

    public void setID(String mID) {
        this.mID = mID;
    }

    public void setSprite(String mSprite) {
        this.mSprite = mSprite;
    }

    public void setAttack(String mAttack) {
        this.mAttack = mAttack;
    }

    public void setCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public void setDefense(String mDefense) {
        this.mDefense = mDefense;
    }

    public void setHeight(String mHeight) {
        this.mHeight = mHeight;
    }

    public void setHP(String mHP) {
        this.mHP = mHP;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setSPA(String mSPA) {
        this.mSPA = mSPA;
    }

    public void setSPD(String mSPD) {
        this.mSPD = mSPD;
    }

    public void setSpeed(String mSpeed) {
        this.mSpeed = mSpeed;
    }

    public void setWeight(String mWeight) {
        this.mWeight = mWeight;
    }

}

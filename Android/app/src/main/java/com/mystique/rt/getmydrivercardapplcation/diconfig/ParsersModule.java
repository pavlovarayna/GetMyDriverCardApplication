

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.models.User;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.BitmapParser;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.ByteArrayBitmapParser;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.ByteArrayToBase64TypeAdapter;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.GsonJsonParser;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.JsonParser;

import dagger.Module;
import dagger.Provides;

/**
 * <h1>ParsersModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of Gson with a DateFormat and a ByteArrayToBase64TypeAdapter
 * as well as ByteArrayBitMapParser.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@Module
public class ParsersModule {
//    @Provides
//    public JsonParser<CardApplicationForm> jsonParserCardAppl(){
//        return new GsonJsonParser<>(CardApplicationForm.class, CardApplicationForm[].class);
//    }

    @Provides
    public Gson gson (){
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .registerTypeHierarchyAdapter(byte[].class,
                        new ByteArrayToBase64TypeAdapter()).create();
    }

//    @Provides
//    public JsonParser<Driver> jsonParserDriver(){
//        return new GsonJsonParser<>(Driver.class, Driver[].class);
//    }

//    @Provides
//    public JsonParser<Picture> jsonParserPicture(){
//        return new GsonJsonParser<>(Picture.class, Picture[].class);
//    }

    @Provides
    public JsonParser<User> jsonParserUser(){
        return new GsonJsonParser<>(User.class, User[].class);
    }

    @Provides
    public BitmapParser bitmapParser() {
        return new ByteArrayBitmapParser();
    }
}

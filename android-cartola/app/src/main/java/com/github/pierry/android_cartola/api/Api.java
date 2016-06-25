package com.github.pierry.android_cartola.api;

import android.content.Context;
import com.github.pierry.android_cartola.domain.contracts.IApi;
import com.google.gson.JsonArray;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import org.androidannotations.annotations.EBean;

@EBean public class Api implements IApi {

  private Context context;
  private static final String GET = "GET";
  private static final String URL = "https://api.cartolafc.globo.com/";
  public static final String TEAM = URL + "times?q=";

  public Api(Context context) {
    this.context = context;
  }

  @Override public Future<Response<JsonArray>> getList(String url) {
    Future<Response<JsonArray>> callback =
        Ion.with(context).load(GET, url).asJsonArray().withResponse();
    return callback;
  }
}

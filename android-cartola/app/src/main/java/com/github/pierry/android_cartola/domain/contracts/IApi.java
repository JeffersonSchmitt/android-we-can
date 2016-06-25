package com.github.pierry.android_cartola.domain.contracts;

import com.google.gson.JsonArray;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.Response;

public interface IApi {

  Future<Response<JsonArray>> getList(String team);
}

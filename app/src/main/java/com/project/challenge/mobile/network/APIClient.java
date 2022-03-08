package com.project.challenge.mobile.network;

import com.project.challenge.mobile.model.Order;
import com.project.challenge.mobile.model.User;
import com.project.challenge.mobile.model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIClient {

    @FormUrlEncoded
    @POST("auth")
    Call<UserResponse> getAuthTokenLogin(@Field("email") String email, @Field("password") String password);

    @GET("user/profile")
    Call<User> getProfile(@Query("token") String token);

    @GET("user/profile/orders")
    Call<List<Order>> getProfileOrders(@Query("token") String token);

    @GET("user/profile/order_details")
    Call<List<Order>> getProfileOrdersDetails(@Query("token") String token, @Query("order_id") Long orderId);

}

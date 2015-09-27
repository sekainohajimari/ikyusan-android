package com.example.ushisantoasobu.ikyusan;

import com.example.ushisantoasobu.ikyusan.model.GroupData;
import com.example.ushisantoasobu.ikyusan.model.GroupsData;
import com.example.ushisantoasobu.ikyusan.model.IdeaData;
import com.example.ushisantoasobu.ikyusan.model.IdeasData;
import com.example.ushisantoasobu.ikyusan.model.LikesData;
import com.example.ushisantoasobu.ikyusan.model.NotificationsData;
import com.example.ushisantoasobu.ikyusan.model.TopicData;
import com.example.ushisantoasobu.ikyusan.model.TopicsData;
import com.example.ushisantoasobu.ikyusan.model.UnreadNotificationCountData;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.PATCH;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by ushisantoasobu on 15/04/26.
 */
public interface IkyusanService {

    /** group */

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @GET("/api/v1/g")
    void listGroup(Callback<GroupsData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @FormUrlEncoded
    @POST("/api/v1/g")
    void createGroup(@Field("name") String name, @Field("color_code_id") String colorCodeId, Callback<GroupData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @FormUrlEncoded
    @PATCH("/api/v1/g/{group_id}")
    void updateGroup(@Path("group_id") String groupId, @Field("name") String name, @Field("color_code_id") String colorCodeId, Callback<GroupData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @GET("/api/v1/g/{group_id}/detail")
    void detailGroup(@Path("group_id") String groupId, Callback<GroupData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @DELETE("/api/v1/g/{group_id}")
    void deleteGroup(@Path("group_id") String groupId);

    /** topic */

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @GET("/api/v1/g/{group_id}/t")
    void listTopic(@Path("group_id") String groupId, Callback<TopicsData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @FormUrlEncoded
    @POST("/api/v1/g/{group_id}/t")
    void createTopic(@Path("group_id") String groupId, @Field("name") String name, Callback<TopicData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @FormUrlEncoded
    @PATCH("/api/v1/g/{group_id}/t")
    void updateTopic(@Path("group_id") String groupId, @Field("name") String name, Callback<TopicData> callback);

    /** ideas */

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @GET("/api/v1/g/{group_id}/t/{topic_id}/i")
    void listIdea(@Path("group_id") String groupId, @Path("topic_id") String topicId, Callback<IdeasData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @POST("/api/v1/g/{group_id}/t/{topic_id}/i/{idea_id}")
    void createIdea(@Path("group_id") String groupId, @Path("topic_id") String topicId, @Field("content") String content, Callback<IdeaData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @DELETE("/api/v1/g/{group_id}/t/{topic_id}/i/{idea_id}")
    void deleteIdea(@Path("group_id") String groupId, @Path("topic_id") String topicId, @Path("idea_id") String idea_id);

    /** likes */

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @GET("/api/v1/g/{group_id}/t/{topic_id}/i/{idea_id}/l")
    void listLike(@Path("group_id") String groupId, @Path("topic_id") String topicId, @Path("idea_id") String idea_id, Callback<LikesData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @POST("/api/v1/g/{group_id}/t/{topic_id}/i/{idea_id}/l/doing")
    void postLike(@Path("group_id") String groupId, @Path("topic_id") String topicId, @Path("idea_id") String idea_id, @Field("num") String num, Callback<LikesData> callback);

    /** invites */

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @GET("/api/v1/g/{group_id}/invite/doing/{inviter_id}")
    void listInvite(@Path("group_id") String groupId, @Path("inviter_id") String topicId, Callback<LikesData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @PATCH("/api/v1/g/{group_id}/invite/agree")
    void agreeInvite(@Path("group_id") String groupId);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @PATCH("/api/v1/g/{group_id}/invite/agree")
    void denyInvite(@Path("group_id") String groupId);

    /** notifications */

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @GET("/api/v1/notifications")
    void listNotification(Callback<NotificationsData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @GET("/api/v1/notifications/unopened_count")
    void unreadNotificationCount(Callback<UnreadNotificationCountData> callback);

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @PATCH("/api/v1/notifications/opend")
    void openNotification(@Field("ids") ArrayList<String> ids);

    /** profiles */


}

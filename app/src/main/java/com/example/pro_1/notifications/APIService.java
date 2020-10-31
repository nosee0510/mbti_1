package com.example.pro_1.notifications;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAB-gBt0s:APA91bG5pEjGd8KUX6Zu3PeDR0CiPADD0dbs6YL5GenLtio04a0kuVqGgkooP1xQ7I98PVx8mGBSPc2fCZvym7XCfHYv86q_d_-doWLy319ILAGEZnbA6s5zRwCylCT8z-rktFsSmMJu"

    })

    @POST("fcm/send")
    Call<Response> sendNotification (@Body Sender body);



}

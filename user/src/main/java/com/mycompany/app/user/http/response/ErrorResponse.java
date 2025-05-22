package com.mycompany.app.user.http.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private String type;

    private String message;

}

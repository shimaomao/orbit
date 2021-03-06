package com.inmaytide.orbit.exception.handler;

import com.inmaytide.orbit.commons.util.JsonUtils;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.status;

/**
 * @author Moss
 * @since October 03, 2017
 */
public class ThrowableTranslator {

    private final ResponseError error;

    private ThrowableTranslator(Throwable throwable, String path) {
        error = ResponseError.withThrowable(throwable).path(path).build();
    }

    private ThrowableTranslator(Throwable throwable) {
        error = ResponseError.withThrowable(throwable).build();
    }

    public static <T extends Throwable> Mono<ThrowableTranslator> translate(final Mono<T> throwable, String path) {
        return throwable.flatMap(error -> Mono.just(new ThrowableTranslator(error, path)));
    }

    public static <T extends Throwable> Mono<ThrowableTranslator> translate(final Mono<T> throwable) {
        return throwable.flatMap(error -> Mono.just(new ThrowableTranslator(error)));
    }

    public Mono<Void> write(ServerHttpResponse response) {
        response.setStatusCode(getHttpStatus());
        DataBuffer buffer = response.bufferFactory().wrap(JsonUtils.getJsonBytes(getError()));
        return response.writeAndFlushWith(Mono.just(Mono.just(buffer)));
    }

    public Mono<ServerResponse> getResponse() {
        return status(getHttpStatus()).body(Mono.just(getError()), ResponseError.class);
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.valueOf(error.getStatus());
    }

    public ResponseError getError() {
        return error;
    }

}

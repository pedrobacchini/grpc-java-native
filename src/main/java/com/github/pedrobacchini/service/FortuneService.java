package com.github.pedrobacchini.service;

import com.github.pedrobacchini.grpcFortune.FortuneGrpc;
import com.github.pedrobacchini.grpcFortune.FortuneMessage;
import com.github.pedrobacchini.grpcFortune.FortuneReply;
import com.github.pedrobacchini.grpcFortune.FortuneRequest;
import io.grpc.stub.StreamObserver;

public class FortuneService extends FortuneGrpc.FortuneImplBase {

    @Override
    public void callFortune (FortuneRequest request, StreamObserver<FortuneReply> responseObserver) {
        FortuneReply.Builder response = FortuneReply.newBuilder();

        String caller = request.getName();
        FortuneMessage fortuneMessage = new FortuneMessage();
        String message = caller + " : " + fortuneMessage.retornaFrase();
        response.setMessage(message);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}

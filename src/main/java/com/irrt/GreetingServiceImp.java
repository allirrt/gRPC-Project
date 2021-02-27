package com.irrt;

import com.irrt.prpc.GreetingServiceGrpc;
import com.irrt.prpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImp extends GreetingServiceGrpc.GreetingServiceImplBase {

    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        System.out.println(request);
        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse.newBuilder().
                setGreeting("Hello from server" + request.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

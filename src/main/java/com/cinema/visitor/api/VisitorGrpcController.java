package com.cinema.visitor.api;

import com.cinema.visitor.*;
import com.cinema.visitor.model.Visitor;
import com.cinema.visitor.service.VisitorService;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class VisitorGrpcController extends VisitorServiceGrpc.VisitorServiceImplBase {
    @Autowired
    private VisitorService visitorService;

    @Override
    public void all(AllVisitorsRequest request, StreamObserver<AllVisitorsResponse> responseObserver) {
        List<Visitor> visitors = visitorService.getAllVisitors();
        List<VisitorResponse> convertedFilms = visitors.stream().
                map(Visitor::toVisitorResponse).
                collect(Collectors.toList());
        AllVisitorsResponse response = AllVisitorsResponse.newBuilder().
                addAllVisitors(convertedFilms).
                build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void add(VisitorRequest request, StreamObserver<VisitorResponse> responseObserver) {
        Visitor visitor = visitorService.addVisitor(Visitor.fromVisitorRequest(request));
        responseObserver.onNext(visitor.toVisitorResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void byId(VisitorByIdRequest request, StreamObserver<VisitorResponse> responseObserver) {
        Visitor visitor = visitorService.getVisitorById(UUID.fromString(request.getId()));
        responseObserver.onNext(visitor.toVisitorResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void delete(VisitorByIdRequest request, StreamObserver<DeleteVisitorResponse> responseObserver) {
        visitorService.deleteVisitorById(UUID.fromString(request.getId()));
        responseObserver.onNext(DeleteVisitorResponse.newBuilder().build());
        responseObserver.onCompleted();
    }
}

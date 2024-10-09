package com.mark.autostock.domain.transfer;

public interface TransferI<REQ, RES, E> {
    RES requestToResponse(REQ req);
    E requestToEntity(REQ res);
    RES entityToResponse(E entity);
    E responseToEntity(RES res);
}

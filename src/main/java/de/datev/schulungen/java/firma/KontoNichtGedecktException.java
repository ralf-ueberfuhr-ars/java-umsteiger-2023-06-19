package de.datev.schulungen.java.firma;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class KontoNichtGedecktException extends Exception {

    private final Konto konto;
    private final long betrag;

}

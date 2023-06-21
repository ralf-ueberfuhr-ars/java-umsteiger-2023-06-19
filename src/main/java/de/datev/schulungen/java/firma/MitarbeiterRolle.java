package de.datev.schulungen.java.firma;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MitarbeiterRolle {

    ANGESTELLTER(28),
    AUSZUBILDENDER(20),
    EXTERNER(0);

    private final int urlaub;

}

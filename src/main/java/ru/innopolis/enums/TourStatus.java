package ru.innopolis.enums;

public enum TourStatus {

    ACTIVE,         //за 14 дней до начала тура
    BLOCKED,        //от 14 до 0 дней до начала тура
    IN_PROGRESS,    //тур идет сейчас
    FINISHED,       //тур окончен
    CANCELLED       //тур отменен

}

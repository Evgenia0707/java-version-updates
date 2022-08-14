package org.company;

public enum Currency {//extends Enum class
    PENNY(1),NICKLE(5),DIME(10),QUARTER(25);
       private int value;

    Currency(int value) {//after generate constr will ask about value
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

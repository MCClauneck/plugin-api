package io.github.mcclauneck.mceconomy.api.enums;

/**
 * Enumeration representing the different currency tiers.
 */
public enum CurrencyType {
    COIN("coin"),
    COPPER("copper"),
    SILVER("silver"),
    GOLD("gold");

    private final String name;

    CurrencyType(String name) {
        this.name = name;
    }

    /**
     * Gets the database column name associated with this currency.
     * @return The lowercase string name.
     */
    public String getName() {
        return name;
    }

    /**
     * Attempts to match a string to a CurrencyType (case-insensitive).
     * @param name The name to check.
     * @return The matching CurrencyType, or null if not found.
     */
    public static CurrencyType fromName(String name) {
        for (CurrencyType type : values()) {
            if (type.name.equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}

package MultiMath_Math.NumeralSystems;

public class HexadecimalToDecimal {

    private static final String HEX_CHARS = "0123456789abcdef";

    public int convert(String hex) {
        hex = hex.toLowerCase();
        return HEX_CHARS.indexOf(hex);
    }
}

import java.math.BigInteger;
import java.util.UUID;

public class ShortenUrlKeyGenerator {

    private static final char[] corpus   = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    public static void main(String[] args) {
        System.out.println(String.format("User 1: Id: %s, Generated Key: %s",1234567890,getBase62From10(1234567890)));
    }
    /*
     * Note if seed is unique then generated base62 number will be unique as well under load balance make sure this value is not same.
     */
    public static final String getBase62From10(final long seed)
    {
        String number = seed + "";
        char[] buf = new char[number.length()];
        int charPos = number.length() - 1;
        BigInteger bigIntegerNumber = new BigInteger(number);
        BigInteger radix = BigInteger.valueOf(62);

        while (bigIntegerNumber.compareTo(radix) >= 0)
        {
            buf[charPos--] = corpus[bigIntegerNumber.mod(radix).intValue()];
            bigIntegerNumber = bigIntegerNumber.divide(radix);
        }
        buf[charPos] = corpus[bigIntegerNumber.intValue()];
        return new String(buf, charPos, (number.length() - charPos));
    }
    /**
     * @param longNumber
     * a positive number in base 62
     * @return the same number, in base 10
     */
    public static final String getBase10From62(final long longNumber)
    {
        String number = longNumber + "";
        BigInteger value = BigInteger.ZERO;
        for (char c : number.toCharArray())
        {
            value = value.multiply(BigInteger.valueOf(62));
            if ('0' <= c && c <= '9')
            {
                value = value.add(BigInteger.valueOf(c - '0'));
            }
            if ('a' <= c && c <= 'z')
            {
                value = value.add(BigInteger.valueOf(c - 'a' + 10));
            }
            if ('A' <= c && c <= 'Z')
            {
                value = value.add(BigInteger.valueOf(c - 'A' + 36));
            }
        }
        return value.toString();
    }


}

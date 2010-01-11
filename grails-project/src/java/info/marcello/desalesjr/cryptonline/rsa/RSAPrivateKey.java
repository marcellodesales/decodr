package info.marcello.desalesjr.cryptonline.rsa;

import static info.marcello.desalesjr.cryptonline.rsa.Rsa.DECIMAL_FORMATTER;

import java.util.ArrayList;
import java.util.List;

/**
 * The private key of the RSA algorithm, containing the public key.
 * The private key D can be retreived.
 * 
 * This is a thread-safe immutable class.
 * 
 * @author Marcello de Sales (marcello.desales@gmail.com)
 */
public final class RSAPrivateKey {

    /**
     * Reference to the public key
     */
    private final RSAPublicKey publicKey;
    /**
     * The private log for the calculator
     */
    private final List<String> log = new ArrayList<String>();
    /**
     * Private Key d
     */
    private final double d;
    
    /**
     * Constructs a new Rsa private Key with a public key.
     * @param publicKey is the public key
     */
    private RSAPrivateKey(RSAPublicKey publicKey) {
        this.publicKey = publicKey;

        this.log.add(Rsa.LOG_ARROW + "Calculating private keys");
        this.d = this.generateDInverseE();
        this.log.add("");
        this.log.add("      Private Key (N,D) = ("
                + DECIMAL_FORMATTER.format(this.publicKey.getKeyN()) + ", "
                + DECIMAL_FORMATTER.format(this.d) + ");");
    }
    
    /**
     * @param publicKey the given public key
     * @return a new instance of the RSA private key with the given key.
     */
    public static RSAPrivateKey newInstance(RSAPublicKey publicKey) {
        return new RSAPrivateKey(publicKey);
    }
    
    /**
     * @return the reference to the public key
     */
    public RSAPublicKey getRSAPublicKey() {
        return this.publicKey;
    }
    
    /**
     * @return the value of the private key D
     */
    public double getPrivateKeyD() {
        return this.d;
    }
    
    /**
     * @return generates the private key D, based on the Inverse value of the public key E
     */
    private double generateDInverseE() {
        double u1 = 1;
        double u2 = 0;
        double u3 = this.publicKey.getFactorFI();
        double v1 = 0;
        double v2 = 1;
        double v3 = this.publicKey.getKeyE();
        double t1, t2, t3, vv, qq;

        this.log.add("         Initializing (p1,p2,p3) = (1, 0 , FI(n))");
        this.log.add("         Initializing (q1,q2,q3) = (0, 1 ,  E  ))");
        this.log.add("         While q3 != 0");
        this.log.add("             quoc = p3 / q3");
        this.log
                .add("             (t1,t2,t3) = (p1,p2,p3) - quoc * (q1,q2,q3)");
        this.log.add("             After, arrange the values:");
        this.log.add("             (p1,p2,p3) = (q1,q2,q3)");
        this.log.add("             (q1,q2,q3) = (t1,t2,t3)");

        while (v3 > 0) {
            this.log.add("");
            this.log.add("           (" + DECIMAL_FORMATTER.format(v3)
                    + " <> 0) , then:");
            qq = Algebra.SINGLETON.getQuotient(u3, v3);

            this.log.add("             quoc = " + DECIMAL_FORMATTER.format(u3)
                    + " / " + DECIMAL_FORMATTER.format(v3) + " = "
                    + DECIMAL_FORMATTER.format(qq));

            t1 = u1 - qq * v1;
            t2 = u2 - qq * v2;
            t3 = u3 - qq * v3;

            u1 = v1;
            u2 = v2;
            u3 = v3;
            v1 = t1;
            v2 = t2;
            v3 = t3;

            this.log.add("             (t1,t2,t3) = ("
                    + DECIMAL_FORMATTER.format(u1) + ","
                    + DECIMAL_FORMATTER.format(u2) + ","
                    + DECIMAL_FORMATTER.format(u3) + ") - "
                    + DECIMAL_FORMATTER.format(qq) + " * ("
                    + DECIMAL_FORMATTER.format(v1) + ","
                    + DECIMAL_FORMATTER.format(v2) + ","
                    + DECIMAL_FORMATTER.format(v3) + ") = ("
                    + DECIMAL_FORMATTER.format(t1) + ","
                    + DECIMAL_FORMATTER.format(t2) + ","
                    + DECIMAL_FORMATTER.format(t3) + ")");
            this.log.add("             (p1,p2,p3) = ("
                    + DECIMAL_FORMATTER.format(v1) + ","
                    + DECIMAL_FORMATTER.format(v2) + ","
                    + DECIMAL_FORMATTER.format(v3) + ")");

            this.log.add("             (q1,q2,q3) = ("
                    + DECIMAL_FORMATTER.format(t1) + ","
                    + DECIMAL_FORMATTER.format(t2) + ","
                    + DECIMAL_FORMATTER.format(t3) + ")");
        }
        this.log.add("");
        this.log
                .add("         q3 is zero(0). Now, verify the value of p2. In case of negative, invert it by summing"
                        + " it with FI. (represent the negative number of z(n) by a positive.)");
        this.log.add("");
        this.log.add("         u2 = " + DECIMAL_FORMATTER.format(u2) + ";");

        vv = u2;
        double inverse;
        if (vv < 0) {
            inverse = vv + this.publicKey.getFactorFI();
            this.log.add("          Since u2 is negative, we have:");
            this.log.add("          D = u2 + FI; D = "
                    + DECIMAL_FORMATTER.format(u2) + " + "
                    + DECIMAL_FORMATTER.format(this.publicKey.getFactorFI()) + " = "
                    + DECIMAL_FORMATTER.format(inverse));
        } else {
            inverse = vv;
            this.log.add("         D = u2; D = "
                    + DECIMAL_FORMATTER.format(u2));
        }
        return inverse;
    }
    
}
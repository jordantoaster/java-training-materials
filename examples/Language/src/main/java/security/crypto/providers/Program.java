package security.crypto.providers;

import java.security.*;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        System.out.println("Registered JCA providers are:");
        for (Provider provider : providers) {
            System.out.println("\t" + provider.getInfo() + " with properties:");
            Set<?> properties = provider.entrySet();
            Iterator<?> iter = properties.iterator();
            while (iter.hasNext()) {
                Map.Entry<?, ?> property = (Map.Entry<?, ?>) iter.next();
                System.out.println("\t\t" + property.getKey() + " = " + property.getValue());
            }
        }
    }
}

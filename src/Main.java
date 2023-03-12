import com.sun.jdi.Value;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        var str = in.nextLine();
        var pattern = Pattern.compile("^([\\d\\w]+)\\s*([+\\-*\\/])\\s*([\\d\\w]+)$");
        var matcher = pattern.matcher(str);
        var rm = new ReturnMiddleware();
        var som = new SameOperandsMiddleware(rm);
        var vm = new ValueMiddleware(som);
        var mm = new MatcherMiddleware(vm);
        var result = mm.Invoke(matcher);
        System.out.println(result);
    }
}
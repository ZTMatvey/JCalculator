import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueMiddleware implements IMiddleware {
    private IMiddleware _next;
    public ValueMiddleware(IMiddleware next){
        _next = next;
    }
    @Override
    public String Invoke(final Matcher matcher) {
        var firstNum = getNubmer(matcher.group(1));
        var secondNum = getNubmer(matcher.group(3));

        if (firstNum < 1 ||
            firstNum > 10 ||
            secondNum < 1 ||
            secondNum > 10){
            throw new IllegalArgumentException();
        }

        return _next.Invoke(matcher);
    }

    private Integer getNubmer(String str){
        try {
            int num = Integer.parseInt(str);
            return num;
        } catch (NumberFormatException e) {

        }
        return Roman.parseFromString(str);
    }
}
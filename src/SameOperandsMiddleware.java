import java.util.regex.Matcher;

public class SameOperandsMiddleware implements IMiddleware {
    private IMiddleware _next;
    public SameOperandsMiddleware(IMiddleware next){
        _next = next;
    }
    @Override
    public String Invoke(Matcher matcher) {
        var isFirstNum = isNubmer(matcher.group(1));
        var isSecondNum = isNubmer(matcher.group(3));

        if (isFirstNum != isSecondNum){
            throw new IllegalArgumentException();
        }

        return _next.Invoke(matcher);
    }

    private boolean isNubmer(String str){
        try {
            int num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

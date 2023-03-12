import java.util.regex.Matcher;

public class MatcherMiddleware implements IMiddleware {
    private IMiddleware _next;
    public MatcherMiddleware(IMiddleware next){
        _next = next;
    }
    @Override
    public String Invoke(Matcher matcher) {
        if (!matcher.matches()){
            throw new IllegalArgumentException();
        }

        return _next.Invoke(matcher);
    }
}

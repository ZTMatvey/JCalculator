import java.util.regex.Matcher;

public interface IMiddleware {
    String Invoke(final Matcher matcher);
}

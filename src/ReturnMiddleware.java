import javax.management.BadStringOperationException;
import javax.management.OperationsException;
import java.util.regex.Matcher;

public class ReturnMiddleware implements IMiddleware{
    @Override
    public String Invoke(Matcher matcher) {
        var firstNum = getNubmer(matcher.group(1));
        var secondNum = getNubmer(matcher.group(3));
        var operator = matcher.group(2);

        Integer result = 0;
        if (operator.equals("+")){
            result = firstNum + secondNum;
        }
        else if (operator.equals("-")) {
            result = firstNum - secondNum;
        }
        else if (operator.equals("*")) {
            result = firstNum * secondNum;
        }
        else if (operator.equals("/")) {
            result = firstNum / secondNum;
        }

        if(isNubmer(matcher.group(1))){
            return result.toString();
        }
        else{
            return Roman.parseToString(result);
        }
    }

    private Integer getNubmer(String str){
        try {
            int num = Integer.parseInt(str);
            return num;
        } catch (NumberFormatException e) {

        }
        return Roman.parseFromString(str);
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

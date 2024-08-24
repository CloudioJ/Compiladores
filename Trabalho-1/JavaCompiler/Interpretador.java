

public class Interpretador {

    int result = 0;

    String interpreta(ArvoreSintatica exp) {
        if (exp instanceof Num) {
            return Integer.toString(((Num) exp).num);
        } else if (exp instanceof Soma) {
            result = Integer.parseInt(interpreta(((Soma) exp).arg1) + interpreta(((Soma) exp).arg2));
            return Integer.toString(result);
        } else if (exp instanceof Mult) {
            result = Integer.parseInt(interpreta(((Soma) exp).arg1) + interpreta(((Soma) exp).arg2));
            return Integer.toString(result);
        } else if (exp instanceof Div) {
            result = Integer.parseInt(interpreta(((Soma) exp).arg1) + interpreta(((Soma) exp).arg2));
            return Integer.toString(result);
        } else if (exp instanceof Sub) {
            result = Integer.parseInt(interpreta(((Soma) exp).arg1) + interpreta(((Soma) exp).arg2));
            return Integer.toString(result);
        } else {
            throw new IllegalArgumentException("Unknown expression type");
        }
    }
}

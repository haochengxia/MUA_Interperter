package src.mua.op.operator;


import src.mua.Expr;
import src.mua.dataType.Number;
import src.mua.dataType.Word;
import src.mua.interpreter.Scope;
import src.mua.utils.ArgUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Sub extends Expr {

    @Override
    public String getOpName() {
        return "sub";
    }

    @Override
    public Word eval(Scope scope) throws Exception {
        super.eval(scope);
        ArgUtil.argCheck(getOpName(), argtypes, arglist);
        Number a = (Number) arglist.get(0);
        Number b = (Number) arglist.get(1);
        return new Word(a.getValue() - b.getValue());
    }


    final static private ArrayList<Class> argtypes = new ArrayList<Class>(Arrays.asList(
            Number.class,
            Number.class
    ));

    public int getArgNum() {
        return argtypes.size();
    }
}

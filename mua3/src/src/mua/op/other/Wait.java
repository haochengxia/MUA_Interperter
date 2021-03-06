package src.mua.op.other;

import src.mua.Expression;
import src.mua.dataType.None;
import src.mua.dataType.Number;
import src.mua.interpreter.NameSpace;
import src.mua.utils.ArgumentUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * wait added in 12/27/2019
 */

public class Wait extends Expression {

    public static final int firstArg = 0;
    public static final int secondArg = 1;
    public static final int thirdArg = 2;

    public static final int firstObj = 0;
    public static final int secondObj = 1;
    public static final int thirdObj = 2;

    @Override
    public String getOpName() {
        return "wait";
    }

    @Override
    public None calculate(NameSpace nameSpace) throws Exception {
        super.calculate(nameSpace);
        ArgumentUtil.argCheck(getOpName(), argTypes, argList);

        Number number = (Number)argList.get(firstArg);
        // wait
        Thread.sleep(number.getValue().intValue());
        return new None();
    }

    // no parameters
    final static private ArrayList<Class> argTypes = new ArrayList<Class>(Arrays.asList(
            Number.class
    ));

    public int getArgNum() {
        return argTypes.size();
    }
}

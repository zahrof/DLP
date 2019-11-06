/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.tme4;


import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.tme4.IASTvisitor;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;


public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter
implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

    
    public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment,
			IOperatorEnvironment operatorEnvironment) {
		super(globalVariableEnvironment, operatorEnvironment);
	}

    @Override
  	public Object visit(com.paracamplus.ilp1.interfaces.IASTprogram iast, ILexicalEnvironment lexenv) throws EvaluationException  {
      	return visit((IASTprogram)iast, lexenv);
      }
    private static Object whatever1 = "whatever1";
    private static Object whatever2 = "whatever2";

	@Override
	public Object visit(IASTunless iast, ILexicalEnvironment data) throws EvaluationException {
		Object c = iast.getCond().accept(this, data);
        if ( c != null && c instanceof Boolean ) {
            Boolean b = (Boolean) c;
            if ( !b.booleanValue() ) {
                return iast.getBdy().accept(this, data);
            } else {
                return whatever2;
            }
        } else {
            return whatever1;
        }
	}
  


}

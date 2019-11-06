/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.tme3;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;

public abstract class BinaryPrimitive extends Primitive {
    
    public BinaryPrimitive(String name) {
        super(name);
    }

    @Override
	public int getArity () {
        return 2;
    }
    
    @Override
	public abstract Object apply(Object arg1,Object arg2) throws EvaluationException; 
}

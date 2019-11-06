/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.tme3;

import java.util.*;
import java.math.BigInteger;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class vectorGet extends BinaryPrimitive {

	public vectorGet() {
		super("makeVector");
		 
	}

	@Override
	public Object apply (Object arg1, Object arg2) throws EvaluationException {
		return ((Object[])arg1)[((BigInteger)arg2).intValue()];
	}
}

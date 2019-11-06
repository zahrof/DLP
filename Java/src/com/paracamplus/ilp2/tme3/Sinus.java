/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.tme3;


import java.lang.Math;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;

public class Sinus extends UnaryPrimitive {

	public Sinus() {
		super("sinus");
	}


	@Override
	public Object apply (Object value) throws EvaluationException {
		if (value instanceof BigInteger) 
			return  Math.sin(((BigInteger)value).doubleValue());
		else 
			if (value instanceof BigDecimal) 
				return  Math.sin(((BigDecimal)value).doubleValue());
			else throw new EvaluationException("Your sinus parameter"
					+ "is not a BigInteger ");
	}
}

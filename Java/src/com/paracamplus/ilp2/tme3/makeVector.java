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

public class makeVector extends BinaryPrimitive {

	public makeVector() {
		super("makeVector");
		 
	}

	@Override
	public Object apply (Object arg1, Object arg2) throws EvaluationException {
		if (arg1 instanceof BigInteger) {
			int t = ((BigInteger) arg1).intValue(); 
			Vector<Object> a = new Vector<Object>();
			
			for (int i=0; i< t; i++) {
				a.add(arg2); 
			}return a; 
		}
			
		else {
			  String msg = "The length should be an Integer";
              throw new EvaluationException(msg); 
		}
	}
}

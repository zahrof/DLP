/* *****************************************************************
 * ilp1 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp1
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.tme4.compiler;


import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.interfaces.IASTexpression;

import com.paracamplus.ilp2.tme4.compiler.INormalizationFactory;
import com.paracamplus.ilp2.tme4.interfaces.IASTunless;
import com.paracamplus.ilp2.tme4.interfaces.IASTvisitor;;

public class Normalizer extends com.paracamplus.ilp2.compiler.normalizer.Normalizer implements 
 IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException> {


	  public Normalizer (INormalizationFactory factory) {
	    	super(factory);
	    	this.factory=factory;
	    }

	  protected final INormalizationFactory factory;	  
	@Override
	public IASTexpression visit(IASTunless iast, INormalizationEnvironment data) throws CompilationException {
		IASTexpression c = iast.getBdy().accept(this, data); 
		IASTexpression t = iast.getCond().accept(this, data);
		return factory.newUnless(c, t);
	}

  
 
}

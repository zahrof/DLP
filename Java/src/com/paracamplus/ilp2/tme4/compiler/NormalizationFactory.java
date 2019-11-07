/* *****************************************************************
 * ilp1 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp1
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.tme4.compiler;

import com.paracamplus.ilp1.interfaces.IASTexpression;

import com.paracamplus.ilp2.tme4.ast.ASTunless;

public class NormalizationFactory 
extends com.paracamplus.ilp2.compiler.normalizer.NormalizationFactory 
implements com.paracamplus.ilp2.tme4.compiler.INormalizationFactory {

	
	@Override
	public IASTexpression newUnless(IASTexpression bdy, IASTexpression cond) {
		return new ASTunless(bdy, cond);
	}
    
}

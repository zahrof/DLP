/* *****************************************************************
 * ilp1 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp1
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.tme4.compiler;


import java.util.Set;

import com.paracamplus.ilp2.tme4.interfaces.IASTunless;
import com.paracamplus.ilp2.tme4.interfaces.IASTvisitor;
import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTClocalVariable;


public class FreeVariableCollector extends com.paracamplus.ilp2.compiler.FreeVariableCollector
implements IASTvisitor<Void, Set<IASTClocalVariable>, CompilationException> {

	public FreeVariableCollector(com.paracamplus.ilp2.compiler.interfaces.IASTCprogram program) {
		super(program);
	}

	@Override
	public Void visit(IASTunless iast, Set<IASTClocalVariable> data) throws CompilationException {
		iast.getCond().accept(this, data);
		iast.getBdy().accept(this, data);
		return null;

	}


}

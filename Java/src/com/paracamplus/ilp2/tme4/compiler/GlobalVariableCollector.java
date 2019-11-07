/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.tme4.compiler;


import java.util.Set;

import com.paracamplus.ilp1.compiler.CompilationException;

import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;

import com.paracamplus.ilp2.tme4.interfaces.IASTvisitor;
import com.paracamplus.ilp2.tme4.interfaces.IASTunless;


public class GlobalVariableCollector extends com.paracamplus.ilp2.compiler.GlobalVariableCollector
implements IASTvisitor<Set<IASTCglobalVariable>,  Set<IASTCglobalVariable>, CompilationException> {

	@Override
	public Set<IASTCglobalVariable> visit(IASTunless iast, Set<IASTCglobalVariable> data) throws CompilationException {
		data = iast.getBdy().accept(this, data);
		data = iast.getCond().accept(this, data);
		return data;
	}

}

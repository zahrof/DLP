/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.tme4;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.tme4.IASTfactory;
import com.paracamplus.ilp2.tme4.IASTunless;



public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory
	implements IASTfactory{


	@Override
	public IASTexpression newUnlesss(IASTexpression bdy, IASTexpression cond) {
		 return new ASTunless(bdy,cond);
	}

}

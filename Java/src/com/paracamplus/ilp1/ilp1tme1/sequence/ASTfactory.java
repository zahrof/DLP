package com.paracamplus.ilp1.ilp1tme1.sequence;


import com.paracamplus.ilp1.interfaces.IASTexpression;


public class ASTfactory extends com.paracamplus.ilp1.ast.ASTfactory implements com.paracamplus.ilp1.interfaces.IASTfactory{
	 @Override
		public IASTsequence newSequence(IASTexpression[] asts) {
	        return new ASTsequence(asts);
	    }
}
